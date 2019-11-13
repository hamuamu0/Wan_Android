package demo.com.demo.ui.fragment.system.know;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import demo.com.demo.R;
import demo.com.demo.bean.KnowBean;
import demo.com.demo.ui.activity.webview.WebviewActivity;
import demo.com.demo.ui.adapter.SystemKnowAdapter;
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
public class KownFragment extends BaseFragment implements IKnowView{
    @BindView(R.id.swiper)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.rv_know)
    RecyclerView rvKnow;

    private List<KnowBean.DataBean.DatasBean> knowList;

    private SystemKnowAdapter systemKnowAdapter;

    private ProgressDialog progressDialog;

    private int page;

    private static final String ID = "ID";

    private final String URL = "LOAD_URL";


    public static KownFragment instance(int cid){
        Bundle bundle = new Bundle();
        bundle.putInt(ID,cid);
        KownFragment instance = new KownFragment();
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public int initLayout() {
        return R.layout.fragment_know;
    }

    @Override
    public void initData() {
        page = 0;
        Bundle bundle = getArguments();
        int cid = bundle.getInt(ID);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("正在加载...");
        KnowPresenter knowPresenter = new KnowPresenter(this);
        knowPresenter.loadingKnow(0,cid);
        knowList = new ArrayList<>();
        systemKnowAdapter = new SystemKnowAdapter(getContext(),knowList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvKnow.setLayoutManager(linearLayoutManager);
        rvKnow.setAdapter(systemKnowAdapter);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                knowList.clear();
                knowPresenter.loadingKnow(0,cid);
                refreshLayout.setRefreshing(false);
            }
        });

        systemKnowAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                page ++;
                knowPresenter.loadingKnow(page,cid);
                systemKnowAdapter.loadMoreComplete();
            }
        },rvKnow);

        systemKnowAdapter.disableLoadMoreIfNotFullPage(rvKnow);
    }


    @Override
    public void loadingKnow(List<KnowBean.DataBean.DatasBean> list) {
        knowList.addAll(list);
        systemKnowAdapter.notifyDataSetChanged();

        systemKnowAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                IntentUtils.startIntentBundleStringActivity(getContext(),URL,list.get(position).getLink(), WebviewActivity.class);
            }
        });


    }

    @Override
    public void errorMsg(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void dismissLoading() {
        progressDialog.dismiss();
    }
}
