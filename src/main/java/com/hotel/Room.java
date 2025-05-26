package com.hotel;

public class Room {
	private int number;
	private String type;
	private String status;
	private double price;

	public Room(int number, String type, String status, double price) {
		this.number = number;
		this.type = type;
		this.status = status;
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public double getPrice() {
		return price;
	}
}
