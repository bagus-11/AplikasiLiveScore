package com.example.pertandinganbola;

import com.example.pertandinganbola.model.BolaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
        @GET("v1/json/1/lookup_all_teams.php")
        Call<BolaResponse> getPlayingFootball(@Query("id") String id);

}

