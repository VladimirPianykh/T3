package com.ntoproject.editables.registered;

import java.util.ArrayList;

import com.bpa4j.core.Data.Editable;
import com.bpa4j.defaults.input.SelectFromEditor;
import com.bpa4j.editor.EditorEntry;

public class Exposition extends Editable{
	public Exposition(){
		super("Нов Экспонат");
	}
	static {
		SelectFromEditor.configure(Exposition.class.getField("owner"), ()->{return new ArrayList<>();});
	}
	@EditorEntry(translation="Владелец", editorBaseSource = SelectFromEditor.class)
	public Studio owner;
}
