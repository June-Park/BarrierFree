package com.example.jj.barrierfree;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private LinearLayout filterName;
    private LinearLayout filterType;
    private LinearLayout filterArea;
    private LinearLayout filterElevator;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        session = new Session(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*===========================================================================================================*/

        /*Intent signupIntent = new Intent(MainActivity.this, GetStartActivity.class);
        startActivity(signupIntent);*/

        /*수정 필요함*/
        filterName = (LinearLayout)findViewById(R.id.searchfileter_name);
        filterName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });

        /*수정 필요함*/
        filterType = (LinearLayout)findViewById(R.id.searchfilter_type);
        filterType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(MainActivity.this, SearchItemDetail.class);
                startActivity(detailIntent);
            }
        });

        /*수정 필요함*/
        filterArea = (LinearLayout)findViewById(R.id.searchfilter_area);
        filterArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(MainActivity.this, ReviewActivity.class);
                startActivity(detailIntent);
            }
        });

        /*수정 필요함*/
        filterElevator = (LinearLayout)findViewById(R.id.searchfilter_elevator);
        filterElevator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(MainActivity.this, Test.class);
                startActivity(detailIntent);
            }
        });

        /*------------------------------------------------------------------------*/

        /*if(!session.loggedin())
        {
            logout();
        }*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*오른쪽 세팅 탭*/
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

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

        //session = new Session(this);


        /*네비게이션 드로워*/
        /*검색*/
        if (id == R.id.nav_search)
        {
            Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(searchIntent);
        }
        /*방문후기*/
        else if (id == R.id.nav_review)
        {
            Intent detailIntent = new Intent(MainActivity.this, ReviewActivity.class);
            startActivity(detailIntent);
        }
        /*즐겨찾기*/
        else if (id == R.id.nav_bookmark)
        {

        }
        /*-------------------------------------------------------------------------------수정 필요함. 지금은 로그인 상태 확인하는 용도로 사용중*/
        else if (id == R.id.nav_manage)
        {
            Toast.makeText(MainActivity.this, session.loggedin()+"!!", Toast.LENGTH_LONG).show();
        }
        /*공지사항*/
        else if (id == R.id.nav_notice)
        {

        }
        /*-------------------------------------------------------------------------------------수정 필요함*/
        /*로그아웃*/
        else if (id == R.id.nav_logout) {
            logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout()
    {
        /*???????????????????????????????????*/
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this, GetStartActivity.class));
    }
}
