package com.example.recyclerview28042021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
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
            public void onClick(View v, int position) {

            }

            @Override
            public void onUpdate(int position) {
                mSongList.get(position).setName(mSongList.get(position).getName() + " updated");
                mSongAdapter.notifyItemChanged(position);
            }

            @Override
            public void onDelete(int position) {
                mSongList.remove(mSongList.get(position));
                mSongAdapter.notifyItemRemoved(position);
            }
        });
    }
}