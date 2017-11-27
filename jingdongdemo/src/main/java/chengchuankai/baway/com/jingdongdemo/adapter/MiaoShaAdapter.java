package chengchuankai.baway.com.jingdongdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.bean.ImageBean;

/**
 * Created by C-PC on 2017/11/3.
 */

public class MiaoShaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ImageBean.TuijianBean.ListBean> list;


    public MiaoShaAdapter(Context context, List<ImageBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.miaosha_item,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyviewHolder myviewHolder= (MyviewHolder) holder;
        String images = list.get(position).getImages();
        String[] split = images.split("!");
        String s = split[0];
        Log.i("sss", s);
        Picasso.with(context).load(s).into(myviewHolder.iv);
        String subhead = list.get(position).getSubhead();
        myviewHolder.tv1.setText(subhead);
        double price = list.get(position).getPrice();
        String price0 = String.valueOf(price);
        myviewHolder.tv2.setText(price0);

        myviewHolder.tv3.setText("为你推荐");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;

        public MyviewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }
}
