package com.cn.smarteam.net;
import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

public class OkhttpUtil {


    public static final String METHOD_GET = "GET";

    public static final String METHOD_POST = "POST";

    public static final String METHOD_PUT = "PUT";

    public static final String METHOD_DELETE = "DELETE";


    public static final String FILE_TYPE_FILE = "file/*";

    public static final String FILE_TYPE_IMAGE = "image/*";

    public static final String FILE_TYPE_AUDIO = "audio/*";

    public static final String FILE_TYPE_VIDEO = "video/*";


    /**
     * get请求
     *
     * @param url：url
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpGet(String url, CallBackUtil callBack) {

        return okHttpGet(url, null, null, callBack);

    }


    /**
     * get请求，可以传递参数
     *
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpGet(String url, Map<String, String> paramsMap, CallBackUtil callBack) {

        return okHttpGet(url, paramsMap, null, callBack);

    }


    /**
     * get请求，可以传递参数
     *
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpGet(String url, Map<String, String> paramsMap, Map<String, String> headerMap, CallBackUtil callBack) {

        return new RequestUtil(METHOD_GET, url, paramsMap, headerMap, callBack).execute();

    }


    /**
     * post请求
     *
     * @param url：url
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpPost(String url, CallBackUtil callBack) {

        return okHttpPost(url, null, callBack);

    }


    /**
     * post请求，可以传递参数
     *
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpPost(String url, Map<String, String> paramsMap, CallBackUtil callBack) {

        return okHttpPost(url, paramsMap, null, callBack);

    }


    /**
     * post请求，可以传递参数
     *
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpPost(String url, Map<String, String> paramsMap, Map<String, String> headerMap, CallBackUtil callBack) {

//        if(headerMap==null)
//        {
//            HashMap<String, String> header = new HashMap<>();
//            header.put("Accept", "application/json");
//            header.put("Content-Type", "application/json;charset=UTF-8");
//            headerMap=header;
//        }
        return new RequestUtil(METHOD_POST, url, paramsMap, headerMap, callBack).execute();

    }

    /**
     * post请求
     *
     * @param url：url
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpPut(String url, CallBackUtil callBack) {

        return okHttpPut(url, null, callBack);

    }


    /**
     * post请求，可以传递参数
     *
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpPut(String url, Map<String, String> paramsMap, CallBackUtil callBack) {

        return okHttpPut(url, paramsMap, null, callBack);

    }


    /**
     * post请求，可以传递参数
     *
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpPut(String url, Map<String, String> paramsMap, Map<String, String> headerMap, CallBackUtil callBack) {

        return new RequestUtil(METHOD_PUT, url, paramsMap, headerMap, callBack).execute();

    }

    /**
     * post请求
     *
     * @param url：url
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpDelete(String url, CallBackUtil callBack) {

        return okHttpDelete(url, null, callBack);

    }


    /**
     * post请求，可以传递参数
     *
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpDelete(String url, Map<String, String> paramsMap, CallBackUtil callBack) {

        return okHttpDelete(url, paramsMap, null, callBack);

    }


    /**
     * post请求，可以传递参数
     *
     * @param url：url
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpDelete(String url, Map<String, String> paramsMap, Map<String, String> headerMap, CallBackUtil callBack) {

        return new RequestUtil(METHOD_DELETE, url, paramsMap, headerMap, callBack).execute();

    }


    /**
     * post请求，可以传递参数
     *
     * @param url：url
     * @param jsonStr：json格式的键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpPostJson(String url, String jsonStr, CallBackUtil callBack) {

        return okHttpPostJson(url, jsonStr, null, callBack);

    }


    /**
     * post请求，可以传递参数
     *
     * @param url：url
     * @param jsonStr：json格式的键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpPostJson(String url, String jsonStr, Map<String, String> headerMap, CallBackUtil callBack) {
            return new RequestUtil(METHOD_POST, url, jsonStr, headerMap, callBack).execute();


    }


    /**
     * post请求，上传单个文件
     *
     * @param url：url
     * @param file：File对象
     * @param fileKey：上传参数时file对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。还可以重写onProgress方法，得到上传进度
     */

    public static Call okHttpUploadFile(String url, File file, String fileKey, String fileType, CallBackUtil callBack) {

        return okHttpUploadFile(url, file, fileKey, fileType, null, callBack);

    }


    /**
     * post请求，上传单个文件
     *
     * @param url：url
     * @param file：File对象
     * @param fileKey：上传参数时file对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。还可以重写onProgress方法，得到上传进度
     */

    public static Call okHttpUploadFile(String url, File file, String fileKey, String fileType, Map<String, String> paramsMap, CallBackUtil callBack) {

        return okHttpUploadFile(url, file, fileKey, fileType, paramsMap, null, callBack);

    }


    /**
     * post请求，上传单个文件
     *
     * @param url：url
     * @param file：File对象
     * @param fileKey：上传参数时file对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。还可以重写onProgress方法，得到上传进度
     */

    public static Call okHttpUploadFile(String url, File file, String fileKey, String fileType, Map<String, String> paramsMap, Map<String, String> headerMap, CallBackUtil callBack) {

        return new RequestUtil(METHOD_POST, url, paramsMap, file, fileKey, fileType, headerMap, callBack).execute();

    }


    /**
     * post请求，上传多个文件，以list集合的形式
     *
     * @param url：url
     * @param fileList：集合元素是File对象
     * @param fileKey：上传参数时fileList对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpUploadListFile(String url, List<File> fileList, String fileKey, String fileType, CallBackUtil callBack) {

        return okHttpUploadListFile(url, null, fileList, fileKey, fileType, callBack);

    }


    /**
     * post请求，上传多个文件，以list集合的形式
     *
     * @param url：url
     * @param fileList：集合元素是File对象
     * @param fileKey：上传参数时fileList对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpUploadListFile(String url, Map<String, String> paramsMap, List<File> fileList, String fileKey, String fileType, CallBackUtil callBack) {

        return okHttpUploadListFile(url, paramsMap, fileList, fileKey, fileType, null, callBack);

    }


    /**
     * post请求，上传多个文件，以list集合的形式
     *
     * @param url：url
     * @param fileList：集合元素是File对象
     * @param fileKey：上传参数时fileList对应的键
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpUploadListFile(String url, Map<String, String> paramsMap, List<File> fileList, String fileKey, String fileType, Map<String, String> headerMap, CallBackUtil callBack) {

        return new RequestUtil(METHOD_POST, url, paramsMap, fileList, fileKey, fileType, headerMap, callBack).execute();

    }


    /**
     * post请求，上传多个文件，以map集合的形式
     *
     * @param url：url
     * @param fileMap：集合key是File对象对应的键，集合value是File对象
     * @param fileType：File类型，是image，video，audio，file
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpUploadMapFile(String url, Map<String, File> fileMap, String fileType, CallBackUtil callBack) {

        return okHttpUploadMapFile(url, fileMap, fileType, null, callBack);

    }


    /**
     * post请求，上传多个文件，以map集合的形式
     *
     * @param url：url
     * @param fileMap：集合key是File对象对应的键，集合value是File对象
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpUploadMapFile(String url, Map<String, File> fileMap, String fileType, Map<String, String> paramsMap, CallBackUtil callBack) {

        return okHttpUploadMapFile(url, fileMap, fileType, paramsMap, null, callBack);

    }


    /**
     * post请求，上传多个文件，以map集合的形式
     *
     * @param url：url
     * @param fileMap：集合key是File对象对应的键，集合value是File对象
     * @param fileType：File类型，是image，video，audio，file
     * @param paramsMap：map集合，封装键值对参数
     * @param headerMap：map集合，封装请求头键值对
     * @param callBack：回调接口，onFailure方法在请求失败时调用，onResponse方法在请求成功后调用，这两个方法都执行在UI线程。
     */

    public static Call okHttpUploadMapFile(String url, Map<String, File> fileMap, String fileType, Map<String, String> paramsMap, Map<String, String> headerMap, CallBackUtil callBack) {

        return new RequestUtil(METHOD_POST, url, paramsMap, fileMap, fileType, headerMap, callBack).execute();

    }


    /**
     * 下载文件,不带参数
     */

    public static Call okHttpDownloadFile(String url, CallBackUtil.CallBackFile callBack) {

        return okHttpDownloadFile(url, null, callBack);

    }


    /**
     * 下载文件,带参数
     */

    public static Call okHttpDownloadFile(String url, Map<String, String> paramsMap, CallBackUtil.CallBackFile callBack) {

        return okHttpGet(url, paramsMap, null, callBack);

    }

    /**
     * 加载图片
     */

    public static Call okHttpGetBitmap(String url, CallBackUtil.CallBackBitmap callBack) {

        return okHttpGetBitmap(url, null, callBack);

    }

    /**
     * 加载图片，带参数
     */

    public static Call okHttpGetBitmap(String url, Map<String, String> paramsMap, CallBackUtil.CallBackBitmap callBack) {

        return okHttpGet(url, paramsMap, null, callBack);

    }


}

