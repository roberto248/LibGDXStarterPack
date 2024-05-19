package com.mygdx.libgdxstarterpack.personajes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Una clase que define a una entidad genérica. Otros personajes mas especificos pueden extender
 * de esta clase que continene datos y metodos basicos.
 */
public abstract class Entidad {
    // CONSTANTES
    protected static final int PARADO = 0;
    protected static final int DERECHA = 1;
    protected static final int IZQUIERDA = -1;
    protected static final int ARRIBA = 1;
    protected static final int ABAJO = -1;

    protected float velocidad;
    protected Rectangle hitbox;

    // ATRIBUTOS
    protected float x, y;
    protected float ancho, alto;
    protected int estadoHori; // Estado del movimiento horizontal
    protected int estadoVert; // Estado del movimiento vertical

    // CONSTRUCTOR
    public Entidad(float x, float y, float ancho, float alto, float velocidad) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.estadoHori = this.estadoVert = 0;
        this.velocidad = velocidad;
        hitbox = new Rectangle(x,y,ancho,alto);
    }

    // MÉTODOS
    abstract public void actualizarEstado(float delta);
    abstract public void dibujar(SpriteBatch batch, ShapeRenderer sr);

    // MOVIMIENTO
    public void moverDerecha(){
        estadoHori = DERECHA;
    }
    public void moverIzquierda(){
        estadoHori = IZQUIERDA;
    }
    public void moverArriba(){
        estadoHori = ARRIBA;
    }
    public void moverAbajo(){
        estadoHori = ABAJO;
    }
    public void parar(){
        estadoHori = PARADO;
    }
    public void pararVert(){
        estadoVert = PARADO;
    }

    // GETTERS
    public Rectangle getHitbox() {
        return hitbox;
    }
}
