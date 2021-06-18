package com.example.recyclerview28042021;

import android.view.View;

public interface OnItemClickSong {
    void onClick(View v , int position);
    void onUpdate(int position);
    void onDelete(int position);
}
