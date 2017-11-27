package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.AddShopCarBean;
import chengchuankai.baway.com.jingdongdemo.model.AddShopCarModel;
import chengchuankai.baway.com.jingdongdemo.model.AddShopCarModelImpl;
import chengchuankai.baway.com.jingdongdemo.view.AddshopCarView;

/**
 * Created by C-PC on 2017/11/8.
 */

public class AddShopCarPrecenterImpl implements AddShopCarPrecenter{
    AddshopCarView AddshopCarView;
    private final AddShopCarModel addShopCarModel;

    public AddShopCarPrecenterImpl(AddshopCarView addshopCarView) {
        this.AddshopCarView=addshopCarView;
        addShopCarModel = new AddShopCarModelImpl(this);
    }

    @Override
    public void GuanlianM(Map<String, String> map) {
        addShopCarModel.getData(map);
    }

    @Override
    public void OngetView(AddShopCarBean addShopCarBean) {
        AddshopCarView.showData(addShopCarBean);
    }
}
