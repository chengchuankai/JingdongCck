package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.Commodity;
import chengchuankai.baway.com.jingdongdemo.model.CommodityModel;
import chengchuankai.baway.com.jingdongdemo.model.CommodityModelImpl;
import chengchuankai.baway.com.jingdongdemo.view.CommodityView;

/**
 * Created by C-PC on 2017/11/7.
 */

public class CommodityPrecenterImpl implements CommodityPrecenter{

    private CommodityView commodityView;
    private final CommodityModel commodityModel;

    public CommodityPrecenterImpl(CommodityView commodityView) {
        this.commodityView=commodityView;
        commodityModel = new CommodityModelImpl(this);
    }

    //M
    @Override
    public void GuanlianM(Map<String, String> map) {
        commodityModel.getData(map);
    }

    @Override
    public void OngetView(Commodity commodity) {
        commodityView.showData(commodity);
    }
}
