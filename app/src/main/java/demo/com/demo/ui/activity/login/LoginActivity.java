package demo.com.demo.ui.activity.login;

import android.app.ProgressDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import demo.com.demo.R;
import demo.com.demo.bean.BaseBean;
import demo.com.demo.bean.UserBean;
import demo.com.demo.ui.activity.register.RegisterActivity;
import demo.com.demo.ui.base.BaseActivity;
import demo.com.demo.utils.IntentUtils;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-11-05
 * @Describe:
 */
public class LoginActivity extends BaseActivity implements ILoginView {
    @BindView(R.id.edt_account)
    EditText edtAccount;

    @BindView(R.id.edt_password)
    EditText edtPassword;

    ProgressDialog progressDialog;

    LoginPresenter loginPresenter;



    @Override
    public int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initData() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("登陆中...");
        loginPresenter = new LoginPresenter(this);
    }

    @OnClick(value = {R.id.btn_login,R.id.txt_register})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_login:
                if (TextUtils.isEmpty(edtAccount.getText()) || TextUtils.isEmpty(edtPassword.getText())){

                    Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();

                }else{

                    loginPresenter.onLogin(this,edtAccount.getText().toString(),edtPassword.getText().toString());

                }
                break;

            case R.id.txt_register:
                IntentUtils.startIntentActivity(this, RegisterActivity.class);
                break;

            default:
                break;
        }
    }

    @Override
    public void onLoginSuccess(BaseBean<UserBean> userBean) {
        Log.i("userBean=======",userBean.errorCode + "");
            if (userBean.errorCode == 0){
                Toast.makeText(this, "登陆成功！", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this, userBean.errorMsg, Toast.LENGTH_SHORT).show();

            }


    }

    @Override
    public void showDialog() {
        progressDialog.show();
    }

    @Override
    public void dismissDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void onErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
