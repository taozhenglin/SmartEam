package com.cn.smarteam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2021/1/15
 */
public class StartndWorkListBean {


    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"pageNum":1,"pageSize":10,"size":10,"startRow":1,"endRow":10,"total":16,"pages":2,"list":[{"jobplanId":51,"jobPlanNum":"202012891142","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"钢丝绳保养作业","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"xmy","createTime":"2020-12-08","changeBy":"xmy","changeTime":"2020-12-08","dataFlag":null,"operationSteps":"如下所示","remarks":"","workContent":"钢丝绳保养","phoneNum":null},{"jobplanId":50,"jobPlanNum":"202012883315","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"更换水平轮作业","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"xmy","createTime":"2020-12-08","changeBy":"xmy","changeTime":"2020-12-08","dataFlag":null,"operationSteps":"如下所示：","remarks":"","workContent":"更换水平轮","phoneNum":null},{"jobplanId":48,"jobPlanNum":"20201125104917","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"缺省","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-25","changeBy":"xmy","changeTime":"2020-11-25","dataFlag":null,"operationSteps":"无","remarks":"无","workContent":"无","phoneNum":null},{"jobplanId":47,"jobPlanNum":"20201123163437","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检10-12#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检10-12#）\n","remarks":"","workContent":"场桥月检（月检+安检10-12#）\n","phoneNum":null},{"jobplanId":46,"jobPlanNum":"20201123163221","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检125-128#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检125-128#）","remarks":"","workContent":"场桥月检（月检+安检125-128#）","phoneNum":null},{"jobplanId":45,"jobPlanNum":"20201123163132","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检31-33/35/36/38-42#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检31-33/35/36/38-42#）","remarks":"","workContent":"场桥月检（月检+安检31-33/35/36/38-42#）","phoneNum":null},{"jobplanId":44,"jobPlanNum":"20201123162942","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检105-124#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检105-124#）","remarks":"","workContent":"场桥月检（月检+安检105-124#）","phoneNum":null},{"jobplanId":43,"jobPlanNum":"20201123162832","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检43-48#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检43-48#）","remarks":"","workContent":"场桥月检（月检+安检43-48#）","phoneNum":null},{"jobplanId":42,"jobPlanNum":"2020112316270","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检231-236#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检231-236#）","remarks":"","workContent":"场桥月检（月检+安检231-236#）","phoneNum":null},{"jobplanId":41,"jobPlanNum":"2020112316265","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检26-30/34/37#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检26-30/34/37#）","remarks":"","workContent":"场桥月检（月检+安检26-30/34/37#）","phoneNum":null}],"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2],"navigateFirstPage":1,"navigateLastPage":2,"firstPage":1,"lastPage":2}
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
         * pageNum : 1
         * pageSize : 10
         * size : 10
         * startRow : 1
         * endRow : 10
         * total : 16
         * pages : 2
         * list : [{"jobplanId":51,"jobPlanNum":"202012891142","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"钢丝绳保养作业","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"xmy","createTime":"2020-12-08","changeBy":"xmy","changeTime":"2020-12-08","dataFlag":null,"operationSteps":"如下所示","remarks":"","workContent":"钢丝绳保养","phoneNum":null},{"jobplanId":50,"jobPlanNum":"202012883315","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"更换水平轮作业","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"xmy","createTime":"2020-12-08","changeBy":"xmy","changeTime":"2020-12-08","dataFlag":null,"operationSteps":"如下所示：","remarks":"","workContent":"更换水平轮","phoneNum":null},{"jobplanId":48,"jobPlanNum":"20201125104917","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"缺省","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-25","changeBy":"xmy","changeTime":"2020-11-25","dataFlag":null,"operationSteps":"无","remarks":"无","workContent":"无","phoneNum":null},{"jobplanId":47,"jobPlanNum":"20201123163437","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检10-12#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检10-12#）\n","remarks":"","workContent":"场桥月检（月检+安检10-12#）\n","phoneNum":null},{"jobplanId":46,"jobPlanNum":"20201123163221","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检125-128#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检125-128#）","remarks":"","workContent":"场桥月检（月检+安检125-128#）","phoneNum":null},{"jobplanId":45,"jobPlanNum":"20201123163132","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检31-33/35/36/38-42#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检31-33/35/36/38-42#）","remarks":"","workContent":"场桥月检（月检+安检31-33/35/36/38-42#）","phoneNum":null},{"jobplanId":44,"jobPlanNum":"20201123162942","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检105-124#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检105-124#）","remarks":"","workContent":"场桥月检（月检+安检105-124#）","phoneNum":null},{"jobplanId":43,"jobPlanNum":"20201123162832","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检43-48#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检43-48#）","remarks":"","workContent":"场桥月检（月检+安检43-48#）","phoneNum":null},{"jobplanId":42,"jobPlanNum":"2020112316270","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检231-236#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检231-236#）","remarks":"","workContent":"场桥月检（月检+安检231-236#）","phoneNum":null},{"jobplanId":41,"jobPlanNum":"2020112316265","supervisor":"","supervisorValue":null,"ownerGroup":null,"ownerGroupValue":null,"ownerNum":"","ownerNumValue":null,"duration":"","personNum":"","personNumValue":null,"description":"场桥月检（月检+安检26-30/34/37#）","type":null,"typeValue":null,"orgNum":"","orgName":null,"siteNum":null,"siteName":null,"status":2,"statusValue":"活动","createBy":"admin","createTime":"2020-11-23","changeBy":"admin","changeTime":"2020-11-23","dataFlag":null,"operationSteps":"场桥月检（月检+安检26-30/34/37#）","remarks":"","workContent":"场桥月检（月检+安检26-30/34/37#）","phoneNum":null}]
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2]
         * navigateFirstPage : 1
         * navigateLastPage : 2
         * firstPage : 1
         * lastPage : 2
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

        public static class ListBean implements Serializable {
            /**
             * jobplanId : 51
             * jobPlanNum : 202012891142
             * supervisor :
             * supervisorValue : null
             * ownerGroup : null
             * ownerGroupValue : null
             * ownerNum :
             * ownerNumValue : null
             * duration :
             * personNum :
             * personNumValue : null
             * description : 钢丝绳保养作业
             * type : null
             * typeValue : null
             * orgNum :
             * orgName : null
             * siteNum : null
             * siteName : null
             * status : 2
             * statusValue : 活动
             * createBy : xmy
             * createTime : 2020-12-08
             * changeBy : xmy
             * changeTime : 2020-12-08
             * dataFlag : null
             * operationSteps : 如下所示
             * remarks :
             * workContent : 钢丝绳保养
             * phoneNum : null
             */

            private int jobplanId;
            private String jobPlanNum;
            private String supervisor;
            private Object supervisorValue;
            private Object ownerGroup;
            private Object ownerGroupValue;
            private String ownerNum;
            private Object ownerNumValue;
            private String duration;
            private String personNum;
            private Object personNumValue;
            private String description;
            private Object type;
            private Object typeValue;
            private String orgNum;
            private Object orgName;
            private Object siteNum;
            private Object siteName;
            private int status;
            private String statusValue;
            private String createBy;
            private String createTime;
            private String changeBy;
            private String changeTime;
            private Object dataFlag;
            private String operationSteps;
            private String remarks;
            private String workContent;
            private Object phoneNum;

            public int getJobplanId() {
                return jobplanId;
            }

            public void setJobplanId(int jobplanId) {
                this.jobplanId = jobplanId;
            }

            public String getJobPlanNum() {
                return jobPlanNum;
            }

            public void setJobPlanNum(String jobPlanNum) {
                this.jobPlanNum = jobPlanNum;
            }

            public String getSupervisor() {
                return supervisor;
            }

            public void setSupervisor(String supervisor) {
                this.supervisor = supervisor;
            }

            public Object getSupervisorValue() {
                return supervisorValue;
            }

            public void setSupervisorValue(Object supervisorValue) {
                this.supervisorValue = supervisorValue;
            }

            public Object getOwnerGroup() {
                return ownerGroup;
            }

            public void setOwnerGroup(Object ownerGroup) {
                this.ownerGroup = ownerGroup;
            }

            public Object getOwnerGroupValue() {
                return ownerGroupValue;
            }

            public void setOwnerGroupValue(Object ownerGroupValue) {
                this.ownerGroupValue = ownerGroupValue;
            }

            public String getOwnerNum() {
                return ownerNum;
            }

            public void setOwnerNum(String ownerNum) {
                this.ownerNum = ownerNum;
            }

            public Object getOwnerNumValue() {
                return ownerNumValue;
            }

            public void setOwnerNumValue(Object ownerNumValue) {
                this.ownerNumValue = ownerNumValue;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getPersonNum() {
                return personNum;
            }

            public void setPersonNum(String personNum) {
                this.personNum = personNum;
            }

            public Object getPersonNumValue() {
                return personNumValue;
            }

            public void setPersonNumValue(Object personNumValue) {
                this.personNumValue = personNumValue;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public Object getTypeValue() {
                return typeValue;
            }

            public void setTypeValue(Object typeValue) {
                this.typeValue = typeValue;
            }

            public String getOrgNum() {
                return orgNum;
            }

            public void setOrgNum(String orgNum) {
                this.orgNum = orgNum;
            }

            public Object getOrgName() {
                return orgName;
            }

            public void setOrgName(Object orgName) {
                this.orgName = orgName;
            }

            public Object getSiteNum() {
                return siteNum;
            }

            public void setSiteNum(Object siteNum) {
                this.siteNum = siteNum;
            }

            public Object getSiteName() {
                return siteName;
            }

            public void setSiteName(Object siteName) {
                this.siteName = siteName;
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

            public Object getDataFlag() {
                return dataFlag;
            }

            public void setDataFlag(Object dataFlag) {
                this.dataFlag = dataFlag;
            }

            public String getOperationSteps() {
                return operationSteps;
            }

            public void setOperationSteps(String operationSteps) {
                this.operationSteps = operationSteps;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getWorkContent() {
                return workContent;
            }

            public void setWorkContent(String workContent) {
                this.workContent = workContent;
            }

            public Object getPhoneNum() {
                return phoneNum;
            }

            public void setPhoneNum(Object phoneNum) {
                this.phoneNum = phoneNum;
            }
        }
    }
}
