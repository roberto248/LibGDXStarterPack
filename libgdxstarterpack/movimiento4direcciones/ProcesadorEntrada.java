package com.mygdx.libgdxstarterpack.movimiento4direcciones;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.libgdxstarterpack.personajes.Entidad;

/**
 * Esta clase contiene métodos para que un personaje se mueva de manera fluida en las cuatro
 * direcciones: arriba, abajo, derecha, e izquierda.
 */
public class ProcesadorEntrada extends InputAdapter {
    Entidad personaje;

    // CONSTRUCTOR
    public ProcesadorEntrada(Entidad bender) {
        this.personaje = bender;
    }

    // MÉTODOS
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.RIGHT){
            personaje.moverDerecha();
        }
        if(keycode == Input.Keys.LEFT){
            personaje.moverIzquierda();
        }

        if(keycode == Input.Keys.UP){
            personaje.moverArriba();
        }

        if(keycode == Input.Keys.DOWN){
            personaje.moverAbajo();
        }

        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.RIGHT && !Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            personaje.parar();
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            personaje.moverIzquierda();
        }

        if(keycode == Input.Keys.LEFT && !Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            personaje.parar();
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            personaje.moverDerecha();
        }

        if(keycode == Input.Keys.UP && !Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            personaje.pararVert();
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            personaje.moverAbajo();
        }

        if(keycode == Input.Keys.DOWN && !Gdx.input.isKeyPressed(Input.Keys.UP)){
            personaje.pararVert();
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            personaje.moverArriba();
        }

        return super.keyUp(keycode);
    }
}
