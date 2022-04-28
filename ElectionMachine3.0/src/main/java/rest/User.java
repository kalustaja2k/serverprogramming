package rest;

import java.io.Serializable;
//this is for login which is not finished yet

public class User implements Serializable{
	
	private int id;
    private String nimi;
    private String email;
    private String salasana;
    
    public User() {
    	
    }
    
	    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSalasana() {
		return salasana;
	}
	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}
	 
	
	     
	}

