package com.dama.fcarvajal.materialdesign.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dama.fcarvajal.materialdesign.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by fcarvajal on 07/03/2017.
 */

public class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " " + "INTEGER PRIMARY KEY AUTOINCREMENT" + ", " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " " + "TEXT" + ", " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " " + "INTEGER" +
                ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " " + "INTEGER PRIMARY KEY AUTOINCREMENT" + ", " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " " + "INTEGER" + ", " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " " + "INTEGER" + ", " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> listaMascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + ") AS LIKES " +
                                " FROM " +  ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA +
                                " = " + mascotaActual.getId();

            Cursor registroLikes = db.rawQuery(queryLikes, null);

            if(registroLikes.moveToNext()){
                mascotaActual.setRaiting(registroLikes.getInt(0));
            }else{
                mascotaActual.setRaiting(0);
            }

            listaMascotas.add(mascotaActual);
        }

        db.close();

        return listaMascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        String query = "SELECT COUNT("+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES +")" +
                            " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                            " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA +
                            " = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        int likes = 0;

        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }

        return likes;
    }

}
