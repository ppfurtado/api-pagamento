package com.ppfurtado.apipagamento.exception;


import com.ppfurtado.apipagamento.utils.Properties;
import com.ppfurtado.apipagamento.utils.ResponseRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ResponseRest<String>> handleNotFound(NotFoundException e) {
		Properties properties = new Properties(-1, HttpStatus.NOT_FOUND, "Pagamento não encontrado");

		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ResponseRest<>(null, properties, e.getMessage()));
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<ResponseRest<String>> handleNegocioException(NegocioException e) {
		Properties properties = new Properties(-1, HttpStatus.BAD_REQUEST, "Erro ao inserir informações");

		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ResponseRest<>(null, properties, e.getMessage()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseRest<String>> handleException(Exception e) {
		Properties properties = new Properties();
		logger.error(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseRest<>(null, properties, e.getMessage()));
	}
}
