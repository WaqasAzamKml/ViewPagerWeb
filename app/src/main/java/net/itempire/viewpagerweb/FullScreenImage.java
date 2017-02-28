package net.itempire.viewpagerweb;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FullScreenImage extends AppCompatActivity {
    ImageView imgFullScreenPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        Bundle extras = getIntent().getExtras();
        Bitmap img = (Bitmap) extras.getParcelable("petImage");

        imgFullScreenPet = (ImageView) findViewById(R.id.imgFullScreenPet);
        imgFullScreenPet.setImageBitmap(img);

        getSupportActionBar().hide();
    }
}
