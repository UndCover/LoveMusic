package com.undcover.lovemusic.provider.platform;

import com.google.gson.JsonObject;
import com.undcover.lovemusic.provider.bean.Lrc163;
import com.undcover.lovemusic.provider.bean.LrcKugou;
import com.undcover.lovemusic.provider.bean.Search163;
import com.undcover.lovemusic.provider.bean.SearchKugou;
import com.undcover.lovemusic.provider.bean.SearchQQ;
import com.undcover.lovemusic.provider.bean.SearchXiami;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestCollection {
    //    @Headers({"Content-type:application/json;charset=UTF-8"})
//    @POST("api/customer/getSmsCode")
//    Observable<JsonObject> getSmsCode(@Body RequestBody body);

    @Headers({"baseUrl:lrc_qq"})
    @GET("soso/fcgi-bin/client_search_cp?new_json=1&p=1&n=20&g_tk=1143379204&format=json")
    Observable<SearchQQ> searchQQ(@Query("w") String keyword);

    @Headers({"baseUrl:lrc_qq", "referer:https://y.qq.com/portal/player.html"})
    @GET("lyric/fcgi-bin/fcg_query_lyric_new.fcg?callback=lrc&g_tk=5381&nobase64=1")
    Observable<ResponseBody> fetchQQ(@Query("songmid") String songId);

    @Headers({"baseUrl:lrc_163", "Referer:http://music.163.com/"})
    @POST("api/search/pc?type=1")
    Observable<Search163> search163(@Query("s") String keyword);

    @Headers({"baseUrl:lrc_163"})
    @GET("api/song/lyric?lv=1&kv=1&tv=-1")
    Observable<Lrc163> fetch163(@Query("id") String songId);

    @Headers({"baseUrl:lrc_xiami", "Referer:http://h.xiami.com/"})
    @POST("web?r=search/songs&app_key=1")
    Observable<SearchXiami> searchXiami(@Query("key") String keyword);

    @Headers({"baseUrl:lrc_kugou"})
    @GET("search?ver=1&man=yes")
    Observable<SearchKugou> searchKugou(@Query("keyword") String keyword, @Query("duration") String duration);

    @Headers({"baseUrl:lrc_kugou"})
    @GET("download?fmt=lrc&ver=1")
    Observable<LrcKugou> fetchKugou(@Query("id") String songId, @Query("accesskey") String token);
}
