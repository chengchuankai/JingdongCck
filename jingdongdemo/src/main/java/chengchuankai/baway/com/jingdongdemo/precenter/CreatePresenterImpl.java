package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.CreateDdbean;
import chengchuankai.baway.com.jingdongdemo.model.CreateModel;
import chengchuankai.baway.com.jingdongdemo.model.CreateModelImpl;
import chengchuankai.baway.com.jingdongdemo.view.CreateView;

/**
 * Created by C-PC on 2017/11/17.
 */

public class CreatePresenterImpl implements CreatePresenter{
    CreateView createView;
    private final CreateModel createModel;

    public CreatePresenterImpl(CreateView createView) {
        this.createView = createView;
        createModel = new CreateModelImpl(this);
    }

    @Override
    public void GuanlianM(Map<String, String> map) {
        createModel.getData(map);
    }

    @Override
    public void OngetView(CreateDdbean createDdbean) {
        createView.showData(createDdbean);
    }
}
