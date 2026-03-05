package com.ntoproject.editables.registered;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.core.EditableDemo;
import com.bpa4j.editor.EditorEntry;
import com.bpa4j.editor.Input;
import com.ntoproject.editables.auxil.PriceObject;

@Input(verifier = Event.Verifier.class)
public class Event extends Editable{
	public static class Verifier implements com.bpa4j.editor.Verifier{
		public String verify(Editable original,Editable editable,boolean isNew){
			Event e=(Event)editable;
			if(e.visitors>e.space.capacity)return "Посетителей слишком много";
			Event eOrg=((Event)original);
			for(int i=0;i<e.space.capacity;++i)
				eOrg.prices.add(new PriceObject(eOrg,i+1,1));
			return "";
		}
	}
	public Event(){
		super("Новое мероприятие");

	}

	@EditorEntry(translation="Дата проведения")
	public LocalDate date;
	@EditorEntry(translation="Тип")
	public EventType typeOfEvents;
	@EditorEntry(translation="Дата начала")
	public LocalDateTime dateStart;
	@EditorEntry(translation="Дата окончания")
	public LocalDateTime dateFinish;
	@EditorEntry(translation="Количество поситителей")
	public int visitors;
	@EditorEntry(translation="Пространство")
	public Space space;
	@EditorEntry(translation="Платно")
	public boolean isPaid;
	@EditorEntry(translation="Описание")
	public String description;

	//Цены, если мероприятие платное. Не отображается, т. к. не помечено EditorEntry.
	public ArrayList<PriceObject>prices=new ArrayList<>();
}