package com.mashael.magentodemo.data.api.interfaces;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthService {
    @Headers("Content-Type:application/json")
    @POST("integration/admin/token?")
    Call<String> getAdminToken(@Query("username") String user, @Query("password") String pass);

}
