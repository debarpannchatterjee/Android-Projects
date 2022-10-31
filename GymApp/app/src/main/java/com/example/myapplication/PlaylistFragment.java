package com.example.myapplication;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class PlaylistFragment extends Fragment {
    MediaPlayer player;
    Button play, pause, stop;
    TextView spotify;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_playlist, container, false);

        play = (Button)view.findViewById(R.id.play);
        pause = (Button) view.findViewById(R.id.pause);
        stop = (Button)view.findViewById(R.id.stop);
        spotify = (TextView)view.findViewById(R.id.tvSpotify);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player==null){
                    player = MediaPlayer.create(getContext(),R.raw.forthenight);
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            stopPlayer();
                        }
                    });
                }

                player.start();

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player!=null){
                    player.pause();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlayer();
            }
        });

        spotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setAction(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                intent.setComponent(new ComponentName("com.spotify.music", "com.spotify.music.MainActivity"));
                intent.putExtra(SearchManager.QUERY, "Pop Smoke" );
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        return view;
    }



    public void play(View view){
        if(player==null){
            player = MediaPlayer.create(getContext(),R.raw.forthenight);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View view){
        if(player!=null){
            player.pause();
        }
    }

    public void stop(View view){
        stopPlayer();
    }

    private void stopPlayer(){
        if(player!=null){
            player.release();
            player=null;
            Toast.makeText(getContext(), "Media Player Released", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        stopPlayer();
    }
}