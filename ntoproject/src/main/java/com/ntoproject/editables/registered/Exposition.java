package com.ntoproject.editables.registered;

import java.util.ArrayList;

import com.bpa4j.core.Data;
import com.bpa4j.core.Data.Editable;
import com.bpa4j.defaults.input.SelectFromEditor;
import com.bpa4j.editor.EditorEntry;

public class Exposition extends Editable{
	public Exposition(){
		super("Нов Экспонат");
	}
	static{
		try{
			SelectFromEditor.configure(Exposition.class.getField("owner"),editable->{
				ArrayList<Studio>list=new ArrayList<>();
				Data.group(Studio.class).stream().forEach(list::add);
				list.add(null);
				return list;
			});
		}catch(Exception ex){
			throw new AssertionError(ex);
		}
	}
	@EditorEntry(translation="Владелец", editorBaseSource = SelectFromEditor.class)
	public Studio owner;
}
