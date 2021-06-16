package com.example.recyclerview28042021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRcvSong;
    SongAdapter mSongAdapter;
    List<Song> mSongList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRcvSong = findViewById(R.id.recyclerView);

        mSongList = Song.getMock();

        mSongAdapter = new SongAdapter(mSongList);

        mRcvSong.setAdapter(mSongAdapter);

        mSongAdapter.setOnItemClickSong(new OnItemClickSong() {
            @Override
            public void onClick(View v, Song song, int position) {
                Toast.makeText(MainActivity.this, song.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}