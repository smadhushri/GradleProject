package com.capgemini.exceptions;

public class InsufficientBalanceException extends Exception{

	String msg;
	
	public InsufficientBalanceException(){
		
	}
	
	public InsufficientBalanceException(String msg){
		this.msg = msg;
	}
}
