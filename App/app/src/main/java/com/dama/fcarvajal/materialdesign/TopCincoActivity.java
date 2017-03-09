package com.dama.fcarvajal.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dama.fcarvajal.materialdesign.adapter.MascotaAdaptador;
import com.dama.fcarvajal.materialdesign.db.ConstructorMascotas;
import com.dama.fcarvajal.materialdesign.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by fcarvajal on 20/2/2017.
 */

public class TopCincoActivity extends AppCompatActivity {

    private ArrayList<Mascota> ListaTopCinco;
    private RecyclerView RVListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_cinco);
        setToolbar();
        setRecyclerView();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //MENU OPCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_contact:
                Intent intentFC = new Intent(this, FormularioContactoActivity.class);
                startActivity(intentFC);
                break;

            case R.id.menu_about:
                Intent intentAD = new Intent(this, AcercaDeActivity.class);
                startActivity(intentAD);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvTitulo = (TextView) findViewById(R.id.toolbar_tvTitulo);
        tvTitulo.setText(R.string.apt5_titulo);

        ImageView imgEstrella = (ImageView) findViewById(R.id.toolbar_imgEstrella);
        imgEstrella.setVisibility(View.INVISIBLE);
    }

    public void setRecyclerView(){
        RVListaMascotas = (RecyclerView) findViewById(R.id.recycler_view_mascotas_top_cinco_activity);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        RVListaMascotas.setLayoutManager(llm);
//        inicializarParametros();
        inicializarListaTopCinco();
        inicializarAdaptador();
    }

//    public void inicializarParametros() {
//        Intent intent = getIntent();
//
//        Bundle parametros = intent.getExtras();
//
//        //ListaTopCinco = (ArrayList<Mascota>) parametros.getSerializable(String.valueOf(R.string.lista_serializada_top_cinco));
//    }

    public void inicializarListaTopCinco() {
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(this);
        ArrayList<Mascota> ListaMascotas = constructorMascotas.obtenerDatosTopCinco();

        ArrayList<Mascota> ListaTemporal = new ArrayList<Mascota>();

        for(Mascota mascota : ListaMascotas){
            ListaTemporal.add(mascota);
        }

        for (int i = 0; i < ListaTemporal.size(); i++) {
            for (int j = ListaTemporal.size() - 1; j > i; j--) {
                if (ListaTemporal.get(i).getRaiting() < ListaTemporal.get(j).getRaiting()) {

                    Mascota mascota = ListaTemporal.get(i);
                    ListaTemporal.set(i,ListaTemporal.get(j)) ;
                    ListaTemporal.set(j,mascota);
                }
            }
        }

        ListaTopCinco = new ArrayList<Mascota>();

        for(int i = 0; i < 5; i++){

            ListaTopCinco.add(ListaTemporal.get(i));
        }
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(ListaTopCinco, this);
        RVListaMascotas.setAdapter(adaptador);
    }

}
