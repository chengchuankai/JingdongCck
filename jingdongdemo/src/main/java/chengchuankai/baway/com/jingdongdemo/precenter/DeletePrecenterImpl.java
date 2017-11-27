package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.DeleteBean;
import chengchuankai.baway.com.jingdongdemo.model.DeleteModel;
import chengchuankai.baway.com.jingdongdemo.model.DeleteModelImpl;
import chengchuankai.baway.com.jingdongdemo.view.DeleteView;

/**
 * Created by C-PC on 2017/11/13.
 */

public class DeletePrecenterImpl implements DeletePrecenter{
    private DeleteView deleteView;
    private final DeleteModel deleteModel;

    public DeletePrecenterImpl(DeleteView deleteView) {
        this.deleteView = deleteView;
        deleteModel = new DeleteModelImpl(this);
    }

    @Override
    public void GuanlianM(Map<String, String> map) {
        deleteModel.getData(map);
    }

    @Override
    public void OngetView(DeleteBean deleteBean) {
        deleteView.showData(deleteBean);
    }
}
