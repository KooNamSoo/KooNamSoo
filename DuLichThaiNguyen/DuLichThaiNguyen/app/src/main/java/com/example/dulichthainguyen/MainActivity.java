package com.example.dulichthainguyen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
//tao doi tuong listData thuoc kieu list, cac phan tu trong list laf item
    List<Item> listData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
//tao doi tuong navigation menu ngang
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        TextView ten = header.findViewById(R.id.ten);
        TextView email =header.findViewById(R.id.email);

        ten.setText("Ryo");
        email.setText("RyoMedia@gmail.com");
        RecyclerView recyclerView = findViewById(R.id.listView);
        loadData();
        //tap andapter item voi du lieu listData
        AdapterItem adapterItem = new AdapterItem(listData,this);
        // list view kieu rycycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // dinh nghia andapter cho list view
        recyclerView.setAdapter(adapterItem);

    }

    private void loadData() {
        listData.add(new Item(R.drawable.ho_nui_coc,"Hồ Núi Cốc","Đại Từ - Thái Nguyên",21.5684389,105.6580269));
        listData.add(new Item(R.drawable.atk,"atk Định Hóa"," Định Hóa - Thái Nguyên",21.7934866,105.509973));
        listData.add(new Item(R.drawable.thac_khuon_tat,"Thác Khuôn Tát","Phú Bình - Thái Nguyên",21.7935789,105.5092916));
        listData.add(new Item(R.drawable.che_tan_cuong,"Đồi Chè Tân Cương","Tân Cương - Thái Nguyên",21.543178,105.7580643));
        listData.add(new Item(R.drawable.ho_suoi_lanh,"Hồ Suối Lạnh","Phổ Yên - Thái Nguyên",21.4069809,105.7666398));
        listData.add(new Item(R.drawable.ho_vai_mieu,"Hồ Vai Miếu","Đại Từ - Thái Nguyên",21.5307101,105.6404377));
        listData.add(new Item(R.drawable.hoghenhche1,"Hồ Ghềnh Chè","Sông Công - Thái Nguyên",21.5073732,105.7660094));
        listData.add(new Item(R.drawable.thac_nam_rut,"Thác Nặm Rứt","Võ Nhai - Thái Nguyên",21.788916,105.9138009));
        listData.add(new Item(R.drawable.hang_phuong_hoang,"Hang Phượng Hoàng","Võ Nhai - Thái Nguyên",21.7794819,106.1156559));
        listData.add(new Item(R.drawable.cuatu,"Suối Cửa Tử","Đại Từ - Thái Nguyên",21.7794819,106.1156559));
        listData.add(new Item(R.drawable.chua_hang,"Chùa Hang","Đồng Hỷ -  Thái Nguyên",21.6280765,105.8148628));
        listData.add(new Item(R.drawable.donglinhson,"Động Linh Sơn","Đồng Hỷ - Thái Nguyên",21.7100345,105.8538087));
        listData.add(new Item(R.drawable.hang_chua,"Hang Chùa","Đồng Hỷ - Thái Nguyên",21.6280765,105.8148628));
        listData.add(new Item(R.drawable.den_duom,"Đền Đuổm","Phú Lương - Thái Nguyên",21.7549186,105.7059785));
        listData.add(new Item(R.drawable.dat_dang,"Thác Đát Đắng","Đại Từ - Thái Nguyên",21.6436721,105.5093755));
        listData.add(new Item(R.drawable.suoi_tien,"Suối Tiên","Đồng Hỷ - Thái Nguyên",21.7874842,105.8219547));
        listData.add(new Item(R.drawable.hangphiengtung,"Hang Phiêng Tung","Võ Nhai - Thái Nguyên",21.7951927,105.8837199));
        listData.add(new Item(R.drawable.mai_da_nguom,"Mái Đá Gườm","Võ Nhai - Thái Nguyên",21.7951927,105.8837199));
        listData.add(new Item(R.drawable.baotang,"Bảo Tàng","Thành Phố Thái Nguyên",21.5745366,105.7986134));
        listData.add(new Item(R.drawable.dung_tan,"Dũng Tân","Sông Công - Thái Nguyên",21.4724005,105.865685));
    }
// su kien nut back
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//hien thi nut tim kiem
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
    //bat su kien nut trang chu
    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        }


//do menu sau khi an
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
