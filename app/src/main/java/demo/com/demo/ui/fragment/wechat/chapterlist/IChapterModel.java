package demo.com.demo.ui.fragment.wechat.chapterlist;

import demo.com.demo.bean.ArticleBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-29
 * @Describe:
 */
public interface IChapterModel {

    public void loadingChapterArticle(int id, int page, OnListenerCallback<ArticleBean> onListenerCallback);


}
