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

    List<Item> listData = new ArrayList<>();
    ListView danhsachdiadiem ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        TextView ten = header.findViewById(R.id.ten);
        TextView email =header.findViewById(R.id.email);

        ten.setText("Ryo");
        email.setText("RyoMedia@gmail.com");
        RecyclerView recyclerView = findViewById(R.id.listView);
        loadData();
        AdapterItem adapterItem = new AdapterItem(listData,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterItem);





    }

    private void loadData() {
        Item a = new Item(R.drawable.ho_nui_coc,"Hồ Núi Cốc","Đại Từ - Thái Nguyên",21.5684389,105.6580269);
        Item b = new Item(R.drawable.atk,"atk Định Hóa"," Định Hóa - Thái Nguyên",21.7934866,105.509973);
        Item c = new Item(R.drawable.thac_khuon_tat,"Thác Khuôn Tát","Phú Bình - Thái Nguyên",21.7935789,105.5092916);
        Item e = new Item(R.drawable.che_tan_cuong,"Đồi Chè Tân Cương","Tân Cương - Thái Nguyên",21.543178,105.7580643);
        Item f = new Item(R.drawable.ho_suoi_lanh,"Hồ Suối Lạnh","Phổ Yên - Thái Nguyên",21.4069809,105.7666398);
        Item g = new Item(R.drawable.ho_vai_mieu,"Hồ Vai Miếu","Đại Từ - Thái Nguyên",21.5307101,105.6404377);
        Item h = new Item(R.drawable.hoghenhche1,"Hồ Ghềnh Chè","Sông Công - Thái Nguyên",21.5073732,105.7660094);
        Item i = new Item(R.drawable.thac_nam_rut,"Thác Nặm Rứt","Võ Nhai - Thái Nguyên",21.788916,105.9138009);
        Item j = new Item(R.drawable.hang_phuong_hoang,"Hang Phượng Hoàng","Võ Nhai - Thái Nguyên",21.7794819,106.1156559);
        Item k = new Item(R.drawable.cuatu,"Suối Cửa Tử","Đại Từ - Thái Nguyên",21.7794819,106.1156559);
        Item l = new Item(R.drawable.chua_hang,"Chùa Hang","Đồng Hỷ -  Thái Nguyên",21.6280765,105.8148628);
        Item m = new Item(R.drawable.donglinhson,"Động Linh Sơn","Đồng Hỷ - Thái Nguyên",21.7100345,105.8538087);
        Item n = new Item(R.drawable.hang_chua,"Hang Chùa","Đồng Hỷ - Thái Nguyên",21.6280765,105.8148628);
        Item o = new Item(R.drawable.den_duom,"Đền Đuổm","Phú Lương - Thái Nguyên",21.7549186,105.7059785);
        Item p = new Item(R.drawable.dat_dang,"Thác Đát Đắng","Đại Từ - Thái Nguyên",21.6436721,105.5093755);
        Item q= new Item(R.drawable.suoi_tien,"Suối Tiên","Đồng Hỷ - Thái Nguyên",21.7874842,105.8219547);
        Item r = new Item(R.drawable.hangphiengtung,"Hang Phiêng Tung","Võ Nhai - Thái Nguyên",21.7951927,105.8837199);
        Item s = new Item(R.drawable.mai_da_nguom,"Mái Đá Gườm","Võ Nhai - Thái Nguyên",21.7951927,105.8837199);
        Item t = new Item(R.drawable.baotang,"Bảo Tàng","Thành Phố Thái Nguyên",21.5745366,105.7986134);
        Item y = new Item(R.drawable.dung_tan,"Dũng Tân","Sông Công - Thái Nguyên",21.4724005,105.865685);
        listData.add(a);
        listData.add(b);
        listData.add(c);
        listData.add(e);
        listData.add(f);
        listData.add(g);
        listData.add(h);
        listData.add(i);
        listData.add(j);
        listData.add(k);
        listData.add(l);
        listData.add(m);
        listData.add(n);
        listData.add(o);
        listData.add(p);
        listData.add(q);
        listData.add(r);
        listData.add(s);
        listData.add(t);
        listData.add(y);
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
            Toast.makeText(this, "Tìm Kiếm", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
