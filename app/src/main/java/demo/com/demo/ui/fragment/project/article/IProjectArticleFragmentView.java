package demo.com.demo.ui.fragment.project.article;

import java.util.List;

import demo.com.demo.bean.ProjectArticleBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-30
 * @Describe:
 */
public interface IProjectArticleFragmentView {

    public void loadingProjectArticle(List<ProjectArticleBean.DataBean.DatasBean> list);

    public void loadingError(String msg);


}
