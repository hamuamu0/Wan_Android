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
public interface IWechatFragmentModel {

    public void loadingChapter(OnListenerCallback<ChapterBean> chapter);


}
