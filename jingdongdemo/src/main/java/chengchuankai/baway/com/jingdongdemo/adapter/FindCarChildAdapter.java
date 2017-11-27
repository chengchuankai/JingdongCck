package chengchuankai.baway.com.jingdongdemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.bean.FindCarBean;
import chengchuankai.baway.com.jingdongdemo.fragment.fragment04;

/**
 * Created by C-PC on 2017/11/9.
 */

class FindCarChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<FindCarBean.DataBean> dataBeen;
    private int p;
    private OnLongItemListener onLongItemListener;

    public interface OnLongItemListener {
        public void onLongItemListener(FindCarBean.DataBean data);
    }

    public void setOnItemListener(OnLongItemListener onLongItemListener) {
        this.onLongItemListener = onLongItemListener;
    }

    public FindCarChildAdapter(Context context, List<FindCarBean.DataBean> dataBeen, int p) {
        this.context = context;
        this.dataBeen = dataBeen;
        this.p = p;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.find_cart_child_rlv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;

        String images = dataBeen.get(p).getList().get(position).getImages();
        String[] split = images.split("\\|");
        String s = split[0];
        myViewHolder.tv_name.setText(dataBeen.get(p).getList().get(position).getTitle());
        myViewHolder.tv_price.setText("￥" + dataBeen.get(p).getList().get(position).getPrice());
        Uri uri = Uri.parse(s);
        myViewHolder.iv.setImageURI(uri);
        myViewHolder.num.setText(dataBeen.get(p).getList().get(position).getNum()+"");
        myViewHolder.cart_child_cb.setChecked(dataBeen.get(p).getList().get(position).getIsShopChildIsChecked());
        myViewHolder.cart_child_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = myViewHolder.cart_child_cb.isChecked();
                panDuan(position, checked);
            }
        });
        final boolean checked = myViewHolder.cart_child_cb.isChecked();


        myViewHolder.cart_child_bt_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checked==true){
                    int num = dataBeen.get(p).getList().get(position).getNum();
                    myViewHolder.num.setText(String.valueOf(num+1));
                    dataBeen.get(p).getList().get(position).setNum(num+1);
                    notifyDataSetChanged();
                }else {
                    Toast.makeText(context,"请勾选",Toast.LENGTH_SHORT).show();
                }

            }
        });

        myViewHolder.cart_child_bt_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checked==true){
                    int num = dataBeen.get(p).getList().get(position).getNum();
                    if(num == 1){
                        Toast.makeText(context, "不能减了", Toast.LENGTH_SHORT).show();
                    }else {
                        myViewHolder.num.setText(""+(num-1));
                        dataBeen.get(p).getList().get(position).setNum(num-1);
                    }
                    notifyDataSetChanged();
                }else {
                    Toast.makeText(context,"请勾选",Toast.LENGTH_SHORT).show();
                }


            }
        });

        myViewHolder.ll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onLongItemListener!=null){
                    onLongItemListener.onLongItemListener(dataBeen.get(position));
                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataBeen.get(p).getList().size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {


        private final SimpleDraweeView iv;
        private final TextView tv_name;
        public static  TextView tv_price;
        private CheckBox cart_child_cb;
        private final LinearLayout ll;
        private final Button cart_child_bt_jian;
        private final TextView num;
        private final Button cart_child_bt_jia;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            cart_child_cb = itemView.findViewById(R.id.cart_child_cb);
            ll = itemView.findViewById(R.id.ll);
            cart_child_bt_jian = itemView.findViewById(R.id.cart_child_bt_jian);
            num = itemView.findViewById(R.id.cart_child_et_num);
            cart_child_bt_jia = itemView.findViewById(R.id.cart_child_bt_jia);
        }
    }

    public void panDuan(int position, boolean checked) {
        // 子选中 先把bean里子的状态改变
        dataBeen.get(p).getList().get(position).setShopChildIsChecked(checked);
        // 判断该组下的所有子是否全部被选中
        boolean allChecked = true;
        // 遍历该组下的所有子 只要有一个没被选中 那就赋false
        double numPrice = 0;
        for (int i = 0; i < dataBeen.get(p).getList().size(); i++) {
            if (!dataBeen.get(p).getList().get(i).getIsShopChildIsChecked()) {
                allChecked = false;
            }
            if(checked){
                numPrice = numPrice + dataBeen.get(p).getList().get(i).getPrice()*dataBeen.get(p).getList().get(i).getNum();
            }
            fragment04.tv_sum_price.setText(numPrice+"");
        }
        // 给组的状态赋值
        dataBeen.get(p).setShopIsChecked(allChecked);
        // 判断所有组的状态是否全被选中
        boolean zuAllChecked = true;
        for (int i = 0; i < dataBeen.size(); i++) {
            if (!dataBeen.get(i).getIsShopIsChecked()) {
                zuAllChecked = false;
            }
        }
        // 赋值
        fragment04.car_all_select.setChecked(zuAllChecked);
        // 刷新适配器
        fragment04.adapter.notifyDataSetChanged();
    }

}
