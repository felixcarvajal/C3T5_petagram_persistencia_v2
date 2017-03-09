package com.dama.fcarvajal.materialdesign.pojo;

import android.content.Context;

import com.dama.fcarvajal.materialdesign.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by fcarvajal on 19/2/2017.
 */

public class Mascota implements Serializable {

    private int id;
    private String nombre;
    private int raiting;
    private int foto;

    public Mascota(String nombre, int foto){
        this.nombre = nombre;
        //this.raiting = raiting;
        this.foto = foto;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRaiting() {
        return raiting;
    }

    //public String getRaiting_string() {
    //    return getRaiting() + "";
    //}

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

//    public void setRaiting() {
//        this.raiting = this.raiting + 1;
//    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public static ArrayList<Mascota> inicialiarListaMascotas(Context context) {

        ArrayList<Mascota> ListaMascotas = new ArrayList<Mascota>();

        ListaMascotas.add(new Mascota(context.getString(R.string.dog_bruto), R.drawable.dog_bruto));
        ListaMascotas.add(new Mascota(context.getString(R.string.dog_cocky), R.drawable.dog_cocky));
        ListaMascotas.add(new Mascota(context.getString(R.string.dog_jack), R.drawable.dog_jack));
        ListaMascotas.add(new Mascota(context.getString(R.string.dog_kira), R.drawable.dog_kira));
        ListaMascotas.add(new Mascota(context.getString(R.string.dog_lebre), R.drawable.dog_lebre));
        ListaMascotas.add(new Mascota(context.getString(R.string.dog_lolo), R.drawable.dog_lolo));
        ListaMascotas.add(new Mascota(context.getString(R.string.dog_rock), R.drawable.dog_rock));
        ListaMascotas.add(new Mascota(context.getString(R.string.dog_sammy), R.drawable.dog_sammy));
        ListaMascotas.add(new Mascota(context.getString(R.string.dog_tile), R.drawable.dog_tile));

        return  ListaMascotas;
    }

    public static ArrayList<Mascota> inicialiarListaBruto(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.dog_bruto), R.drawable.dog_bruto);
    }

    public static ArrayList<Mascota> inicialiarListaCocky(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.dog_cocky), R.drawable.dog_cocky);
    }

    public static ArrayList<Mascota> inicialiarListaJack(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.dog_jack), R.drawable.dog_jack);
    }

    public static ArrayList<Mascota> inicialiarListaKira(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.dog_kira), R.drawable.dog_kira);
    }

    public static ArrayList<Mascota> inicialiarListaLebre(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.dog_lebre), R.drawable.dog_lebre);
    }

    public static ArrayList<Mascota> inicialiarListaLolo(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.dog_lolo), R.drawable.dog_lolo);
    }

    public static ArrayList<Mascota> inicialiarListaRock(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.dog_rock), R.drawable.dog_rock);
    }

    public static ArrayList<Mascota> inicialiarListaSammy(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.dog_sammy), R.drawable.dog_sammy);
    }

    public static ArrayList<Mascota> inicialiarListaTile(Context context) {
        return inicialiarListaMascotaIndividual(context.getString(R.string.dog_tile), R.drawable.dog_tile);
    }


    public static ArrayList<Mascota> inicialiarListaMascotaIndividual(String nombre, int imagen) {

        ArrayList<Mascota> ListaMascotas = new ArrayList<Mascota>();

        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));
        ListaMascotas.add(new Mascota(nombre, imagen));

        return  ListaMascotas;
    }

}
