package org.jsp.rest_crud.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataNotFoundException extends RuntimeException{
	String message = "Data not found";
}
