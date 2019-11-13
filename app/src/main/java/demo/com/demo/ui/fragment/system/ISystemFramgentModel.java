package demo.com.demo.ui.fragment.system;

import demo.com.demo.bean.SystemBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-29
 * @Describe:
 */
public interface ISystemFramgentModel {

    public void loadSystemData(OnListenerCallback<SystemBean> onListenerCallback);
}
