package com.experimentality.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	/**
	 * Función que retorna la excepción de cualquier tipo bajo el formato establecido internamente 
	 * retornado el error 406 por defecto
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> HandlerException(Exception e){
		Map<String, String> response = new HashMap<>();
		response.put("error", e.getMessage());
		response.put("exception_type", e.getClass().getSimpleName());
		return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Función que retorna la excepción en caso de encontrar inconsistecias en la estructura de los 
	 * objetos a nivel de entidades
	 * @param e
	 * @return
	 */
	@ExceptionHandler(JpaObjectRetrievalFailureException.class)
	public ResponseEntity<?> DataException(Exception e){
		Map<String, String> response = new HashMap<>();
		response.put("Not_Found", "El id ingresado no se encuentra registrado en la base de datos");
		response.put("error", e.getMessage());
		response.put("exception_type", e.getClass().getSimpleName());
		String[] messageFull = e.getLocalizedMessage().split(" ");
		String[] attribute = messageFull[3].split("\\.");
		String value = attribute[attribute.length-1];
		response.put(value, "El objeto no existe");
		return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Función que retorna la excepción cuando se encuentran errores en la operación de base de datos,
	 * por ejemplo en tareas crud
	 * @param e
	 * @return
	 */
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<?> DataAccessException(DataAccessException e){
		Map<String, String> response = new HashMap<>();
		response.put("mensaje", "Error al realizar la operación en la base de datos");
		response.put("Error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
		return new ResponseEntity<Map<String, String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
}
