package demo.com.demo.ui.activity.search;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import demo.com.demo.bean.HomeListBean;
import demo.com.demo.bean.SearchTagBean;
import demo.com.demo.intercallback.OnListenerCallback;
import demo.com.demo.net.ApiRequest;
import demo.com.demo.net.Url;
import io.reactivex.Observable;
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
 * @Data:2019-10-28
 * @Describe:
 */
public class SearchModelImp implements ISearchModel {
    @Override
    public void loadSearchTag(OnListenerCallback<SearchTagBean> listenerCallback) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Observable<SearchTagBean> searchTagBeanObservable = retrofit.create(ApiRequest.class).searchTag();

        searchTagBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchTagBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("SearchActivityError", "======");
            }

            @Override
            public void onNext(SearchTagBean value) {

                listenerCallback.onSuccess(value);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("SearchActivityError",e.getMessage());
                listenerCallback.onError(e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i("SearchActivityError", "--------");
            }
        });
    }

    @Override
    public void loadSearchResult(int page,String keyWord,OnListenerCallback<HomeListBean> listenerCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Url.BASE_URL)
                .build();

        Observable<HomeListBean> homeListBeanObservable = retrofit.create(ApiRequest.class).searchWord(page, keyWord);
        homeListBeanObservable.subscribeOn(Schedulers.io())
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
