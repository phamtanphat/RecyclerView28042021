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
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.inflate(R.menu.menu_popup_song);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.menuItemUpdate :
                                mSongList.get(position).setName(mSongList.get(position).getName() + " updated");
                                mSongAdapter.notifyItemChanged(position);
                                break;
                            case R.id.menuItemDelete :
                                mSongList.remove(mSongList.get(position));
                                mSongAdapter.notifyItemRemoved(position);
                                break;
                        }
                        return true;
                    }
                });

                popupMenu.show();
            }
        });
    }
}