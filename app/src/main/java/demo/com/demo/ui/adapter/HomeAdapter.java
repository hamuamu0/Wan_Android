package demo.com.demo.ui.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import demo.com.demo.R;
import demo.com.demo.bean.BaseBean;
import demo.com.demo.bean.HomeListBean;
import demo.com.demo.bean.UserBean;
import demo.com.demo.collect.ICollectPresenter;
import demo.com.demo.collect.ICollectView;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-23
 * @Describe:
 */
public class HomeAdapter extends BaseQuickAdapter<HomeListBean.DataBean.DatasBean, BaseViewHolder> implements ICollectView {

    Context context;
    ICollectPresenter iCollectPresenter;
    public HomeAdapter(Context context,@Nullable List<HomeListBean.DataBean.DatasBean> data) {
        super(R.layout.item_home_list, data);
        this.context = context;
        iCollectPresenter = new ICollectPresenter(this);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HomeListBean.DataBean.DatasBean item) {
        if (item.isFresh()){
            helper.setText(R.id.txt_tag,"新");

        }else if (!item.getTags().isEmpty()){

           helper.setText(R.id.txt_tag,item.getTags().get(0).getName());

        }else{
            helper.setVisible(R.id.txt_tag,false);
            helper.setVisible(R.id.txt_author,false);
        }
        if (item.getZan() == 0){
            helper.setImageBitmap(R.id.img_love, BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_favorite_gray_24dp));
        }else if (item.getZan() == 1){
            helper.setImageBitmap(R.id.img_love,BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_favorite_light_24dp));
        }
        helper.setText(R.id.txt_author,item.getAuthor());
        helper.setText(R.id.txt_content,item.getTitle());
        helper.setText(R.id.txt_type,item.getSuperChapterName() + "/" + item.getChapterName());
        helper.setText(R.id.txt_date,item.getNiceDate());

        helper.setOnClickListener(R.id.img_love, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iCollectPresenter.onCollect(context,item.getId());
            }
        });
    }

    @Override
    public void onClickCollect(BaseBean<UserBean> userBeanBaseBean) {
        //Toast.makeText(context, userBeanBaseBean.errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCollectError(String msg) {

    }
}
