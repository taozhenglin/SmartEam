package com.cn.smarteam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2021/1/11
 */
public class MainTainPlanListBean {

    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"pageNum":1,"pageSize":3,"size":3,"startRow":1,"endRow":3,"total":50,"pages":17,"list":[{"pmId":155,"pmNum":"20211692826","description":"点巡检测试自动生成","jobPlanNum":"20201125104917","jobPlanDescription":"缺省","woStatus":null,"woStatusValue":null,"workType":null,"workTypeValue":null,"priority":null,"priorityValue":null,"supervisor":"xyc","personNum":"xyc","lastStartDate":"2021-01-08","nextCompDate":"2021-01-12","orgNum":"","orgName":null,"siteNum":"","siteName":null,"createBy":"admin","changeBy":"admin","createTime":"2021-01-06","changeTime":"2021-01-06","status":null,"statusValue":null,"useTargetDate":0,"frequency":4,"freqUnit":1,"freqUnitValue":"日","jobPlanName":"缺省","nextDate":null,"aheadDays":0,"aheadDaysActive":0,"extDate":0,"nextDateAdj":null,"parts":"点巡检测试自动生成","workContent":"点巡检测试自动生成","phoneNum":"15527492036","remarks":null,"personNumValue":"谢宇驰","supervisorValue":"谢宇驰","pmType":"3","pmTypeValue":"点巡检计划"},{"pmId":153,"pmNum":"20201231132316","description":"班检测试","jobPlanNum":"20201125104917","jobPlanDescription":"缺省","woStatus":null,"woStatusValue":null,"workType":null,"workTypeValue":null,"priority":null,"priorityValue":null,"supervisor":"xmy","personNum":"xyc","lastStartDate":"2020-12-01","nextCompDate":"2020-12-31","orgNum":"","orgName":null,"siteNum":"","siteName":null,"createBy":"admin","changeBy":"admin","createTime":"2020-12-31","changeTime":"2020-12-31","status":null,"statusValue":null,"useTargetDate":0,"frequency":4,"freqUnit":1,"freqUnitValue":"日","jobPlanName":"缺省","nextDate":null,"aheadDays":0,"aheadDaysActive":0,"extDate":0,"nextDateAdj":null,"parts":"测试","workContent":"测试","phoneNum":"15527492036","remarks":null,"personNumValue":"谢宇驰","supervisorValue":"谢鸣洋","pmType":"3","pmTypeValue":"点巡检计划"},{"pmId":152,"pmNum":"2020123112591","description":" Y103#岸桥、Y207#场桥日常班检","jobPlanNum":"20201125104917","jobPlanDescription":"缺省","woStatus":null,"woStatusValue":null,"workType":null,"workTypeValue":null,"priority":null,"priorityValue":null,"supervisor":"ty","personNum":"xsl","lastStartDate":"2020-12-31","nextCompDate":"2020-12-31","orgNum":"","orgName":null,"siteNum":"","siteName":null,"createBy":"admin","changeBy":"admin","createTime":"2020-12-31","changeTime":"2020-12-31","status":null,"statusValue":null,"useTargetDate":0,"frequency":1,"freqUnit":1,"freqUnitValue":"日","jobPlanName":"缺省","nextDate":null,"aheadDays":0,"aheadDaysActive":0,"extDate":0,"nextDateAdj":null,"parts":" Y103#岸桥、Y207#场桥日常班检","workContent":" Y103#岸桥、Y207#场桥日常班检","phoneNum":"15527492036","remarks":null,"personNumValue":"熊书林","supervisorValue":"汤 勇","pmType":"3","pmTypeValue":"点巡检计划"}],"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6,7,8],"navigateFirstPage":1,"navigateLastPage":8,"firstPage":1,"lastPage":8}
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
         * pageSize : 3
         * size : 3
         * startRow : 1
         * endRow : 3
         * total : 50
         * pages : 17
         * list : [{"pmId":155,"pmNum":"20211692826","description":"点巡检测试自动生成","jobPlanNum":"20201125104917","jobPlanDescription":"缺省","woStatus":null,"woStatusValue":null,"workType":null,"workTypeValue":null,"priority":null,"priorityValue":null,"supervisor":"xyc","personNum":"xyc","lastStartDate":"2021-01-08","nextCompDate":"2021-01-12","orgNum":"","orgName":null,"siteNum":"","siteName":null,"createBy":"admin","changeBy":"admin","createTime":"2021-01-06","changeTime":"2021-01-06","status":null,"statusValue":null,"useTargetDate":0,"frequency":4,"freqUnit":1,"freqUnitValue":"日","jobPlanName":"缺省","nextDate":null,"aheadDays":0,"aheadDaysActive":0,"extDate":0,"nextDateAdj":null,"parts":"点巡检测试自动生成","workContent":"点巡检测试自动生成","phoneNum":"15527492036","remarks":null,"personNumValue":"谢宇驰","supervisorValue":"谢宇驰","pmType":"3","pmTypeValue":"点巡检计划"},{"pmId":153,"pmNum":"20201231132316","description":"班检测试","jobPlanNum":"20201125104917","jobPlanDescription":"缺省","woStatus":null,"woStatusValue":null,"workType":null,"workTypeValue":null,"priority":null,"priorityValue":null,"supervisor":"xmy","personNum":"xyc","lastStartDate":"2020-12-01","nextCompDate":"2020-12-31","orgNum":"","orgName":null,"siteNum":"","siteName":null,"createBy":"admin","changeBy":"admin","createTime":"2020-12-31","changeTime":"2020-12-31","status":null,"statusValue":null,"useTargetDate":0,"frequency":4,"freqUnit":1,"freqUnitValue":"日","jobPlanName":"缺省","nextDate":null,"aheadDays":0,"aheadDaysActive":0,"extDate":0,"nextDateAdj":null,"parts":"测试","workContent":"测试","phoneNum":"15527492036","remarks":null,"personNumValue":"谢宇驰","supervisorValue":"谢鸣洋","pmType":"3","pmTypeValue":"点巡检计划"},{"pmId":152,"pmNum":"2020123112591","description":" Y103#岸桥、Y207#场桥日常班检","jobPlanNum":"20201125104917","jobPlanDescription":"缺省","woStatus":null,"woStatusValue":null,"workType":null,"workTypeValue":null,"priority":null,"priorityValue":null,"supervisor":"ty","personNum":"xsl","lastStartDate":"2020-12-31","nextCompDate":"2020-12-31","orgNum":"","orgName":null,"siteNum":"","siteName":null,"createBy":"admin","changeBy":"admin","createTime":"2020-12-31","changeTime":"2020-12-31","status":null,"statusValue":null,"useTargetDate":0,"frequency":1,"freqUnit":1,"freqUnitValue":"日","jobPlanName":"缺省","nextDate":null,"aheadDays":0,"aheadDaysActive":0,"extDate":0,"nextDateAdj":null,"parts":" Y103#岸桥、Y207#场桥日常班检","workContent":" Y103#岸桥、Y207#场桥日常班检","phoneNum":"15527492036","remarks":null,"personNumValue":"熊书林","supervisorValue":"汤 勇","pmType":"3","pmTypeValue":"点巡检计划"}]
         * prePage : 0
         * nextPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2,3,4,5,6,7,8]
         * navigateFirstPage : 1
         * navigateLastPage : 8
         * firstPage : 1
         * lastPage : 8
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
             * pmId : 155
             * pmNum : 20211692826
             * description : 点巡检测试自动生成
             * jobPlanNum : 20201125104917
             * jobPlanDescription : 缺省
             * woStatus : null
             * woStatusValue : null
             * workType : null
             * workTypeValue : null
             * priority : null
             * priorityValue : null
             * supervisor : xyc
             * personNum : xyc
             * lastStartDate : 2021-01-08
             * nextCompDate : 2021-01-12
             * orgNum :
             * orgName : null
             * siteNum :
             * siteName : null
             * createBy : admin
             * changeBy : admin
             * createTime : 2021-01-06
             * changeTime : 2021-01-06
             * status : null
             * statusValue : null
             * useTargetDate : 0
             * frequency : 4
             * freqUnit : 1
             * freqUnitValue : 日
             * jobPlanName : 缺省
             * nextDate : null
             * aheadDays : 0
             * aheadDaysActive : 0
             * extDate : 0
             * nextDateAdj : null
             * parts : 点巡检测试自动生成
             * workContent : 点巡检测试自动生成
             * phoneNum : 15527492036
             * remarks : null
             * personNumValue : 谢宇驰
             * supervisorValue : 谢宇驰
             * pmType : 3
             * pmTypeValue : 点巡检计划
             */

            private int pmId;
            private String pmNum;
            private String description;
            private String jobPlanNum;
            private String jobPlanDescription;
            private Object woStatus;
            private Object woStatusValue;
            private Object workType;
            private Object workTypeValue;
            private Object priority;
            private Object priorityValue;
            private String supervisor;
            private String personNum;
            private String lastStartDate;
            private String nextCompDate;
            private String orgNum;
            private Object orgName;
            private String siteNum;
            private Object siteName;
            private String createBy;
            private String changeBy;
            private String createTime;
            private String changeTime;
            private Object status;
            private Object statusValue;
            private int useTargetDate;
            private int frequency;
            private int freqUnit;
            private String freqUnitValue;
            private String jobPlanName;
            private Object nextDate;
            private int aheadDays;
            private int aheadDaysActive;
            private int extDate;
            private Object nextDateAdj;
            private String parts;
            private String workContent;
            private String phoneNum;
            private Object remarks;
            private String personNumValue;
            private String supervisorValue;
            private String pmType;
            private String pmTypeValue;

            public int getPmId() {
                return pmId;
            }

            public void setPmId(int pmId) {
                this.pmId = pmId;
            }

            public String getPmNum() {
                return pmNum;
            }

            public void setPmNum(String pmNum) {
                this.pmNum = pmNum;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getJobPlanNum() {
                return jobPlanNum;
            }

            public void setJobPlanNum(String jobPlanNum) {
                this.jobPlanNum = jobPlanNum;
            }

            public String getJobPlanDescription() {
                return jobPlanDescription;
            }

            public void setJobPlanDescription(String jobPlanDescription) {
                this.jobPlanDescription = jobPlanDescription;
            }

            public Object getWoStatus() {
                return woStatus;
            }

            public void setWoStatus(Object woStatus) {
                this.woStatus = woStatus;
            }

            public Object getWoStatusValue() {
                return woStatusValue;
            }

            public void setWoStatusValue(Object woStatusValue) {
                this.woStatusValue = woStatusValue;
            }

            public Object getWorkType() {
                return workType;
            }

            public void setWorkType(Object workType) {
                this.workType = workType;
            }

            public Object getWorkTypeValue() {
                return workTypeValue;
            }

            public void setWorkTypeValue(Object workTypeValue) {
                this.workTypeValue = workTypeValue;
            }

            public Object getPriority() {
                return priority;
            }

            public void setPriority(Object priority) {
                this.priority = priority;
            }

            public Object getPriorityValue() {
                return priorityValue;
            }

            public void setPriorityValue(Object priorityValue) {
                this.priorityValue = priorityValue;
            }

            public String getSupervisor() {
                return supervisor;
            }

            public void setSupervisor(String supervisor) {
                this.supervisor = supervisor;
            }

            public String getPersonNum() {
                return personNum;
            }

            public void setPersonNum(String personNum) {
                this.personNum = personNum;
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

            public String getSiteNum() {
                return siteNum;
            }

            public void setSiteNum(String siteNum) {
                this.siteNum = siteNum;
            }

            public Object getSiteName() {
                return siteName;
            }

            public void setSiteName(Object siteName) {
                this.siteName = siteName;
            }

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public String getChangeBy() {
                return changeBy;
            }

            public void setChangeBy(String changeBy) {
                this.changeBy = changeBy;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
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

            public Object getStatusValue() {
                return statusValue;
            }

            public void setStatusValue(Object statusValue) {
                this.statusValue = statusValue;
            }

            public int getUseTargetDate() {
                return useTargetDate;
            }

            public void setUseTargetDate(int useTargetDate) {
                this.useTargetDate = useTargetDate;
            }

            public int getFrequency() {
                return frequency;
            }

            public void setFrequency(int frequency) {
                this.frequency = frequency;
            }

            public int getFreqUnit() {
                return freqUnit;
            }

            public void setFreqUnit(int freqUnit) {
                this.freqUnit = freqUnit;
            }

            public String getFreqUnitValue() {
                return freqUnitValue;
            }

            public void setFreqUnitValue(String freqUnitValue) {
                this.freqUnitValue = freqUnitValue;
            }

            public String getJobPlanName() {
                return jobPlanName;
            }

            public void setJobPlanName(String jobPlanName) {
                this.jobPlanName = jobPlanName;
            }

            public Object getNextDate() {
                return nextDate;
            }

            public void setNextDate(Object nextDate) {
                this.nextDate = nextDate;
            }

            public int getAheadDays() {
                return aheadDays;
            }

            public void setAheadDays(int aheadDays) {
                this.aheadDays = aheadDays;
            }

            public int getAheadDaysActive() {
                return aheadDaysActive;
            }

            public void setAheadDaysActive(int aheadDaysActive) {
                this.aheadDaysActive = aheadDaysActive;
            }

            public int getExtDate() {
                return extDate;
            }

            public void setExtDate(int extDate) {
                this.extDate = extDate;
            }

            public Object getNextDateAdj() {
                return nextDateAdj;
            }

            public void setNextDateAdj(Object nextDateAdj) {
                this.nextDateAdj = nextDateAdj;
            }

            public String getParts() {
                return parts;
            }

            public void setParts(String parts) {
                this.parts = parts;
            }

            public String getWorkContent() {
                return workContent;
            }

            public void setWorkContent(String workContent) {
                this.workContent = workContent;
            }

            public String getPhoneNum() {
                return phoneNum;
            }

            public void setPhoneNum(String phoneNum) {
                this.phoneNum = phoneNum;
            }

            public Object getRemarks() {
                return remarks;
            }

            public void setRemarks(Object remarks) {
                this.remarks = remarks;
            }

            public String getPersonNumValue() {
                return personNumValue;
            }

            public void setPersonNumValue(String personNumValue) {
                this.personNumValue = personNumValue;
            }

            public String getSupervisorValue() {
                return supervisorValue;
            }

            public void setSupervisorValue(String supervisorValue) {
                this.supervisorValue = supervisorValue;
            }

            public String getPmType() {
                return pmType;
            }

            public void setPmType(String pmType) {
                this.pmType = pmType;
            }

            public String getPmTypeValue() {
                return pmTypeValue;
            }

            public void setPmTypeValue(String pmTypeValue) {
                this.pmTypeValue = pmTypeValue;
            }
        }
    }
}
