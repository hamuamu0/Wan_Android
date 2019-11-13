package demo.com.demo.ui.fragment.wechat;

import android.app.ProgressDialog;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import demo.com.demo.R;
import demo.com.demo.bean.ChapterBean;
import demo.com.demo.ui.adapter.ChapterFragmemtsAdapter;
import demo.com.demo.ui.base.BaseFragment;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-22
 * @Describe:
 */
public class WechatFragment extends BaseFragment implements IWechatFragmentView {

    @BindView(R.id.table)
    TabLayout tabLayout;
    @BindView(R.id.viewpage_wechat)
    ViewPager vpWeChat;

    WechatFragmentPresenter wechatFragmentPresenter;

    private ProgressDialog progressDialog;

    @Override
    public int initLayout() {
        return R.layout.fragment_wechat;
    }

    @Override
    public void initData() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("加载中...");
        wechatFragmentPresenter = new WechatFragmentPresenter(this);
        wechatFragmentPresenter.loadChapter();
    }

    @Override
    public void loadingWeChat(List<ChapterBean.DataBean> chapterList) {


        ChapterFragmemtsAdapter chapterFragmemtsAdapter = new ChapterFragmemtsAdapter(getChildFragmentManager(),chapterList);
        vpWeChat.setAdapter(chapterFragmemtsAdapter);
        vpWeChat.setOffscreenPageLimit(chapterList.size());
        tabLayout.setupWithViewPager(vpWeChat);

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
