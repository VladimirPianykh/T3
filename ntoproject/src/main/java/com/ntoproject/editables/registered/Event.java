package com.ntoproject.editables.registered;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.editor.EditorEntry;
import com.ntoproject.editables.auxil.PriceObject;

public class Event extends Editable{
	public static class Verifier implements com.bpa4j.editor.Verifier{
		public String verify(Editable original,Editable editable,boolean isNew){
			Event e=(Event)editable;
			if(e.visitors>e.space.capacity)return "Слишком маленькое пространство!";
			return ""; //Ok
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