package com.example.android.fpmemory;

/**
 * Created by Lee on 2017/10/07.
 */

public class SportsResultHistory {
    private int imageId;
    private String sportsStutas;
    private String sportsTime;
    private String sportsResult;


    public SportsResultHistory(int imageId, String sportsStutas, String sportsTime, String sportsResult){
        this.imageId=imageId;
        this.sportsStutas=sportsStutas;
        this.sportsTime=sportsTime;
        this.sportsResult=sportsResult;
    }

    public int getImageId(){
        return imageId;
    }

    public String getSportsStutas(){
        return sportsStutas;
    }
    public String getSportsTime(){
        return sportsTime;
    }
    public String getSportsResult(){
        return sportsResult;
    }
}
