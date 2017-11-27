package chengchuankai.baway.com.jingdongdemo.bean;

import java.util.List;

/**
 * Created by C-PC on 2017/11/14.
 */

public class DingDanBean extends BaseBean{

    /**
     * msg : 请求成功
     * data : [{"createtime":"2017-11-13T16:21:32","orderid":1483,"price":546.96,"status":2,"title":null,"uid":1378},{"createtime":"2017-11-13T16:22:04","orderid":1484,"price":546.96,"status":0,"title":null,"uid":1378}]
     * page : 1
     */

    private String msg;
    private String page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2017-11-13T16:21:32
         * orderid : 1483
         * price : 546.96
         * status : 2
         * title : null
         * uid : 1378
         */

        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private Object title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
