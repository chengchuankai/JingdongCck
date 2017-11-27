package chengchuankai.baway.com.jingdongdemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.bean.FenleiIMPL;

/**
 * Created by C-PC on 2017/11/7.
 */

public class FeiLeiRv3Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<FenleiIMPL.DataBean.ListBean> list;
    private OnFenleiRvListener onFenleiRvListener;

    public interface OnFenleiRvListener {
        public void onChildItemClick(FenleiIMPL.DataBean.ListBean listBean);
    }

    public void setOnFenleiRvListener(OnFenleiRvListener onFenleiRvListener) {
        this.onFenleiRvListener = onFenleiRvListener;
    }

    public FeiLeiRv3Adapter(Context context, List<FenleiIMPL.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fenlei_rv3_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Uri uri = Uri.parse(list.get(position).getIcon());
        myViewHolder.rv3_iv.setImageURI(uri);
        myViewHolder.rv3_tv.setText(list.get(position).getName());
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFenleiRvListener.onChildItemClick(list.get(position));
               /* Intent intent=new Intent(context, ListCommodityActivity.class);
                intent.putExtra("position",position);*/

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView rv3_iv;
        private final TextView rv3_tv;
        private final LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            rv3_iv = itemView.findViewById(R.id.rv3_iv);
            rv3_tv = itemView.findViewById(R.id.rv3_tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
