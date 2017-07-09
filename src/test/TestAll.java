package test;

import model.Game;
import model.GameFactory;
import model.GameFactoryConcreto1;

public class TestAll {
	public static void main(String []args)
	{
		GameFactory gameFactory = new GameFactoryConcreto1();
		Game gameSubject = Game.instance();
		gameSubject.setNivel(2);
		gameSubject.setGameFactory(gameFactory);
		gameSubject.initGame();
	}
}
