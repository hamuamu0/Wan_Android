package demo.com.demo.ui.activity.login;

import android.content.Context;

import demo.com.demo.bean.BaseBean;
import demo.com.demo.bean.UserBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-11-05
 * @Describe:
 */
public class LoginPresenter {

    ILoginView iLoginView;
    ILoginModel iLoginModel;

    public LoginPresenter(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        this.iLoginModel = new LoginModelImpl();
    }

    public void onLogin(Context context,String userName, String password){
        iLoginView.showDialog();
        iLoginModel.onLogin(context,userName, password, new OnListenerCallback<BaseBean<UserBean>>() {
            @Override
            public void onSuccess(BaseBean<UserBean> userBean) {
                iLoginView.onLoginSuccess(userBean);
                iLoginView.dismissDialog();
            }

            @Override
            public void onError(String msg) {
                iLoginView.onErrorMsg(msg);
                iLoginView.dismissDialog();
            }
        });
    }
}
