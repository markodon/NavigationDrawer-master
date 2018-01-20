package info.androidhive.navigationdrawer.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.ViewPagerAdapter;
import info.androidhive.navigationdrawer.fragment.HomeFragment;
import info.androidhive.navigationdrawer.fragment.MoviesFragment;
import info.androidhive.navigationdrawer.fragment.NotificationsFragment;
import info.androidhive.navigationdrawer.fragment.PhotosFragment;
import info.androidhive.navigationdrawer.fragment.SettingsFragment;
import info.androidhive.navigationdrawer.other.CircleTransform;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    private ViewPager vp;

    // urls to load navigation header background image
    // and profile image
    private static final String urlNavHeaderBg = "http://www.ccwilcox.com/blog/wp-content/themes/material-gaze/images/headers/blue.jpg";
    private static final String urlProfileImg = "https://www.horoscope.com/images-US/signs/profile-virgo.png";

    // index to identify current nav menu item
    public static int navItemIndex = 0;


    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.vp);
        ViewPagerAdapter vpadapter = new ViewPagerAdapter(getSupportFragmentManager());

        vpadapter.dodadiFragment(new HomeFragment());
        vpadapter.dodadiFragment(new PhotosFragment());
        vpadapter.dodadiFragment(new MoviesFragment());
        vpadapter.dodadiFragment(new NotificationsFragment());
        vpadapter.dodadiFragment(new SettingsFragment());
        vp.setAdapter(vpadapter);

        vp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }


        });


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);


        txtName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.name);
        txtWebsite = (TextView) navigationView.getHeaderView(0).findViewById(R.id.website);
        imgNavHeaderBg = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.img_profile);



        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);


        // load nav menu header data
        loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            loadHomeFragment();
        }
    }

    /***
     * Load navigation menu header information
     */
    private void loadNavHeader() {
        // name, website
        txtName.setText("Zorica Stojchevska");
        txtWebsite.setText("Brainster");

        // наместо Пикаса е ова, вие користете си Пикаса
        Glide.with(this).load(urlNavHeaderBg)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);

        // наместо Пикаса е ова, вие користете си Пикаса
        Glide.with(this).load(urlProfileImg)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);

        // showing dot next to notifications label
        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);
    }

    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment() {

        // set toolbar title
        setToolbarTitle();


        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }


    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }


    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.home:
                        navItemIndex = 0;
                        vp.setCurrentItem(navItemIndex);
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_photos:
                        navItemIndex = 1;
                        vp.setCurrentItem(navItemIndex);
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_movies:
                        navItemIndex = 2;
                        vp.setCurrentItem(navItemIndex);
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_notifications:
                        navItemIndex = 3;
                        vp.setCurrentItem(navItemIndex);
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_settings:
                        navItemIndex = 4;
                        vp.setCurrentItem(navItemIndex);
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_about_us:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
                        drawer.closeDrawers();
                        return true;
                    case R.id.nav_privacy_policy:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, PrivacyPolicyActivity.class));
                        drawer.closeDrawers();
                        return true;
                    default:
                        navItemIndex = 0;
                        vp.setCurrentItem(navItemIndex);
                        drawer.closeDrawers();
                }



                invalidateOptionsMenu();
                setToolbarTitle();
                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }


        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // show menu only when home fragment is selected
        if (navItemIndex == 0) {
            getMenuInflater().inflate(R.menu.main, menu);
        }

        // when fragment is notifications, load the menu created for notifications
        if (navItemIndex == 3) {
            getMenuInflater().inflate(R.menu.notifications, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();
            return true;
        }

        // user is in notifications fragment
        // and selected 'Mark all as Read'
        if (id == R.id.action_mark_all_read) {
            Toast.makeText(getApplicationContext(), "All notifications marked as read!", Toast.LENGTH_LONG).show();
        }

        // user is in notifications fragment
        // and selected 'Clear All'
        if (id == R.id.action_clear_notifications) {
            Toast.makeText(getApplicationContext(), "Clear all notifications!", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


}
