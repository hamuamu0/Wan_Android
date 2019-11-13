package demo.com.demo.ui.activity.login;

import demo.com.demo.bean.BaseBean;
import demo.com.demo.bean.UserBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-11-05
 * @Describe:
 */
public interface ILoginView {

    public void onLoginSuccess(BaseBean<UserBean> userBean);

    public void showDialog();

    public void dismissDialog();

    public void onErrorMsg(String msg);
}
