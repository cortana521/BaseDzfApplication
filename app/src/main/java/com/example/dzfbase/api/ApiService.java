package com.example.dzfbase.api;



import com.example.dzfbase.base.BaseResponse;
import com.example.dzfbase.ui.login.LoginBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/5/25
 * Time: 14:24
 */
public interface ApiService {

    /**
     * 注册
     * @param username
     * @param password
     * @param repassword
     * @return
     */
//    @POST("user/register")
//    @FormUrlEncoded
//    Observable<BaseResponse<RegisterBean>> register(@Field("username") String username,
//                                                                 @Field("password") String password,
//                                                                 @Field("repassword") String repassword);

    /**
     * 登录
     * @param telephone
     * @param password
     * @return
     */
    @POST("index.php?g=mobile&m=register&a=login")
    @FormUrlEncoded
    Observable<BaseResponse<LoginBean>> login(@Field("telephone") String telephone,
                                              @Field("password") String password);


    @Multipart
    @POST
    Observable<ResponseBody> uploadFile(@Url String url, @Body MultipartBody body);
}
