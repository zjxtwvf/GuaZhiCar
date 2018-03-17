package com.terminator.zjxtwvf.guazi.model.api;

import com.terminator.zjxtwvf.guazi.model.entity.BannerImageUrlEntity;
import com.terminator.zjxtwvf.guazi.model.entity.CarListEntity;
import com.terminator.zjxtwvf.guazi.model.entity.FastIndexEntity;
import com.terminator.zjxtwvf.guazi.model.entity.HomeEntity;
import com.terminator.zjxtwvf.guazi.model.entity.PersonalCenterEntity;
import com.terminator.zjxtwvf.guazi.model.entity.RecommendEntity;
import com.terminator.zjxtwvf.guazi.model.entity.SellRecordsEntity;
import com.terminator.zjxtwvf.guazi.model.entity.SellDetailInfoEntity;
import com.terminator.zjxtwvf.guazi.model.entity.SourceDetailEntity;
import com.terminator.zjxtwvf.guazi.model.entity.SplashEntity;
import com.terminator.zjxtwvf.guazi.model.entity.TopicEntity;

import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2017/12/3.
 */

public interface ApiService {
    //https://api.guazi.com/clientc/banner/start?city=-1&screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&deviceId=862007036501106&ca_n=meizu&sign=a21c3e59b37b7fe138cf5d4878f4bd1f&dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=-1&versionId=3.9.1.0&model=m3%20note&ca_s=app_tg HTTP/1.1
    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Accept-Encoding: gzip",
            "Connection: Keep-Alive"
    })
    @GET("/clientc/banner/start")
    Observable<SplashEntity> getSplash(@Query("city") String city, @Query("screenWH") String screenWH,
           @Query("platform") String platform, @Query("osv") String osv,
           @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
           @Query("sign") String sign, @Query("dpi") String dpi,
           @Query("customerId") String customerId, @Query("mac") String mac,
           @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
           @Query("model") String model, @Query("ca_s") String ca_s);


    @Headers({
            "Content-Length: 112",
            "Content-Type: application/x-www-form-urlencoded",
            "Host: wuxian.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip"
    })
    @FormUrlEncoded
    @POST("wuxian.guazi.com/guazi/device/register")
    Observable<SplashEntity> postBefore02GetSplash(@Query("sign") String sign, @Query("platform") String platform,
           @Query("screenWH") String screenWH,
           @Query("deviceId") String deviceId, @Query("osv") String osv,
           @Query("customerId") String customerId, @Query("versionId") String versionId,
           @Query("net") String net, @Query("model") String model, @FieldMap Map<String,String> postBody);

        /*
      Content-Length: 112
      Content-Type: application/x-www-form-urlencoded
      Host: wuxian.guazi.com
      Connection: Keep-Alive
      Accept-Encoding: gzip

      factory=Meizu&user_id=-1&device_token=%2Br36MQnvIg19C7Mvl%2BEBWaDRcrWvsaUHD2QfE%2BQUfpE%3D&user_phone=&app_id=12
       */
    //https://wuxian.guazi.com/guazi/device/register?sign=78cf2ea6fcefdadc9f7208e227dc296b&
    // platform=armeabi-v7a&screenWH=1080X1920&deviceId=862007036501106&osv=7.0&dpi=3.0&
    // customerId=879&versionId=3.9.1.0&net=wifi&model=m3+note
    @Headers({
            "Content-Length: 112",
            "Content-Type: application/x-www-form-urlencoded",
            "Host: wuxian.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip"
    })
    @FormUrlEncoded
    @POST("wuxian.guazi.com/guazi/device/register")
    Observable<SplashEntity> postBefore03GetSplash(@Query("sign") String sign, @Query("platform") String platform,
             @Query("screenWH") String screenWH,
             @Query("deviceId") String deviceId, @Query("osv") String osv,
             @Query("customerId") String customerId, @Query("versionId") String versionId,
             @Query("net") String net, @Query("model") String model, @FieldMap Map<String,String> postBody);


    @Headers({
            "Accept: application/json",
            "versionId: 3.9.1.0",
            "model: m3 note",
            "Content-Type: application/json",
            "Content-Length: 4632",
            "Host: t.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "User-Agent: okhttp/3.9.0",
    })
    @POST()
    Observable<ResponseBody> postBefore00GetSplash(@Url String baseUrl,@Query("screenWH") String screenWH,
           @Query("platform") String platform, @Query("osv") String osv,
           @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
           @Query("sign") String sign, @Query("customerId") String customerId,
           @Query("dpi") String dpi, @Query("versionId") String versionId, @Query("net") String net,
           @Query("model") String model, @Query("ca_s") String ca_s, @Body RequestBody body);

    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/configure")
    Observable<SplashEntity> postBefore01GetSplash(@Query("screenWH") String screenWH,
           @Query("platform") String platform, @Query("osv") String osv,
           @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
           @Query("sign") String sign, @Query("dpi") String dpi,
           @Query("customerId") String customerId, @Query("mac") String mac,
           @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
           @Query("model") String model, @Query("ca_s") String ca_s);


    //https://api.guazi.com/clientc/banner?city=-1&screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&
    // deviceId=862007036501106&ca_n=meizu&sign=a21c3e59b37b7fe138cf5d4878f4bd1f&dpi=3.0&customerId=879&
    // mac=a4:44:d1:41:f3:14&guazi_city=-1&versionId=3.9.1.0&model=m3%20note&ca_s=app_tg HTTP/1.1
    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/banner")
    Observable<BannerImageUrlEntity> getBannerImageUrl(@Query("city") String city, @Query("screenWH") String screenWH,
           @Query("platform") String platform, @Query("osv") String osv,
           @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
           @Query("sign") String sign, @Query("dpi") String dpi,
           @Query("customerId") String customerId, @Query("mac") String mac,
           @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
           @Query("model") String model, @Query("ca_s") String ca_s);


    ///clientc/article/toplineorschool?screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&deviceId=862007036501106&ca_n=meizu
    /// &sign=2262cc25d91b2d2fb1bb17508a3051df&dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=3.9.6.0
    /// &model=m3%20note&ca_s=app_tg
    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/article/toplineorschool")
    Observable<TopicEntity> getToplineorschool(@Query("city") String city, @Query("screenWH") String screenWH,
           @Query("platform") String platform, @Query("osv") String osv,
           @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
           @Query("sign") String sign, @Query("dpi") String dpi,
           @Query("customerId") String customerId, @Query("mac") String mac,
           @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
           @Query("model") String model, @Query("ca_s") String ca_s);

    //https://api.guazi.com/clientc/option/fastindex?city=45&screenWH=1080X1920&platform=armeabi-
    //v7a&osv=7.0&deviceId=862007036501106&ca_n=meizu&sign=a477bfa17161cf1fa64cbf76ea531ad1&dpi=3.0
    // &customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg
    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/option/fastindex")
    Observable<FastIndexEntity> getFastIndex(@Query("city") String city, @Query("screenWH") String screenWH,
             @Query("platform") String platform, @Query("osv") String osv,
             @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
             @Query("sign") String sign, @Query("dpi") String dpi,
             @Query("customerId") String customerId, @Query("mac") String mac,
             @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
             @Query("model") String model, @Query("ca_s") String ca_s);

    ///clientc/home?city=45&versionId=3.9.6.0&screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&deviceId=862007036501106
    /// &ca_n=meizu&sign=a477bfa17161cf1fa64cbf76ea531ad1&dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45
    /// &versionId=3.9.6.0&model=m3%20note&ca_s=app_tg

    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/home")
    Observable<HomeEntity> getHomeCar(@Query("city") String city, @Query("screenWH") String screenWH,
          @Query("platform") String platform, @Query("osv") String osv,
          @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
          @Query("sign") String sign, @Query("dpi") String dpi,
          @Query("customerId") String customerId, @Query("mac") String mac,
          @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
          @Query("model") String model, @Query("ca_s") String ca_s);

    ///clientc/post/getCarList?last_time=1515296982&lat=30.704263&page=1&lng=104.017556&pageSize=20&city=45
    /// &screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&deviceId=862007036501106&ca_n=meizu&sign=8354b640c73730bb1182dc2d462a0f8a
    /// &dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg

    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.6.0",
            "User-Agent: c_android/3.9.6.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.6.0",
            "model: m3 note",
            "CustomerId: ",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/post/getCarList")
    Observable<CarListEntity> getCarList(@Query("last_time") String lastTime, @Query("lat") String lat,
         @Query("page") String page, @Query("lng") String lng, @Query("pageSize") String pageSize,
         @Query("city") String city, @Query("screenWH") String screenWH,
         @Query("platform") String platform, @Query("osv") String osv,
         @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
         @Query("sign") String sign, @Query("dpi") String dpi,
         @Query("customerId") String customerId, @Query("mac") String mac,
         @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
         @Query("model") String model, @Query("ca_s") String ca_s);

    ///clientc/selldetail/records?screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&
    /// deviceId=862007036501106&ca_n=meizu&sign=2262cc25d91b2d2fb1bb17508a3051df&dpi=3.0&
    /// customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg
    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/selldetail/records")
    Observable<SellRecordsEntity> getSellRecords(@Query("screenWH") String screenWH,
                                                 @Query("platform") String platform, @Query("osv") String osv,
                                                 @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
                                                 @Query("sign") String sign, @Query("dpi") String dpi,
                                                 @Query("customerId") String customerId, @Query("mac") String mac,
                                                 @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
                                                 @Query("model") String model, @Query("ca_s") String ca_s);

    ///clientc/selldetail/sellDetalInfo?city_id=45&screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&
    /// deviceId=862007036501106&ca_n=meizu&sign=66f15ddba76d11fadb4c63da0b3ba0aa&dpi=3.0&
    /// customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg
    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/selldetail/sellDetalInfo")
    Observable<SellDetailInfoEntity> getSelldetailInfo(@Query("city_id") String city_id, @Query("screenWH") String screenWH,
                                                       @Query("platform") String platform, @Query("osv") String osv,
                                                       @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
                                                       @Query("sign") String sign, @Query("dpi") String dpi,
                                                       @Query("customerId") String customerId, @Query("mac") String mac,
                                                       @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
                                                       @Query("model") String model, @Query("ca_s") String ca_s);

    ///clientc/personal/personalCenter?cityId=45&screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&
    /// deviceId=862007036501106&ca_n=meizu&sign=fa7e8b9d7526739f8a956ae5f0021bf2&dpi=3.0&
    /// customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg
    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/personal/personalCenter")
    Observable<PersonalCenterEntity> getPersonalCenter(@Query("cityId") String city_id, @Query("screenWH") String screenWH,
                                                       @Query("platform") String platform, @Query("osv") String osv,
                                                       @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
                                                       @Query("sign") String sign, @Query("dpi") String dpi,
                                                       @Query("customerId") String customerId, @Query("mac") String mac,
                                                       @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
                                                       @Query("model") String model, @Query("ca_s") String ca_s);

    ///clientc/recommend?city=45&screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&deviceId=862007036501106&
    /// ca_n=meizu&sign=a477bfa17161cf1fa64cbf76ea531ad1&dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14&
    /// guazi_city=45&versionId=3.9.6.0&model=m3%20note&ca_s=app_tg

    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/recommend")
    Observable<RecommendEntity> getRecommend(@Query("city") String city_id, @Query("screenWH") String screenWH,
                                             @Query("platform") String platform, @Query("osv") String osv,
                                             @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
                                             @Query("sign") String sign, @Query("dpi") String dpi,
                                             @Query("customerId") String customerId, @Query("mac") String mac,
                                             @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
                                             @Query("model") String model, @Query("ca_s") String ca_s);

    ///clientc/post/getSourceDetail?puid=3002889995&lat=30.704434&lng=104.017464&screenWH=1080X1920
    /// &platform=armeabi-v7a&osv=7.0&deviceId=862007036501106&ca_n=meizu&sign=3beea967e88121487b78516addba72be
    /// &dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=4.0.2.0&model=m3%20note&ca_s=app_tg
    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/post/getSourceDetail")
    Observable<SourceDetailEntity> getSourceDetail(@Query("puid") String puid, @Query("lat") String lat,
                                                   @Query("lng") String lng, @Query("screenWH") String screenWH,
                                                   @Query("platform") String platform, @Query("osv") String osv,
                                                   @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
                                                   @Query("sign") String sign, @Query("dpi") String dpi,
                                                   @Query("customerId") String customerId, @Query("mac") String mac,
                                                   @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
                                                   @Query("model") String model, @Query("ca_s") String ca_s);


    ///clientc/banner/ad?ad_pos=app_detail_activity_entry,APP_DETAIL_ZHIBAO,app_dialog_banner&isBaoMai=0
    /// &clue_id=20651815&city_id=45&screenWH=1080X1920&platform=armeabi-v7a&osv=7.0&deviceId=862007036501106
    /// &ca_n=meizu&sign=d6c55df189ba805a5c5ab3597ea37911&dpi=3.0&customerId=879&mac=a4:44:d1:41:f3:14
    /// &guazi_city=45&versionId=4.0.2.0&model=m3%20note&ca_s=app_tg

    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/post/getSourceDetail")
    Observable<RecommendEntity> getBannerAd(@Query("ad_pos") String ad_pos, @Query("isBaoMai") String isBaoMai,
                                                @Query("clue_id") String clue_id,
                                                @Query("city_id") String city_id,@Query("screenWH") String screenWH,
                                                @Query("platform") String platform, @Query("osv") String osv,
                                                @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
                                                @Query("sign") String sign, @Query("dpi") String dpi,
                                                @Query("customerId") String customerId, @Query("mac") String mac,
                                                @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
                                                @Query("model") String model, @Query("ca_s") String ca_s);

    ///clientc/personal/contrast/20651815/exist?screenWH=1080X1920&platform=armeabi-v7a
    /// &osv=7.0&deviceId=862007036501106&ca_n=meizu&sign=f101cdeffcdf06b6c01b42116803a66c&dpi=3.0
    /// &customerId=879&mac=a4:44:d1:41:f3:14&guazi_city=45&versionId=4.0.2.0&model=m3%20note&ca_s=app_tg
    @Headers({
            "X-Ganji-Agency: meizu",
            "contentformat: json2",
            "GjData-Version: 1.0",
            "versionId: 3.9.1.0",
            "User-Agent: c_android/3.9.1.0(Android;7.0;dpi/3.0)",
            "X-Ganji-CustomerId: 879",
            "X-Ganji-VersionId: 3.9.1.0",
            "model: m3 note",
            "CustomerId: 879",
            "Host: api.guazi.com",
            "Connection: Keep-Alive",
            "Accept-Encoding: gzip",
            "If-Modified-Since: Sun, 10 Dec 2017 08:08:34 GMT"
    })
    @GET("/clientc/post/getSourceDetail")
    Observable<RecommendEntity> getContrast(@Query("puid") String puid, @Query("lat") String lat,
                                            @Query("lng") String lng, @Query("screenWH") String screenWH,
                                            @Query("platform") String platform, @Query("osv") String osv,
                                            @Query("deviceId") String deviceId, @Query("ca_n") String ca_n,
                                            @Query("sign") String sign, @Query("dpi") String dpi,
                                            @Query("customerId") String customerId, @Query("mac") String mac,
                                            @Query("guazi_city") String guazi_city, @Query("versionId") String versionId,
                                            @Query("model") String model, @Query("ca_s") String ca_s);
}
