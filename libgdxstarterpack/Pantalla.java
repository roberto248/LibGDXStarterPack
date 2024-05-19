package com.mygdx.libgdxstarterpack;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

/**
 * Esta clase implementa las interfaces Screen e InputProcessor, reescribiendo todos los métodos
 * obligatorios en blanco.
 * Su finalidad es que otras clases extiendan de esta y reescriban SOLO aquellos métodos que
 * necesiten usar, dejando un codigo más limpio y legible.
 */
public class Pantalla implements Screen, InputProcessor {
    /*=============================== MÉTODOS DE SCREEN ==========================================*/
    @Override
    public void show() {}

    @Override
    public void render(float delta) {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}

    /*=============================== MÉTODOS DE INPUTPROCESOR ===================================*/
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
