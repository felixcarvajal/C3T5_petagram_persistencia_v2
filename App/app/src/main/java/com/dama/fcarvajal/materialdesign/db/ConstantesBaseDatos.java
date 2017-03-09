package com.dama.fcarvajal.materialdesign.db;

/**
 * Created by fcarvajal on 07/03/2017.
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTA = "contacto";
    public static final String TABLE_MASCOTA_ID = "id";
    public static final String TABLE_MASCOTA_NOMBRE = "nombre";
    public static final String TABLE_MASCOTA_FOTO = "foto";

    public static final String TABLE_LIKES_MASCOTA              = "mascota_likes";
    public static final String TABLE_LIKES_MASCOTA_ID           = "id";
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA   = "id_contacto";
    public static final String TABLE_LIKES_MASCOTA_NUMERO_LIKES = "numero_likes";
}
