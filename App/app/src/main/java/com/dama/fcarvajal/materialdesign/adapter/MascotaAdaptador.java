package com.dama.fcarvajal.materialdesign.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dama.fcarvajal.materialdesign.db.ConstructorMascotas;
import com.dama.fcarvajal.materialdesign.pojo.Mascota;
import com.dama.fcarvajal.materialdesign.R;

import java.util.ArrayList;

/**
 * Created by fcarvajal on 20/02/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    private ArrayList<Mascota> ListaMascotas;
    private Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> ListaMascotas, Activity activity) {
        this.ListaMascotas = ListaMascotas;
        this.activity = activity;
    }

    //Va a inflar el layout y lo pasara al ViewHolder para que
    //el obtenga cada elemento de los views

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = ListaMascotas.get(position);
        holder.cardview_imgMascota.setImageResource(mascota.getFoto());
        holder.cardview_tvNombreMascota.setText(mascota.getNombre());
        holder.cardview_tvRaiting.setText(mascota.getRaiting() + "");

        holder.cardview_imgHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mascota.setRaiting();

               // holder.cardview_tvRaiting.setText(mascota.getRaiting_string());

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);

                int likes = constructorMascotas.obtenerLikesMascota(mascota);

                holder.cardview_tvRaiting.setText(likes + "");

                Toast.makeText(activity, "Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

//        holder.cardview_imgMascota.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(activity, "Prueba AA.", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {//cantidad de elementos que contiene la lista de mascotas
        return ListaMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView cardview_imgMascota;
        private ImageView cardview_imgHueso;
        private TextView cardview_tvNombreMascota;
        private TextView cardview_tvRaiting;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            cardview_imgMascota = (ImageView) itemView.findViewById(R.id.cardview_imgMascota);
            cardview_imgHueso = (ImageView) itemView.findViewById(R.id.cardview_imgHueso);
            cardview_tvNombreMascota = (TextView) itemView.findViewById(R.id.cardview_tvNombreMascota);
            cardview_tvRaiting = (TextView) itemView.findViewById(R.id.cardview_tvRaiting);
        }
    }


}
