package demo.com.demo.ui.fragment.system;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import demo.com.demo.R;
import demo.com.demo.bean.SystemBean;
import demo.com.demo.ui.activity.system.KnowSystemActivity;
import demo.com.demo.ui.adapter.SystemDataAdapter;
import demo.com.demo.ui.base.BaseFragment;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-22
 * @Describe:
 */
public class SystemFragment extends BaseFragment implements ISystemFragmentView {

    private ProgressDialog progressDialog;

    private SystemFragmentPresenter systemFragmentPresenter;

    private List<SystemBean.DataBean> systemList;

    private final String CHILDREN = "CHILDREN";

    @BindView(R.id.rv_list)
    RecyclerView rvSystemList;

    SystemDataAdapter systemDataAdapter;
    @Override
    public int initLayout() {
        return R.layout.fragment_system;
    }

    @Override
    public void initData() {
        systemList = new ArrayList<>();
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("加载中...");
        systemFragmentPresenter = new SystemFragmentPresenter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvSystemList.setLayoutManager(linearLayoutManager);
        systemDataAdapter = new SystemDataAdapter(getContext(),systemList);
        rvSystemList.setAdapter(systemDataAdapter);
        systemFragmentPresenter.loadingSystemData();


    }


    @Override
    public void showSystemData(List<SystemBean.DataBean> list) {
        systemList.addAll(list);
        systemDataAdapter.notifyDataSetChanged();
        systemDataAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), KnowSystemActivity.class);
                intent.putExtra(CHILDREN,systemList.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void dissLoading() {
        progressDialog.dismiss();
    }
}
