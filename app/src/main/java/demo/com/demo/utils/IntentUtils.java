package demo.com.demo.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;



/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-25
 * @Describe:
 */
public class IntentUtils {

    public static void startIntentActivity(Context context,Class cls){
        Intent intent = new Intent(context,cls);
        context.startActivity(intent);
    }



    public static void startIntentBundleStringActivity(Context context, String key, String value, Class cls){
        Intent intent = new Intent(context,cls);
        intent.putExtra(key,value);
        context.startActivity(intent);
    }
}
