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
public interface ILoginOutModel {

    public void onLoginOut(Context context,OnListenerCallback<BaseBean<UserBean>> onListenerCallback);
}
