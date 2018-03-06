package com.ex.admin.taskkrfinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Admin on 04.03.2018.
 */

public interface IServerApi {

    @GET("login/{kod}/{password}")
    Call<DateApi> messages(@Path("kod") String kodName, @Path("password") String pasName);

    @GET("catalog-groups/{group}")
    Call<List<OrdersApi>>groupOrder(@Path("group") String group);

    @GET("catalog-items/{group}")
    Call<List<ItemApi>>itemOrder(@Path("group") String group);
}
