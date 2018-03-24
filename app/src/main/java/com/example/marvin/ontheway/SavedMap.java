package com.example.marvin.ontheway;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RemoteViews;
import android.widget.Toast;

public class SavedMap extends AppCompatActivity {

    Point p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_map);

        ImageButton ib = (ImageButton) findViewById(R.id.imageButton2);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (p != null) {
                    showPopup(SavedMap.this, p);
                    //popUp(null);
                }
            }
        });

        Button saveButton = (Button) findViewById(R.id.button3);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(v);
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        int[] location = new int[2];
        ImageButton button = (ImageButton) findViewById(R.id.imageButton2);

        // Get the x, y location and store it in the location[] array
        // location[0] = x, location[1] = y.
        button.getLocationOnScreen(location);

        //Initialize the Point with x, and y positions
        p = new Point();
        p.x = location[0];
        p.y = location[1];
    }

    private void showPopup(final Activity context, Point p) {
        int popupWidth = 600;
        int popupHeight = 450;

        // Inflate the popup_layout.xml
        LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup);
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup_layout, viewGroup);

        // Creating the PopupWindow
        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        popup.setWidth(popupWidth);
        popup.setHeight(popupHeight);
        popup.setFocusable(true);

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X = popupWidth/2 + 200;//130;
        int OFFSET_Y = -popupHeight/2 - 100;//-300;

        // Clear the default translucent background
        popup.setBackgroundDrawable(new BitmapDrawable());

        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y);

        // Getting a reference to Close button, and close the popup when clicked.
//        Button close = (Button) layout.findViewById(R.id.close);
//        close.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                popup.dismiss();
//            }
//        });
    }

    public void save(View view) {
        Toast.makeText(SavedMap.this,
                "Saved",
                Toast.LENGTH_SHORT)
                .show();
        Intent mainMenuIntent = new Intent(this, MainMenu.class);
        String snackbarMessage = "Nobu Malibu";
        mainMenuIntent.putExtra("saved", snackbarMessage);
        startActivity(mainMenuIntent);
        finish();

        // notification channel values
        String CHANNEL_ID = "my_channel_01";// The id of the channel.
        CharSequence name = CHANNEL_ID;// The user-visible name of the channel.
        Notification.Builder mBuilder = null;

        // different Notifications for different versions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mBuilder = new Notification.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                    .setContentTitle("Hey! Check it out!")
                    .setContentText("One of the places you saved is on the way!")
                    .setDefaults(Notification.DEFAULT_ALL);
        } else {
            mBuilder = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                    .setContentTitle("Hey! Check it out!")
                    .setContentText("One of the places you saved is on the way!")
                    .setDefaults(Notification.DEFAULT_ALL);
        }

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int importance = NotificationManager.IMPORTANCE_HIGH;
        // modifications for oreo notifications
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Toast.makeText(SavedMap.this,
                    "Notification attempt",
                    Toast.LENGTH_SHORT)
                    .show();
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mNotificationManager.createNotificationChannel(mChannel);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mNotificationManager.notify(0,mBuilder.build());
        }


    }

    public void popUp(View view) {
        Toast.makeText(SavedMap.this,
                "Nobu Malibu",
                Toast.LENGTH_SHORT)
                .show();

    }
}
