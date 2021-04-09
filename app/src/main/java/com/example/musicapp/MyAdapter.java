package com.example.musicapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.models.AudioModel;

import java.io.File;
import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private  Context context;
    private  List<AudioModel> audioModelList;
    TextView txtName,txtArtist;
    ImageButton button;
    MediaPlayer player;
    AudioModel audioModel;
    public MyAdapter(Context context, List list,TextView txtName,TextView txtArtist,ImageButton btn){
        this.context=context;
        this.audioModelList=list;
        this.txtName=txtName;
        this.txtArtist=txtArtist;
        this.button=btn;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        AudioModel item=audioModelList.get(position);
        holder.songName.setText(item.getName());
        holder.albumName.setText(item.getAlbum());
        holder.artistName.setText(item.getArtist());

    }

    @Override
    public int getItemCount() {
        return audioModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView songName;
        public  TextView albumName;
        public TextView artistName;
        public RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            songName=itemView.findViewById(R.id.title_name);
            albumName=itemView.findViewById(R.id.albumArt);
            artistName=itemView.findViewById(R.id.song_artist);

        }



        @Override
        public void onClick(View view) {
            if(player!=null){
                player.reset();
            }else{
                player=new MediaPlayer();
            }
            int position =getAdapterPosition();
            AudioModel model = audioModelList.get(position);

            String path = model.getPath();
            if (!player.isPlaying()) {
                try {
                    player.setDataSource(path);
                    player.prepare();
                    txtName.setText(model.getName());
                    txtArtist.setText(model.getArtist());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("Exception of type : " + e.toString());
                    e.printStackTrace();
                }
                player.start();
                txtName.setText(model.getName());
                txtArtist.setText(model.getArtist());
                button.setImageResource(R.drawable.baseline_pause_circle_filled_black_18dp);
            }
             else if(player.isPlaying()) {

                try {
                    player.setDataSource(path);
                    player.prepare();


                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println("Exception of type : " + e.toString());
                    e.printStackTrace();
                }
                player.pause();
                txtName.setText("");
                txtArtist.setText("");

                button.setImageResource(R.drawable.baseline_play_circle_filled_black_18dp);
            }


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    AudioModel model = audioModelList.get(position);

                    String path = model.getPath();
                    if (!player.isPlaying()) {
                        try {
                            player.setDataSource(path);
                            player.prepare();
                            txtName.setText(model.getName());
                            txtArtist.setText(model.getArtist());


                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            System.out.println("Exception of type : " + e.toString());
                            e.printStackTrace();
                        }
                        player.start();
                        txtName.setText(model.getName());
                        txtArtist.setText(model.getArtist());
                        button.setImageResource(R.drawable.baseline_pause_circle_filled_black_18dp);
                    } else if (player.isPlaying()) {
                        try {
                            player.setDataSource(path);
                            player.prepare();

                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            System.out.println("Exception of type : " + e.toString());
                            e.printStackTrace();
                        }

                        player.pause();
                        txtName.setText("");
                        txtArtist.setText("");
                        button.setImageResource(R.drawable.baseline_play_circle_filled_black_18dp);
                    }

                }
            });
        }



    }
}