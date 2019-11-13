package demo.com.demo.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-23
 * @Describe:
 */
public class HttpRequest {

    private static HttpRequest instance = null;

    private  HttpRequest(){

    }

    public static HttpRequest getInstance(){
        if (instance == null){
            synchronized (HttpRequest.class){
                if (instance == null){
                    instance = new HttpRequest();
                }
            }
        }
        return instance;
    }

    public void httpNetWorkRequest(){

    }
}
