package com.cn.smarteam.base;

public class Constants {
    public static final String SHARE_PREFERENCES_NAME = "BeiSanCompanny";
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
    public static String GET_ASSERT_WORKORDERS="/asset/getAssetWorkOrders";//设备台账-维修工单
//        public static  String COMMONURL="http://192.168.1.180:7009/maximo/mobile/common/api";
//        public static String COMMONSOAP="http://192.168.1.180:7009/meaweb/services/WFSERVICE";
//        public static String COMMONSOAP2="http://192.168.1.180:7009/meaweb/services/MOBILESERVICE";










    public static final int NETWORN_NONE = 0;//没有网路
    public static final int NETWORN_WIFI = 1;//wifi
    public static final int NETWORN_MODEL = 2;//




}
