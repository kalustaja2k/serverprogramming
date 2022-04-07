package app;

import java.io.Serializable;

public class Questions implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Kysymys_id;
	private String kysymys;
	
	public int getKysymys_id() {
		return Kysymys_id;
	}
	public void setKysymys_id(int Kysymys_id) {
		this.Kysymys_id = Kysymys_id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public void setKysymys_id(String Kysymys_id) {
		
		try {
			this.Kysymys_id = Integer.parseInt(Kysymys_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			
		}
	}
	public String toString() {
		return Kysymys_id+" "+kysymys;
	}
	
	public Questions() {
		
	}
	
	public Questions(int Kysymys_id, String kysymys) {
		setKysymys_id(Kysymys_id);
		this.Kysymys_id = Kysymys_id;
	}
	public Questions(String kysymys) {
		this.kysymys = kysymys;
	}
	public Questions(String kysymys_id, String kysymys) {
		this.kysymys=kysymys_id;
		this.kysymys=kysymys;
	}
	
}
