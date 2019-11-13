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
public interface ILoginModel {

    public void onLogin(Context context,String userName, String password, OnListenerCallback<BaseBean<UserBean>> onListenerCallback);
}
