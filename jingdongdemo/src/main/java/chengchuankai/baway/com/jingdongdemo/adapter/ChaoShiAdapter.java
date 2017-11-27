package chengchuankai.baway.com.jingdongdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.bean.ChaoShiBean;

/**
 * Created by C-PC on 2017/11/3.
 */

public class ChaoShiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ChaoShiBean.DataBean> dataBeen;

    public ChaoShiAdapter(Context context, List<ChaoShiBean.DataBean> dataBeen) {
        this.context = context;
        this.dataBeen = dataBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chaoshi_item, null);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyviewHolder myviewHolder= (MyviewHolder) holder;
        Picasso.with(context).load(dataBeen.get(position).getIcon()).into(myviewHolder.iv);
        myviewHolder.tv.setText(dataBeen.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder {
        private final TextView tv;
        private final ImageView iv;

        public MyviewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);

        }
    }
}
