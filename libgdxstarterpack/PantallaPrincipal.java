package com.mygdx.libgdxstarterpack;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * En esta pantalla se declaran los elementos que se usaran en las demás pantallas tales como
 * un SpriteBatch, un ShapeRenderer y un OrthographicCamera.
 * La finalidad es que estos objetos se puedan usar en todas las demas pantallas, reutilizandolos
 * para ahorrar un poco de memoria.
 */
public class PantallaPrincipal extends Game {
    SpriteBatch batch;
    private ShapeRenderer sr;
    private OrthographicCamera camara;

    @Override
    public void create () {
        batch = new SpriteBatch();
        sr = new ShapeRenderer();
        camara = new OrthographicCamera();

        // Abriendo la pantalla de título
        setScreen(PantallaTitulo.getInstance(this));
    }

    @Override
    public void render () {
        super.render();
    }

    @Override
    public void dispose () {
        super.dispose();
    }

    // GETTERS
    public SpriteBatch getBatch() {
        return batch;
    }
    public ShapeRenderer getSr() {
        return sr;
    }
    public OrthographicCamera getCamara() {
        return camara;
    }
}
