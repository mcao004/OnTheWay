package com.example.marvin.ontheway;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
    private Button btn1;
    // Used to load the 'native-lib' library on application startup.
    View view;
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

        Bundle extraData = getIntent().getExtras();
        if (extraData != null && extraData.getString("saved") != null) {
            String savedMessage = "saved " + extraData.getString("saved");
            Snackbar sb = Snackbar.make((View)findViewById(R.id.toolbar),savedMessage, Snackbar.LENGTH_LONG);
            sb.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainMenu.this,
                            "Removed",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            });
            sb.show();
        }

        // Setup background scroll
        final ImageView backgroundOne = (ImageView) findViewById(R.id.imageView);
        final ImageView backgroundTwo = (ImageView) findViewById(R.id.imageView3);
        final ImageView backgroundThree = (ImageView) findViewById(R.id.imageView4);

        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(10000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float height = backgroundOne.getHeight();
                final float translationY = height * progress;
                backgroundThree.setTranslationY(translationY + height);
                backgroundOne.setTranslationY(translationY);
                backgroundTwo.setTranslationY(translationY - height);
            }
        });
        animator.start();

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        btn1 =findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                ToNotification(v);
            }
        });

        Button toListButton = (Button) findViewById(R.id.button4);
        toListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToList();
            }
        });
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
//        finish();
    }
    public void ToNotification(View view) {
        Intent intent = new Intent(this, ListViewNotification.class);

        // Example of sending info from this intent to the next
        // if I had a EditText view for user input
        // final EditText mainMenuInput = (EditText) findViewById(R.id.mainMenuInput);
        // String userMessage = mainMenuInput.getText().toString();
        // i.putExtra("mainMenuMessage", userMessage); // key, value pair

        startActivity(intent);
//        finish();
    }

    private void ToList() {
        //Intent placeListIntent = new Intent(this, PlacesList.class);
        //startActivity(placeListIntent);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
