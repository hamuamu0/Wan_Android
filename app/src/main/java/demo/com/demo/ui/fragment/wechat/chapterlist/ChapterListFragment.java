package demo.com.demo.ui.fragment.wechat.chapterlist;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import demo.com.demo.R;
import demo.com.demo.bean.ArticleBean;
import demo.com.demo.ui.activity.webview.WebviewActivity;
import demo.com.demo.ui.adapter.ArticleAdapter;
import demo.com.demo.ui.base.BaseFragment;
import demo.com.demo.utils.IntentUtils;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-29
 * @Describe:
 */
public class ChapterListFragment extends BaseFragment implements IChapterListView {

    private static final String ID = "CHAPTER_ID";
    private int id;
    @BindView(R.id.rv_chapterlist)
    RecyclerView rvArticle;
    @BindView(R.id.swiper)
    SwipeRefreshLayout refreshLayout;
    List<ArticleBean.DataBean.DatasBean> list;
    ArticleAdapter articleAdapter;
    int i = 1;
    private final String URL = "LOAD_URL";
    public static ChapterListFragment instance(int id){
        ChapterListFragment instance = new ChapterListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ID,id);
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public int initLayout() {
        return R.layout.fragment_chapterlist;
    }

    @Override
    public void initData() {
        list = new ArrayList<>();
        articleAdapter = new ArticleAdapter(getContext(),list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvArticle.setLayoutManager(linearLayoutManager);
        rvArticle.setAdapter(articleAdapter);
        Bundle bundle = getArguments();
        id = bundle.getInt(ID);
        ChapterArticlePresenter chapterArticlePresenter = new ChapterArticlePresenter(this);
        chapterArticlePresenter.loadArticle(id,i);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                chapterArticlePresenter.loadArticle(id,i);
                refreshLayout.setRefreshing(false);
            }
        });


        articleAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                i++;
                chapterArticlePresenter.loadArticle(id,i);
                articleAdapter.loadMoreComplete();
            }
        },rvArticle);

        articleAdapter.disableLoadMoreIfNotFullPage();

        articleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                IntentUtils.startIntentBundleStringActivity(getContext(),URL,list.get(position).getLink(), WebviewActivity.class);
            }
        });

    }

    @Override
    public void loadingWeChat(List<ArticleBean.DataBean.DatasBean> articleList) {
        list.addAll(articleList);
        articleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
