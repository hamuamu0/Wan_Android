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
public class ProjectTypePrensenter {

    IProjectTypeView iProjectTypeView;
    IProjectTypeModel iProjectTypeModel;

    public ProjectTypePrensenter(IProjectTypeView iProjectTypeView){
        this.iProjectTypeView = iProjectTypeView;
        this.iProjectTypeModel = new ProjectTypeModelImpl();
    }

    public void loadProjectType(){
        iProjectTypeView.showLoading();
        iProjectTypeModel.loadingProjectType(new OnListenerCallback<ProjectTypeBean>() {
            @Override
            public void onSuccess(ProjectTypeBean projectTypeBean) {
                if (!projectTypeBean.getData().isEmpty()){
                    iProjectTypeView.loadProjectType(projectTypeBean.getData());
                }
                iProjectTypeView.disMissLoading();
            }

            @Override
            public void onError(String msg) {
                    iProjectTypeView.loadProjectError(msg);
                    iProjectTypeView.disMissLoading();
            }
        });
    }
}
