package com.example.student.a20180310_02sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("mydata", MODE_PRIVATE);                           // 1 getSharedPreferences

    }

    public void clickRead (View v)
    {
        String str = sp.getString("nickname", "teacher");                           //1 getString
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }
    public void clickWrite (View v)
    {
        SharedPreferences.Editor editor = sp.edit();                                                            //1 SharedPreferences.Editor
        editor.putString("nickname", "Peter");                                                                   //2 editor.putString
        editor.commit();                                                                                                     //3 editor.commit
    }
    public void clicksetting (View v)
    {
        Intent it = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(it);
    }
    public void clickNick (View v )
    {
        TextView tv = findViewById(R.id.textView);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);             //1 getDefaultSharedPreferences
        String str = sp.getString("sp_nickname", "NickName");                                       //2 getString
        tv.setText(str);
    }
}
