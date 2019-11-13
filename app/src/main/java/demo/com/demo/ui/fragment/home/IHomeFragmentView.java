package demo.com.demo.ui.fragment.home;

import java.util.List;

import demo.com.demo.bean.BannerBean;
import demo.com.demo.bean.HomeListBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-23
 * @Describe:
 */
public interface IHomeFragmentView {

    public void onSuccessShowBannerImage(List<BannerBean.DataBean> beanList);

    public void onErrorBannerImage(String msg);

    public void onSuccessHomeList(List<HomeListBean.DataBean.DatasBean> datasBeanList);

    public void onErrorHomeList(String msg);


}
