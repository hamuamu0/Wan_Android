package demo.com.demo.ui.fragment.system.know;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import demo.com.demo.bean.KnowBean;
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
 * @Data:2019-10-30
 * @Describe:
 */
public class KnowModelImpl implements IKnowModel {
    @Override
    public void loadKnowData(int page, int cid, OnListenerCallback<KnowBean> listenerCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        retrofit.create(ApiRequest.class)
                .getSystemKnow(page,cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<KnowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(KnowBean value) {
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
