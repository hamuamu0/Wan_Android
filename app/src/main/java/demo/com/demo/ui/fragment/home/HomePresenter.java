package demo.com.demo.ui.fragment.home;

import demo.com.demo.bean.BannerBean;
import demo.com.demo.bean.HomeListBean;
import demo.com.demo.intercallback.OnListenerCallback;
import demo.com.demo.net.Url;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-23
 * @Describe:
 */
public class HomePresenter {

    IHomeFragmentView homeFragmentView;

    IHomeFragmentModel homeFragmentModel;

    public HomePresenter(IHomeFragmentView homeFragmentView){
            this.homeFragmentView = homeFragmentView;
            homeFragmentModel = new HomeFragmentModelImp();
    }

    public void requestBannerInfo(){
        homeFragmentModel.loadBanner(Url.BANNER, new OnListenerCallback<BannerBean>() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                if (!bannerBean.getData().isEmpty()){
                    homeFragmentView.onSuccessShowBannerImage(bannerBean.getData());
                }

            }

            @Override
            public void onError(String msg) {
                    homeFragmentView.onErrorBannerImage(msg);
            }
        });
    }

    public void requestHomeListInfo(int page){
        homeFragmentModel.loadHomeList(page, new OnListenerCallback<HomeListBean>() {
            @Override
            public void onSuccess(HomeListBean homeListBean) {
                if (!homeListBean.getData().getDatas().isEmpty()){
                    homeFragmentView.onSuccessHomeList(homeListBean.getData().getDatas());
                }
            }

            @Override
            public void onError(String msg) {
                    homeFragmentView.onErrorHomeList(msg);
            }
        });
    }


}
