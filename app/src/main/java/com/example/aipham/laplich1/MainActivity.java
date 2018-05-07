package com.example.aipham.laplich1;
//Bước 1: Đổi tên app
//Bước 2: đổi theme thành Theme.AppCompat.Light.NoActionBar
//Bước 3: đổi màu primarydark
//Bước 4: đổi activity.xml về RelativeLayout
//Bước 5: Mở <android.support.v7.widget.Toolbar
//Bước 6: Đặt thuộc tính: android:layout_width="match_parent"
//        android:layout_height="?attr/actionBarSize"
//Bước 7: Đặt id: android:id="@+id/toolbar"
//Bước 8: Đổ màu toolbar android:background="#FFB90F"
//Bước 9: Toolbar toolbar;
//Bước 10: toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//Bước 11: chỉnh  import android.support.v7.widget.Toolbar;
//B12. Đổi layout android.support.v4.widget.DrawerLayout, đẩy Relative layout vào trong
//B13: Vào build.gradle app level thêm implementation 'com.android.support:design:27.1.1'
//B14: Mở thẻ <android.support.design.widget.NavigationView
//B15: Tạo menu navigation_menu
//B16: Thêm item
//<!--B17: app:menu="@menu/navigation_menu"-->
//b18:private DrawerLayout mDrawerLayout;
//    private ActionBarDrawerToggle mToggle;
//B19:Tạo String <string name="open">Open</string>
//    <string name="close">Close</string>
//B20 mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
//        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open,R.string.close);
//B21
//B22
//B23: Copy icon vào mipmap
//B24: thêm icon
//B24: Thêm navigation_header.xml
//B25: app:headerLayout="@layout/navigation_header"
//B26: bỏ b24+b25
//B27: tạo fragment_sign_in.xml kiểu RelativeLayout
//B28: tạo class SignInFragment extends Fragment
///B29: implements NavigationView.OnNavigationItemSelectedListener (widget.NavigationView)
//B30: Ctrl+I - boolean onNavigationItemSelected
// B31: chỉnh thành return true;
//B32: switch (item.getItemId()){
//            case R.id.account:
//
//                break;
//B33:  Tạo <FrameLayout
//            android:id="@+id/fragment_container"
//B34: thêm tools:openDrawer="start"
//B35: B33:getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
////                        new SignInFragment()).commit();


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Bước 9: Toolbar toolbar;
    Toolbar toolbar;

    //B18:
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bước 10: toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //B20:
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
//        B21
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
//    B30:Ctrl+I - boolean onNavigationItemSelected
//    B31: chỉnh thành return true;
    //    B32: xử lý navigation view item click
    //B32: switch (item.getItemId()){
//            case R.id.account:
//
//                break;
//    B35:getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new SignInFragment()).commit();
//    B36:



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.account:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SignInFragment()).commit();
                break;
        }

        return true;
    }

    //    B22:onOption
        @Override
        public boolean onOptionsItemSelected (MenuItem item){

            if (mToggle.onOptionsItemSelected(item)) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

