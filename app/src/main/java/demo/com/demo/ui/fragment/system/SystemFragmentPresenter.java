package demo.com.demo.ui.fragment.system;

import demo.com.demo.bean.SystemBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-29
 * @Describe:
 */
public class SystemFragmentPresenter {

    ISystemFragmentView iSystemFragmentView;

    ISystemFramgentModel iSystemFramgentModel;

    public SystemFragmentPresenter(ISystemFragmentView iSystemFragmentView){
        this.iSystemFragmentView = iSystemFragmentView;
        this.iSystemFramgentModel = new SystemFragmentModelImp();
    }

    public void loadingSystemData(){
        iSystemFragmentView.showLoading();
        iSystemFramgentModel.loadSystemData(new OnListenerCallback<SystemBean>() {
            @Override
            public void onSuccess(SystemBean systemBean) {
                if (!systemBean.getData().isEmpty()){
                    iSystemFragmentView.showSystemData(systemBean.getData());
                }
                iSystemFragmentView.dissLoading();

            }

            @Override
            public void onError(String msg) {
                iSystemFragmentView.dissLoading();
            }
        });
    }
}
