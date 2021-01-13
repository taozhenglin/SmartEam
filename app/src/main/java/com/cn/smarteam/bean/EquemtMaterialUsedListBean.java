package com.cn.smarteam.bean;

import java.util.List;

/**
 * Created by tzl
 * on 2021/1/5
 */
public class EquemtMaterialUsedListBean {

    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"pageNum":1,"pageSize":5,"size":3,"startRow":1,"endRow":3,"total":3,"pages":1,"list":[{"workorderWomaterialid":25,"jobtaskNum":null,"itemNum":"25","itemNumValue":null,"accessoriesName":"2号锂基脂","storeroomNumValue":null,"quantity":2,"unitCost":289,"lineCost":578,"woNum":null,"woTaskNum":null,"jobplanNum":"202012891142","specifications":"2号锂基脂","cost":10756},{"workorderWomaterialid":22,"jobtaskNum":null,"itemNum":"10000","itemNumValue":null,"accessoriesName":"水平轮","storeroomNumValue":null,"quantity":4,"unitCost":2400,"lineCost":9600,"woNum":null,"woTaskNum":null,"jobplanNum":"202012883315","specifications":"SPL-5632","cost":10756},{"workorderWomaterialid":24,"jobtaskNum":null,"itemNum":"763","itemNumValue":null,"accessoriesName":"2号锂基脂","storeroomNumValue":null,"quantity":2,"unitCost":289,"lineCost":578,"woNum":null,"woTaskNum":null,"jobplanNum":null,"specifications":"2号锂基脂","cost":10756}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1,"firstPage":1,"lastPage":1}
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
         * size : 3
         * startRow : 1
         * endRow : 3
         * total : 3
         * pages : 1
         * list : [{"workorderWomaterialid":25,"jobtaskNum":null,"itemNum":"25","itemNumValue":null,"accessoriesName":"2号锂基脂","storeroomNumValue":null,"quantity":2,"unitCost":289,"lineCost":578,"woNum":null,"woTaskNum":null,"jobplanNum":"202012891142","specifications":"2号锂基脂","cost":10756},{"workorderWomaterialid":22,"jobtaskNum":null,"itemNum":"10000","itemNumValue":null,"accessoriesName":"水平轮","storeroomNumValue":null,"quantity":4,"unitCost":2400,"lineCost":9600,"woNum":null,"woTaskNum":null,"jobplanNum":"202012883315","specifications":"SPL-5632","cost":10756},{"workorderWomaterialid":24,"jobtaskNum":null,"itemNum":"763","itemNumValue":null,"accessoriesName":"2号锂基脂","storeroomNumValue":null,"quantity":2,"unitCost":289,"lineCost":578,"woNum":null,"woTaskNum":null,"jobplanNum":null,"specifications":"2号锂基脂","cost":10756}]
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
             * workorderWomaterialid : 25
             * jobtaskNum : null
             * itemNum : 25
             * itemNumValue : null
             * accessoriesName : 2号锂基脂
             * storeroomNumValue : null
             * quantity : 2
             * unitCost : 289
             * lineCost : 578
             * woNum : null
             * woTaskNum : null
             * jobplanNum : 202012891142
             * specifications : 2号锂基脂
             * cost : 10756
             */

            private int workorderWomaterialid;
            private Object jobtaskNum;
            private String itemNum;
            private Object itemNumValue;
            private String accessoriesName;
            private Object storeroomNumValue;
            private int quantity;
            private int unitCost;
            private int lineCost;
            private Object woNum;
            private Object woTaskNum;
            private String jobplanNum;
            private String specifications;
            private int cost;

            public int getWorkorderWomaterialid() {
                return workorderWomaterialid;
            }

            public void setWorkorderWomaterialid(int workorderWomaterialid) {
                this.workorderWomaterialid = workorderWomaterialid;
            }

            public Object getJobtaskNum() {
                return jobtaskNum;
            }

            public void setJobtaskNum(Object jobtaskNum) {
                this.jobtaskNum = jobtaskNum;
            }

            public String getItemNum() {
                return itemNum;
            }

            public void setItemNum(String itemNum) {
                this.itemNum = itemNum;
            }

            public Object getItemNumValue() {
                return itemNumValue;
            }

            public void setItemNumValue(Object itemNumValue) {
                this.itemNumValue = itemNumValue;
            }

            public String getAccessoriesName() {
                return accessoriesName;
            }

            public void setAccessoriesName(String accessoriesName) {
                this.accessoriesName = accessoriesName;
            }

            public Object getStoreroomNumValue() {
                return storeroomNumValue;
            }

            public void setStoreroomNumValue(Object storeroomNumValue) {
                this.storeroomNumValue = storeroomNumValue;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getUnitCost() {
                return unitCost;
            }

            public void setUnitCost(int unitCost) {
                this.unitCost = unitCost;
            }

            public int getLineCost() {
                return lineCost;
            }

            public void setLineCost(int lineCost) {
                this.lineCost = lineCost;
            }

            public Object getWoNum() {
                return woNum;
            }

            public void setWoNum(Object woNum) {
                this.woNum = woNum;
            }

            public Object getWoTaskNum() {
                return woTaskNum;
            }

            public void setWoTaskNum(Object woTaskNum) {
                this.woTaskNum = woTaskNum;
            }

            public String getJobplanNum() {
                return jobplanNum;
            }

            public void setJobplanNum(String jobplanNum) {
                this.jobplanNum = jobplanNum;
            }

            public String getSpecifications() {
                return specifications;
            }

            public void setSpecifications(String specifications) {
                this.specifications = specifications;
            }

            public int getCost() {
                return cost;
            }

            public void setCost(int cost) {
                this.cost = cost;
            }
        }
    }
}
