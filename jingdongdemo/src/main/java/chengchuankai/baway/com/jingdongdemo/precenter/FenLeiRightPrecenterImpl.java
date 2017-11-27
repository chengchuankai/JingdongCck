package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.FenleiIMPL;
import chengchuankai.baway.com.jingdongdemo.model.FenLeiRightModel;
import chengchuankai.baway.com.jingdongdemo.model.FenLeiRightModelImpl;
import chengchuankai.baway.com.jingdongdemo.view.FenleiRightView;

/**
 * Created by C-PC on 2017/11/6.
 */

public class FenLeiRightPrecenterImpl implements FenLeiRightPrecenter{
    private FenleiRightView fenleiRightView;
    private final FenLeiRightModel fenLeiRightModel;

    public FenLeiRightPrecenterImpl(FenleiRightView fenleiRightView){
        this.fenleiRightView=fenleiRightView;
        fenLeiRightModel = new FenLeiRightModelImpl(this);
    }



    //关联M
    @Override
    public void guanlian(Map<String, String> map) {
        fenLeiRightModel.getData(map);
    }

    @Override
    public void ConnectRingV(FenleiIMPL fenleiIMPL) {
        fenleiRightView.showData(fenleiIMPL);
    }
}
