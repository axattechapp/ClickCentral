package com.axat.clickcentral;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Api {
     String BASE_URL="https://clickcentral.com.au/";



     @POST("rest/default/V1/integration/customer/token")
     Call<String> login(@Body JsonObject model);


}
