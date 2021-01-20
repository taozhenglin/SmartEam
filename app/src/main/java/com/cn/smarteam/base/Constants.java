package com.cn.smarteam.base;

public class Constants {
    public static final String SHARE_PREFERENCES_NAME = "SmartEam";
    public static final String FONT_SIZE ="fontsize";


    public static boolean DeBug = true;
        public static String BASE_URL="http://47.108.68.144:9001";
        public static String LOGIN="/user/login";
    public static String UPDATE_USER_PWD="/user/updateUserPassWord";//更改密码
    public static String WAIT_DO_LIST="/workOrder/getWillWorkOrderList"; // 待办工单
    public static String MATAIN_LIST="/workOrder/getExpireWorkOrderList"; // 保养工单
    public  static String EQMENT_LIST="/asset/getAssetsList";//获取设备列表
    public  static String EQMENT_SEARCH_LIST="/asset/getAssetsQueryList";//设备列表模糊查询
    public static String ASSET_RUN_PARAMETERS="/asset/getAssetRunParameters";
    public static String GET_ASSERT_MATERIAL="/asset/getAssetMaterial";//设备台账-零配件使用情况
    public static String GET_ASSERT_WORKORDERS="/asset/getAssetWorkOrders";//设备台账-维修工单 保养工单 点巡检工单
    public static String GET_WAITDO_MATERIAL_LIST="/workOrder/getWorkOrderMaterialList";//待办工单使用零配件
    public static String MAINTAIN_PLAN_LIST="/workOrderPm/selectWorkOrderPmList";//运维管理-保养计划列表
    public static String DXJ_WORKORDER_LIST="/workOrder/selectWorkorderList";// 运维管理-点巡检工单
    public static String DXJ_SEARCH_WORKORDER_LIST="/workOrder/selectWorkorderQueryList";//运维管理-点巡检工单模糊搜索
    public static String GET_WORK_PROCESS="/workOrder/getWorkOrderTaskList";//保养工单-作业工序
    public static final String GET_WORK_EQUMENT_LIST = "/workOrder/selectWorkOrderAsset";//保养工单-设备
    public static String PROCESS_REJECT="/workOrder/updateBackStatus";//流程撤回
    public static final String PROCESS_GO ="/workOrder/updateNextStatus";//流程同意
    public static String FAULT_LIST="/failure/selectFailureList";//故障知识库
    public static String FAULT_LIST_SEARCH="/failure/selectFailureQueryList";//故障知识库模糊搜索
    public static final String GET_FAULT_COUNT ="/failure/getFailureCount";//故障知识库详情故障数
    public static String GET_FAULT_VISION="/failure/getFailureInfoMerge";//故障知识库详情 故障编码

    public static final String STANDARD_WORK_LIST ="/sop/selectSopQueryList" ;//标准作业列表
    public static final String GET_JOB_WORK_PROCESS ="/sop/selectJobplanJobtaskList" ;//标准作业 作业工序
    public static final String GET_JOB_MATERIAL_LIST = "/sop/selectJobplanJobmaterialQueryList";//标准作业 使用零配件




//        public static  String COMMONURL="http://192.168.1.180:7009/maximo/mobile/common/api";
//        public static String COMMONSOAP="http://192.168.1.180:7009/meaweb/services/WFSERVICE";
//        public static String COMMONSOAP2="http://192.168.1.180:7009/meaweb/services/MOBILESERVICE";










    public static final int NETWORN_NONE = 0;//没有网路
    public static final int NETWORN_WIFI = 1;//wifi
    public static final int NETWORN_MODEL = 2;//


    public static String IS_AUTHOR="/workOrder/isAuthor";

}
