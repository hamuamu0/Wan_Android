package demo.com.demo.ui.fragment.wechat;

import java.util.List;

import demo.com.demo.bean.ChapterBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-29
 * @Describe:
 */
public interface IWechatFragmentView {

    public void loadingWeChat(List<ChapterBean.DataBean> chapterList);

    public void showLoading();

    public void dismissLoading();
}
