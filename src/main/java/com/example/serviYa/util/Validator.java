/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.serviYa.util;

/**
 *
 * @author daihan
 */
public interface Validator<T> {

	/**
	 *  * <a href="http://martinfowler.com/articles/replaceThrowWithNotification.html">Replacing Throwing Exceptions with Notification in Validations</a> via Martin Fowler
	 * @param t
	 * @return
	 */
	Notificacion validate(T t) throws IllegalAccessException;
}
