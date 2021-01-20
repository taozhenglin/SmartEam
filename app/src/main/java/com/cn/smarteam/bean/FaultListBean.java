package com.cn.smarteam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2021/1/15
 */
public class FaultListBean {

    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"pageNum":1,"pageSize":10,"size":10,"startRow":1,"endRow":10,"total":62,"pages":7,"list":[{"failureId":65,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"fanji","createTime":"2020-07-27","changeBy":"fanji","changeTime":"2020-10-12","status":0,"statusValue":"禁用","failureNum":"20201023183740","type":1,"typeValue":"分类","parent":null,"description":"整车故障","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":267,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-23","changeBy":"admin","changeTime":"2020-10-23","status":0,"statusValue":"禁用","failureNum":"20201023125426","type":1,"typeValue":"分类","parent":null,"description":"起升故障","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10451,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"011","type":1,"typeValue":"分类","parent":null,"description":"起升主机构","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10452,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"012","type":1,"typeValue":"分类","parent":null,"description":"起升紧急制动器","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10453,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"013","type":1,"typeValue":"分类","parent":null,"description":"称重系统","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10454,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"014","type":1,"typeValue":"分类","parent":null,"description":"吊具卷缆","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10455,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"015","type":1,"typeValue":"分类","parent":null,"description":"起升钢丝绳","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10456,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"021","type":1,"typeValue":"分类","parent":null,"description":"小车主机构","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10457,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"022","type":1,"typeValue":"分类","parent":null,"description":"小车张紧","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10458,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"023","type":1,"typeValue":"分类","parent":null,"description":"输缆装置","dataFlag":1,"dataFlagValue":"启用","count":null}],"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6,7],"navigateFirstPage":1,"navigateLastPage":7,"firstPage":1,"lastPage":7}
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

    public static class DataBean implements Serializable {
        /**
         * pageNum : 1
         * pageSize : 10
         * size : 10
         * startRow : 1
         * endRow : 10
         * total : 62
         * pages : 7
         * list : [{"failureId":65,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"fanji","createTime":"2020-07-27","changeBy":"fanji","changeTime":"2020-10-12","status":0,"statusValue":"禁用","failureNum":"20201023183740","type":1,"typeValue":"分类","parent":null,"description":"整车故障","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":267,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-23","changeBy":"admin","changeTime":"2020-10-23","status":0,"statusValue":"禁用","failureNum":"20201023125426","type":1,"typeValue":"分类","parent":null,"description":"起升故障","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10451,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"011","type":1,"typeValue":"分类","parent":null,"description":"起升主机构","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10452,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"012","type":1,"typeValue":"分类","parent":null,"description":"起升紧急制动器","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10453,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"013","type":1,"typeValue":"分类","parent":null,"description":"称重系统","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10454,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"014","type":1,"typeValue":"分类","parent":null,"description":"吊具卷缆","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10455,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"015","type":1,"typeValue":"分类","parent":null,"description":"起升钢丝绳","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10456,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"021","type":1,"typeValue":"分类","parent":null,"description":"小车主机构","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10457,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"022","type":1,"typeValue":"分类","parent":null,"description":"小车张紧","dataFlag":1,"dataFlagValue":"启用","count":null},{"failureId":10458,"orgNum":"GUIDE","orgName":"港迪电气","siteNum":"GUIDE-SOFT","siteName":"港迪软件","createBy":"admin","createTime":"2020-10-28","changeBy":"admin","changeTime":"2020-10-28","status":0,"statusValue":"禁用","failureNum":"023","type":1,"typeValue":"分类","parent":null,"description":"输缆装置","dataFlag":1,"dataFlagValue":"启用","count":null}]
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3,4,5,6,7]
         * navigateFirstPage : 1
         * navigateLastPage : 7
         * firstPage : 1
         * lastPage : 7
         */

        private int pageNum;
        private int pageSize;
        private int size;
        private int startRow;
        private int endRow;
        private int total;
        private int pages;
        private int prePage;
        private int nextPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private int navigateFirstPage;
        private int navigateLastPage;
        private int firstPage;
        private int lastPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(int navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public int getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(int navigateLastPage) {
            this.navigateLastPage = navigateLastPage;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean implements Serializable{
            /**
             * failureId : 65
             * orgNum : GUIDE
             * orgName : 港迪电气
             * siteNum : GUIDE-SOFT
             * siteName : 港迪软件
             * createBy : fanji
             * createTime : 2020-07-27
             * changeBy : fanji
             * changeTime : 2020-10-12
             * status : 0
             * statusValue : 禁用
             * failureNum : 20201023183740
             * type : 1
             * typeValue : 分类
             * parent : null
             * description : 整车故障
             * dataFlag : 1
             * dataFlagValue : 启用
             * count : null
             */

            private int failureId;
            private String orgNum;
            private String orgName;
            private String siteNum;
            private String siteName;
            private String createBy;
            private String createTime;
            private String changeBy;
            private String changeTime;
            private int status;
            private String statusValue;
            private String failureNum;
            private int type;
            private String typeValue;
            private Object parent;
            private String description;
            private int dataFlag;
            private String dataFlagValue;
            private Object count;

            public int getFailureId() {
                return failureId;
            }

            public void setFailureId(int failureId) {
                this.failureId = failureId;
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

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getChangeBy() {
                return changeBy;
            }

            public void setChangeBy(String changeBy) {
                this.changeBy = changeBy;
            }

            public String getChangeTime() {
                return changeTime;
            }

            public void setChangeTime(String changeTime) {
                this.changeTime = changeTime;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getStatusValue() {
                return statusValue;
            }

            public void setStatusValue(String statusValue) {
                this.statusValue = statusValue;
            }

            public String getFailureNum() {
                return failureNum;
            }

            public void setFailureNum(String failureNum) {
                this.failureNum = failureNum;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getTypeValue() {
                return typeValue;
            }

            public void setTypeValue(String typeValue) {
                this.typeValue = typeValue;
            }

            public Object getParent() {
                return parent;
            }

            public void setParent(Object parent) {
                this.parent = parent;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getDataFlag() {
                return dataFlag;
            }

            public void setDataFlag(int dataFlag) {
                this.dataFlag = dataFlag;
            }

            public String getDataFlagValue() {
                return dataFlagValue;
            }

            public void setDataFlagValue(String dataFlagValue) {
                this.dataFlagValue = dataFlagValue;
            }

            public Object getCount() {
                return count;
            }

            public void setCount(Object count) {
                this.count = count;
            }
        }
    }
}
