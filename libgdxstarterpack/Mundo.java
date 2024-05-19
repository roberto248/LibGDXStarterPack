package com.mygdx.libgdxstarterpack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * En esta clase se establecen cualquier tipo de datos de del juego: tamaño del mundo o entidades,
 * velocidad o posición inicial de las entidades etc.
 * Estos datos deberian estar accesibles desde cualquier parte del programa y ser inmutables.
 */
public class Mundo {
    public static final boolean MODO_DEBUG = true;

    public static final int ANCHO_MUNDO = 332;
    public static final int ALTO_MUNDO = 200;


    // Archivo con las mejores puntuaciones del juego
    public static final Preferences RECORDS = Gdx.app.getPreferences("com.mygdx.bichos.records.prefs");


}
