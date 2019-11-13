package demo.com.demo.ui.activity.loginout;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import demo.com.demo.bean.BaseBean;
import demo.com.demo.bean.UserBean;
import demo.com.demo.intercallback.OnListenerCallback;
import demo.com.demo.intercept.AddIntercepter;
import demo.com.demo.net.ApiRequest;
import demo.com.demo.net.Url;
import demo.com.demo.ui.activity.login.ILoginModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-11-06
 * @Describe:
 */
public class ILoginOutModelImpl implements ILoginOutModel {
    @Override
    public void onLoginOut(Context context,OnListenerCallback<BaseBean<UserBean>> onListenerCallback) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AddIntercepter(context))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Url.BASE_URL)
                .client(okHttpClient)
                .build();

        retrofit.create(ApiRequest.class)
                .onLoginOut()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<UserBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<UserBean> value) {
                        onListenerCallback.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        onListenerCallback.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
