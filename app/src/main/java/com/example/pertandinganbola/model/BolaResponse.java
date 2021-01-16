package com.example.pertandinganbola.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BolaResponse {

    @SerializedName("teams")
    private ArrayList<Bola> teams;



    public ArrayList<Bola> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Bola> teams) {
        this.teams = teams;
    }


}
