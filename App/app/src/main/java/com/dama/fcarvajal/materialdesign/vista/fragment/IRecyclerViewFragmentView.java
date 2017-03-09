package com.dama.fcarvajal.materialdesign.vista.fragment;

import com.dama.fcarvajal.materialdesign.adapter.MascotaAdaptador;
import com.dama.fcarvajal.materialdesign.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by fcarvajal on 6/3/2017.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRecyclerView(MascotaAdaptador adaptador);
}
