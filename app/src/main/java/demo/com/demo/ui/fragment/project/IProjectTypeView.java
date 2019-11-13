package demo.com.demo.ui.fragment.project;

import java.util.List;

import demo.com.demo.bean.ProjectTypeBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-30
 * @Describe:
 */
public interface IProjectTypeView {

    public void showLoading();

    public void disMissLoading();

    public void loadProjectType(List<ProjectTypeBean.DataBean> projectTypeList);

    public void loadProjectError(String msg);
}
