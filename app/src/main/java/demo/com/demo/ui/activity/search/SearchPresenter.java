package demo.com.demo.ui.activity.search;

import demo.com.demo.bean.HomeListBean;
import demo.com.demo.bean.SearchTagBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-28
 * @Describe:
 */
public class SearchPresenter {

    ISearchModel iSearchModel;
    ISearchView iSearchView;

    public SearchPresenter(ISearchView iSearchView){
        this.iSearchView = iSearchView;
        iSearchModel = new SearchModelImp();
    }

    public void loadTag(){
        iSearchModel.loadSearchTag(new OnListenerCallback<SearchTagBean>() {
            @Override
            public void onSuccess(SearchTagBean searchTagBean) {
                if (!searchTagBean.getData().isEmpty()){
                    iSearchView.showTag(searchTagBean.getData());
                }

            }

            @Override
            public void onError(String msg) {
                    iSearchView.loadSearchTagError(msg);
            }
        });
    }

    public void loadSearchResult(int page,String keyWord){
        iSearchModel.loadSearchResult(page, keyWord, new OnListenerCallback<HomeListBean>() {
            @Override
            public void onSuccess(HomeListBean homeListBean) {
                iSearchView.loadSearchResult(homeListBean.getData().getDatas());
            }

            @Override
            public void onError(String msg) {
                iSearchView.loadSearchTagError(msg);
            }
        });
    }
}
