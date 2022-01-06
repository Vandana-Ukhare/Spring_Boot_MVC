package com.vandu.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

public class LocalDateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
System.out.println("LocalDateEditor.setAsText()");
String dateContent[]=text.split("-");
int year=Integer.parseInt(dateContent[0]);
int month=Integer.parseInt(dateContent[1]);
int day=Integer.parseInt(dateContent[2]);
LocalDate ld=LocalDate.of(year, month, day);
setValue(ld);
	}

}
