package demo.com.demo.ui.fragment.wechat;

import demo.com.demo.bean.ChapterBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-29
 * @Describe:
 */
public class WechatFragmentPresenter {
    IWechatFragmentModel iWechatFragmentModel;
    IWechatFragmentView iWechatFragmentView;

    public WechatFragmentPresenter(IWechatFragmentView iWechatFragmentView){
        this.iWechatFragmentView = iWechatFragmentView;
        this.iWechatFragmentModel = new WechatFragmentModelImpl();
    }

    public void loadChapter(){
        iWechatFragmentView.showLoading();
        iWechatFragmentModel.loadingChapter(new OnListenerCallback<ChapterBean>() {
            @Override
            public void onSuccess(ChapterBean chapterBean) {
                if (!chapterBean.getData().isEmpty()){
                    iWechatFragmentView.loadingWeChat(chapterBean.getData());
                }

                iWechatFragmentView.dismissLoading();
            }

            @Override
            public void onError(String msg) {
                iWechatFragmentView.dismissLoading();
            }
        });
    }
}
