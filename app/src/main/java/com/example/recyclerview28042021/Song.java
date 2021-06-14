package com.example.recyclerview28042021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Song {
    // alt + insert

    private String name;
    private int image;
    private long time;
    private String singer;

    public Song(String name, int image, long time, String singer) {
        this.name = name;
        this.image = image;
        this.time = time;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", image=" + image +
                ", time=" + time +
                ", singer='" + singer + '\'' +
                '}';
    }

    public static List<Song> getMock(){
        return new ArrayList<>(Arrays.asList(
                new Song("The Playah",R.drawable.hinh_the_playah,507000,"Soobin, SlimV"),
                new Song("Trốn Tìm",R.drawable.hinh_tron_tim,252000 ,"Đen, MTV"),
                new Song("Sài Gòn Hôm Nay Mưa",R.drawable.hinh_sai_gon_hom_nay_mua,255000 ,"JSOL, Hoàng Duyên"),
                new Song("LayLaLay",R.drawable.hinh_lay_la_lay,295000 ,"Jack (J97)"),
                new Song("Trả Người Về Tự Do",R.drawable.hinh_tra_nguoi_ve_tu_do,292000 ,"Minh Tuyết, Tăng Phúc")
        ));
    }

}
