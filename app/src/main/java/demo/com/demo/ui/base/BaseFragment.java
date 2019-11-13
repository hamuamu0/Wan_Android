package demo.com.demo.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-22
 * @Describe:
 */
public abstract class BaseFragment extends Fragment {

    public BaseFragment(){}

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(initLayout(), container, false);
        ButterKnife.bind(this,view);
        initData();

        return view;
    }


    abstract public int initLayout();

    abstract public void initData();


    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.bind(this,view).unbind();
    }
}
