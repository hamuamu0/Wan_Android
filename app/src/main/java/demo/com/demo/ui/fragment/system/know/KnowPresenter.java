package demo.com.demo.ui.fragment.system.know;

import demo.com.demo.bean.KnowBean;
import demo.com.demo.intercallback.OnListenerCallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-30
 * @Describe:
 */
public class KnowPresenter {

    private IKnowView iKnowView;
    private IKnowModel iKnowModel;

    public KnowPresenter(IKnowView iKnowView){
        this.iKnowView = iKnowView;
        this.iKnowModel = new KnowModelImpl();
    }

    public void loadingKnow(int page,int cid){
        iKnowView.showLoading();
        iKnowModel.loadKnowData(page, cid, new OnListenerCallback<KnowBean>() {
            @Override
            public void onSuccess(KnowBean knowBean) {
                if (!knowBean.getData().getDatas().isEmpty()){
                    iKnowView.loadingKnow(knowBean.getData().getDatas());

                }
                iKnowView.dismissLoading();
            }

            @Override
            public void onError(String msg) {
                iKnowView.errorMsg(msg);
                iKnowView.dismissLoading();
            }
        });
    }
}
