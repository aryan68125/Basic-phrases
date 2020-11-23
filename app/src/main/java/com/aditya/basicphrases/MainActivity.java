package com.aditya.basicphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void PlayPhrase(View view)
    {
         Button button = (Button) view;
         Log.i("Button Pressed", button.getTag().toString()); //it will return the tag of a button pressed using view method
        /*
        here in order to play the sound that we want when a button is pressed we will use the mediaplayer function but with a slight modification
        you see the mediaPlayer function ecpects the file name that is present inside the row folder in our app
        it can not play the sound from a variable so with the modifications done to the mediaplayer function below we will be able to just that
        getResources() = gets the resources needed
        getIdentifier() = identifies the variables and files associated with it
        button = Button button = (Button) view -> we are accessing the button id directly by using view method
        button.getTag() = will get the tag that we have already set in our xml file
        toString() = converts the tag into string
        defType = "raw" => is the folder where our audio files are contained
        getPackageName() -> tells the compiler where it should look for the audio files in this case its in our app folder inside that raw folder in which the sound files are located
         */
        MediaPlayer mediaPlayer = MediaPlayer.create(this,getResources().getIdentifier(button.getTag().toString(),"raw",getPackageName()));
        mediaPlayer.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}