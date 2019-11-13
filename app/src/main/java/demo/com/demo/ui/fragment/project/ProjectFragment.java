package demo.com.demo.ui.fragment.project;

import android.app.ProgressDialog;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import demo.com.demo.R;
import demo.com.demo.bean.ProjectTypeBean;
import demo.com.demo.ui.adapter.ProjectFragmentAdapter;
import demo.com.demo.ui.base.BaseFragment;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-22
 * @Describe:
 */
public class ProjectFragment extends BaseFragment implements IProjectTypeView{
    @BindView(R.id.table)
    TabLayout tabLayout;
    @BindView(R.id.vpProject)
    ViewPager vpProject;

    List<ProjectTypeBean.DataBean> projectTypeList;

    private ProgressDialog progressDialog;

    @Override
    public int initLayout() {
        return R.layout.fragment_project;
    }

    @Override
    public void initData() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("加载中...");
        projectTypeList = new ArrayList<>();
        ProjectTypePrensenter projectTypePrensenter = new ProjectTypePrensenter(this);
        projectTypePrensenter.loadProjectType();



    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void disMissLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void loadProjectType(List<ProjectTypeBean.DataBean> projectTypeList) {

        ProjectFragmentAdapter projectFragmentAdapter = new ProjectFragmentAdapter(projectTypeList,getChildFragmentManager());
        vpProject.setAdapter(projectFragmentAdapter);
        vpProject.setOffscreenPageLimit(projectTypeList.size());
        tabLayout.setupWithViewPager(vpProject);
    }

    @Override
    public void loadProjectError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
