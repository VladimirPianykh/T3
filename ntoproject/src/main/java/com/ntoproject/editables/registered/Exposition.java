package com.ntoproject.editables.registered;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.editor.EditorEntry;

public class Exposition extends Editable{
	public Exposition(){
		super("Нов Экспонат");
	}

	@EditorEntry(translation="Владелец")
	public String owner;
	@EditorEntry(translation="Преподаватель")
	public String teacher;

}
