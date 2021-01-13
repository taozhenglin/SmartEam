package com.cn.smarteam.bean;

import java.util.List;

/**
 * Created by tzl
 * on 2021/1/13
 */
public class WorkEqmentListBean {

    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"pageNum":1,"pageSize":3,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"workorderAssetId":10402,"assetNum":"Y204#场桥","assetType":2,"status":1,"description":"场内轨道式集装箱装卸设备","statusValue":"活动","assetTypeValue":"场桥","purchasePrice":600,"pmAssetId":null}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * pageSize : 3
         * size : 1
         * startRow : 1
         * endRow : 1
         * total : 1
         * pages : 1
         * list : [{"workorderAssetId":10402,"assetNum":"Y204#场桥","assetType":2,"status":1,"description":"场内轨道式集装箱装卸设备","statusValue":"活动","assetTypeValue":"场桥","purchasePrice":600,"pmAssetId":null}]
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
             * workorderAssetId : 10402
             * assetNum : Y204#场桥
             * assetType : 2
             * status : 1
             * description : 场内轨道式集装箱装卸设备
             * statusValue : 活动
             * assetTypeValue : 场桥
             * purchasePrice : 600
             * pmAssetId : null
             */

            private int workorderAssetId;
            private String assetNum;
            private int assetType;
            private int status;
            private String description;
            private String statusValue;
            private String assetTypeValue;
            private int purchasePrice;
            private Object pmAssetId;

            public int getWorkorderAssetId() {
                return workorderAssetId;
            }

            public void setWorkorderAssetId(int workorderAssetId) {
                this.workorderAssetId = workorderAssetId;
            }

            public String getAssetNum() {
                return assetNum;
            }

            public void setAssetNum(String assetNum) {
                this.assetNum = assetNum;
            }

            public int getAssetType() {
                return assetType;
            }

            public void setAssetType(int assetType) {
                this.assetType = assetType;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getStatusValue() {
                return statusValue;
            }

            public void setStatusValue(String statusValue) {
                this.statusValue = statusValue;
            }

            public String getAssetTypeValue() {
                return assetTypeValue;
            }

            public void setAssetTypeValue(String assetTypeValue) {
                this.assetTypeValue = assetTypeValue;
            }

            public int getPurchasePrice() {
                return purchasePrice;
            }

            public void setPurchasePrice(int purchasePrice) {
                this.purchasePrice = purchasePrice;
            }

            public Object getPmAssetId() {
                return pmAssetId;
            }

            public void setPmAssetId(Object pmAssetId) {
                this.pmAssetId = pmAssetId;
            }
        }
    }
}
