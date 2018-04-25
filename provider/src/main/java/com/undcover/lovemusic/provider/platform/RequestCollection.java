package com.undcover.lovemusic.provider.platform;

import com.undcover.lovemusic.provider.bean.SearchQQ;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RequestCollection {
    //    @Headers({"Content-type:application/json;charset=UTF-8"})
//    @POST("api/customer/getSmsCode")
//    Observable<JsonObject> getSmsCode(@Body RequestBody body);

    @Headers({"baseUrl:lrc_qq"})
    @GET("soso/fcgi-bin/client_search_cp?new_json=1&p=1&n=20&g_tk=1143379204&format=json")
    Observable<SearchQQ> searchQQ(@Query("w") String keyword);

    @Headers({"baseUrl:lrc_qq","referer:https://y.qq.com/portal/player.html"})
    @GET("lyric/fcgi-bin/fcg_query_lyric_new.fcg?callback=lrc&g_tk=5381&nobase64=1")
    Observable<ResponseBody> fetchQQ(@Query("songmid") String songId);
}
