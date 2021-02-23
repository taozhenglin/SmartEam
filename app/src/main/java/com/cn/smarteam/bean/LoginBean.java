package com.cn.smarteam.bean;

/**
 * Created by tzl
 * on 2020/12/25
 */
public class LoginBean {


    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"authorization":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMDAwMCIsImV4cCI6MTYwOTIxOTAxNCwiaWF0IjoxNjA5MTMyNjE0fQ.lwe0lbZ73gKYsTlFZRcbkQ70SfbTQ8e6-2igR_mKsmw","userNum":"10001","defaultSiteNum":"GUIDE-SOFT","orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","phoneNum":"15527492036","personNum":"10000","userName":"admin","userId":"10000"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * authorization : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMDAwMCIsImV4cCI6MTYwOTIxOTAxNCwiaWF0IjoxNjA5MTMyNjE0fQ.lwe0lbZ73gKYsTlFZRcbkQ70SfbTQ8e6-2igR_mKsmw
         * userNum : 10001
         * defaultSiteNum : GUIDE-SOFT
         * orgNum : GUIDE
         * orgName : 港迪电气
         * siteNum : GUIDE-SOFT
         * siteName : 港迪软件
         * phoneNum : 15527492036
         * personNum : 10000
         * userName : admin
         * userId : 10000
         */

        private String authorization;
        private String userNum;
        private String defaultSiteNum;
        private String orgNum;
        private String orgName;
        private String siteNum;
        private String siteName;
        private String phoneNum;
        private String personNum;
        private String userName;
        private String userId;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        private int count;

        public String getAuthorization() {
            return authorization;
        }

        public void setAuthorization(String authorization) {
            this.authorization = authorization;
        }

        public String getUserNum() {
            return userNum;
        }

        public void setUserNum(String userNum) {
            this.userNum = userNum;
        }

        public String getDefaultSiteNum() {
            return defaultSiteNum;
        }

        public void setDefaultSiteNum(String defaultSiteNum) {
            this.defaultSiteNum = defaultSiteNum;
        }

        public String getOrgNum() {
            return orgNum;
        }

        public void setOrgNum(String orgNum) {
            this.orgNum = orgNum;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public String getSiteNum() {
            return siteNum;
        }

        public void setSiteNum(String siteNum) {
            this.siteNum = siteNum;
        }

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }

        public String getPersonNum() {
            return personNum;
        }

        public void setPersonNum(String personNum) {
            this.personNum = personNum;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
