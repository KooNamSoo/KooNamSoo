package com.example.dulichthainguyen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class
Detail extends AppCompatActivity {

//tao bien
    TextView tvName = null;
    TextView tvAddress = null;
    TextView tvDesc = null;
    TextView tvGeod = null;
    ImageView img = null;
    Button btn = null;
    String geod = "";
    @Override
    // hien thi dau khi chay app
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // hien thi layout chi tiet
        setContentView(R.layout.chitiet);
//anh xa bien
        tvName = (TextView) findViewById(R.id.tvchitiet);
        tvAddress = (TextView) findViewById(R.id.tvdiadiem);
        tvDesc = (TextView) findViewById(R.id.tvthongtin);
        tvGeod = (TextView) findViewById(R.id.geod);
        img = (ImageView) findViewById(R.id.imgchitiet);
//tao doi tuong inten de nhan du lieu tu andapter
        Intent intent = getIntent();
//hien thi du lieu ra da lay duoc layout
        tvName.setText(intent.getStringExtra("name"));
        tvAddress.setText(intent.getStringExtra("address"));
        tvGeod.setText(intent.getStringExtra("geod"));
        img.setImageResource(intent.getIntExtra("img", 1));


        Button btn = (Button)findViewById(R.id.timduong);
//bat su kien nut de hien thi map kem toa do
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+tvGeod.getText().toString()+"("+tvName.getText().toString()+")");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

// chay inten
                startActivity(mapIntent);
            }
        });
    }
}
