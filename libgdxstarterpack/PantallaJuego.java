package com.mygdx.libgdxstarterpack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Esta pantalla podría ser el juego principal o una pantalla más de este.
 */
public class PantallaJuego extends Pantalla{
    private final PantallaPrincipal PANTALLA_PRINCIPAL;
    private static PantallaJuego instancia;

    // CONSTANTES
    private final int SEGS_CREAR_ = 1;

    // ATRIBUTOS
    private OrthographicCamera camara;

    private SpriteBatch batch;
    private ShapeRenderer sr;
    private BitmapFont fuente = new BitmapFont();

    float stateTime;

    // CONSTRUCTOR CON SINGLETON ===================================================================
    private PantallaJuego(PantallaPrincipal pantallaPrincipal) {
        this.PANTALLA_PRINCIPAL = pantallaPrincipal;
    }
    public static PantallaJuego getInstance(PantallaPrincipal pantallaPrincipal){

        if(instancia == null){
            instancia = new PantallaJuego(pantallaPrincipal);
        }
        return instancia;
    }

    // Procesador de entrada =======================================================================
    @Override
    public boolean keyDown(int keycode) {
        // CÓDIGO_QUE_SE_EJECUTA_AL_PULSAR_UNA_TECLA

        return super.keyDown(keycode);
    }

    // MÉTODOS DE SCREEN ===========================================================================
    @Override
    public void show() {
        camara = PANTALLA_PRINCIPAL.getCamara();
        batch = PANTALLA_PRINCIPAL.getBatch();
        sr = PANTALLA_PRINCIPAL.getSr();

        fuente.setColor(Color.BLACK);
        fuente.getData().setScale(1f);

        Gdx.input.setInputProcessor(this);

        stateTime = 0;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);

        // CONTROL DEL TIEMPO
        stateTime += delta;

        // Dibujar Pantalla
        sr.begin(ShapeRenderer.ShapeType.Line);
        batch.begin();

        // ESCRIBE_EL_CÓDIGO_AQUÍ

        batch.end();
        sr.end();
    }

    @Override
    public void resize(int width, int height) {
        camara.setToOrtho(false, Mundo.ANCHO_MUNDO, Mundo.ALTO_MUNDO);
        batch.setProjectionMatrix(camara.combined);
        sr.setProjectionMatrix(camara.combined);
        camara.update();
    }

    @Override
    public void dispose() {
        batch.dispose();
        sr.dispose();
        fuente.dispose();
    }
}
