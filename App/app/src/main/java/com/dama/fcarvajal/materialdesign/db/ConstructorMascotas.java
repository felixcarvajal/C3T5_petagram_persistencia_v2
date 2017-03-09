package com.dama.fcarvajal.materialdesign.db;

import android.content.ContentValues;
import android.content.Context;

import com.dama.fcarvajal.materialdesign.R;
import com.dama.fcarvajal.materialdesign.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by fcarvajal on 6/3/2017.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);

        ArrayList<Mascota> temporal = db.obtenerTodasLasMascotas();

        int numeroMascotas = temporal.size();

        if(numeroMascotas == 0) {
            insertarMascotas(db);
            temporal =  db.obtenerTodasLasMascotas();
        }

        return temporal;
    }

    //Las mascotas ya debieron ser creadas al ingresar a la aplicacion
    public ArrayList<Mascota> obtenerDatosTopCinco(){
        BaseDatos db = new BaseDatos(context);
        //insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public  void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.dog_bruto));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog_bruto);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.dog_cocky));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog_cocky);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.dog_jack));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog_jack);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.dog_kira));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog_kira);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.dog_lebre));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog_lebre);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.dog_lolo));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog_lolo);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.dog_rock));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog_rock);

        db.insertarMascotas(contentValues);


        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.dog_sammy));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog_sammy);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, context.getString(R.string.dog_tile));
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dog_tile);

        db.insertarMascotas(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

}
