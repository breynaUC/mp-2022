package com.example.mp10;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = null;
    }
    public void music(View view) {
        switch (view.getId()){
            case R.id.idplay:
                 if(mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.music);
                }
                 mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                         stopMusic();
                    }
                });
                   mediaPlayer.start();
                break;
            case R.id.idpause:
                if(mediaPlayer != null) {
                     mediaPlayer.pause();
                }
                break;
            case R.id.idstop:
                if(mediaPlayer != null){
                     mediaPlayer.stop();
                    stopMusic();
                }
                break;
        }
    }

    private void stopMusic() {
        mediaPlayer.release();
        mediaPlayer = null;
    }
    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }
}