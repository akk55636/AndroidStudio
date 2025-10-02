package com.example.video;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // initialize player view from layout
    private PlayerView playerView;
    // initialize player from ExoPlayer
    private ExoPlayer player;

    // define a array of video urls
    private final List<String> videoUrls = Arrays.asList(
            "https://videos.pexels.com/video-files/2519660/2519660-sd_640_360_24fps.mp4",
            "https://videos.pexels.com/video-files/2023708/2023708-sd_360_640_30fps.mp4",
            "https://videos.pexels.com/video-files/3629511/3629511-sd_360_450_24fps.mp4"
    );

    // define a variable to keep track of current video index
    private int currentVideoIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // define player view from layout
        playerView = findViewById(R.id.player_view);
        initializePlayer();
    }

    // define a function to initialize player
    private void initializePlayer() {
        // initialize player
        player = new ExoPlayer.Builder(this).build();
        // set player to player view
        playerView.setPlayer(player);

        // set first video
        setVideo(videoUrls.get(currentVideoIndex));

        // add listener to player to handle playback end
        player.addListener(new Player.Listener() {
            @Override
            public void onPlaybackStateChanged(int playbackState) {
                if (playbackState == Player.STATE_ENDED) {
                    showCompletionDialog();
                }
            }
        });
    }

    // define a function to set videos to player
    private void setVideo(String url) {
        MediaItem mediaItem = MediaItem.fromUri(url);
        player.setMediaItem(mediaItem);
        player.prepare();
        player.play();
    }

    // define a function to show a dialog box after video completion
    private void showCompletionDialog() {
        // show a dialog box with two options - replay or play next video
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Playback Finished!")
                .setMessage("Want to replay or play next video?")
                .setIcon(R.mipmap.ic_launcher)
                // set two buttons
                // replay button will set video to start from beginning
                .setPositiveButton("Replay", (dialogInterface, i) -> {
                    player.seekTo(0);
                    player.play();
                })
                // next video button will play next video
                .setNegativeButton("Next", (dialogInterface, i) -> {
                    currentVideoIndex = (currentVideoIndex + 1) % videoUrls.size();
                    setVideo(videoUrls.get(currentVideoIndex));
                })
                // cancel button will dismiss the dialog
                .create();

        // show the dialog box
        dialog.show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        // release player when app is stopped
        player.release();
    }
}