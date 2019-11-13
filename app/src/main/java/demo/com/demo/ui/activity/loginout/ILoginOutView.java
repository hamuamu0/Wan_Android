package demo.com.demo.ui.activity.loginout;

import demo.com.demo.bean.BaseBean;
import demo.com.demo.bean.UserBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-11-06
 * @Describe:
 */
public interface ILoginOutView {

    public void onLoginOut(BaseBean<UserBean> userBeanBaseBean);

    public void onErrorMsg(String msg);

    public void onShowDialog();

    public void onDisMissDialog();
}
