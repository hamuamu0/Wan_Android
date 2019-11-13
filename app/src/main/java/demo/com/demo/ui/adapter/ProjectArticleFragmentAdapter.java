package demo.com.demo.ui.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import demo.com.demo.R;
import demo.com.demo.bean.ProjectArticleBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-30
 * @Describe:
 */
public class ProjectArticleFragmentAdapter extends BaseQuickAdapter<ProjectArticleBean.DataBean.DatasBean, BaseViewHolder> {
    Context context;
    public ProjectArticleFragmentAdapter(Context context,@Nullable List<ProjectArticleBean.DataBean.DatasBean> data) {
        super(R.layout.item_project, data);
        this.context = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ProjectArticleBean.DataBean.DatasBean item) {

        Glide.with(context).load(item.getEnvelopePic()).placeholder(R.drawable.ic_img_default).into((ImageView)helper.getView(R.id.img_project));
        helper.setText(R.id.txt_title,item.getTitle());
        helper.setText(R.id.txt_content,item.getDesc());
        helper.setText(R.id.txt_date,item.getNiceDate());
        helper.setText(R.id.txt_author,item.getAuthor());
        if (item.getZan() == 0){
            helper.setImageBitmap(R.id.img_love, BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_favorite_gray_24dp));
        }else if (item.getZan() == 1){
            helper.setImageBitmap(R.id.img_love,BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_favorite_light_24dp));
        }
    }
}
