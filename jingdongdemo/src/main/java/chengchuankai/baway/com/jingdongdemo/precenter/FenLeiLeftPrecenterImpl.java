package chengchuankai.baway.com.jingdongdemo.precenter;

import chengchuankai.baway.com.jingdongdemo.bean.ChaoShiBean;
import chengchuankai.baway.com.jingdongdemo.model.FenLeiLeftModel;
import chengchuankai.baway.com.jingdongdemo.model.FenLeiLeftModelImpl;
import chengchuankai.baway.com.jingdongdemo.view.FenLeiLeftView;
import chengchuankai.baway.com.jingdongdemo.view.OnFenLeiFinishListener;

/**
 * Created by C-PC on 2017/11/4.
 */

public class FenLeiLeftPrecenterImpl implements FenLeiLeftPrecenter, OnFenLeiFinishListener {
    private FenLeiLeftView fenLeiLeftView;
    private final FenLeiLeftModel fenLeiLeftModel;

    public FenLeiLeftPrecenterImpl(FenLeiLeftView fenLeiLeftView) {
        this.fenLeiLeftView = fenLeiLeftView;
        fenLeiLeftModel = new FenLeiLeftModelImpl();
    }


    @Override
    public void Gunnlian() {
        fenLeiLeftModel.GetFenleiModel(this);
    }

    @Override
    public void success(ChaoShiBean chaoShiBean) {
        fenLeiLeftView.ShowFenLeiView(chaoShiBean);
    }
}
