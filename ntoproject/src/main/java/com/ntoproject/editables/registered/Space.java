package com.ntoproject.editables.registered;

import java.util.ArrayList;
import java.util.List;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.defaults.input.FlagWEditor;
import com.bpa4j.defaults.input.SelectFromEditor;
import com.bpa4j.editor.EditorEntry;

public class Space extends Editable{
	public static enum Location{
		PARETER("Партер",9,35),
		AMPHI("Амфитеатр",8,30),
		BALCON("Балкон",9,40);
		private String translation;
		private Location(String translation,int rows,int placesPerRow){
			this.translation=translation;
			this.rows=rows;
			this.placesPerRow=placesPerRow;
		}
		public String toString(){return translation;}
	}
	public Space(){
		super("Нов Пространство");
	}
	@EditorEntry(translation="Описание")
	public String description;
	@EditorEntry(translation="Вместимость")
	public int capacity;
	static{
		try{
			SelectFromEditor.configure(
				Space.class.getField("locations"),
				editable->new ArrayList<>(List.of(Location.values()))
			);
			FlagWEditor.configure(Space.class.getField("locations"),SelectFromEditor.class,null,()->new ArrayList<>());
		}catch(Exception ex){throw new RuntimeException(ex);}
	}
	@EditorEntry(translation="Локации",editorBaseSource = FlagWEditor.class)
	public ArrayList<Location>locations;
}
