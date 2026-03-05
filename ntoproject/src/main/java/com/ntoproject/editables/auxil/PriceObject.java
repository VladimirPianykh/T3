package com.ntoproject.editables.auxil;

import java.io.Serializable;

import com.ntoproject.editables.registered.Event;

public class PriceObject implements Serializable{
	private int placeNum;
	private int price;
	public final Event eventBacklink;
	public PriceObject(Event event,int placeNum,int price){
		eventBacklink=event;
		this.placeNum=placeNum;
		this.price=price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public String toString() {
		return "#"+placeNum+" за "+ price+" руб. на "+eventBacklink.name;
	}
}
