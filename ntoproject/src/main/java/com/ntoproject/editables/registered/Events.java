package com.ntoproject.editables.registered;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.bpa4j.core.Data;
import com.bpa4j.core.Data.Editable;
import com.bpa4j.defaults.input.SelectFromEditor;
import com.bpa4j.editor.EditorEntry;

public class Events extends Editable{
    
    public Events(){
        super("Новое мероприятие");

    }

    @EditorEntry(translation="Дата проведения")
    public LocalDate date;
    @EditorEntry(translation="Тип")
    public TypeOfEvents typeOfEvents;
    @EditorEntry(translation="Дата начала")
    public LocalDateTime dateStart;
    @EditorEntry(translation="Дата окончания")
    public LocalDateTime dateFinish;
    @EditorEntry(translation="Количество поситителей")
    public int visitors;
    @EditorEntry(translation="Пространство")
    public Space space;
    @EditorEntry(translation="Платно")
    public boolean cost;
    @EditorEntry(translation="Описание")
    public String description;

}