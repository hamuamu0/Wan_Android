package demo.com.demo.intercept;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme: 拦截器
 * @Data:2019-11-05
 * @Describe:
 */
public class SaveIntercepter implements Interceptor {

    Context context;

    public SaveIntercepter(Context context){
        this.context = context;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        Set<String> hashSet = new HashSet<>();
        if (!proceed.headers("Set-Cookie").isEmpty()){
            for (String cookie:proceed.headers("Set-Cookie")){
                hashSet.add(cookie);
            }
        };

        SharedPreferences saveCookie = context.getSharedPreferences("CookieData", Context.MODE_PRIVATE);
        saveCookie.edit().putStringSet("cookie",hashSet).commit();
        return proceed;
    }
}
