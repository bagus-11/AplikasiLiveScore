package com.example.pertandinganbola.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.pertandinganbola.ApiClient;
import com.example.pertandinganbola.ApiService;
import com.example.pertandinganbola.model.Bola;
import com.example.pertandinganbola.BolaAdapter;
import com.example.pertandinganbola.R;
import com.example.pertandinganbola.model.BolaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalFragment extends Fragment {

    private ArrayList<Bola> listBola;
    private RecyclerView rvBola;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jadwal,container, false );
        rvBola = view.findViewById(R.id.rv_bola);
        rvBola.setHasFixedSize(true);
        rvBola.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<BolaResponse> call = service.getPlayingFootball("4331");
        call.enqueue(new Callback<BolaResponse>() {
            @Override
            public void onResponse(Call<BolaResponse> call, Response<BolaResponse> response) {


                listBola = response.body().getTeams();

                BolaAdapter bolaAdapter = new BolaAdapter(listBola);
                rvBola.setAdapter(bolaAdapter);

            }

            @Override
            public void onFailure(Call<BolaResponse> call, Throwable t) {

            }
        });



        return view;
    }
}