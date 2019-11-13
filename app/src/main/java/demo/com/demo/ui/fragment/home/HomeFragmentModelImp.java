package demo.com.demo.ui.fragment.home;



import android.net.Uri;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import demo.com.demo.bean.BannerBean;
import demo.com.demo.bean.HomeListBean;
import demo.com.demo.intercallback.OnListenerCallback;
import demo.com.demo.net.ApiRequest;
import demo.com.demo.net.Url;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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
public class HomeFragmentModelImp implements IHomeFragmentModel {


    @Override
    public void loadBanner(String url, OnListenerCallback<BannerBean> listenerCallback) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiRequest apiRequest = retrofit.create(ApiRequest.class);
        apiRequest.banner().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean value) {
                        listenerCallback.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listenerCallback.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void loadHomeList(int page,OnListenerCallback<HomeListBean> listenerCallback) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Url.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            retrofit.create(ApiRequest.class)
                    .homeList(page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<HomeListBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(HomeListBean value) {
                            listenerCallback.onSuccess(value);
                        }

                        @Override
                        public void onError(Throwable e) {
                            listenerCallback.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }
}
