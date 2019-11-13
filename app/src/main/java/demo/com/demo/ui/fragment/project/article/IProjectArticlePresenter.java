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
public class IProjectArticlePresenter {

    private IProjectArticleModel iProjectArticleModel;
    private IProjectArticleFragmentView iProjectArticleFragmentView;

    public IProjectArticlePresenter(IProjectArticleFragmentView iProjectArticleFragmentView){
        this.iProjectArticleFragmentView = iProjectArticleFragmentView;
        this.iProjectArticleModel = new ProjectArticleModelImpl();
    }

    public void loadProjectArticle(int page,int cid){
        iProjectArticleModel.loadingProjectarticle(page,cid, new OnListenerCallback<ProjectArticleBean>() {
            @Override
            public void onSuccess(ProjectArticleBean projectArticleBean) {
                if (!projectArticleBean.getData().getDatas().isEmpty()){
                    iProjectArticleFragmentView.loadingProjectArticle(projectArticleBean.getData().getDatas());
                }
            }

            @Override
            public void onError(String msg) {
                    iProjectArticleFragmentView.loadingError(msg);
            }
        });
    }
}
