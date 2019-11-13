package demo.com.demo.ui.fragment.project.article;

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
import demo.com.demo.bean.ProjectArticleBean;
import demo.com.demo.ui.activity.webview.WebviewActivity;
import demo.com.demo.ui.adapter.ProjectArticleFragmentAdapter;
import demo.com.demo.ui.base.BaseFragment;
import demo.com.demo.utils.IntentUtils;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-30
 * @Describe:
 */
public class ProjectArticleFragment extends BaseFragment implements IProjectArticleFragmentView {
    @BindView(R.id.rv_project)
    RecyclerView rvProject;

    @BindView(R.id.swiper)
    SwipeRefreshLayout refreshLayout;

    private static final String ID = "ID";

    private List<ProjectArticleBean.DataBean.DatasBean> articleList;

    private ProjectArticleFragmentAdapter projectArticleFragmentAdapter;

    private int page;

    private int cid;

    private final String URL = "LOAD_URL";

    public static ProjectArticleFragment instance(int id){
        Bundle bundle = new Bundle();
        bundle.putInt(ID,id);
        ProjectArticleFragment instance = new ProjectArticleFragment();
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public int initLayout() {
        return R.layout.fragment_project_article;
    }

    @Override
    public void initData() {
        articleList = new ArrayList<>();
        page = 1;
        cid = getArguments().getInt(ID);
        IProjectArticlePresenter iProjectArticlePresenter = new IProjectArticlePresenter(this);
        iProjectArticlePresenter.loadProjectArticle(page,cid);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvProject.setLayoutManager(linearLayoutManager);
        rvProject.hasFixedSize();
        projectArticleFragmentAdapter = new ProjectArticleFragmentAdapter(getContext(),articleList);
        rvProject.setAdapter(projectArticleFragmentAdapter);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                articleList.clear();
                iProjectArticlePresenter.loadProjectArticle(1,cid);
                refreshLayout.setRefreshing(false);
            }
        });

        projectArticleFragmentAdapter.loadMoreEnd(true);
        projectArticleFragmentAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                page++;
                iProjectArticlePresenter.loadProjectArticle(page,cid);
                projectArticleFragmentAdapter.loadMoreComplete();
            }
        },rvProject);
        projectArticleFragmentAdapter.disableLoadMoreIfNotFullPage();


    }

    @Override
    public void loadingProjectArticle(List<ProjectArticleBean.DataBean.DatasBean> list) {
        articleList.addAll(list);
        projectArticleFragmentAdapter.notifyDataSetChanged();
        projectArticleFragmentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                IntentUtils.startIntentBundleStringActivity(getContext(),URL,articleList.get(position).getLink(), WebviewActivity.class);
            }
        });
    }

    @Override
    public void loadingError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
