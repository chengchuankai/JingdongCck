package chengchuankai.baway.com.jingdongdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.bean.ChaoShiBean;

/**
 * Created by C-PC on 2017/11/4.
 */

public class FenleiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ChaoShiBean chaoShiBean;
    private List<ChaoShiBean.DataBean> data;
    private OnItemListener onItemListener;

    public interface OnItemListener {
        public void onItemListener(ChaoShiBean.DataBean dataBean);
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }

    public FenleiAdapter(Context context, ChaoShiBean chaoShiBean) {
        this.context = context;
        this.chaoShiBean = chaoShiBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fenlei_left_item, null);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyviewHolder myviewHolder = (MyviewHolder) holder;
        data = chaoShiBean.getData();
        myviewHolder.tv.setText(data.get(position).getName());
        myviewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemListener!=null){
                    onItemListener.onItemListener(data.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return chaoShiBean.getData().size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final LinearLayout ll;

        public MyviewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }


}
