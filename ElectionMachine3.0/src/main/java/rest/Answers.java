package rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int kysymys_id;
	private int ehdokas_id;
	private int vastaus;
	private String kommentti;
	
	
	
	public Answers() {
		
	}
	public Answers(int kysymys_id, int ehdokas_id, int vastaus, String kommentti) {
		setKysymys_id(kysymys_id);
		this.kysymys_id=kysymys_id;
		setEhdokas_id(ehdokas_id);
		this.ehdokas_id=ehdokas_id;
		this.vastaus=vastaus;
		this.kommentti=kommentti;
	}
	public int getKysymys_id() {
		return kysymys_id;
	}
	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public void setKysymys_id(String Kysymys_id) {
		
		try {
			this.kysymys_id = Integer.parseInt(Kysymys_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			
		}
	}
	public int getEhdokas_id() {
		return ehdokas_id;
	}
	public void setEhdokas_id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}
	public void setEhdokas_id(String ehdokas_id) {
		
		try {
			this.ehdokas_id = Integer.parseInt(ehdokas_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			
		}
	}
	public int getVastaus() {
		return vastaus;
	}
	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}
	public String getKommentti() {
		return kommentti;
	}
	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}
	public String toString() {
		return kysymys_id+" "+ehdokas_id+" "+vastaus+" "+kommentti;
	}

}
