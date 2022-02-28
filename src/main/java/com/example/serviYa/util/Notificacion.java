/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
/**
 *
 * @author daihan
 */
public class Notificacion {
    
    private List<String> errors = new ArrayList<>();

	public void addError(String message) {
		errors.add(message);
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public String getError() {
		return StringUtils.capitalize(StringUtils.collectionToCommaDelimitedString(errors));
	}

	public String getError(String delimiter) {
		return StringUtils.capitalize(StringUtils.collectionToDelimitedString(errors, delimiter));
	}
    
}
