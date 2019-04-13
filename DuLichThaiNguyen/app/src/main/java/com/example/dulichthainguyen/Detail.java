package com.example.dulichthainguyen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {


    TextView tvName = null;
    TextView tvAddress = null;
    TextView tvDesc = null;
    TextView tvGeod = null;
    ImageView img = null;
    Button btn = null;
    String geod = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitiet);

        tvName = (TextView) findViewById(R.id.tvchitiet);
        tvAddress = (TextView) findViewById(R.id.tvdiadiem);
        tvDesc = (TextView) findViewById(R.id.tvthongtin);
        tvGeod = (TextView) findViewById(R.id.geod);
        img = (ImageView) findViewById(R.id.imgchitiet);

        Intent intent = getIntent();

        tvName.setText(intent.getStringExtra("name"));
        tvAddress.setText(intent.getStringExtra("address"));
        tvGeod.setText(intent.getStringExtra("geod"));
        img.setImageResource(intent.getIntExtra("img", 1));


        Button btn = (Button)findViewById(R.id.timduong);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+tvGeod.getText().toString()+"("+tvName.getText().toString()+")");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

// Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);
            }
        });
    }
}
