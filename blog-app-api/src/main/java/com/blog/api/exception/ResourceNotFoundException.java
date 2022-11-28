package com.blog.api.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
String resourseName;
String fieldName;
long fieldValue;
public ResourceNotFoundException(String resourseName, String fieldName, long fieldValue) {
	super(String.format("%s not found with %s : %l", resourseName,fieldName,fieldValue));
	this.resourseName = resourseName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
}

}
