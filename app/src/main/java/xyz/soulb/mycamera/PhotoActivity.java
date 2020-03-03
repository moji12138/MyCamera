package xyz.soulb.mycamera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class PhotoActivity extends AppCompatActivity {

    String className;
    String userName;
    ImageView img_class;
    ImageView img_note;
    String classPath;
    String notePath;
    Intent nextIntent = new Intent(PhotoActivity.this,ImgActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        Intent classIntent = getIntent();
        className = classIntent.getStringExtra("class");
        userName = classIntent.getStringExtra("user");

        String root = "/sdcard/DCIM/";
        classPath = root + "NyCamera/"+ className +"/上课/" + userName + ".jpg";
        notePath = root + "NyCamera/"+ className +"/笔记/" + userName + ".jpg";

        img_class = findViewById(R.id.img_class);
        img_note = findViewById(R.id.img_note);


    }

    public void tack_class_photo(View view) {
        nextIntent.putExtra("path",classPath);
        nextIntent.putExtra("class",className);
        nextIntent.putExtra("user",userName);
        startActivity(nextIntent);
    }

    public void tack_note_photo(View view) {
        nextIntent.putExtra("path",classPath);
        nextIntent.putExtra("class",className);
        nextIntent.putExtra("user",userName);
        startActivity(nextIntent);
    }
}
