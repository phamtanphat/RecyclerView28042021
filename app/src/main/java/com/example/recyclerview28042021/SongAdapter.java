package com.example.recyclerview28042021;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    List<Song> mListSong;
    Context mContext;
    OnItemClickSong mOnItemClickSong;

    public SongAdapter(List<Song> songList) {
        mListSong = songList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = mListSong.get(position);
        holder.imgSong.setImageResource(song.getImage());
        holder.tvName.setText(song.getName());
        holder.tvSinger.setText(song.getSinger());

        long minutes = (song.getTime() / 60000);
        long seconds = (song.getTime() / 1000) % 60;
        String resultMinutes = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        String resultSeconds = seconds < 10 ? "0" + seconds : String.valueOf(seconds);
        holder.tvTotalTime.setText(resultMinutes + ":" + resultSeconds);

    }

    @Override
    public int getItemCount() {
        if (mListSong == null || mListSong.size() == 0) {
            return 0;
        }
        return mListSong.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSong;
        TextView tvName, tvSinger, tvTotalTime;
        ImageButton imgSetting;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSong = itemView.findViewById(R.id.imageViewSong);
            tvName = itemView.findViewById(R.id.textViewName);
            tvSinger = itemView.findViewById(R.id.textViewSinger);
            tvTotalTime = itemView.findViewById(R.id.textViewTotalTime);
            imgSetting = itemView.findViewById(R.id.imageSettings);

            imgSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(itemView.getContext(), view);
                    popupMenu.inflate(R.menu.menu_popup_song);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            switch (menuItem.getItemId()) {
                                case R.id.menuItemUpdate:
                                    if (mOnItemClickSong != null) {
                                        mOnItemClickSong.onUpdate(getAdapterPosition());
                                    }
                                    break;
                                case R.id.menuItemDelete:
                                    if (mOnItemClickSong != null) {
                                        mOnItemClickSong.onDelete(getAdapterPosition());
                                    }
                                    break;
                            }
                            return true;
                        }
                    });
                    popupMenu.show();

                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickSong != null) {
                        mOnItemClickSong.onClick(view, getAdapterPosition());
                    }
                }
            });

        }
    }

    public void setOnItemClickSong(OnItemClickSong onItemClickSong) {
        this.mOnItemClickSong = onItemClickSong;
    }
}
