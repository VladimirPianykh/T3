package com.ntoproject.editables.registered;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.editor.EditorEntry;

public class Studio extends Editable{
	public Studio(){
		super("Нов Студия");
	}
	@EditorEntry(translation="Описание")
	public String description;

}
