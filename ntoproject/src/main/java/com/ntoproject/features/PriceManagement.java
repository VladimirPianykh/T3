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
				int price=Integer.parseInt(JOptionPane.showInputDialog("Какую цену поставить?"));
				for(PriceObject o:list)o.setPrice(price);
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,"Неверный формат");
			}
		})
			.setSlicer(price->((PriceObject)price).eventBacklink.toString());
		return f;
	}
}
