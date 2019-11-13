package demo.com.demo.ui.fragment.project;

import demo.com.demo.bean.ProjectTypeBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-30
 * @Describe:
 */
public interface IProjectTypeModel {

    public void loadingProjectType(OnListenerCallback<ProjectTypeBean> listenerCallback);


}
