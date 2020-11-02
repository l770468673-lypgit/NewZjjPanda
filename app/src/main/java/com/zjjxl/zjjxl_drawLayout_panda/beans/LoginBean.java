package com.zjjxl.zjjxl_drawLayout_panda.beans;

public class LoginBean {
    /**
     * msg : 登录成功
     * userInfo : {"idcardId":"","isAutonym":0,"unionId":"",
     * "membershipLevel":"","orgMid":"","sex":0,"userMid":"ff8080816f4045af01703d2131c00034",
     * "mobile":"15689123357","photo":"","isPortrait":0,"idcardName":"","userName":"",
     * "isLocal":-1,"password":"e10adc3949ba59abbe56e057f20f883e",
     * "expireTime":"","createTime":"2020-10-21 17:22:22","identityId":"",
     * "id":"ff808081754a73de01754a776f8f0000","email":"","territory":""}
     * status : true
     */

    private String msg;
    private UserInfoBean userInfo;
    private boolean status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class UserInfoBean {
        /**
         * idcardId :
         * isAutonym : 0
         * unionId :
         * membershipLevel :
         * orgMid :
         * sex : 0
         * userMid : ff8080816f4045af01703d2131c00034
         * mobile : 15689123357
         * photo :
         * isPortrait : 0
         * idcardName :
         * userName :
         * isLocal : -1
         * password : e10adc3949ba59abbe56e057f20f883e
         * expireTime :
         * createTime : 2020-10-21 17:22:22
         * identityId :
         * id : ff808081754a73de01754a776f8f0000
         * email :
         * territory :
         */

        private String idcardId;
        private int isAutonym;
        private String unionId;
        private String membershipLevel;
        private String orgMid;
        private int sex;
        private String userMid;
        private String mobile;
        private String photo;
        private int isPortrait;
        private String idcardName;
        private String userName;
        private int isLocal;
        private String password;
        private String expireTime;
        private String createTime;
        private String identityId;
        private String id;
        private String email;
        private String territory;

        public String getIdcardId() {
            return idcardId;
        }

        public void setIdcardId(String idcardId) {
            this.idcardId = idcardId;
        }

        public int getIsAutonym() {
            return isAutonym;
        }

        public void setIsAutonym(int isAutonym) {
            this.isAutonym = isAutonym;
        }

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }

        public String getMembershipLevel() {
            return membershipLevel;
        }

        public void setMembershipLevel(String membershipLevel) {
            this.membershipLevel = membershipLevel;
        }

        public String getOrgMid() {
            return orgMid;
        }

        public void setOrgMid(String orgMid) {
            this.orgMid = orgMid;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getUserMid() {
            return userMid;
        }

        public void setUserMid(String userMid) {
            this.userMid = userMid;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getIsPortrait() {
            return isPortrait;
        }

        public void setIsPortrait(int isPortrait) {
            this.isPortrait = isPortrait;
        }

        public String getIdcardName() {
            return idcardName;
        }

        public void setIdcardName(String idcardName) {
            this.idcardName = idcardName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getIsLocal() {
            return isLocal;
        }

        public void setIsLocal(int isLocal) {
            this.isLocal = isLocal;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getIdentityId() {
            return identityId;
        }

        public void setIdentityId(String identityId) {
            this.identityId = identityId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTerritory() {
            return territory;
        }

        public void setTerritory(String territory) {
            this.territory = territory;
        }
    }

    /**
     * msg : 登录成功
     * userInfo : {"lastLoginTime":"2020-05-29 15:27:13",
     * "orgMemberId":"ff8080816f4045af016f6409510a0000",
     * "password":"903b77606da996aabffa247b46461d14",
     * "unionId":"","userMemberId":"ff8080816f4045af01703d2131c00034",
     * "createTime":"2020-01-10 10:10:48",
     * "openId":"oelNt5cHvCS95m-zhbhOSJSjvfM4",
     * "mobile":"15689123357",
     * "photo":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ7WJxtILFKyJuau5ZjqSpmn2Buia
     * VGJajsIoEgUBPjibRbfjFFxcr8ro6CZIXHWsHIibicERwtJprb1g/132",
     * "id":"ff8080816f89cb95016f8d37e55a0012","userName":"Keep"}
     * status : true
     */


    /**
     * {"msg":"登录成功",
     * "userInfo":{"idcardId":"",
     * "isAutonym":0,
     * "unionId":"",
     * "membershipLevel":"",
     * "orgMid":"",
     * "sex":0,
     * "userMid":"ff8080816f4045af01703d2131c00034",
     * "mobile":"15689123357",
     * "photo":"",
     * "isPortrait":0,
     * "idcardName":"","userName":"",
     * "isLocal":-1,"password":"e10adc3949ba59abbe56e057f20f883e",
     * "expireTime":"","createTime":"2020-10-21 17:22:22",
     * "identityId":"","id":"ff808081754a73de01754a776f8f0000","email":"","territory":""},"status":true}
     */
//
//    private String msg;
//    private UserInfoBean userInfo;
//    private boolean status;
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public UserInfoBean getUserInfo() {
//        return userInfo;
//    }
//
//    public void setUserInfo(UserInfoBean userInfo) {
//        this.userInfo = userInfo;
//    }
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//
//    public static class UserInfoBean {
//        /**
//         * lastLoginTime : 2020-05-29 15:27:13
//         * orgMemberId : ff8080816f4045af016f6409510a0000
//         * password : 903b77606da996aabffa247b46461d14
//         * unionId :
//         * userMemberId : ff8080816f4045af01703d2131c00034
//         * createTime : 2020-01-10 10:10:48
//         * openId : oelNt5cHvCS95m-zhbhOSJSjvfM4
//         * mobile : 15689123357
//         * photo : https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ7WJxtILFKyJuau5ZjqSpmn2BuiaVGJajsIoEgUBPjibRbfjFFxcr8ro6CZIXHWsHIibicERwtJprb1g/132
//         * id : ff8080816f89cb95016f8d37e55a0012
//         * userName : Keep
//         */
//
//        private String lastLoginTime;
//        private String orgMemberId;
//        private String password;
//        private String unionId;
//        private String userMemberId;
//        private String createTime;
//        private String openId;
//        private String mobile;
//        private String photo;
//        private String id;
//        private String userName;
//
//        public String getLastLoginTime() {
//            return lastLoginTime;
//        }
//
//        public void setLastLoginTime(String lastLoginTime) {
//            this.lastLoginTime = lastLoginTime;
//        }
//
//        public String getOrgMemberId() {
//            return orgMemberId;
//        }
//
//        public void setOrgMemberId(String orgMemberId) {
//            this.orgMemberId = orgMemberId;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//
//        public String getUnionId() {
//            return unionId;
//        }
//
//        public void setUnionId(String unionId) {
//            this.unionId = unionId;
//        }
//
//        public String getUserMemberId() {
//            return userMemberId;
//        }
//
//        public void setUserMemberId(String userMemberId) {
//            this.userMemberId = userMemberId;
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
//        public String getOpenId() {
//            return openId;
//        }
//
//        public void setOpenId(String openId) {
//            this.openId = openId;
//        }
//
//        public String getMobile() {
//            return mobile;
//        }
//
//        public void setMobile(String mobile) {
//            this.mobile = mobile;
//        }
//
//        public String getPhoto() {
//            return photo;
//        }
//
//        public void setPhoto(String photo) {
//            this.photo = photo;
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
//        public String getUserName() {
//            return userName;
//        }
//
//        public void setUserName(String userName) {
//            this.userName = userName;
//        }
//    }
}
