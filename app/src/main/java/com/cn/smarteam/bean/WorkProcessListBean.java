package com.cn.smarteam.bean;

import java.util.List;

/**
 * Created by tzl
 * on 2021/1/12
 */
public class WorkProcessListBean {

    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"pageNum":1,"pageSize":10,"size":5,"startRow":1,"endRow":5,"total":5,"pages":1,"list":[{"workOrderTaskId":12316,"orgNum":null,"siteNum":null,"createBy":null,"createTime":null,"changeBy":"admin","changeTime":"2020-12-12","status":null,"dataFlag":null,"jobPlanNum":"202012891142","type":null,"seqNum":630,"description":"检查:绳端固定是否牢固,可靠。","duration":null,"personNum":null,"jobtaskNum":"1","woNum":"1607702401037","pmNum":null,"woTaskNum":null,"dataSource":null},{"workOrderTaskId":12317,"orgNum":null,"siteNum":null,"createBy":null,"createTime":null,"changeBy":"admin","changeTime":"2020-12-12","status":null,"dataFlag":null,"jobPlanNum":"202012891142","type":null,"seqNum":631,"description":"检查钢丝绳是否有断丝、断股、磨损程度。","duration":null,"personNum":null,"jobtaskNum":"2","woNum":"1607702401037","pmNum":null,"woTaskNum":null,"dataSource":null},{"workOrderTaskId":12318,"orgNum":null,"siteNum":null,"createBy":null,"createTime":null,"changeBy":"admin","changeTime":"2020-12-12","status":null,"dataFlag":null,"jobPlanNum":"202012891142","type":null,"seqNum":632,"description":"检查安全圈数","duration":null,"personNum":null,"jobtaskNum":"3","woNum":"1607702401037","pmNum":null,"woTaskNum":null,"dataSource":null},{"workOrderTaskId":12319,"orgNum":null,"siteNum":null,"createBy":null,"createTime":null,"changeBy":"admin","changeTime":"2020-12-12","status":null,"dataFlag":null,"jobPlanNum":"202012891142","type":null,"seqNum":633,"description":"查看挡绳装置","duration":null,"personNum":null,"jobtaskNum":"4","woNum":"1607702401037","pmNum":null,"woTaskNum":null,"dataSource":null},{"workOrderTaskId":12320,"orgNum":null,"siteNum":null,"createBy":null,"createTime":null,"changeBy":"admin","changeTime":"2020-12-12","status":null,"dataFlag":null,"jobPlanNum":"202012891142","type":null,"seqNum":634,"description":"润滑钢丝和滑轮组","duration":null,"personNum":null,"jobtaskNum":"5","woNum":"1607702401037","pmNum":null,"woTaskNum":null,"dataSource":null}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * size : 5
         * startRow : 1
         * endRow : 5
         * total : 5
         * pages : 1
         * list : [{"workOrderTaskId":12316,"orgNum":null,"siteNum":null,"createBy":null,"createTime":null,"changeBy":"admin","changeTime":"2020-12-12","status":null,"dataFlag":null,"jobPlanNum":"202012891142","type":null,"seqNum":630,"description":"检查:绳端固定是否牢固,可靠。","duration":null,"personNum":null,"jobtaskNum":"1","woNum":"1607702401037","pmNum":null,"woTaskNum":null,"dataSource":null},{"workOrderTaskId":12317,"orgNum":null,"siteNum":null,"createBy":null,"createTime":null,"changeBy":"admin","changeTime":"2020-12-12","status":null,"dataFlag":null,"jobPlanNum":"202012891142","type":null,"seqNum":631,"description":"检查钢丝绳是否有断丝、断股、磨损程度。","duration":null,"personNum":null,"jobtaskNum":"2","woNum":"1607702401037","pmNum":null,"woTaskNum":null,"dataSource":null},{"workOrderTaskId":12318,"orgNum":null,"siteNum":null,"createBy":null,"createTime":null,"changeBy":"admin","changeTime":"2020-12-12","status":null,"dataFlag":null,"jobPlanNum":"202012891142","type":null,"seqNum":632,"description":"检查安全圈数","duration":null,"personNum":null,"jobtaskNum":"3","woNum":"1607702401037","pmNum":null,"woTaskNum":null,"dataSource":null},{"workOrderTaskId":12319,"orgNum":null,"siteNum":null,"createBy":null,"createTime":null,"changeBy":"admin","changeTime":"2020-12-12","status":null,"dataFlag":null,"jobPlanNum":"202012891142","type":null,"seqNum":633,"description":"查看挡绳装置","duration":null,"personNum":null,"jobtaskNum":"4","woNum":"1607702401037","pmNum":null,"woTaskNum":null,"dataSource":null},{"workOrderTaskId":12320,"orgNum":null,"siteNum":null,"createBy":null,"createTime":null,"changeBy":"admin","changeTime":"2020-12-12","status":null,"dataFlag":null,"jobPlanNum":"202012891142","type":null,"seqNum":634,"description":"润滑钢丝和滑轮组","duration":null,"personNum":null,"jobtaskNum":"5","woNum":"1607702401037","pmNum":null,"woTaskNum":null,"dataSource":null}]
         * prePage : 0
         * nextPage : 0
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         * navigateFirstPage : 1
         * navigateLastPage : 1
         * firstPage : 1
         * lastPage : 1
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

        public static class ListBean {
            /**
             * workOrderTaskId : 12316
             * orgNum : null
             * siteNum : null
             * createBy : null
             * createTime : null
             * changeBy : admin
             * changeTime : 2020-12-12
             * status : null
             * dataFlag : null
             * jobPlanNum : 202012891142
             * type : null
             * seqNum : 630
             * description : 检查:绳端固定是否牢固,可靠。
             * duration : null
             * personNum : null
             * jobtaskNum : 1
             * woNum : 1607702401037
             * pmNum : null
             * woTaskNum : null
             * dataSource : null
             */

            private int workOrderTaskId;
            private Object orgNum;
            private Object siteNum;
            private Object createBy;
            private Object createTime;
            private String changeBy;
            private String changeTime;
            private Object status;
            private Object dataFlag;
            private String jobPlanNum;
            private Object type;
            private int seqNum;
            private String description;
            private Object duration;
            private Object personNum;
            private String jobtaskNum;
            private String woNum;
            private Object pmNum;
            private Object woTaskNum;
            private Object dataSource;

            public int getWorkOrderTaskId() {
                return workOrderTaskId;
            }

            public void setWorkOrderTaskId(int workOrderTaskId) {
                this.workOrderTaskId = workOrderTaskId;
            }

            public Object getOrgNum() {
                return orgNum;
            }

            public void setOrgNum(Object orgNum) {
                this.orgNum = orgNum;
            }

            public Object getSiteNum() {
                return siteNum;
            }

            public void setSiteNum(Object siteNum) {
                this.siteNum = siteNum;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
                this.createBy = createBy;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
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

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getDataFlag() {
                return dataFlag;
            }

            public void setDataFlag(Object dataFlag) {
                this.dataFlag = dataFlag;
            }

            public String getJobPlanNum() {
                return jobPlanNum;
            }

            public void setJobPlanNum(String jobPlanNum) {
                this.jobPlanNum = jobPlanNum;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public int getSeqNum() {
                return seqNum;
            }

            public void setSeqNum(int seqNum) {
                this.seqNum = seqNum;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Object getDuration() {
                return duration;
            }

            public void setDuration(Object duration) {
                this.duration = duration;
            }

            public Object getPersonNum() {
                return personNum;
            }

            public void setPersonNum(Object personNum) {
                this.personNum = personNum;
            }

            public String getJobtaskNum() {
                return jobtaskNum;
            }

            public void setJobtaskNum(String jobtaskNum) {
                this.jobtaskNum = jobtaskNum;
            }

            public String getWoNum() {
                return woNum;
            }

            public void setWoNum(String woNum) {
                this.woNum = woNum;
            }

            public Object getPmNum() {
                return pmNum;
            }

            public void setPmNum(Object pmNum) {
                this.pmNum = pmNum;
            }

            public Object getWoTaskNum() {
                return woTaskNum;
            }

            public void setWoTaskNum(Object woTaskNum) {
                this.woTaskNum = woTaskNum;
            }

            public Object getDataSource() {
                return dataSource;
            }

            public void setDataSource(Object dataSource) {
                this.dataSource = dataSource;
            }
        }
    }
}
