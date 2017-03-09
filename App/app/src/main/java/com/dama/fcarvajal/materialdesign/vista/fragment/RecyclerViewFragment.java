package com.dama.fcarvajal.materialdesign.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dama.fcarvajal.materialdesign.R;
import com.dama.fcarvajal.materialdesign.adapter.MascotaAdaptador;
import com.dama.fcarvajal.materialdesign.pojo.Mascota;
import com.dama.fcarvajal.materialdesign.presentador.IRecyclerViewFragmentPresenter;
import com.dama.fcarvajal.materialdesign.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    //private ArrayList<Mascota> ListaMascotas;
    private RecyclerView RVListaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

//    public void setListaMascotas(ArrayList<Mascota> ListaMascotas){
//        this.ListaMascotas = ListaMascotas;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        RVListaMascotas = (RecyclerView) v.findViewById(R.id.recycler_view_mascotas_main_activity);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        RVListaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRecyclerView(MascotaAdaptador adaptador) {
        RVListaMascotas.setAdapter(adaptador);
    }

}
