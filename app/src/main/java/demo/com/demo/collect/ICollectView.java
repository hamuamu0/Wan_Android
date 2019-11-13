package demo.com.demo.collect;

import demo.com.demo.bean.BaseBean;
import demo.com.demo.bean.UserBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-11-06
 * @Describe:
 */
public interface ICollectView {

    public void onClickCollect(BaseBean<UserBean> userBeanBaseBean);

    public void onCollectError(String msg);
}
