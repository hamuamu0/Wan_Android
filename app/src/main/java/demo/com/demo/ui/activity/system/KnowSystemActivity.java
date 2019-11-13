package demo.com.demo.ui.activity.system;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import demo.com.demo.R;
import demo.com.demo.bean.SystemBean;
import demo.com.demo.ui.adapter.KnowArticleAdapter;
import demo.com.demo.ui.base.BaseActivity;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-30
 * @Describe:
 */
public class KnowSystemActivity extends BaseActivity {
    @BindView(R.id.table)
    TabLayout table;

    @BindView(R.id.vp_systemt)
    ViewPager vpSystem;

    @BindView(R.id.img_back)
    ImageView imgBack;

    @BindView(R.id.txt_title)
    TextView txtTitle;

    private final String CHILDREN = "CHILDREN";


    @Override
    public int initLayout() {
        return R.layout.activity_knowsystem;
    }

    @Override
    public void initData() {

        SystemBean.DataBean  childrenBeanList = (SystemBean.DataBean) getIntent().getSerializableExtra(CHILDREN);



        KnowArticleAdapter knowArticleAdapter = new KnowArticleAdapter(getSupportFragmentManager(),childrenBeanList.getChildren());
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        txtTitle.setText(childrenBeanList.getName());
        vpSystem.setOffscreenPageLimit(childrenBeanList.getChildren().size());
        vpSystem.setAdapter(knowArticleAdapter);
        table.setupWithViewPager(vpSystem);
    }
}
