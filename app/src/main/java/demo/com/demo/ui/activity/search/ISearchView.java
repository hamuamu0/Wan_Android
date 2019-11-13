package demo.com.demo.ui.activity.search;

import java.util.List;

import demo.com.demo.bean.HomeListBean;
import demo.com.demo.bean.SearchTagBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-28
 * @Describe:
 */
public interface ISearchView {

    /**
     * 搜索标签结果
     * @param searchTag
     */
    public void showTag(List<SearchTagBean.DataBean> searchTag);

    /**
     * 搜索出错
     * @param error
     */
    public void loadSearchTagError(String error);

    /**
     * 加载搜索结果
     * @param homelistBean
     */
    public void loadSearchResult(List<HomeListBean.DataBean.DatasBean> homelistBean);


}
