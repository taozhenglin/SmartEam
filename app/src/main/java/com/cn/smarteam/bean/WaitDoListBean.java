package com.cn.smarteam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tzl
 * on 2020/12/18
 */
public class WaitDoListBean  {


    /**
     * code : 200
     * msg : GUIDE-操作成功
     * data : {"pageNum":1,"pageSize":1,"size":1,"startRow":1,"endRow":1,"total":11,"pages":11,"list":[{"workOrderId":63,"createBy":"admin","createTime":"2020-12-29","changeBy":"admin","changeTime":"2020-12-29","status":4,"statusValue":"已完工","woNum":"2020122994534","assetNum":"Y101#岸桥","assetValue":"岸边集装箱装卸设备","pmNum":null,"jobPlanNum":"20201125104917","failureNum":"20201023125426","failureValue":null,"problemNum":"20201023125426-08","problemValue":null,"causeNum":"20201023125426-08-01","causeValue":null,"remedyNum":null,"remedyValue":null,"workType":2,"workTypeValue":"维修工单","statusTime":null,"planStartTime":null,"planFinishTime":null,"actualStartTime":"2020-12-01 00:00:00","actualFinishTime":"2020-12-29 00:00:00","duration":null,"supervisor":null,"supervisorName":null,"personNum":"xsl","personName":"熊书林","jobplanName":"缺省","description":"测试数据","reportBy":"10000","reportTime":"2020-12-29","dataFlag":null,"parentchgsStatus":0,"wopriority":null,"justifypriority":null,"risk":null,"sneconstraint":null,"fnlconstraint":null,"remdur":null,"spotCheckTypeValue":null,"phoneNum":"15527492036","workContent":"无","remarks":null,"spotCheckType":null,"failureTime":"2020-12-01","failureName":"起升故障","problemName":"起升冲顶","caseName":"起升冲顶","remedyName":"停机","reportNum":null,"nextCompDate":null,"lastStartDate":null,"pmName":null,"freqUnitValue":null,"frequency":null,"freqUnit":null,"parts":null,"dePersonName":null,"dePerson":4,"repairType":2,"repairTypeValue":"临时性维修","button":5,"buttonValue":"同意","woText":null,"quick":null}],"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6,7,8],"navigateFirstPage":1,"navigateLastPage":8,"firstPage":1,"lastPage":8}
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
         * pageSize : 1
         * size : 1
         * startRow : 1
         * endRow : 1
         * total : 11
         * pages : 11
         * list : [{"workOrderId":63,"createBy":"admin","createTime":"2020-12-29","changeBy":"admin","changeTime":"2020-12-29","status":4,"statusValue":"已完工","woNum":"2020122994534","assetNum":"Y101#岸桥","assetValue":"岸边集装箱装卸设备","pmNum":null,"jobPlanNum":"20201125104917","failureNum":"20201023125426","failureValue":null,"problemNum":"20201023125426-08","problemValue":null,"causeNum":"20201023125426-08-01","causeValue":null,"remedyNum":null,"remedyValue":null,"workType":2,"workTypeValue":"维修工单","statusTime":null,"planStartTime":null,"planFinishTime":null,"actualStartTime":"2020-12-01 00:00:00","actualFinishTime":"2020-12-29 00:00:00","duration":null,"supervisor":null,"supervisorName":null,"personNum":"xsl","personName":"熊书林","jobplanName":"缺省","description":"测试数据","reportBy":"10000","reportTime":"2020-12-29","dataFlag":null,"parentchgsStatus":0,"wopriority":null,"justifypriority":null,"risk":null,"sneconstraint":null,"fnlconstraint":null,"remdur":null,"spotCheckTypeValue":null,"phoneNum":"15527492036","workContent":"无","remarks":null,"spotCheckType":null,"failureTime":"2020-12-01","failureName":"起升故障","problemName":"起升冲顶","caseName":"起升冲顶","remedyName":"停机","reportNum":null,"nextCompDate":null,"lastStartDate":null,"pmName":null,"freqUnitValue":null,"frequency":null,"freqUnit":null,"parts":null,"dePersonName":null,"dePerson":4,"repairType":2,"repairTypeValue":"临时性维修","button":5,"buttonValue":"同意","woText":null,"quick":null}]
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

        public static class ListBean implements Serializable {
            /**
             * workOrderId : 63
             * createBy : admin
             * createTime : 2020-12-29
             * changeBy : admin
             * changeTime : 2020-12-29
             * status : 4
             * statusValue : 已完工
             * woNum : 2020122994534
             * assetNum : Y101#岸桥
             * assetValue : 岸边集装箱装卸设备
             * pmNum : null
             * jobPlanNum : 20201125104917
             * failureNum : 20201023125426
             * failureValue : null
             * problemNum : 20201023125426-08
             * problemValue : null
             * causeNum : 20201023125426-08-01
             * causeValue : null
             * remedyNum : null
             * remedyValue : null
             * workType : 2
             * workTypeValue : 维修工单
             * statusTime : null
             * planStartTime : null
             * planFinishTime : null
             * actualStartTime : 2020-12-01 00:00:00
             * actualFinishTime : 2020-12-29 00:00:00
             * duration : null
             * supervisor : null
             * supervisorName : null
             * personNum : xsl
             * personName : 熊书林
             * jobplanName : 缺省
             * description : 测试数据
             * reportBy : 10000
             * reportTime : 2020-12-29
             * dataFlag : null
             * parentchgsStatus : 0
             * wopriority : null
             * justifypriority : null
             * risk : null
             * sneconstraint : null
             * fnlconstraint : null
             * remdur : null
             * spotCheckTypeValue : null
             * phoneNum : 15527492036
             * workContent : 无
             * remarks : null
             * spotCheckType : null
             * failureTime : 2020-12-01
             * failureName : 起升故障
             * problemName : 起升冲顶
             * caseName : 起升冲顶
             * remedyName : 停机
             * reportNum : null
             * nextCompDate : null
             * lastStartDate : null
             * pmName : null
             * freqUnitValue : null
             * frequency : null
             * freqUnit : null
             * parts : null
             * dePersonName : null
             * dePerson : 4
             * repairType : 2
             * repairTypeValue : 临时性维修
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
            private Object pmNum;
            private String jobPlanNum;
            private String failureNum;
            private Object failureValue;
            private String problemNum;
            private Object problemValue;
            private String causeNum;
            private Object causeValue;
            private Object remedyNum;
            private Object remedyValue;
            private int workType;
            private String workTypeValue;
            private Object statusTime;
            private Object planStartTime;
            private Object planFinishTime;
            private String actualStartTime;
            private String actualFinishTime;
            private Object duration;
            private Object supervisor;
            private Object supervisorName;
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
            private Object spotCheckTypeValue;
            private String phoneNum;
            private String workContent;
            private Object remarks;
            private Object spotCheckType;
            private String failureTime;
            private String failureName;
            private String problemName;
            private String caseName;
            private String remedyName;
            private Object reportNum;
            private Object nextCompDate;
            private Object lastStartDate;
            private Object pmName;
            private Object freqUnitValue;
            private Object frequency;
            private Object freqUnit;
            private Object parts;
            private Object dePersonName;
            private int dePerson;
            private int repairType;
            private String repairTypeValue;
            private int button;
            private String buttonValue;
            private Object woText;
            private Object quick;
            private boolean isChecked;

            public void setChecked(boolean isChecked) {
                this.isChecked=isChecked;

            }

            public boolean isChecked() {
                return isChecked;
            }
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

            public Object getPmNum() {
                return pmNum;
            }

            public void setPmNum(Object pmNum) {
                this.pmNum = pmNum;
            }

            public String getJobPlanNum() {
                return jobPlanNum;
            }

            public void setJobPlanNum(String jobPlanNum) {
                this.jobPlanNum = jobPlanNum;
            }

            public String getFailureNum() {
                return failureNum;
            }

            public void setFailureNum(String failureNum) {
                this.failureNum = failureNum;
            }

            public Object getFailureValue() {
                return failureValue;
            }

            public void setFailureValue(Object failureValue) {
                this.failureValue = failureValue;
            }

            public String getProblemNum() {
                return problemNum;
            }

            public void setProblemNum(String problemNum) {
                this.problemNum = problemNum;
            }

            public Object getProblemValue() {
                return problemValue;
            }

            public void setProblemValue(Object problemValue) {
                this.problemValue = problemValue;
            }

            public String getCauseNum() {
                return causeNum;
            }

            public void setCauseNum(String causeNum) {
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

            public String getActualFinishTime() {
                return actualFinishTime;
            }

            public void setActualFinishTime(String actualFinishTime) {
                this.actualFinishTime = actualFinishTime;
            }

            public Object getDuration() {
                return duration;
            }

            public void setDuration(Object duration) {
                this.duration = duration;
            }

            public Object getSupervisor() {
                return supervisor;
            }

            public void setSupervisor(Object supervisor) {
                this.supervisor = supervisor;
            }

            public Object getSupervisorName() {
                return supervisorName;
            }

            public void setSupervisorName(Object supervisorName) {
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

            public Object getSpotCheckTypeValue() {
                return spotCheckTypeValue;
            }

            public void setSpotCheckTypeValue(Object spotCheckTypeValue) {
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

            public Object getRemarks() {
                return remarks;
            }

            public void setRemarks(Object remarks) {
                this.remarks = remarks;
            }

            public Object getSpotCheckType() {
                return spotCheckType;
            }

            public void setSpotCheckType(Object spotCheckType) {
                this.spotCheckType = spotCheckType;
            }

            public String getFailureTime() {
                return failureTime;
            }

            public void setFailureTime(String failureTime) {
                this.failureTime = failureTime;
            }

            public String getFailureName() {
                return failureName;
            }

            public void setFailureName(String failureName) {
                this.failureName = failureName;
            }

            public String getProblemName() {
                return problemName;
            }

            public void setProblemName(String problemName) {
                this.problemName = problemName;
            }

            public String getCaseName() {
                return caseName;
            }

            public void setCaseName(String caseName) {
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

            public Object getNextCompDate() {
                return nextCompDate;
            }

            public void setNextCompDate(Object nextCompDate) {
                this.nextCompDate = nextCompDate;
            }

            public Object getLastStartDate() {
                return lastStartDate;
            }

            public void setLastStartDate(Object lastStartDate) {
                this.lastStartDate = lastStartDate;
            }

            public Object getPmName() {
                return pmName;
            }

            public void setPmName(Object pmName) {
                this.pmName = pmName;
            }

            public Object getFreqUnitValue() {
                return freqUnitValue;
            }

            public void setFreqUnitValue(Object freqUnitValue) {
                this.freqUnitValue = freqUnitValue;
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

            public Object getParts() {
                return parts;
            }

            public void setParts(Object parts) {
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

            public int getRepairType() {
                return repairType;
            }

            public void setRepairType(int repairType) {
                this.repairType = repairType;
            }

            public String getRepairTypeValue() {
                return repairTypeValue;
            }

            public void setRepairTypeValue(String repairTypeValue) {
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
        }
    }
}
