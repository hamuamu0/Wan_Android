package demo.com.demo.ui.adapter;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import demo.com.demo.bean.ChapterBean;
import demo.com.demo.ui.fragment.wechat.chapterlist.ChapterListFragment;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-29
 * @Describe:
 */
public class ChapterFragmemtsAdapter extends FragmentPagerAdapter {
    private List<ChapterBean.DataBean> list;
    public ChapterFragmemtsAdapter(FragmentManager fm,List<ChapterBean.DataBean> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return ChapterListFragment.instance(list.get(position).getId());
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
