package com.zjjxl.zjjxl_drawLayout_panda.beans;

public class queryUserInfoByUserMobileBean {

    /**
     * userInfo : {"createTime":"2020-10-21 17:22:22","email":"","expireTime":"","id":"ff808081754a73de01754a776f8f0000","idcardId":"","idcardName":"","identityId":"","isAutonym":0,"isLocal":-1,"isPortrait":0,"membershipLevel":"","mobile":"15689123357","orgMid":"","password":"e10adc3949ba59abbe56e057f20f883e","photo":"","sex":0,"territory":"","unionId":"","userMid":"ff8080816f4045af01703d2131c00034","userName":""}
     * status : true
     * msg : 查询成功
     */

    private UserInfoBean userInfo;
    private boolean status;
    private String msg;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class UserInfoBean {
        /**
         * createTime : 2020-10-21 17:22:22
         * email :
         * expireTime :
         * id : ff808081754a73de01754a776f8f0000
         * idcardId :
         * idcardName :
         * identityId :
         * isAutonym : 0
         * isLocal : -1
         * isPortrait : 0
         * membershipLevel :
         * mobile : 15689123357
         * orgMid :
         * password : e10adc3949ba59abbe56e057f20f883e
         * photo :
         * sex : 0
         * territory :
         * unionId :
         * userMid : ff8080816f4045af01703d2131c00034
         * userName :
         */

        private String createTime;
        private String email;
        private String expireTime;
        private String id;
        private String idcardId;
        private String idcardName;
        private String identityId;
        private int isAutonym;
        private int isLocal;
        private int isPortrait;
        private String membershipLevel;
        private String mobile;
        private String orgMid;
        private String password;
        private String photo;
        private int sex;
        private String territory;
        private String unionId;
        private String userMid;
        private String userName;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdcardId() {
            return idcardId;
        }

        public void setIdcardId(String idcardId) {
            this.idcardId = idcardId;
        }

        public String getIdcardName() {
            return idcardName;
        }

        public void setIdcardName(String idcardName) {
            this.idcardName = idcardName;
        }

        public String getIdentityId() {
            return identityId;
        }

        public void setIdentityId(String identityId) {
            this.identityId = identityId;
        }

        public int getIsAutonym() {
            return isAutonym;
        }

        public void setIsAutonym(int isAutonym) {
            this.isAutonym = isAutonym;
        }

        public int getIsLocal() {
            return isLocal;
        }

        public void setIsLocal(int isLocal) {
            this.isLocal = isLocal;
        }

        public int getIsPortrait() {
            return isPortrait;
        }

        public void setIsPortrait(int isPortrait) {
            this.isPortrait = isPortrait;
        }

        public String getMembershipLevel() {
            return membershipLevel;
        }

        public void setMembershipLevel(String membershipLevel) {
            this.membershipLevel = membershipLevel;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getOrgMid() {
            return orgMid;
        }

        public void setOrgMid(String orgMid) {
            this.orgMid = orgMid;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getTerritory() {
            return territory;
        }

        public void setTerritory(String territory) {
            this.territory = territory;
        }

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }

        public String getUserMid() {
            return userMid;
        }

        public void setUserMid(String userMid) {
            this.userMid = userMid;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
