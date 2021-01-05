package com.cn.smarteam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2020/12/30
 */
public class EquementListBean {

    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"pageNum":1,"pageSize":3,"size":3,"startRow":1,"endRow":3,"total":16,"pages":6,"list":[{"assetId":10016,"assetNum":"Y103#岸桥","assetType":1,"classNum":"JAJ35","description":"岸边集装箱装卸设备","itemNum":null,"locNum":"","orgNum":"GUIDE","siteNum":"GUIDE-SOFT","parent":"","totalCost":null,"totalDownTime":null,"vendor":"","serialNum":null,"manufacturer":"上海港机","status":1,"changeBy":"admin","changeTime":"2020-12-09","createBy":"admin","createTime":"2020-06-19","dataFlag":1,"statusOld":null,"statusValue":"活动","assetTypeValue":"岸桥","parentValue":null,"locValue":null,"siteName":"港迪软件","orgName":"港迪电气","vendorValue":null,"manufacturerValue":null,"meterNum":"前伸臂33m,吊钩下45t,吊具下35t","meterName":null,"installDate":"2008-08-01","purchasePrice":2200,"replaceCost":0,"deptNum":"1001","deptName":"工程技术部","isRunning":0,"statusDate":"2008-06-01"},{"assetId":10015,"assetNum":"Y102#岸桥","assetType":1,"classNum":"JAJ41","description":"岸边集装箱装卸设备","itemNum":null,"locNum":"","orgNum":"GUIDE","siteNum":"GUIDE-SOFT","parent":"","totalCost":null,"totalDownTime":null,"vendor":"","serialNum":null,"manufacturer":"上海港机","status":1,"changeBy":"admin","changeTime":"2020-12-09","createBy":"admin","createTime":"2020-06-18","dataFlag":1,"statusOld":null,"statusValue":"活动","assetTypeValue":"岸桥","parentValue":null,"locValue":null,"siteName":"港迪软件","orgName":"港迪电气","vendorValue":null,"manufacturerValue":null,"meterNum":"前伸臂22m,吊钩下45t,吊具下41t","meterName":null,"installDate":"2008-08-01","purchasePrice":2200,"replaceCost":0,"deptNum":"1001","deptName":"工程技术部","isRunning":0,"statusDate":"2008-06-01"},{"assetId":10014,"assetNum":"Y101#岸桥","assetType":1,"classNum":"JAJ41","description":"岸边集装箱装卸设备","itemNum":null,"locNum":"","orgNum":"GUIDE","siteNum":"GUIDE-SOFT","parent":"","totalCost":null,"totalDownTime":null,"vendor":"","serialNum":null,"manufacturer":"上海港机","status":1,"changeBy":"admin","changeTime":"2020-12-09","createBy":"admin","createTime":"2020-06-18","dataFlag":1,"statusOld":null,"statusValue":"活动","assetTypeValue":"岸桥","parentValue":null,"locValue":null,"siteName":"港迪软件","orgName":"港迪电气","vendorValue":null,"manufacturerValue":null,"meterNum":"前伸臂22m,吊钩下45t，吊具下35t","meterName":null,"installDate":"2008-08-01","purchasePrice":2200,"replaceCost":0,"deptNum":"1001","deptName":"工程技术部","isRunning":0,"statusDate":"2008-06-01"}],"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6],"navigateFirstPage":1,"navigateLastPage":6,"firstPage":1,"lastPage":6}
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
         * size : 3
         * startRow : 1
         * endRow : 3
         * total : 16
         * pages : 6
         * list : [{"assetId":10016,"assetNum":"Y103#岸桥","assetType":1,"classNum":"JAJ35","description":"岸边集装箱装卸设备","itemNum":null,"locNum":"","orgNum":"GUIDE","siteNum":"GUIDE-SOFT","parent":"","totalCost":null,"totalDownTime":null,"vendor":"","serialNum":null,"manufacturer":"上海港机","status":1,"changeBy":"admin","changeTime":"2020-12-09","createBy":"admin","createTime":"2020-06-19","dataFlag":1,"statusOld":null,"statusValue":"活动","assetTypeValue":"岸桥","parentValue":null,"locValue":null,"siteName":"港迪软件","orgName":"港迪电气","vendorValue":null,"manufacturerValue":null,"meterNum":"前伸臂33m,吊钩下45t,吊具下35t","meterName":null,"installDate":"2008-08-01","purchasePrice":2200,"replaceCost":0,"deptNum":"1001","deptName":"工程技术部","isRunning":0,"statusDate":"2008-06-01"},{"assetId":10015,"assetNum":"Y102#岸桥","assetType":1,"classNum":"JAJ41","description":"岸边集装箱装卸设备","itemNum":null,"locNum":"","orgNum":"GUIDE","siteNum":"GUIDE-SOFT","parent":"","totalCost":null,"totalDownTime":null,"vendor":"","serialNum":null,"manufacturer":"上海港机","status":1,"changeBy":"admin","changeTime":"2020-12-09","createBy":"admin","createTime":"2020-06-18","dataFlag":1,"statusOld":null,"statusValue":"活动","assetTypeValue":"岸桥","parentValue":null,"locValue":null,"siteName":"港迪软件","orgName":"港迪电气","vendorValue":null,"manufacturerValue":null,"meterNum":"前伸臂22m,吊钩下45t,吊具下41t","meterName":null,"installDate":"2008-08-01","purchasePrice":2200,"replaceCost":0,"deptNum":"1001","deptName":"工程技术部","isRunning":0,"statusDate":"2008-06-01"},{"assetId":10014,"assetNum":"Y101#岸桥","assetType":1,"classNum":"JAJ41","description":"岸边集装箱装卸设备","itemNum":null,"locNum":"","orgNum":"GUIDE","siteNum":"GUIDE-SOFT","parent":"","totalCost":null,"totalDownTime":null,"vendor":"","serialNum":null,"manufacturer":"上海港机","status":1,"changeBy":"admin","changeTime":"2020-12-09","createBy":"admin","createTime":"2020-06-18","dataFlag":1,"statusOld":null,"statusValue":"活动","assetTypeValue":"岸桥","parentValue":null,"locValue":null,"siteName":"港迪软件","orgName":"港迪电气","vendorValue":null,"manufacturerValue":null,"meterNum":"前伸臂22m,吊钩下45t，吊具下35t","meterName":null,"installDate":"2008-08-01","purchasePrice":2200,"replaceCost":0,"deptNum":"1001","deptName":"工程技术部","isRunning":0,"statusDate":"2008-06-01"}]
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3,4,5,6]
         * navigateFirstPage : 1
         * navigateLastPage : 6
         * firstPage : 1
         * lastPage : 6
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
             * assetId : 10016
             * assetNum : Y103#岸桥
             * assetType : 1
             * classNum : JAJ35
             * description : 岸边集装箱装卸设备
             * itemNum : null
             * locNum :
             * orgNum : GUIDE
             * siteNum : GUIDE-SOFT
             * parent :
             * totalCost : null
             * totalDownTime : null
             * vendor :
             * serialNum : null
             * manufacturer : 上海港机
             * status : 1
             * changeBy : admin
             * changeTime : 2020-12-09
             * createBy : admin
             * createTime : 2020-06-19
             * dataFlag : 1
             * statusOld : null
             * statusValue : 活动
             * assetTypeValue : 岸桥
             * parentValue : null
             * locValue : null
             * siteName : 港迪软件
             * orgName : 港迪电气
             * vendorValue : null
             * manufacturerValue : null
             * meterNum : 前伸臂33m,吊钩下45t,吊具下35t
             * meterName : null
             * installDate : 2008-08-01
             * purchasePrice : 2200
             * replaceCost : 0
             * deptNum : 1001
             * deptName : 工程技术部
             * isRunning : 0
             * statusDate : 2008-06-01
             */

            private int assetId;
            private String assetNum;
            private int assetType;
            private String classNum;
            private String description;
            private Object itemNum;
            private String locNum;
            private String orgNum;
            private String siteNum;
            private String parent;
            private Object totalCost;
            private Object totalDownTime;
            private String vendor;
            private Object serialNum;
            private String manufacturer;
            private int status;
            private String changeBy;
            private String changeTime;
            private String createBy;
            private String createTime;
            private int dataFlag;
            private Object statusOld;
            private String statusValue;
            private String assetTypeValue;
            private Object parentValue;
            private Object locValue;
            private String siteName;
            private String orgName;
            private Object vendorValue;
            private Object manufacturerValue;
            private String meterNum;
            private Object meterName;
            private String installDate;
            private int purchasePrice;
            private int replaceCost;
            private String deptNum;
            private String deptName;
            private int isRunning;
            private String statusDate;

            public int getAssetId() {
                return assetId;
            }

            public void setAssetId(int assetId) {
                this.assetId = assetId;
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

            public String getClassNum() {
                return classNum;
            }

            public void setClassNum(String classNum) {
                this.classNum = classNum;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Object getItemNum() {
                return itemNum;
            }

            public void setItemNum(Object itemNum) {
                this.itemNum = itemNum;
            }

            public String getLocNum() {
                return locNum;
            }

            public void setLocNum(String locNum) {
                this.locNum = locNum;
            }

            public String getOrgNum() {
                return orgNum;
            }

            public void setOrgNum(String orgNum) {
                this.orgNum = orgNum;
            }

            public String getSiteNum() {
                return siteNum;
            }

            public void setSiteNum(String siteNum) {
                this.siteNum = siteNum;
            }

            public String getParent() {
                return parent;
            }

            public void setParent(String parent) {
                this.parent = parent;
            }

            public Object getTotalCost() {
                return totalCost;
            }

            public void setTotalCost(Object totalCost) {
                this.totalCost = totalCost;
            }

            public Object getTotalDownTime() {
                return totalDownTime;
            }

            public void setTotalDownTime(Object totalDownTime) {
                this.totalDownTime = totalDownTime;
            }

            public String getVendor() {
                return vendor;
            }

            public void setVendor(String vendor) {
                this.vendor = vendor;
            }

            public Object getSerialNum() {
                return serialNum;
            }

            public void setSerialNum(Object serialNum) {
                this.serialNum = serialNum;
            }

            public String getManufacturer() {
                return manufacturer;
            }

            public void setManufacturer(String manufacturer) {
                this.manufacturer = manufacturer;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
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

            public int getDataFlag() {
                return dataFlag;
            }

            public void setDataFlag(int dataFlag) {
                this.dataFlag = dataFlag;
            }

            public Object getStatusOld() {
                return statusOld;
            }

            public void setStatusOld(Object statusOld) {
                this.statusOld = statusOld;
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

            public Object getParentValue() {
                return parentValue;
            }

            public void setParentValue(Object parentValue) {
                this.parentValue = parentValue;
            }

            public Object getLocValue() {
                return locValue;
            }

            public void setLocValue(Object locValue) {
                this.locValue = locValue;
            }

            public String getSiteName() {
                return siteName;
            }

            public void setSiteName(String siteName) {
                this.siteName = siteName;
            }

            public String getOrgName() {
                return orgName;
            }

            public void setOrgName(String orgName) {
                this.orgName = orgName;
            }

            public Object getVendorValue() {
                return vendorValue;
            }

            public void setVendorValue(Object vendorValue) {
                this.vendorValue = vendorValue;
            }

            public Object getManufacturerValue() {
                return manufacturerValue;
            }

            public void setManufacturerValue(Object manufacturerValue) {
                this.manufacturerValue = manufacturerValue;
            }

            public String getMeterNum() {
                return meterNum;
            }

            public void setMeterNum(String meterNum) {
                this.meterNum = meterNum;
            }

            public Object getMeterName() {
                return meterName;
            }

            public void setMeterName(Object meterName) {
                this.meterName = meterName;
            }

            public String getInstallDate() {
                return installDate;
            }

            public void setInstallDate(String installDate) {
                this.installDate = installDate;
            }

            public int getPurchasePrice() {
                return purchasePrice;
            }

            public void setPurchasePrice(int purchasePrice) {
                this.purchasePrice = purchasePrice;
            }

            public int getReplaceCost() {
                return replaceCost;
            }

            public void setReplaceCost(int replaceCost) {
                this.replaceCost = replaceCost;
            }

            public String getDeptNum() {
                return deptNum;
            }

            public void setDeptNum(String deptNum) {
                this.deptNum = deptNum;
            }

            public String getDeptName() {
                return deptName;
            }

            public void setDeptName(String deptName) {
                this.deptName = deptName;
            }

            public int getIsRunning() {
                return isRunning;
            }

            public void setIsRunning(int isRunning) {
                this.isRunning = isRunning;
            }

            public String getStatusDate() {
                return statusDate;
            }

            public void setStatusDate(String statusDate) {
                this.statusDate = statusDate;
            }
        }
    }
}
