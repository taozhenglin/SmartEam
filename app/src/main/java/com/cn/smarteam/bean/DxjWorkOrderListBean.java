package com.cn.smarteam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2021/1/11
 */
public class DxjWorkOrderListBean {

    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"pageNum":1,"pageSize":2,"size":2,"startRow":1,"endRow":2,"total":14,"pages":7,"list":[{"workOrderId":83,"createBy":"admin","createTime":"2021-01-06","changeBy":"admin","changeTime":"2021-01-08","status":5,"statusValue":"已关闭","woNum":"2021-01-06 09:53:01:106","assetNum":"Y101#岸桥","assetValue":"岸边集装箱装卸设备","pmNum":"20211692826","jobPlanNum":"20201125104917","failureNum":null,"failureValue":null,"problemNum":null,"problemValue":null,"causeNum":null,"causeValue":null,"remedyNum":null,"remedyValue":null,"workType":3,"workTypeValue":"点巡检工单","statusTime":null,"planStartTime":null,"planFinishTime":null,"actualStartTime":"2021-01-08 21:10:01","actualFinishTime":null,"duration":null,"supervisor":"xyc","supervisorName":"谢宇驰","personNum":"xyc","personName":"谢宇驰","jobplanName":"缺省","description":"点巡检测试自动生成","reportBy":"admin","reportTime":"2021-01-06 09:53:01","dataFlag":null,"parentchgsStatus":0,"wopriority":null,"justifypriority":null,"risk":null,"sneconstraint":null,"fnlconstraint":null,"remdur":null,"spotCheckTypeValue":"班检","phoneNum":"15527492036","workContent":"点巡检测试自动生成","remarks":"22222333","spotCheckType":"1","failureTime":null,"failureName":null,"problemName":null,"caseName":null,"remedyName":"","reportNum":null,"nextCompDate":"2021-01-12 00:00:01","lastStartDate":"2021-01-08 00:00:00","pmName":"点巡检测试自动生成","freqUnitValue":"日","frequency":4,"freqUnit":1,"parts":"点巡检测试自动生成","dePersonName":null,"dePerson":4,"repairType":null,"repairTypeValue":null,"button":5,"buttonValue":"同意","woText":null,"quick":null},{"workOrderId":72,"createBy":"admin","createTime":"2020-12-31","changeBy":"admin","changeTime":"2020-12-31","status":2,"statusValue":"已派发","woNum":"1609392287222","assetNum":"Y102#岸桥","assetValue":"岸边集装箱装卸设备","pmNum":"20201231132316","jobPlanNum":"20201125104917","failureNum":null,"failureValue":null,"problemNum":null,"problemValue":null,"causeNum":null,"causeValue":null,"remedyNum":null,"remedyValue":null,"workType":3,"workTypeValue":"点巡检工单","statusTime":null,"planStartTime":null,"planFinishTime":null,"actualStartTime":null,"actualFinishTime":null,"duration":null,"supervisor":"xmy","supervisorName":"谢鸣洋","personNum":"xyc","personName":"谢宇驰","jobplanName":"缺省","description":"班检测试","reportBy":"admin","reportTime":"2020-12-31 13:24:47","dataFlag":null,"parentchgsStatus":0,"wopriority":null,"justifypriority":null,"risk":null,"sneconstraint":null,"fnlconstraint":null,"remdur":null,"spotCheckTypeValue":"班检","phoneNum":"15527492036","workContent":"测试","remarks":null,"spotCheckType":"1","failureTime":null,"failureName":null,"problemName":null,"caseName":null,"remedyName":null,"reportNum":null,"nextCompDate":"2020-12-31 13:24:47","lastStartDate":"2020-12-01 00:00:00","pmName":"班检测试","freqUnitValue":"日","frequency":4,"freqUnit":1,"parts":"测试","dePersonName":null,"dePerson":2,"repairType":null,"repairTypeValue":null,"button":2,"buttonValue":"进行中","woText":null,"quick":null}],"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6,7],"navigateFirstPage":1,"navigateLastPage":7,"firstPage":1,"lastPage":7}
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
         * pageSize : 2
         * size : 2
         * startRow : 1
         * endRow : 2
         * total : 14
         * pages : 7
         * list : [{"workOrderId":83,"createBy":"admin","createTime":"2021-01-06","changeBy":"admin","changeTime":"2021-01-08","status":5,"statusValue":"已关闭","woNum":"2021-01-06 09:53:01:106","assetNum":"Y101#岸桥","assetValue":"岸边集装箱装卸设备","pmNum":"20211692826","jobPlanNum":"20201125104917","failureNum":null,"failureValue":null,"problemNum":null,"problemValue":null,"causeNum":null,"causeValue":null,"remedyNum":null,"remedyValue":null,"workType":3,"workTypeValue":"点巡检工单","statusTime":null,"planStartTime":null,"planFinishTime":null,"actualStartTime":"2021-01-08 21:10:01","actualFinishTime":null,"duration":null,"supervisor":"xyc","supervisorName":"谢宇驰","personNum":"xyc","personName":"谢宇驰","jobplanName":"缺省","description":"点巡检测试自动生成","reportBy":"admin","reportTime":"2021-01-06 09:53:01","dataFlag":null,"parentchgsStatus":0,"wopriority":null,"justifypriority":null,"risk":null,"sneconstraint":null,"fnlconstraint":null,"remdur":null,"spotCheckTypeValue":"班检","phoneNum":"15527492036","workContent":"点巡检测试自动生成","remarks":"22222333","spotCheckType":"1","failureTime":null,"failureName":null,"problemName":null,"caseName":null,"remedyName":"","reportNum":null,"nextCompDate":"2021-01-12 00:00:01","lastStartDate":"2021-01-08 00:00:00","pmName":"点巡检测试自动生成","freqUnitValue":"日","frequency":4,"freqUnit":1,"parts":"点巡检测试自动生成","dePersonName":null,"dePerson":4,"repairType":null,"repairTypeValue":null,"button":5,"buttonValue":"同意","woText":null,"quick":null},{"workOrderId":72,"createBy":"admin","createTime":"2020-12-31","changeBy":"admin","changeTime":"2020-12-31","status":2,"statusValue":"已派发","woNum":"1609392287222","assetNum":"Y102#岸桥","assetValue":"岸边集装箱装卸设备","pmNum":"20201231132316","jobPlanNum":"20201125104917","failureNum":null,"failureValue":null,"problemNum":null,"problemValue":null,"causeNum":null,"causeValue":null,"remedyNum":null,"remedyValue":null,"workType":3,"workTypeValue":"点巡检工单","statusTime":null,"planStartTime":null,"planFinishTime":null,"actualStartTime":null,"actualFinishTime":null,"duration":null,"supervisor":"xmy","supervisorName":"谢鸣洋","personNum":"xyc","personName":"谢宇驰","jobplanName":"缺省","description":"班检测试","reportBy":"admin","reportTime":"2020-12-31 13:24:47","dataFlag":null,"parentchgsStatus":0,"wopriority":null,"justifypriority":null,"risk":null,"sneconstraint":null,"fnlconstraint":null,"remdur":null,"spotCheckTypeValue":"班检","phoneNum":"15527492036","workContent":"测试","remarks":null,"spotCheckType":"1","failureTime":null,"failureName":null,"problemName":null,"caseName":null,"remedyName":null,"reportNum":null,"nextCompDate":"2020-12-31 13:24:47","lastStartDate":"2020-12-01 00:00:00","pmName":"班检测试","freqUnitValue":"日","frequency":4,"freqUnit":1,"parts":"测试","dePersonName":null,"dePerson":2,"repairType":null,"repairTypeValue":null,"button":2,"buttonValue":"进行中","woText":null,"quick":null}]
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

        public static class ListBean implements Serializable {
            /**
             * workOrderId : 83
             * createBy : admin
             * createTime : 2021-01-06
             * changeBy : admin
             * changeTime : 2021-01-08
             * status : 5
             * statusValue : 已关闭
             * woNum : 2021-01-06 09:53:01:106
             * assetNum : Y101#岸桥
             * assetValue : 岸边集装箱装卸设备
             * pmNum : 20211692826
             * jobPlanNum : 20201125104917
             * failureNum : null
             * failureValue : null
             * problemNum : null
             * problemValue : null
             * causeNum : null
             * causeValue : null
             * remedyNum : null
             * remedyValue : null
             * workType : 3
             * workTypeValue : 点巡检工单
             * statusTime : null
             * planStartTime : null
             * planFinishTime : null
             * actualStartTime : 2021-01-08 21:10:01
             * actualFinishTime : null
             * duration : null
             * supervisor : xyc
             * supervisorName : 谢宇驰
             * personNum : xyc
             * personName : 谢宇驰
             * jobplanName : 缺省
             * description : 点巡检测试自动生成
             * reportBy : admin
             * reportTime : 2021-01-06 09:53:01
             * dataFlag : null
             * parentchgsStatus : 0
             * wopriority : null
             * justifypriority : null
             * risk : null
             * sneconstraint : null
             * fnlconstraint : null
             * remdur : null
             * spotCheckTypeValue : 班检
             * phoneNum : 15527492036
             * workContent : 点巡检测试自动生成
             * remarks : 22222333
             * spotCheckType : 1
             * failureTime : null
             * failureName : null
             * problemName : null
             * caseName : null
             * remedyName :
             * reportNum : null
             * nextCompDate : 2021-01-12 00:00:01
             * lastStartDate : 2021-01-08 00:00:00
             * pmName : 点巡检测试自动生成
             * freqUnitValue : 日
             * frequency : 4
             * freqUnit : 1
             * parts : 点巡检测试自动生成
             * dePersonName : null
             * dePerson : 4
             * repairType : null
             * repairTypeValue : null
             * button : 5
             * buttonValue : 同意
             * woText : null
             * quick : null
             */

            private int workOrderId;
            private String createBy;
            private String createTime;
            private String changeBy;
            private String changeTime;
            private int status;
            private String statusValue;
            private String woNum;
            private String assetNum;
            private String assetValue;
            private String pmNum;
            private String jobPlanNum;
            private Object failureNum;
            private Object failureValue;
            private Object problemNum;
            private Object problemValue;
            private Object causeNum;
            private Object causeValue;
            private Object remedyNum;
            private Object remedyValue;
            private int workType;
            private String workTypeValue;
            private Object statusTime;
            private Object planStartTime;
            private Object planFinishTime;
            private String actualStartTime;
            private Object actualFinishTime;
            private Object duration;
            private String supervisor;
            private String supervisorName;
            private String personNum;
            private String personName;
            private String jobplanName;
            private String description;
            private String reportBy;
            private String reportTime;
            private Object dataFlag;
            private int parentchgsStatus;
            private Object wopriority;
            private Object justifypriority;
            private Object risk;
            private Object sneconstraint;
            private Object fnlconstraint;
            private Object remdur;
            private String spotCheckTypeValue;
            private String phoneNum;
            private String workContent;
            private String remarks;
            private String spotCheckType;
            private Object failureTime;
            private Object failureName;
            private Object problemName;
            private Object caseName;
            private String remedyName;
            private Object reportNum;
            private String nextCompDate;
            private String lastStartDate;
            private String pmName;
            private String freqUnitValue;
            private int frequency;
            private int freqUnit;
            private String parts;
            private Object dePersonName;
            private int dePerson;
            private Object repairType;
            private Object repairTypeValue;
            private int button;
            private String buttonValue;
            private Object woText;
            private Object quick;
            private boolean isChecked;

            public int getWorkOrderId() {
                return workOrderId;
            }

            public void setWorkOrderId(int workOrderId) {
                this.workOrderId = workOrderId;
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

            public String getWoNum() {
                return woNum;
            }

            public void setWoNum(String woNum) {
                this.woNum = woNum;
            }

            public String getAssetNum() {
                return assetNum;
            }

            public void setAssetNum(String assetNum) {
                this.assetNum = assetNum;
            }

            public String getAssetValue() {
                return assetValue;
            }

            public void setAssetValue(String assetValue) {
                this.assetValue = assetValue;
            }

            public String getPmNum() {
                return pmNum;
            }

            public void setPmNum(String pmNum) {
                this.pmNum = pmNum;
            }

            public String getJobPlanNum() {
                return jobPlanNum;
            }

            public void setJobPlanNum(String jobPlanNum) {
                this.jobPlanNum = jobPlanNum;
            }

            public Object getFailureNum() {
                return failureNum;
            }

            public void setFailureNum(Object failureNum) {
                this.failureNum = failureNum;
            }

            public Object getFailureValue() {
                return failureValue;
            }

            public void setFailureValue(Object failureValue) {
                this.failureValue = failureValue;
            }

            public Object getProblemNum() {
                return problemNum;
            }

            public void setProblemNum(Object problemNum) {
                this.problemNum = problemNum;
            }

            public Object getProblemValue() {
                return problemValue;
            }

            public void setProblemValue(Object problemValue) {
                this.problemValue = problemValue;
            }

            public Object getCauseNum() {
                return causeNum;
            }

            public void setCauseNum(Object causeNum) {
                this.causeNum = causeNum;
            }

            public Object getCauseValue() {
                return causeValue;
            }

            public void setCauseValue(Object causeValue) {
                this.causeValue = causeValue;
            }

            public Object getRemedyNum() {
                return remedyNum;
            }

            public void setRemedyNum(Object remedyNum) {
                this.remedyNum = remedyNum;
            }

            public Object getRemedyValue() {
                return remedyValue;
            }

            public void setRemedyValue(Object remedyValue) {
                this.remedyValue = remedyValue;
            }

            public int getWorkType() {
                return workType;
            }

            public void setWorkType(int workType) {
                this.workType = workType;
            }

            public String getWorkTypeValue() {
                return workTypeValue;
            }

            public void setWorkTypeValue(String workTypeValue) {
                this.workTypeValue = workTypeValue;
            }

            public Object getStatusTime() {
                return statusTime;
            }

            public void setStatusTime(Object statusTime) {
                this.statusTime = statusTime;
            }

            public Object getPlanStartTime() {
                return planStartTime;
            }

            public void setPlanStartTime(Object planStartTime) {
                this.planStartTime = planStartTime;
            }

            public Object getPlanFinishTime() {
                return planFinishTime;
            }

            public void setPlanFinishTime(Object planFinishTime) {
                this.planFinishTime = planFinishTime;
            }

            public String getActualStartTime() {
                return actualStartTime;
            }

            public void setActualStartTime(String actualStartTime) {
                this.actualStartTime = actualStartTime;
            }

            public Object getActualFinishTime() {
                return actualFinishTime;
            }

            public void setActualFinishTime(Object actualFinishTime) {
                this.actualFinishTime = actualFinishTime;
            }

            public Object getDuration() {
                return duration;
            }

            public void setDuration(Object duration) {
                this.duration = duration;
            }

            public String getSupervisor() {
                return supervisor;
            }

            public void setSupervisor(String supervisor) {
                this.supervisor = supervisor;
            }

            public String getSupervisorName() {
                return supervisorName;
            }

            public void setSupervisorName(String supervisorName) {
                this.supervisorName = supervisorName;
            }

            public String getPersonNum() {
                return personNum;
            }

            public void setPersonNum(String personNum) {
                this.personNum = personNum;
            }

            public String getPersonName() {
                return personName;
            }

            public void setPersonName(String personName) {
                this.personName = personName;
            }

            public String getJobplanName() {
                return jobplanName;
            }

            public void setJobplanName(String jobplanName) {
                this.jobplanName = jobplanName;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getReportBy() {
                return reportBy;
            }

            public void setReportBy(String reportBy) {
                this.reportBy = reportBy;
            }

            public String getReportTime() {
                return reportTime;
            }

            public void setReportTime(String reportTime) {
                this.reportTime = reportTime;
            }

            public Object getDataFlag() {
                return dataFlag;
            }

            public void setDataFlag(Object dataFlag) {
                this.dataFlag = dataFlag;
            }

            public int getParentchgsStatus() {
                return parentchgsStatus;
            }

            public void setParentchgsStatus(int parentchgsStatus) {
                this.parentchgsStatus = parentchgsStatus;
            }

            public Object getWopriority() {
                return wopriority;
            }

            public void setWopriority(Object wopriority) {
                this.wopriority = wopriority;
            }

            public Object getJustifypriority() {
                return justifypriority;
            }

            public void setJustifypriority(Object justifypriority) {
                this.justifypriority = justifypriority;
            }

            public Object getRisk() {
                return risk;
            }

            public void setRisk(Object risk) {
                this.risk = risk;
            }

            public Object getSneconstraint() {
                return sneconstraint;
            }

            public void setSneconstraint(Object sneconstraint) {
                this.sneconstraint = sneconstraint;
            }

            public Object getFnlconstraint() {
                return fnlconstraint;
            }

            public void setFnlconstraint(Object fnlconstraint) {
                this.fnlconstraint = fnlconstraint;
            }

            public Object getRemdur() {
                return remdur;
            }

            public void setRemdur(Object remdur) {
                this.remdur = remdur;
            }

            public String getSpotCheckTypeValue() {
                return spotCheckTypeValue;
            }

            public void setSpotCheckTypeValue(String spotCheckTypeValue) {
                this.spotCheckTypeValue = spotCheckTypeValue;
            }

            public String getPhoneNum() {
                return phoneNum;
            }

            public void setPhoneNum(String phoneNum) {
                this.phoneNum = phoneNum;
            }

            public String getWorkContent() {
                return workContent;
            }

            public void setWorkContent(String workContent) {
                this.workContent = workContent;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getSpotCheckType() {
                return spotCheckType;
            }

            public void setSpotCheckType(String spotCheckType) {
                this.spotCheckType = spotCheckType;
            }

            public Object getFailureTime() {
                return failureTime;
            }

            public void setFailureTime(Object failureTime) {
                this.failureTime = failureTime;
            }

            public Object getFailureName() {
                return failureName;
            }

            public void setFailureName(Object failureName) {
                this.failureName = failureName;
            }

            public Object getProblemName() {
                return problemName;
            }

            public void setProblemName(Object problemName) {
                this.problemName = problemName;
            }

            public Object getCaseName() {
                return caseName;
            }

            public void setCaseName(Object caseName) {
                this.caseName = caseName;
            }

            public String getRemedyName() {
                return remedyName;
            }

            public void setRemedyName(String remedyName) {
                this.remedyName = remedyName;
            }

            public Object getReportNum() {
                return reportNum;
            }

            public void setReportNum(Object reportNum) {
                this.reportNum = reportNum;
            }

            public String getNextCompDate() {
                return nextCompDate;
            }

            public void setNextCompDate(String nextCompDate) {
                this.nextCompDate = nextCompDate;
            }

            public String getLastStartDate() {
                return lastStartDate;
            }

            public void setLastStartDate(String lastStartDate) {
                this.lastStartDate = lastStartDate;
            }

            public String getPmName() {
                return pmName;
            }

            public void setPmName(String pmName) {
                this.pmName = pmName;
            }

            public String getFreqUnitValue() {
                return freqUnitValue;
            }

            public void setFreqUnitValue(String freqUnitValue) {
                this.freqUnitValue = freqUnitValue;
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

            public String getParts() {
                return parts;
            }

            public void setParts(String parts) {
                this.parts = parts;
            }

            public Object getDePersonName() {
                return dePersonName;
            }

            public void setDePersonName(Object dePersonName) {
                this.dePersonName = dePersonName;
            }

            public int getDePerson() {
                return dePerson;
            }

            public void setDePerson(int dePerson) {
                this.dePerson = dePerson;
            }

            public Object getRepairType() {
                return repairType;
            }

            public void setRepairType(Object repairType) {
                this.repairType = repairType;
            }

            public Object getRepairTypeValue() {
                return repairTypeValue;
            }

            public void setRepairTypeValue(Object repairTypeValue) {
                this.repairTypeValue = repairTypeValue;
            }

            public int getButton() {
                return button;
            }

            public void setButton(int button) {
                this.button = button;
            }

            public String getButtonValue() {
                return buttonValue;
            }

            public void setButtonValue(String buttonValue) {
                this.buttonValue = buttonValue;
            }

            public Object getWoText() {
                return woText;
            }

            public void setWoText(Object woText) {
                this.woText = woText;
            }

            public Object getQuick() {
                return quick;
            }

            public void setQuick(Object quick) {
                this.quick = quick;
            }

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean b) {
                isChecked=b;
            }
        }
    }
}
