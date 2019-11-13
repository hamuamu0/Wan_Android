package demo.com.demo.ui.adapter;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import demo.com.demo.bean.ProjectTypeBean;
import demo.com.demo.ui.fragment.project.article.ProjectArticleFragment;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-30
 * @Describe:
 */
public class ProjectFragmentAdapter extends FragmentPagerAdapter {
    private List<ProjectTypeBean.DataBean> list;

    public ProjectFragmentAdapter(List<ProjectTypeBean.DataBean> list,FragmentManager fm) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return ProjectArticleFragment.instance(list.get(position).getId());
    }

    @Override
    public int getCount() {
        return list.size() == 0 ? 0 : list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return list.get(position).getName();
    }
}
