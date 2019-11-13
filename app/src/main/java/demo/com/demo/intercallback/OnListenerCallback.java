package demo.com.demo.intercallback;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-23
 * @Describe:
 */
public interface OnListenerCallback<T> {

    public void onSuccess(T t);

    public void onError(String msg);
}
