package demo.com.demo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

import demo.com.demo.R;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme: 首页Banner图片加载
 * @Data:2019-10-23
 * @Describe:
 */
public class BannerGlideLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).placeholder(R.drawable.ic_img_default).into(imageView);
    }
}
