package com.cn.smarteam.base;

public class Constants {
    public static final String SHARE_PREFERENCES_NAME = "SmartEam";
    public static final String FONT_SIZE = "fontsize";


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


//        public static  String COMMONURL="http://192.168.1.180:7009/maximo/mobile/common/api";
//        public static String COMMONSOAP="http://192.168.1.180:7009/meaweb/services/WFSERVICE";
//        public static String COMMONSOAP2="http://192.168.1.180:7009/meaweb/services/MOBILESERVICE";










    public static final int NETWORN_NONE = 0;//没有网路
    public static final int NETWORN_WIFI = 1;//wifi
    public static final int NETWORN_MODEL = 2;//


}
