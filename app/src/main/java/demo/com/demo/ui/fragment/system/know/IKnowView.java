package demo.com.demo.ui.fragment.system.know;

import java.util.List;

import demo.com.demo.bean.KnowBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-30
 * @Describe:
 */
public interface IKnowView {

    public void loadingKnow(List<KnowBean.DataBean.DatasBean> list);

    public void errorMsg(String msg);

    public void showLoading();

    public void dismissLoading();
}
