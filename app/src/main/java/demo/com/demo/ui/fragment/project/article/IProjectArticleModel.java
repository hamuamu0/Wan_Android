package demo.com.demo.ui.fragment.project.article;

import demo.com.demo.bean.ProjectArticleBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-30
 * @Describe:
 */
public interface IProjectArticleModel {

    public void loadingProjectarticle(int cid, int page, OnListenerCallback<ProjectArticleBean> onListenerCallback);


}
