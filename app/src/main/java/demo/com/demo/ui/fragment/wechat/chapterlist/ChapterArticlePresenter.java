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
public class ChapterArticlePresenter {

    IChapterListView iChapterListView;
    IChapterModel iChapterModel;

    public ChapterArticlePresenter(IChapterListView iChapterListView){
        this.iChapterListView = iChapterListView;
        iChapterModel = new ChapterArticleModelImpl();
    }

    public void loadArticle(int id,int page){
        iChapterModel.loadingChapterArticle(id, page, new OnListenerCallback<ArticleBean>() {
            @Override
            public void onSuccess(ArticleBean articleBean) {
                if (!articleBean.getData().getDatas().isEmpty()){
                    iChapterListView.loadingWeChat(articleBean.getData().getDatas());
                }

            }

            @Override
            public void onError(String msg) {
                iChapterListView.showErrorMsg(msg);
            }
        });
    }
}
