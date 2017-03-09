package com.dama.fcarvajal.materialdesign.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dama.fcarvajal.materialdesign.R;
import com.dama.fcarvajal.materialdesign.adapter.DetalleMascotaAdaptador;
import com.dama.fcarvajal.materialdesign.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> ListaDetalleMascota;
    private RecyclerView RecyclerView_ListaDetalleMascota;

    public PerfilFragment() {
        // Required empty public constructor
    }

    public void setListaDetalleMascota(ArrayList<Mascota> ListaDetalleMascota){
        this.ListaDetalleMascota = ListaDetalleMascota;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        detalleMascota(v);

        setRecyclerView_listaGrilla(v);

        return v;
    }

    private void detalleMascota(View v) {

        Mascota mascota = ListaDetalleMascota.get(0);

        ImageView fragment_imgMascota = (ImageView) v.findViewById(R.id.fragment_imgMascota);
        fragment_imgMascota.setImageResource(mascota.getFoto());

        TextView fragment_tvMascota = (TextView) v.findViewById(R.id.fragment_tvMascota);
        fragment_tvMascota.setText(mascota.getNombre());
    }


    public void setRecyclerView_listaGrilla(View v){
        RecyclerView_ListaDetalleMascota = (RecyclerView) v.findViewById(R.id.recycler_view_detalle_mascota);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        glm.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView_ListaDetalleMascota.setLayoutManager(glm);
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        DetalleMascotaAdaptador adaptador = new DetalleMascotaAdaptador(ListaDetalleMascota, getActivity());
        RecyclerView_ListaDetalleMascota.setAdapter(adaptador);
    }

}
