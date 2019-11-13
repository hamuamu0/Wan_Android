package demo.com.demo.ui.activity.loginout;

import android.content.Context;

import demo.com.demo.bean.BaseBean;
import demo.com.demo.bean.UserBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-11-06
 * @Describe:
 */
public class ILoginOutPresenter {

    ILoginOutView iLoginOutView;
    ILoginOutModel iLoginOutModel;

    public ILoginOutPresenter(ILoginOutView iLoginOutView){
        this.iLoginOutView = iLoginOutView;
        this.iLoginOutModel = new ILoginOutModelImpl();
    }

    public void onLoginOut(Context context){
        iLoginOutView.onShowDialog();
        iLoginOutModel.onLoginOut(context, new OnListenerCallback<BaseBean<UserBean>>() {
            @Override
            public void onSuccess(BaseBean<UserBean> userBeanBaseBean) {
                iLoginOutView.onLoginOut(userBeanBaseBean);
                iLoginOutView.onDisMissDialog();
            }

            @Override
            public void onError(String msg) {
                iLoginOutView.onErrorMsg(msg);
                iLoginOutView.onDisMissDialog();
            }
        });
    }
}
