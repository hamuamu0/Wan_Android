package demo.com.demo.ui;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;
import butterknife.OnClick;
import demo.com.demo.R;
import demo.com.demo.bean.BaseBean;
import demo.com.demo.bean.UserBean;
import demo.com.demo.ui.activity.login.LoginActivity;
import demo.com.demo.ui.activity.loginout.ILoginOutPresenter;
import demo.com.demo.ui.activity.loginout.ILoginOutView;
import demo.com.demo.ui.activity.search.SearchActivity;
import demo.com.demo.ui.base.BaseActivity;
import demo.com.demo.ui.fragment.home.HomeFragment;
import demo.com.demo.ui.fragment.project.ProjectFragment;
import demo.com.demo.ui.fragment.system.SystemFragment;
import demo.com.demo.ui.fragment.wechat.WechatFragment;
import demo.com.demo.utils.IntentUtils;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends BaseActivity implements ILoginOutView {

    @BindView(R.id.img_menu)
    ImageView imgMenu;
    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.radio)
    RadioGroup radioGroup;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.ll_slide)
    LinearLayout llSlide;
    @BindView(R.id.txt_state)
    TextView txtState;

    private ProgressDialog progressDialog;
    private ILoginOutPresenter iLoginOutPresenter;


    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("加载中...");

        Set<String> cookie = getSharedPreferences("CookieData", MODE_PRIVATE).getStringSet("cookie", null);
        if (cookie != null){
            txtState.setText("已登录");
        }else{
            txtState.setText("未登录");
        }

        iLoginOutPresenter = new ILoginOutPresenter(this);


        getSupportFragmentManager().beginTransaction().add(R.id.framelayout,new HomeFragment()).commit();
        txtTitle.setText("首页");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio_home:

                        txtTitle.setText("首页");
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new HomeFragment()).commit();

                        break;

                    case R.id.radio_system:

                        txtTitle.setText("知识体系");
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new SystemFragment()).commit();

                        break;

                    case R.id.radio_wechat:

                        txtTitle.setText("公众号");
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new WechatFragment()).commit();

                        break;

                    case R.id.radio_project:

                        txtTitle.setText("项目");
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new ProjectFragment()).commit();

                        break;

                     default:
                         break;

                }
            }
        });

    }

    @OnClick(value = {R.id.img_menu,R.id.img_search,R.id.txt_state,R.id.img_head,R.id.ll_exit})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.img_menu:
                drawerLayout.openDrawer(llSlide);
                break;

            case R.id.img_search:
                IntentUtils.startIntentActivity(this, SearchActivity.class);
                break;

            case R.id.txt_state:
                Set<String> cookies = getSharedPreferences("CookieData", MODE_PRIVATE).getStringSet("cookie", null);
                if (cookies == null){
                    IntentUtils.startIntentActivity(MainActivity.this, LoginActivity.class);
                }
                break;

            case R.id.ll_exit:
                iLoginOutPresenter.onLoginOut(this);
                break;

            default:
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Set<String> cookie = getSharedPreferences("CookieData", MODE_PRIVATE).getStringSet("cookie", null);
        if (cookie != null){
            txtState.setText("已登录");
        }else{
            txtState.setText("未登录");
        }
    }

    @Override
    public void onLoginOut(BaseBean<UserBean> userBeanBaseBean) {
        if (userBeanBaseBean.errorCode == 0){
            Toast.makeText(this, "退出成功", Toast.LENGTH_SHORT).show();
            txtState.setText("未登录");
            getSharedPreferences("CookieData", MODE_PRIVATE).edit().clear().commit();
        }else{
            Toast.makeText(this, userBeanBaseBean.errorMsg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowDialog() {
        progressDialog.show();
    }

    @Override
    public void onDisMissDialog() {
        progressDialog.dismiss();
    }
}
