package com.mygdx.libgdxstarterpack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Esta es la primera pantalla que aparecerá. Está pensada para ser una pantalla con el titulo del
 * juego y algún otro dato que se desee mostrar.
 */
public class PantallaTitulo extends Pantalla{

    private final PantallaPrincipal PANTALLA_PRINCIPAL;
    private static PantallaTitulo instancia;

    // CONSTANTES
    private final int SEGS_CREAR_ = 1;

    // ATRIBUTOS
    private OrthographicCamera camara;

    private SpriteBatch batch;
    private ShapeRenderer sr;
    private BitmapFont fuente = new BitmapFont();

    float stateTime, stateTimeCrear;

    // CONSTRUCTOR CON SINGLETON ===================================================================
    private PantallaTitulo(PantallaPrincipal pantallaPrincipal) {
        this.PANTALLA_PRINCIPAL = pantallaPrincipal;
    }
    public static PantallaTitulo getInstance(PantallaPrincipal pantallaPrincipal){

        if(instancia == null){
            instancia = new PantallaTitulo(pantallaPrincipal);
        }
        return instancia;
    }

    // Procesador de entrada =======================================================================
    @Override
    public boolean keyDown(int keycode) {
        // Al pulsar una tecla se abre una nueva pantalla
        PANTALLA_PRINCIPAL.setScreen(PantallaJuego.getInstance(PANTALLA_PRINCIPAL));

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

        stateTime = stateTimeCrear = 0;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);

        // CONTROL DEL TIEMPO
        stateTime += delta;

        // Dibujar Pantalla
        sr.begin(ShapeRenderer.ShapeType.Line);
        batch.begin();

	    // ESCRIBE_EL_CODIGO_AQUÍ

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
