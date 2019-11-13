package demo.com.demo.ui.fragment.home;


import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import demo.com.demo.R;
import demo.com.demo.bean.BannerBean;
import demo.com.demo.bean.HomeListBean;
import demo.com.demo.ui.activity.webview.WebviewActivity;
import demo.com.demo.ui.adapter.HomeAdapter;
import demo.com.demo.ui.base.BaseFragment;
import demo.com.demo.utils.BannerGlideLoader;
import demo.com.demo.utils.IntentUtils;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-22
 * @Describe:
 */
public class HomeFragment extends BaseFragment implements IHomeFragmentView {



    HomePresenter homePresenter;
    @BindView(R.id.swiper)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private View head;
    List<HomeListBean.DataBean.DatasBean> dataList;
    private HomeAdapter homeAdapter;
    private final String URL = "LOAD_URL";
    int i = 0;

    @Override
    public int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initData() {
        dataList = new ArrayList<>();
        head = View.inflate(getContext(),R.layout.head_banner,null);
        homePresenter = new HomePresenter(this);

        homeAdapter = new HomeAdapter(getContext(),dataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(homeAdapter);

        homeAdapter.setHeaderView(head);

        homePresenter.requestBannerInfo();
        homePresenter.requestHomeListInfo(0);



        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataList.clear();
                homeAdapter.removeHeaderView(head);
                homePresenter.requestHomeListInfo(0);
                homeAdapter.setHeaderView(head);
                homeAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        //上拉加载更多
        homeAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                i++;
                homePresenter.requestHomeListInfo(i);
                homeAdapter.loadMoreComplete();

            }
        },recyclerView);

        homeAdapter.disableLoadMoreIfNotFullPage();

        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.i("========",dataList.get(position).getLink() +"");
                IntentUtils.startIntentBundleStringActivity(getContext(),URL,dataList.get(position).getLink(), WebviewActivity.class);

            }
        });

    }


    @Override
    public void onSuccessShowBannerImage(List<BannerBean.DataBean> beanList) {
        List<String> imgs = new ArrayList<>();
        for (int i = 0; i < beanList.size(); i++) {
            imgs.add(beanList.get(i).getImagePath());
        }

        Banner banner = (Banner) head.findViewById(R.id.banner);
        banner.setImageLoader(new BannerGlideLoader());
        banner.setImages(imgs);
        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                IntentUtils.startIntentBundleStringActivity(getContext(),URL,beanList.get(position).getUrl(), WebviewActivity.class);
            }
        });

    }

    @Override
    public void onErrorBannerImage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessHomeList(List<HomeListBean.DataBean.DatasBean> datasBeanList) {

        dataList.addAll(datasBeanList);
        homeAdapter.notifyDataSetChanged();

    }

    @Override
    public void onErrorHomeList(String msg) {

    }
}
