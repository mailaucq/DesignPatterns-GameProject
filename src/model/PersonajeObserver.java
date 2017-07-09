package model;

import javax.media.opengl.GL2;

/**
 * Patron Observer
 * -Observer
 * @author XD
 *
 */
public abstract class PersonajeObserver {
	public abstract void draw(GL2 gl);
	/**
	 * Los personajes enemigos actualizan sus movimientos cuando 
	 * son notificados por GameSubject
	 * @see model.GameSubject#notifyEnemies()
	 */
	public abstract void updateMovesNotified();
	/**
	 * Todos los Personajes actualizan su estado cuando 
	 * son notificados por GameSubject
	 * @see model.GameSubject#init()
	 */
	public abstract void initNotified();
	/**
	 * @see model.GameSubject#pause()
	 */
	public abstract void pauseNotified();
	/**
	 * @see model.GameSubject#gameover()
	 */
	public abstract void gameoverNotified();
	/**
	 * @see model.GameSubject#levelComplete()
	 */
	public abstract void levelCompleteNotified();
	/**
	 * @see model.GameSubject#hurt()
	 */
	public abstract void hurtNotified();
	/**
	 * @see model.GameSubject#visible()
	 */
	public abstract void visibleNotified();
	/**
	 * @see model.GameSubject#invisible()
	 */
	public abstract void invisibleNotified();
}
