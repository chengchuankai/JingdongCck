package chengchuankai.baway.com.jingdongdemo.bean;

import java.util.List;

/**
 * Created by C-PC on 2017/11/18.
 */

public class GetAddrBean extends BaseBean{


    /**
     * msg : 地址列表请求成功
     * data : [{"addr":"北京市海淀区","addrid":547,"mobile":18801110283,"name":"程传凯","status":0,"uid":1378},{"addr":"北京市昌平区金域国际1-1-1","addrid":549,"mobile":18612991023,"name":"kson","status":0,"uid":1378},{"addr":"北京","addrid":550,"mobile":18801110283,"name":"程传凯","status":0,"uid":1378}]
     */

    private String msg;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * addr : 北京市海淀区
         * addrid : 547
         * mobile : 18801110283
         * name : 程传凯
         * status : 0
         * uid : 1378
         */

        private String addr;
        private int addrid;
        private long mobile;
        private String name;
        private int status;
        private int uid;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public int getAddrid() {
            return addrid;
        }

        public void setAddrid(int addrid) {
            this.addrid = addrid;
        }

        public long getMobile() {
            return mobile;
        }

        public void setMobile(long mobile) {
            this.mobile = mobile;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
