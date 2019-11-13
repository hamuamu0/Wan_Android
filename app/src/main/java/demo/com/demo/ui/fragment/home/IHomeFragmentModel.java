package demo.com.demo.ui.fragment.home;

import demo.com.demo.bean.BannerBean;
import demo.com.demo.bean.HomeListBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-23
 * @Describe:
 */
public interface IHomeFragmentModel {

        public void loadBanner(String url, OnListenerCallback<BannerBean> listenerCallback);

        public void loadHomeList(int page,OnListenerCallback<HomeListBean> listenerCallback);


}
