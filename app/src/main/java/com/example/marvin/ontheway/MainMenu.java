package com.example.marvin.ontheway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Example of a call to a native method
        // TextView tv = (TextView) findViewById(R.id.sample_text);
        // tv.setText(stringFromJNI());

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_map){
            Toast.makeText(MainMenu.this,
                    "You have clicked on map action menu",
                    Toast.LENGTH_SHORT)
                    .show();
            ToMap(null);
        }
        if(item.getItemId() == R.id.action_setting){
            Toast.makeText(MainMenu.this,
                    "You have clicked on setting action menu",
                    Toast.LENGTH_SHORT)
                    .show();
            // Intent settingsActivityIntent = new Intent(this, SettingActivity.class);
            // startActivity(settingsActivityIntent);
            // finish();
        }
        if(item.getItemId() == R.id.action_about_us){
            Toast.makeText(MainMenu.this,
                    "You have clicked on about us action menu",
                    Toast.LENGTH_SHORT)
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void ToMap(View view) {
        Intent mapIntent = new Intent(this, MapsActivity.class);

        // Example of sending info from this intent to the next
        // if I had a EditText view for user input
        // final EditText mainMenuInput = (EditText) findViewById(R.id.mainMenuInput);
        // String userMessage = mainMenuInput.getText().toString();
        // i.putExtra("mainMenuMessage", userMessage); // key, value pair

        startActivity(mapIntent);
        finish();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
