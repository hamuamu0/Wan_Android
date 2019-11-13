package demo.com.demo.net;



import demo.com.demo.bean.ArticleBean;
import demo.com.demo.bean.BannerBean;
import demo.com.demo.bean.BaseBean;
import demo.com.demo.bean.ChapterBean;
import demo.com.demo.bean.HomeListBean;
import demo.com.demo.bean.KnowBean;
import demo.com.demo.bean.ProjectArticleBean;
import demo.com.demo.bean.ProjectTypeBean;
import demo.com.demo.bean.SearchTagBean;
import demo.com.demo.bean.SystemBean;
import demo.com.demo.bean.UserBean;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-23
 * @Describe:
 */
public interface ApiRequest {

    /**
     * 首页banner
     * @return
     */
    @GET(Url.BANNER)
    Observable<BannerBean> banner();

    /**
     * 首页文章列表
     * @param page
     * @return
     */
    @GET(Url.HOME_LIST)
    Observable<HomeListBean> homeList(@Path("page") int page);

    /**
     * 热搜词
     * @return
     */
    @GET(Url.HOME_LIST)
    Observable<SearchTagBean> searchTag();


    /**
     * 关键词搜索
     * @param page
     * @param keyword
     * @return
     */
    @FormUrlEncoded
    @POST(Url.SEARCH_WORD)
    Observable<HomeListBean> searchWord(@Path("page") int page, @Field("k") String keyword);


    /**
     * 体系数据
     * @return
     */
    @GET(Url.SYSTEM_DATA)
    Observable<SystemBean> systemData();


    /**
     * 公众号列表
     * @return
     */
    @GET(Url.CHAPTER)
    Observable<ChapterBean> getChapterData();

    /**
     * 公众号文章
     * @param id
     * @param page
     * @return
     */
    @GET(Url.ARTICLE)
    Observable<ArticleBean> getArticleData(@Path("id") int id,@Path("page") int page);

    /**
     * 项目类型
     * @return
     */
    @GET(Url.PROJECT_TYPE)
    Observable<ProjectTypeBean> getProjectType();


    /**
     * 项目列表数据
     * @param cid
     * @param page
     * @return
     */
    @GET(Url.PROJECT_ARTICLE)
    Observable<ProjectArticleBean> getProjectArticle(@Path("page") int page,@Query("cid") int cid);

    /**
     * 知识体系文章
     * @param page
     * @param cid
     * @return
     */
    @GET(Url.KNOW_ARTCLE)
    Observable<KnowBean> getSystemKnow(@Path("page") int page,@Query("cid") int cid);


    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST(Url.LOGIN)
    Observable<BaseBean<UserBean>> onLogin(@Field("username") String username, @Field("password") String password);


    /**
     * 登出
     * @return
     */
    @GET(Url.LOGIN_OUT)
    Observable<BaseBean<UserBean>> onLoginOut();


    /**
     * 收藏站内消息
     * @param id
     * @return
     */
    @FormUrlEncoded
    @POST(Url.COLLECT)
    Observable<BaseBean<UserBean>> onCollect(@Field("id") int id);


}
