package demo.com.demo.ui.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import demo.com.demo.R;
import demo.com.demo.bean.ArticleBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-29
 * @Describe:
 */
public class ArticleAdapter extends BaseQuickAdapter<ArticleBean.DataBean.DatasBean, BaseViewHolder> {

    Context context;

    public ArticleAdapter(Context context, @Nullable List<ArticleBean.DataBean.DatasBean> data) {
        super(R.layout.item_article, data);
        this.context = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ArticleBean.DataBean.DatasBean item) {
            helper.setText(R.id.txt_author,item.getAuthor());
            helper.setText(R.id.txt_date,item.getNiceDate());
            helper.setText(R.id.txt_wechat,"公众号 /" + item.getAuthor());
            helper.setText(R.id.txt_content,item.getTitle());
        if (item.getZan() == 0){
            helper.setImageBitmap(R.id.img_love, BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_favorite_gray_24dp));
        }else if (item.getZan() == 1){
            helper.setImageBitmap(R.id.img_love,BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_favorite_light_24dp));
        }
    }

}
