package com.example.andrei.bbc_mindgym;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void sendMessage(View view) {
        // Do something in response to button click
        //startActivity(new Intent(MainActivity.this, ));

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar)

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_alarm) {
            this.openAlarmTab();
        } else if (id == R.id.nav_calendar) {
            this.openCalendarTab();
        } else if (id == R.id.nav_todolist) {
            this.openTodoTab();
        } else if (id == R.id.nav_trackedapps) {
            this.openTrackTab();
        } else if (id == R.id.nav_workouts){
            this.openWorkoutsTab();
        } else if (id == R.id.nav_quizzes){
            this.openQuizzesTab();
        } else if (id == R.id.nav_games) {
            this.openGamesTab();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void openWorkoutsTab(){
        startActivity(new Intent(MainActivity.this, WorkoutsActivity.class));
    }

    public void openAlarmTab() {
        startActivity(new Intent(MainActivity.this, AlarmActivity.class));
    }

    public void openTodoTab() {
        startActivity(new Intent(MainActivity.this, TodoActivity.class));
    }

    public void openCalendarTab() {
        //
        // startActivity(new Intent(MainActivity.this, CalendarActivity.class));
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.calendar");
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        } else {
            // Bring user to the market or let them choose an app?
            launchIntent = new Intent(Intent.ACTION_VIEW);
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            launchIntent.setData(Uri.parse("market://details?id=" + "com.google.android.calendar"));
            startActivity(launchIntent);
        }
    }

    public void openTrackTab() {
        startActivity(new Intent(MainActivity.this, TrackActivity.class));
    }


    public void openQuizzesTab() {
        startActivity(new Intent(MainActivity.this, QuizzesActivity.class));
    }
    public void openGamesTab() {
        startActivity(new Intent(MainActivity.this, GamesActivity.class));
    }
}
