package com.zjjxl.zjjxl_drawLayout_panda.beans;

public class Bean_BaseCard {


    /**
     * status : true
     * msg : 成功
     * data : {"trace_id":"20201029135640373","biz_type":"SERV_ORDER_REFUND","sign_type":"RSA2","sign":"BrEgoumO88O7JNvPKGpnk1zh2Ul4FZMAtXqItM0j9BkgnFsAQgGiFfQRIMT3xh78wv5azYRpLx6wrWVEj35o3Ta9Vm+NrfC8V6S4GjKWPW/sOdtWcIzpkN7x9CpqcXQAE6ks01IeBBpiGUkgSeFns9LXQi4Si1cVBhowsJjwKh3ETkK3L8f7fM8WjwgZtHb8TJ8Kpx2XoaC3QXA/JXL10XkXmm6ZMB4wzJp3b6qIbT6p7Jxgi1CwzHJrVViWVYN+sC/KYkDt/63B9uTI3EdvjZ5d0jOWICYO/BlDsm7aMo3gcK4iHuS/OBzlrbYZSSKcyl6ICevC+cm0vfHvl1lQ/w==","code":"1000","message":"处理成功。","data":{"out_trade_no":"sttsm4de03a5442ad47929935dc4366ba827e","server_time":"2020-10-29T13:56:40","trade_no":"20201029552373465248394231312432","trade_type":"REFUND"}}
     */

    private boolean status;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * trace_id : 20201029135640373
         * biz_type : SERV_ORDER_REFUND
         * sign_type : RSA2
         * sign : BrEgoumO88O7JNvPKGpnk1zh2Ul4FZMAtXqItM0j9BkgnFsAQgGiFfQRIMT3xh78wv5azYRpLx6wrWVEj35o3Ta9Vm+NrfC8V6S4GjKWPW/sOdtWcIzpkN7x9CpqcXQAE6ks01IeBBpiGUkgSeFns9LXQi4Si1cVBhowsJjwKh3ETkK3L8f7fM8WjwgZtHb8TJ8Kpx2XoaC3QXA/JXL10XkXmm6ZMB4wzJp3b6qIbT6p7Jxgi1CwzHJrVViWVYN+sC/KYkDt/63B9uTI3EdvjZ5d0jOWICYO/BlDsm7aMo3gcK4iHuS/OBzlrbYZSSKcyl6ICevC+cm0vfHvl1lQ/w==
         * code : 1000
         * message : 处理成功。
         * data : {"out_trade_no":"sttsm4de03a5442ad47929935dc4366ba827e","server_time":"2020-10-29T13:56:40","trade_no":"20201029552373465248394231312432","trade_type":"REFUND"}
         */

        private String trace_id;
        private String biz_type;
        private String sign_type;
        private String sign;
        private String code;
        private String message;
        private DataBean data;

        public String getTrace_id() {
            return trace_id;
        }

        public void setTrace_id(String trace_id) {
            this.trace_id = trace_id;
        }

        public String getBiz_type() {
            return biz_type;
        }

        public void setBiz_type(String biz_type) {
            this.biz_type = biz_type;
        }

        public String getSign_type() {
            return sign_type;
        }

        public void setSign_type(String sign_type) {
            this.sign_type = sign_type;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * out_trade_no : sttsm4de03a5442ad47929935dc4366ba827e
             * server_time : 2020-10-29T13:56:40
             * trade_no : 20201029552373465248394231312432
             * trade_type : REFUND
             */

            private String out_trade_no;
            private String server_time;
            private String trade_no;
            private String trade_type;

            public String getOut_trade_no() {
                return out_trade_no;
            }

            public void setOut_trade_no(String out_trade_no) {
                this.out_trade_no = out_trade_no;
            }

            public String getServer_time() {
                return server_time;
            }

            public void setServer_time(String server_time) {
                this.server_time = server_time;
            }

            public String getTrade_no() {
                return trade_no;
            }

            public void setTrade_no(String trade_no) {
                this.trade_no = trade_no;
            }

            public String getTrade_type() {
                return trade_type;
            }

            public void setTrade_type(String trade_type) {
                this.trade_type = trade_type;
            }
        }
    }
}
