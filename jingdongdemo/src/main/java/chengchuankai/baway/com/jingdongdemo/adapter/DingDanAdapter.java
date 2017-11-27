package chengchuankai.baway.com.jingdongdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.activity.ZhiFuActivity;
import chengchuankai.baway.com.jingdongdemo.bean.DingDanBean;

/**
 * Created by C-PC on 2017/11/14.
 */

public class DingDanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DingDanBean.DataBean> dataBeen;
    private Context context;

    public DingDanAdapter(List<DingDanBean.DataBean> dataBeen, Context context) {
        this.dataBeen = dataBeen;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dingdan_rv_item, null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewHolder viewHolder= (DingDanAdapter.viewHolder) holder;
        viewHolder.tv_dingdan_id.setText(dataBeen.get(position).getOrderid()+"");
        viewHolder.tv_price.setText(dataBeen.get(position).getPrice()+"");
        viewHolder.bt_nopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ZhiFuActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_dingdan_id;
        private final TextView tv_price;
        private final Button bt_pay;
        private final Button bt_nopay;

        public viewHolder(View itemView) {
            super(itemView);
            tv_dingdan_id = itemView.findViewById(R.id.tv_dingdan_id);
            tv_price = itemView.findViewById(R.id.tv_price);
            bt_pay = itemView.findViewById(R.id.bt_pay);
            bt_nopay = itemView.findViewById(R.id.bt_nopay);
        }
    }
}
