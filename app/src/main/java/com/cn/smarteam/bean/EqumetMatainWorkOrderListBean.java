package com.cn.smarteam.bean;

import java.util.List;

/**
 * Created by tzl
 * on 2021/1/6
 */
public class EqumetMatainWorkOrderListBean {

    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"pageNum":1,"pageSize":4,"size":4,"startRow":1,"endRow":4,"total":4,"pages":1,"list":[{"workOrderId":67,"woNum":"1609344001045","description":"钢丝绳检查及季度保养","actualFinishTime":null,"actualStartTime":null,"failureNum":null,"failureName":null,"failureTime":null,"lastStartDate":"2020-01-01","nextCompDate":"2020-12-31","frequency":365,"freqUnit":null,"spotCheckType":null,"freqUnitValue":"日","worktype":1,"worktypeValue":"保养工单","spotCheckTypeValue":null},{"workOrderId":76,"woNum":"1609430401043","description":"整车润滑保养","actualFinishTime":null,"actualStartTime":null,"failureNum":null,"failureName":null,"failureTime":null,"lastStartDate":"2020-01-01","nextCompDate":"2021-01-01","frequency":366,"freqUnit":null,"spotCheckType":null,"freqUnitValue":"日","worktype":1,"worktypeValue":"保养工单","spotCheckTypeValue":null},{"workOrderId":75,"woNum":"1609430401036","description":"制动器及电路检查、修改、保养，拖令电缆及组件检查保养","actualFinishTime":null,"actualStartTime":null,"failureNum":null,"failureName":null,"failureTime":null,"lastStartDate":"2020-01-01","nextCompDate":"2021-01-01","frequency":366,"freqUnit":null,"spotCheckType":null,"freqUnitValue":"日","worktype":1,"worktypeValue":"保养工单","spotCheckTypeValue":null},{"workOrderId":60,"woNum":"1607702401037","description":"钢丝绳保养","actualFinishTime":null,"actualStartTime":null,"failureNum":null,"failureName":null,"failureTime":null,"lastStartDate":"2020-09-12","nextCompDate":"2020-12-12","frequency":3,"freqUnit":null,"spotCheckType":null,"freqUnitValue":"月","worktype":1,"worktypeValue":"保养工单","spotCheckTypeValue":null}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"lastPage":1,"firstPage":1}
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
         * pageSize : 4
         * size : 4
         * startRow : 1
         * endRow : 4
         * total : 4
         * pages : 1
         * list : [{"workOrderId":67,"woNum":"1609344001045","description":"钢丝绳检查及季度保养","actualFinishTime":null,"actualStartTime":null,"failureNum":null,"failureName":null,"failureTime":null,"lastStartDate":"2020-01-01","nextCompDate":"2020-12-31","frequency":365,"freqUnit":null,"spotCheckType":null,"freqUnitValue":"日","worktype":1,"worktypeValue":"保养工单","spotCheckTypeValue":null},{"workOrderId":76,"woNum":"1609430401043","description":"整车润滑保养","actualFinishTime":null,"actualStartTime":null,"failureNum":null,"failureName":null,"failureTime":null,"lastStartDate":"2020-01-01","nextCompDate":"2021-01-01","frequency":366,"freqUnit":null,"spotCheckType":null,"freqUnitValue":"日","worktype":1,"worktypeValue":"保养工单","spotCheckTypeValue":null},{"workOrderId":75,"woNum":"1609430401036","description":"制动器及电路检查、修改、保养，拖令电缆及组件检查保养","actualFinishTime":null,"actualStartTime":null,"failureNum":null,"failureName":null,"failureTime":null,"lastStartDate":"2020-01-01","nextCompDate":"2021-01-01","frequency":366,"freqUnit":null,"spotCheckType":null,"freqUnitValue":"日","worktype":1,"worktypeValue":"保养工单","spotCheckTypeValue":null},{"workOrderId":60,"woNum":"1607702401037","description":"钢丝绳保养","actualFinishTime":null,"actualStartTime":null,"failureNum":null,"failureName":null,"failureTime":null,"lastStartDate":"2020-09-12","nextCompDate":"2020-12-12","frequency":3,"freqUnit":null,"spotCheckType":null,"freqUnitValue":"月","worktype":1,"worktypeValue":"保养工单","spotCheckTypeValue":null}]
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
             * workOrderId : 67
             * woNum : 1609344001045
             * description : 钢丝绳检查及季度保养
             * actualFinishTime : null
             * actualStartTime : null
             * failureNum : null
             * failureName : null
             * failureTime : null
             * lastStartDate : 2020-01-01
             * nextCompDate : 2020-12-31
             * frequency : 365
             * freqUnit : null
             * spotCheckType : null
             * freqUnitValue : 日
             * worktype : 1
             * worktypeValue : 保养工单
             * spotCheckTypeValue : null
             */

            private int workOrderId;
            private String woNum;
            private String description;
            private Object actualFinishTime;
            private Object actualStartTime;
            private Object failureNum;
            private Object failureName;
            private Object failureTime;
            private String lastStartDate;
            private String nextCompDate;
            private int frequency;
            private Object freqUnit;
            private Object spotCheckType;
            private String freqUnitValue;
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

            public Object getActualFinishTime() {
                return actualFinishTime;
            }

            public void setActualFinishTime(Object actualFinishTime) {
                this.actualFinishTime = actualFinishTime;
            }

            public Object getActualStartTime() {
                return actualStartTime;
            }

            public void setActualStartTime(Object actualStartTime) {
                this.actualStartTime = actualStartTime;
            }

            public Object getFailureNum() {
                return failureNum;
            }

            public void setFailureNum(Object failureNum) {
                this.failureNum = failureNum;
            }

            public Object getFailureName() {
                return failureName;
            }

            public void setFailureName(Object failureName) {
                this.failureName = failureName;
            }

            public Object getFailureTime() {
                return failureTime;
            }

            public void setFailureTime(Object failureTime) {
                this.failureTime = failureTime;
            }

            public String getLastStartDate() {
                return lastStartDate;
            }

            public void setLastStartDate(String lastStartDate) {
                this.lastStartDate = lastStartDate;
            }

            public String getNextCompDate() {
                return nextCompDate;
            }

            public void setNextCompDate(String nextCompDate) {
                this.nextCompDate = nextCompDate;
            }

            public int getFrequency() {
                return frequency;
            }

            public void setFrequency(int frequency) {
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

            public String getFreqUnitValue() {
                return freqUnitValue;
            }

            public void setFreqUnitValue(String freqUnitValue) {
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
