package demo.com.demo.ui.activity.search;

import demo.com.demo.bean.HomeListBean;
import demo.com.demo.bean.SearchTagBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-28
 * @Describe:
 */
public interface ISearchModel {

    public void loadSearchTag(OnListenerCallback<SearchTagBean> listenerCallback);

    public void loadSearchResult(int page,String keyword,OnListenerCallback<HomeListBean> listenerCallback);


}
