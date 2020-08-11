package com.example.demo;

public class Account {
	
	private String value;
	
	private String name;
	
	public Account(String name)
	{
		this.name = name;
	}
	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	private Account() {
        //Constructor is now private.
    }
	
	
	public static class Builder 
	{
		private String value;
		
		private String name;
		


		public Builder setValue(String value)
		{
			this.value = value;
			return this;
			
		}
		
		 public Account build(){
	            //Here we create the actual bank account object, which is always in a fully initialised state when it's returned.
	            Account account = new Account();  //Since the builder is in the BankAccount class, we can invoke its private constructor.
	            account.name = name;
	            account.value = value;
	            return account;
	        }
	}

}
