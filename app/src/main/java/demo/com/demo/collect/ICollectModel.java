package demo.com.demo.collect;

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
public interface ICollectModel {

    public void onCollect(Context context, int id, OnListenerCallback<BaseBean<UserBean>> onListenerCallback);
}
