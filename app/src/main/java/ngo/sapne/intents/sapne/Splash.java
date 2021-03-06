package ngo.sapne.intents.sapne;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_anim_layout);

        //get the VideoView from the resources

        VideoView vView = (VideoView)findViewById(R.id.videoView3);
        //use this to get touch events
        vView.requestFocus();
        //now we have to load video from the resources folder
        //set the video path
        String vSource = "android.resource://ngo.sapne.intents.sapne/" + R.raw.video;
        //set the video URI, passing thevSource as a URI
        vView.setVideoURI(Uri.parse(vSource));
        //enable this if you want to enable video controllers, such as pause and forward
        // vView.setMediaController(new MediaController(this));
        //plays the movie
        vView.start();
        vView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                startActivity(new Intent(getApplicationContext(), BaseActivity.class));
                finish();
            }

        });
    }

}
