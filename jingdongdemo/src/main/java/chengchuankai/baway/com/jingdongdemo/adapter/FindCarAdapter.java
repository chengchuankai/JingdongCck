package chengchuankai.baway.com.jingdongdemo.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.bean.DeleteBean;
import chengchuankai.baway.com.jingdongdemo.bean.FindCarBean;
import chengchuankai.baway.com.jingdongdemo.bean.MessageEvent;
import chengchuankai.baway.com.jingdongdemo.fragment.fragment04;
import chengchuankai.baway.com.jingdongdemo.precenter.DeletePrecenter;
import chengchuankai.baway.com.jingdongdemo.precenter.DeletePrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.view.DeleteView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by C-PC on 2017/11/9.
 */

public class FindCarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements DeleteView{
    private Context context;
    public  List<FindCarBean.DataBean> dataBeen;
    private FindCarChildAdapter adapter;


    public FindCarAdapter(Context context, List<FindCarBean.DataBean> dataBeen) {
        this.context = context;
        this.dataBeen = dataBeen;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_rlv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.shop_car_name.setText(dataBeen.get(position).getSellerName());
        // 给组的框赋上bean里的状态值
        myViewHolder.cart_rlv_cb.setChecked(dataBeen.get(position).getIsShopIsChecked());

        myViewHolder.cart_rlv_rlv.setLayoutManager(new LinearLayoutManager(context));
        adapter = new FindCarChildAdapter(context, dataBeen,position);
        Log.i("TAG", dataBeen.size() + "aavvvva");
        myViewHolder.cart_rlv_rlv.setAdapter(adapter);

        // 组的框的点击事件
        myViewHolder.cart_rlv_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 拿到框的状态
                boolean checked = myViewHolder.cart_rlv_cb.isChecked();
                double numPrice = 0;
                if (checked) {
                    // 如果被选中了
                    dataBeen.get(position).setShopIsChecked(checked);
                    for (int i = 0; i < dataBeen.get(position).getList().size(); i++) {
                        dataBeen.get(position).getList().get(i).setShopChildIsChecked(checked);
                        if(checked){
                            numPrice = numPrice + dataBeen.get(position).getList().get(i).getPrice()*dataBeen.get(position).getList().get(i).getNum();
                        }
                    }
                    notifyDataSetChanged();
                    fragment04.tv_sum_price.setText(numPrice+"");
                } else {
                    // 如果没被选中了
                    dataBeen.get(position).setShopIsChecked(checked);
                    for (int i = 0; i < dataBeen.get(position).getList().size(); i++) {
                        dataBeen.get(position).getList().get(i).setShopChildIsChecked(checked);
                        if(checked){
                            numPrice = numPrice + dataBeen.get(position).getList().get(i).getPrice()*dataBeen.get(position).getList().get(i).getNum();
                        }
                    }
                    notifyDataSetChanged();
                    fragment04.tv_sum_price.setText(numPrice+"");
                }

                if (myViewHolder.cart_rlv_cb.isChecked()) {
                    if (isAllChecked()) {
                        //让全选勾选上
                        MessageEvent msg = new MessageEvent();
                        msg.setChecked(true);
                        EventBus.getDefault().post(msg);
                    } else {
                        //全选勾取消
                        MessageEvent msg = new MessageEvent();
                        msg.setChecked(false);
                        EventBus.getDefault().post(msg);
                    }
                } else {
                    dataBeen.get(position).setShopIsChecked(false);
                    //全选勾取消
                    MessageEvent msg = new MessageEvent();
                    msg.setChecked(false);
                    EventBus.getDefault().post(msg);
                }
            }


        });
        final DeletePrecenter deletePrecenter=new DeletePrecenterImpl(this);
        adapter.setOnItemListener(new FindCarChildAdapter.OnLongItemListener() {

            private int pid0;

            @Override
            public void onLongItemListener(final FindCarBean.DataBean data) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(context)
                        .setTitle("提示")
                        .setMessage("你确定要删除吗")
                        .setNegativeButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                for (int j = 0; j < data.getList().size(); j++) {
                                    pid0 = data.getList().get(position).getPid();
                                }
                                SharedPreferences sharedPreferences = context.getSharedPreferences("token", MODE_PRIVATE);
                                String token = sharedPreferences.getString("token", null);
                                int uid0 = sharedPreferences.getInt("uid", 0);
                                String uid = String.valueOf(uid0);
                                String pid = String.valueOf(pid0);
                                HashMap<String,String> map=new HashMap<>();
                                map.put("token",token);
                                map.put("uid",uid);
                                map.put("pid",pid);
                                deletePrecenter.GuanlianM(map);

                                dataBeen.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

    //全选的方法
    public void Allchecked(boolean flag) {

        double numPrice = 0;

        for (int i = 0;i<dataBeen.size();i++) {
            dataBeen.get(i).setShopIsChecked(flag);
            for(int j = 0;j < dataBeen.get(i).getList().size();j++){
                dataBeen.get(i).getList().get(j).setShopChildIsChecked(flag);
                if(flag){
                    numPrice = numPrice + dataBeen.get(i).getList().get(j).getPrice()*dataBeen.get(i).getList().get(j).getNum();
                }
            }
        }
        notifyDataSetChanged();
        fragment04.tv_sum_price.setText(numPrice+"");
    }

    private boolean isAllChecked() {
        for (FindCarBean.DataBean dataBean : dataBeen) {
            if (!dataBean.getIsShopIsChecked()) {
                //表示有某个checkbox未选中
                return false;
            }
        }
        return true;
    }

    @Override
    public void showData(DeleteBean deleteBean) {
        String msg = deleteBean.getMsg();
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView shop_car_name;
        private final CheckBox cart_rlv_cb;
        private final RecyclerView cart_rlv_rlv;
        private final LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            shop_car_name = itemView.findViewById(R.id.shop_car_name);
            cart_rlv_rlv = itemView.findViewById(R.id.cart_rlv_rlv);
            cart_rlv_cb = itemView.findViewById(R.id.cart_rlv_cb);
            ll = itemView.findViewById(R.id.ll);
        }
    }

}
