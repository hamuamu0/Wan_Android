package demo.com.demo.ui.fragment.system.know;

import demo.com.demo.bean.KnowBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-30
 * @Describe:
 */
public interface IKnowModel {

    public void loadKnowData(int page, int cid, OnListenerCallback<KnowBean> listenerCallback);
}
