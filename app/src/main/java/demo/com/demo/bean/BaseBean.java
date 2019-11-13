package demo.com.demo.bean;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-11-05
 * @Describe:
 */
public class BaseBean<T> {
    /**
     * 服务器返回的错误码
     */
    public int errorCode;
    /**
     * 服务器返回的成功或失败的提示
     */
    public String errorMsg;
    /**
     * 服务器返回的数据
     */
    public T data;

    public BaseBean(int errorCode, String errorMsg, T data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
