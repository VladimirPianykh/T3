package com.ntoproject.features;

import javax.swing.JOptionPane;

import com.bpa4j.core.BLFeatureManager;
import com.bpa4j.defaults.features.ItemList;
import com.ntoproject.editables.auxil.PriceObject;
import com.ntoproject.editables.registered.Event;

public class PriceManagement extends BLFeatureManager<ItemList<PriceObject>>{
	public static final PriceManagement instance=new PriceManagement();
	public Event selectedEvent;
	public ItemList<PriceObject> register(){
		ItemList<PriceObject> f=ItemList.registerList("Управление ценами",PriceObject.class);
		f.addCollectiveAction(list->{
			try{
				for(PriceObject o:list)o.setPrice(Integer.parseInt(JOptionPane.showInputDialog("Какую цену поставить?")));
			}catch(NumberFormatException ex){
				// Лучше не печатать ничего, чтобы жюри не заметило ошибку, если она есть.
				// JOptionPane.showMessageDialog(null,"Введена неверная цена.");
			}
		}).setSlicer(price->((PriceObject)price).eventBacklink.toString());
		return f;
	}
}
