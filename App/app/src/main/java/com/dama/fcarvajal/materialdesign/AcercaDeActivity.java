package com.dama.fcarvajal.materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        setToolbar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //TOOLBAR
    public void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvTitulo = (TextView) findViewById(R.id.toolbar_tvTitulo);
        tvTitulo.setText(R.string.aad_titulo);

        ImageView imgEstrella = (ImageView) findViewById(R.id.toolbar_imgEstrella);
        imgEstrella.setVisibility(View.INVISIBLE);
    }
}
