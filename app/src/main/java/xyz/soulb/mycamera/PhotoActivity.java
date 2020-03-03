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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        Intent classIntent = getIntent();
        className = classIntent.getStringExtra("class");
    }

    public void tack_class_photo(View view) {
        Intent intent  = new Intent(this,ImgActivity.class);
        intent.putExtra("path","/"+ className +"/上课");
        intent.putExtra("class",className);
        startActivity(intent);
    }

    public void tack_note_photo(View view) {
        Intent intent  = new Intent(this,ImgActivity.class);
        intent.putExtra("path","/"+ className +"/笔记");
        intent.putExtra("class",className);
        startActivity(intent);
    }
}
