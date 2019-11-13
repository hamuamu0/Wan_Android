package demo.com.demo.ui.fragment.system;

import java.util.List;

import demo.com.demo.bean.SystemBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-29
 * @Describe:
 */
public interface ISystemFragmentView {

    public void showSystemData(List<SystemBean.DataBean> list);

    public void showLoading();

    public void dissLoading();
}
