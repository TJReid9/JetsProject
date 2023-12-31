package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private double price;
	
	public abstract void fly();
	
	public Jet() {
		
	}
	
	public Jet(String model, double speed, int range, double price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		
	}
		
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[Model: " + model + ", Speed: " + speed + ", Range: " + range + ", Price: " + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && range == other.range
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}


	
}
