package demo.com.demo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import demo.com.demo.R;
import demo.com.demo.bean.SystemBean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-29
 * @Describe:
 */
public class SystemDataAdapter extends BaseQuickAdapter<SystemBean.DataBean, BaseViewHolder> {
    Context context;

    public SystemDataAdapter(Context context,@Nullable List<SystemBean.DataBean> data) {

        super(R.layout.item_system, data);
        this.context = context;

    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, SystemBean.DataBean item) {
        helper.setText(R.id.txt_title,item.getName());
        TagFlowLayout tagFlowLayout = (TagFlowLayout) helper.getView(R.id.tag_layout);
        tagFlowLayout.setAdapter(new TagAdapter(item.getChildren()) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView tagText = (TextView) LayoutInflater.from(context).inflate(R.layout.item_system_text, tagFlowLayout, false);
                tagText.setText(item.getChildren().get(position).getName());
                return tagText;
            }
        });
    }
}
