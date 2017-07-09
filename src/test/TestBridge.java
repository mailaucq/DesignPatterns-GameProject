package test;

import model.Game;
import model.Personaje;
import model.impl.Car;

public class TestBridge {
	public static void main(String [] args){
		Personaje car = new Car(Game.instance());
		car.init();
		car.move();
	}
}
