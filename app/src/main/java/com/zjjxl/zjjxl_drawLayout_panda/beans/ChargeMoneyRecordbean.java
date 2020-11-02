package com.zjjxl.zjjxl_drawLayout_panda.beans;

import java.io.Serializable;
import java.util.List;

public class ChargeMoneyRecordbean {
    /**
     * status : true
     * msg : 成功
     * data : [{"cardNo":"3104895111212000000","circleState":1,"createTime":"2020-10-22 14:46:47","id":"ff808081754eb4cd01754f0f567d0009","orderCode":"sttsm50418e7862b74b5493cf07a2a26cf537","payAmount":0,"payTime":"","phone":"15689123357","state":6,"subject":"","tradeAmount":10,"tradeNo":"20201022460674263242695412243142","updateTime":"2020-10-23 13:50:45","userId":"","userMid":"ff8080816f4045af01703d2131c00034"}]
     */

    private boolean status;
    private String msg;
    private List<DataBean> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

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

    public static class DataBean implements Serializable {
        /**
         * cardNo : 3104895111212000000
         * circleState : 1
         * createTime : 2020-10-22 14:46:47
         * id : ff808081754eb4cd01754f0f567d0009
         * orderCode : sttsm50418e7862b74b5493cf07a2a26cf537
         * payAmount : 0
         * payTime :
         * phone : 15689123357
         * state : 6
         * subject :
         * tradeAmount : 10
         * tradeNo : 20201022460674263242695412243142
         * updateTime : 2020-10-23 13:50:45
         * userId :
         * userMid : ff8080816f4045af01703d2131c00034
         */

        private String cardNo;
        private int circleState;
        private String createTime;
        private String id;
        private String orderCode;
        private int payAmount;
        private String payTime;
        private String phone;
        private int state;
        private String subject;
        private int tradeAmount;
        private String tradeNo;
        private String updateTime;
        private String userId;
        private String userMid;

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public int getCircleState() {
            return circleState;
        }

        public void setCircleState(int circleState) {
            this.circleState = circleState;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public String getPayTime() {
            return payTime;
        }

        public void setPayTime(String payTime) {
            this.payTime = payTime;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public int getTradeAmount() {
            return tradeAmount;
        }

        public void setTradeAmount(int tradeAmount) {
            this.tradeAmount = tradeAmount;
        }

        public String getTradeNo() {
            return tradeNo;
        }

        public void setTradeNo(String tradeNo) {
            this.tradeNo = tradeNo;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserMid() {
            return userMid;
        }

        public void setUserMid(String userMid) {
            this.userMid = userMid;
        }
    }


    /**
     * status : true
     * msg : 成功
     * data : [{"cardNo":"","circleState":-1,"createTime":"2020-10-21 18:24:27","id":"ff808081754a73de01754ab041f00004","orderCode":"123123123123123","phone":"1589123357","state":2,"tradeAmount":20,"tradeNo":"","updateTime":"","userId":"","userMid":"ff8080816f4045af01703d2131c00034"},{"cardNo":"30000002220000100","circleState":-1,"createTime":"2020-10-22 10:47:46","id":"ff808081754e311601754e34828a0002","orderCode":"123123123123123","phone":"1589123357","state":2,"tradeAmount":20,"tradeNo":"22222222222222","updateTime":"","userId":"","userMid":"ff8080816f4045af01703d2131c00034"},{"cardNo":"300044444442220000100","circleState":-1,"createTime":"2020-10-22 10:48:10","id":"ff808081754e311601754e34e0b50003","orderCode":"123123123123123","phone":"1589123357","state":2,"tradeAmount":20,"tradeNo":"2222333333222","updateTime":"","userId":"","userMid":"ff8080816f4045af01703d2131c00034"}]
     */
//
//    private boolean status;
//    private String msg;
//    private List<DataBean> data;
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public List<DataBean> getData() {
//        return data;
//    }
//
//    public void setData(List<DataBean> data) {
//        this.data = data;
//    }
//
//    public static class DataBean  implements Serializable {
//        /**
//         * cardNo :
//         * circleState : -1
//         * createTime : 2020-10-21 18:24:27
//         * id : ff808081754a73de01754ab041f00004
//         * orderCode : 123123123123123
//         * phone : 1589123357
//         * state : 2
//         * tradeAmount : 20
//         * tradeNo :
//         * updateTime :
//         * userId :
//         * userMid : ff8080816f4045af01703d2131c00034
//         */
//
//        private String cardNo;
//        private int circleState;
//        private String createTime;
//        private String id;
//        private String orderCode;
//        private String phone;
//        private int state;
//        private int tradeAmount;
//        private String tradeNo;
//        private String updateTime;
//        private String userId;
//        private String userMid;
//
//        public String getCardNo() {
//            return cardNo;
//        }
//
//        public void setCardNo(String cardNo) {
//            this.cardNo = cardNo;
//        }
//
//        public int getCircleState() {
//            return circleState;
//        }
//
//        public void setCircleState(int circleState) {
//            this.circleState = circleState;
//        }
//
//        public String getCreateTime() {
//            return createTime;
//        }
//
//        public void setCreateTime(String createTime) {
//            this.createTime = createTime;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getOrderCode() {
//            return orderCode;
//        }
//
//        public void setOrderCode(String orderCode) {
//            this.orderCode = orderCode;
//        }
//
//        public String getPhone() {
//            return phone;
//        }
//
//        public void setPhone(String phone) {
//            this.phone = phone;
//        }
//
//        public int getState() {
//            return state;
//        }
//
//        public void setState(int state) {
//            this.state = state;
//        }
//
//        public int getTradeAmount() {
//            return tradeAmount;
//        }
//
//        public void setTradeAmount(int tradeAmount) {
//            this.tradeAmount = tradeAmount;
//        }
//
//        public String getTradeNo() {
//            return tradeNo;
//        }
//
//        public void setTradeNo(String tradeNo) {
//            this.tradeNo = tradeNo;
//        }
//
//        public String getUpdateTime() {
//            return updateTime;
//        }
//
//        public void setUpdateTime(String updateTime) {
//            this.updateTime = updateTime;
//        }
//
//        public String getUserId() {
//            return userId;
//        }
//
//        public void setUserId(String userId) {
//            this.userId = userId;
//        }
//
//        public String getUserMid() {
//            return userMid;
//        }
//
//        public void setUserMid(String userMid) {
//            this.userMid = userMid;
//        }
//    }
}
