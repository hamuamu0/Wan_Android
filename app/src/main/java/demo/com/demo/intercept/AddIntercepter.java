package demo.com.demo.intercept;

import android.content.Context;

import java.io.IOException;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme: 获取拦截器内容
 * @Data:2019-11-05
 * @Describe:
 */
public class AddIntercepter implements Interceptor {

    Context context;

    public AddIntercepter(Context context){
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        Set<String> cookieSet = context.getSharedPreferences("CookieData", Context.MODE_PRIVATE).getStringSet("cookie", null);
        if (!cookieSet.isEmpty()){
            for(String cookie:cookieSet){
                builder.addHeader("Cookie",cookie);
            }
        }
        return chain.proceed(builder.build());
    }
}
