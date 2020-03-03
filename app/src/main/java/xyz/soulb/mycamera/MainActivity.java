package xyz.soulb.mycamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    Context mContext = MainActivity.this;
    List<Map<String, Object>> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gl);

        data = new ArrayList<>();

        AssetManager as = getAssets();
        try {
            InputStream  inputStream = as.open("data.json");
            byte[] bytes = new byte[0];
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            String json_str = new String(bytes);
            JSONArray jsonArray = new JSONArray(json_str);
            Log.d("TEST",jsonArray.toString());
            for (int i=0; i<jsonArray.length(); i++){
                Map<String, Object> itemMap = new HashMap<>();
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                itemMap.put("name",jsonObject.getString("name"));
                itemMap.put("pos",jsonObject.getString("pos"));
                itemMap.put("teacher",jsonObject.getString("teach"));
                data.add(itemMap);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                data,
                R.layout.item_grid,new String[]{"name","pos","teacher"},
                new int[]{R.id.item_name,R.id.item_pos,R.id.item_teacher}
                );
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = (int)id;
                Map course = data.get(index);
                String name = (String) course.get("name");
                Intent intent = new Intent(mContext,PhotoActivity.class);
                intent.putExtra("class",name);
                startActivity(intent);
            }
        });
    }
}
