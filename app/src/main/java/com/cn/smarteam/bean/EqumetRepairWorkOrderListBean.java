package com.cn.smarteam.bean;

import java.util.List;

/**
 * Created by tzl
 * on 2021/1/6
 */
public class EqumetRepairWorkOrderListBean {

    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"pageNum":1,"pageSize":5,"size":5,"startRow":1,"endRow":5,"total":5,"pages":1,"list":[{"workOrderId":2,"woNum":"202012194524","description":"油管维修","actualFinishTime":"2020-12-14","actualStartTime":"2020-12-01","failureNum":"191","failureName":"正面吊大臂","failureTime":"2020-12-08","lastStartDate":null,"nextCompDate":null,"frequency":null,"freqUnit":null,"spotCheckType":null,"freqUnitValue":null,"worktype":2,"worktypeValue":"维修工单","spotCheckTypeValue":null},{"workOrderId":34,"woNum":"2020128104550","description":"起升上升无全速维修","actualFinishTime":"2020-12-08","actualStartTime":"2020-12-08","failureNum":"20201023125426","failureName":"起升故障","failureTime":"2020-12-08","lastStartDate":null,"nextCompDate":null,"frequency":null,"freqUnit":null,"spotCheckType":null,"freqUnitValue":null,"worktype":2,"worktypeValue":"维修工单","spotCheckTypeValue":null},{"workOrderId":38,"woNum":"2020128133114","description":"小车异响维修","actualFinishTime":"2020-12-08","actualStartTime":"2020-12-08","failureNum":"021","failureName":"小车主机构","failureTime":"2020-12-08","lastStartDate":null,"nextCompDate":null,"frequency":null,"freqUnit":null,"spotCheckType":null,"freqUnitValue":null,"worktype":2,"worktypeValue":"维修工单","spotCheckTypeValue":null},{"workOrderId":40,"woNum":"202012821366","description":"1","actualFinishTime":null,"actualStartTime":null,"failureNum":"20201023183740","failureName":"整车故障","failureTime":"2020-12-08","lastStartDate":null,"nextCompDate":null,"frequency":null,"freqUnit":null,"spotCheckType":null,"freqUnitValue":null,"worktype":2,"worktypeValue":"维修工单","spotCheckTypeValue":null},{"workOrderId":41,"woNum":"202012822436","description":"22","actualFinishTime":null,"actualStartTime":null,"failureNum":"20201023125426","failureName":"起升故障","failureTime":"2020-12-08","lastStartDate":null,"nextCompDate":null,"frequency":null,"freqUnit":null,"spotCheckType":null,"freqUnitValue":null,"worktype":2,"worktypeValue":"维修工单","spotCheckTypeValue":null}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"lastPage":1,"firstPage":1}
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
         * pageSize : 5
         * size : 5
         * startRow : 1
         * endRow : 5
         * total : 5
         * pages : 1
         * list : [{"workOrderId":2,"woNum":"202012194524","description":"油管维修","actualFinishTime":"2020-12-14","actualStartTime":"2020-12-01","failureNum":"191","failureName":"正面吊大臂","failureTime":"2020-12-08","lastStartDate":null,"nextCompDate":null,"frequency":null,"freqUnit":null,"spotCheckType":null,"freqUnitValue":null,"worktype":2,"worktypeValue":"维修工单","spotCheckTypeValue":null},{"workOrderId":34,"woNum":"2020128104550","description":"起升上升无全速维修","actualFinishTime":"2020-12-08","actualStartTime":"2020-12-08","failureNum":"20201023125426","failureName":"起升故障","failureTime":"2020-12-08","lastStartDate":null,"nextCompDate":null,"frequency":null,"freqUnit":null,"spotCheckType":null,"freqUnitValue":null,"worktype":2,"worktypeValue":"维修工单","spotCheckTypeValue":null},{"workOrderId":38,"woNum":"2020128133114","description":"小车异响维修","actualFinishTime":"2020-12-08","actualStartTime":"2020-12-08","failureNum":"021","failureName":"小车主机构","failureTime":"2020-12-08","lastStartDate":null,"nextCompDate":null,"frequency":null,"freqUnit":null,"spotCheckType":null,"freqUnitValue":null,"worktype":2,"worktypeValue":"维修工单","spotCheckTypeValue":null},{"workOrderId":40,"woNum":"202012821366","description":"1","actualFinishTime":null,"actualStartTime":null,"failureNum":"20201023183740","failureName":"整车故障","failureTime":"2020-12-08","lastStartDate":null,"nextCompDate":null,"frequency":null,"freqUnit":null,"spotCheckType":null,"freqUnitValue":null,"worktype":2,"worktypeValue":"维修工单","spotCheckTypeValue":null},{"workOrderId":41,"woNum":"202012822436","description":"22","actualFinishTime":null,"actualStartTime":null,"failureNum":"20201023125426","failureName":"起升故障","failureTime":"2020-12-08","lastStartDate":null,"nextCompDate":null,"frequency":null,"freqUnit":null,"spotCheckType":null,"freqUnitValue":null,"worktype":2,"worktypeValue":"维修工单","spotCheckTypeValue":null}]
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
         * lastPage : 1
         * firstPage : 1
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
        private int lastPage;
        private int firstPage;
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

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
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
             * workOrderId : 2
             * woNum : 202012194524
             * description : 油管维修
             * actualFinishTime : 2020-12-14
             * actualStartTime : 2020-12-01
             * failureNum : 191
             * failureName : 正面吊大臂
             * failureTime : 2020-12-08
             * lastStartDate : null
             * nextCompDate : null
             * frequency : null
             * freqUnit : null
             * spotCheckType : null
             * freqUnitValue : null
             * worktype : 2
             * worktypeValue : 维修工单
             * spotCheckTypeValue : null
             */

            private int workOrderId;
            private String woNum;
            private String description;
            private String actualFinishTime;
            private String actualStartTime;
            private String failureNum;
            private String failureName;
            private String failureTime;
            private Object lastStartDate;
            private Object nextCompDate;
            private Object frequency;
            private Object freqUnit;
            private Object spotCheckType;
            private Object freqUnitValue;
            private int worktype;
            private String worktypeValue;
            private Object spotCheckTypeValue;

            public int getWorkOrderId() {
                return workOrderId;
            }

            public void setWorkOrderId(int workOrderId) {
                this.workOrderId = workOrderId;
            }

            public String getWoNum() {
                return woNum;
            }

            public void setWoNum(String woNum) {
                this.woNum = woNum;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getActualFinishTime() {
                return actualFinishTime;
            }

            public void setActualFinishTime(String actualFinishTime) {
                this.actualFinishTime = actualFinishTime;
            }

            public String getActualStartTime() {
                return actualStartTime;
            }

            public void setActualStartTime(String actualStartTime) {
                this.actualStartTime = actualStartTime;
            }

            public String getFailureNum() {
                return failureNum;
            }

            public void setFailureNum(String failureNum) {
                this.failureNum = failureNum;
            }

            public String getFailureName() {
                return failureName;
            }

            public void setFailureName(String failureName) {
                this.failureName = failureName;
            }

            public String getFailureTime() {
                return failureTime;
            }

            public void setFailureTime(String failureTime) {
                this.failureTime = failureTime;
            }

            public Object getLastStartDate() {
                return lastStartDate;
            }

            public void setLastStartDate(Object lastStartDate) {
                this.lastStartDate = lastStartDate;
            }

            public Object getNextCompDate() {
                return nextCompDate;
            }

            public void setNextCompDate(Object nextCompDate) {
                this.nextCompDate = nextCompDate;
            }

            public Object getFrequency() {
                return frequency;
            }

            public void setFrequency(Object frequency) {
                this.frequency = frequency;
            }

            public Object getFreqUnit() {
                return freqUnit;
            }

            public void setFreqUnit(Object freqUnit) {
                this.freqUnit = freqUnit;
            }

            public Object getSpotCheckType() {
                return spotCheckType;
            }

            public void setSpotCheckType(Object spotCheckType) {
                this.spotCheckType = spotCheckType;
            }

            public Object getFreqUnitValue() {
                return freqUnitValue;
            }

            public void setFreqUnitValue(Object freqUnitValue) {
                this.freqUnitValue = freqUnitValue;
            }

            public int getWorktype() {
                return worktype;
            }

            public void setWorktype(int worktype) {
                this.worktype = worktype;
            }

            public String getWorktypeValue() {
                return worktypeValue;
            }

            public void setWorktypeValue(String worktypeValue) {
                this.worktypeValue = worktypeValue;
            }

            public Object getSpotCheckTypeValue() {
                return spotCheckTypeValue;
            }

            public void setSpotCheckTypeValue(Object spotCheckTypeValue) {
                this.spotCheckTypeValue = spotCheckTypeValue;
            }
        }
    }
}
