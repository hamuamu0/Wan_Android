package demo.com.demo.ui.activity.search;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import demo.com.demo.R;
import demo.com.demo.bean.HomeListBean;
import demo.com.demo.bean.SearchTagBean;
import demo.com.demo.ui.adapter.SearchResultAdapter;
import demo.com.demo.ui.base.BaseActivity;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-28
 * @Describe:
 */
public class SearchActivity extends BaseActivity implements ISearchView {
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.flaow_layout)
    TagFlowLayout flowLayout;
    @BindView(R.id.txt_hotword)
    TextView txtHotword;
    @BindView(R.id.rv_list)
    RecyclerView rvList;


    List<SearchTagBean.DataBean> tagList;
    List<HomeListBean.DataBean.DatasBean> list;

    private SearchPresenter searchPresenter;

    SearchResultAdapter searchResultAdapter;

    @Override
    public int initLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void initData() {
        searchPresenter = new SearchPresenter(this);
        searchPresenter.loadTag();
        tagList = new ArrayList<>();
        list = new ArrayList<>();
        searchResultAdapter =  new SearchResultAdapter(this,list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(searchResultAdapter);

        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    if (TextUtils.isEmpty(edtSearch.getText())){
                        return true;
                    }
                    searchPresenter.loadSearchResult(0,edtSearch.getText().toString());

                }
                return false;
            }
        });




    }

    @Override
    public void showTag(List<SearchTagBean.DataBean> searchTag) {
        Log.i("==========",searchTag.size() + "");
        tagList.addAll(searchTag);


        flowLayout.setAdapter(new TagAdapter(tagList) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView txtTag = (TextView) LayoutInflater.from(SearchActivity.this).inflate(R.layout.item_tag_list,flowLayout,false);
                setTagTextColor(txtTag);
                txtTag.setText(searchTag.get(position).getName());
                return txtTag;
            }
        });

        flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                edtSearch.setText(searchTag.get(position).getName());
                searchPresenter.loadSearchResult(0,edtSearch.getText().toString());
                return true;
            }
        });


    }

    /**
     * 关键词颜色
     * @param tagView
     */
    private void setTagTextColor(TextView tagView) {
        int red, green, blue;
        Random mRandow = new Random();
        red = mRandow.nextInt(255);
        green = mRandow.nextInt(255);
        blue = mRandow.nextInt(255);
        int color = Color.rgb(red, green, blue);
        tagView.setTextColor(color);
    }

    @Override
    public void loadSearchTagError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        Log.i("SearchActivityError",error);
    }

    @Override
    public void loadSearchResult(List<HomeListBean.DataBean.DatasBean> homelistBean) {
        list.addAll(homelistBean);
        txtHotword.setVisibility(View.GONE);
        flowLayout.setVisibility(View.GONE);
        searchResultAdapter.notifyDataSetChanged();
        if (homelistBean.isEmpty()){
            searchResultAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.item_empty,null));
        }
    }


    @OnClick(value = {R.id.img_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.img_back:
                    finish();
                break;

                default:
                    break;
        }
    }

    @OnTextChanged(value = {R.id.edt_search} ,callback = OnTextChanged.Callback.TEXT_CHANGED)
    public void onTextChange(){
            if (TextUtils.isEmpty(edtSearch.getText())){
                txtHotword.setVisibility(View.VISIBLE);
                flowLayout.setVisibility(View.VISIBLE);
            }
    }
}
