package demo.com.demo.ui.fragment.wechat.chapterlist;

import java.util.List;

import demo.com.demo.bean.ArticleBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-29
 * @Describe:
 */
public interface IChapterListView {

    public void loadingWeChat(List<ArticleBean.DataBean.DatasBean> articleList);

    public void showErrorMsg(String msg);


}
