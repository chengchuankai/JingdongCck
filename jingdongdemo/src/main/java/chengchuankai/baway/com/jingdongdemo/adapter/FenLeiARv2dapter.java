package chengchuankai.baway.com.jingdongdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.activity.ListCommodityActivity;
import chengchuankai.baway.com.jingdongdemo.bean.Commodity;
import chengchuankai.baway.com.jingdongdemo.bean.FenleiIMPL;
import chengchuankai.baway.com.jingdongdemo.precenter.CommodityPrecenter;
import chengchuankai.baway.com.jingdongdemo.precenter.CommodityPrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.view.CommodityView;

/**
 * Created by C-PC on 2017/11/7.
 */

public class FenLeiARv2dapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements CommodityView{
    private Context context;
    private List<FenleiIMPL.DataBean> dataBeen;
    private List<FenleiIMPL.DataBean.ListBean> list;


    public FenLeiARv2dapter(Context context, List<FenleiIMPL.DataBean> dataBeen) {
        this.context = context;
        this.dataBeen = dataBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fenlei_rv2_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        list = dataBeen.get(position).getList();
       /* Uri uri=Uri.parse(dataBeen.get(position).getList().get(position).getIcon());
        myViewHolder.rv2_iv.setImageURI(uri);*/
        myViewHolder.rv2_tv.setText(dataBeen.get(position).getName());
        myViewHolder.rv3.setLayoutManager(new GridLayoutManager(context, 3));
        FeiLeiRv3Adapter adapter = new FeiLeiRv3Adapter(context, list);
        myViewHolder.rv3.setAdapter(adapter);


        adapter.setOnFenleiRvListener(new FeiLeiRv3Adapter.OnFenleiRvListener() {
            @Override
            public void onChildItemClick(FenleiIMPL.DataBean.ListBean listBean) {
                int pscid = listBean.getPscid();
                String pcid0 = String.valueOf(pscid);
                CommodityPrecenter commodityPrecenter=new CommodityPrecenterImpl(FenLeiARv2dapter.this);
                HashMap<String,String> map=new HashMap<String, String>();
                map.put("pscid",pcid0);
                commodityPrecenter.GuanlianM(map);
                Intent intent=new Intent(context, ListCommodityActivity.class);
                intent.putExtra("pscid",pcid0);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

    @Override
    public void showData(Commodity commodity) {
        List<Commodity.DataBean> data = commodity.getData();
       // Toast.makeText(context,data.toString(),Toast.LENGTH_SHORT).show();

/*        Intent intent=new Intent(context, ListCommodityActivity.class);
        EventBus_Commodity eventBus_commodity = new EventBus_Commodity();
        eventBus_commodity.setData(data);
        EventBus.getDefault().post(eventBus_commodity);*/
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView rv3;
        private final TextView rv2_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            rv3 = itemView.findViewById(R.id.rv3);
            rv2_tv = itemView.findViewById(R.id.rv2_tv);
        }
    }
}
