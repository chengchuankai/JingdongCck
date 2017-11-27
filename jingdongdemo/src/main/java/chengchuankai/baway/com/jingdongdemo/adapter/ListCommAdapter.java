package chengchuankai.baway.com.jingdongdemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.bean.Commodity;

/**
 * Created by C-PC on 2017/11/7.
 */

public class ListCommAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Commodity.DataBean> dataBeen;
    public OnDianJiListener onDianJiListener;

    public interface OnDianJiListener {
        public void onChildItemClick(Commodity.DataBean dataBean);
    }

    public void SetOnDianJiListener(OnDianJiListener onDianJiListener) {
        this.onDianJiListener = onDianJiListener;
    }


    public ListCommAdapter(Context context, List<Commodity.DataBean> dataBeen) {
        this.context = context;
        this.dataBeen = dataBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_comm_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        String images = dataBeen.get(position).getImages();
        //Log.i("TAG",images);
        String[] split = images.split("\\|");
        String s = split[0];
        Log.i("TAG", s);
        Uri uri = Uri.parse(s);
        myViewHolder.sdv.setImageURI(uri);
        myViewHolder.tv1.setText(dataBeen.get(position).getTitle());
        myViewHolder.tv2.setText(dataBeen.get(position).getPrice() + "");
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDianJiListener.onChildItemClick(dataBeen.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView tv1;
        private final TextView tv2;
        private final LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
