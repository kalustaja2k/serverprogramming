package app;

import java.io.Serializable;

public class Candidates implements Serializable{
	
	
	private int ehdokas_id;
	private String sukunimi;
	private String etunimi;
	private String puolue;
	private String kotikunta;
	private int ika;
	private String ehdolle;
	private String edistaa;
	private String ammatti;
	
	
	public Candidates()
	{
		
	}
	public Candidates(String sukunimi, String etunimi, String puolue, String koti, int ika, String ehdolle, String edistaa, String ammatti)
	{
		this.sukunimi = sukunimi;
		this.etunimi = etunimi;
		this.puolue = puolue;
		this.kotikunta = koti;
		setIka(ika);
		this.ehdolle = ehdolle;
		this.edistaa = edistaa;
		this.ammatti = ammatti;
		
		
	}
	
	public Candidates(int ehdokas_id, String sukunimi, String etunimi, String puolue, String koti, int ika, String ehdolle, String edistaa, String ammatti)
	{
		setEhdokas_id(ehdokas_id);
		this.sukunimi = sukunimi;
		this.etunimi = etunimi;
		this.puolue = puolue;
		this.kotikunta = koti;
		setIka(ika);
		this.ehdolle = ehdolle;
		this.edistaa = edistaa;
		this.ammatti = ammatti;
		
	}
	
	public Candidates(String ehdokas_id, String sukunimi, String etunimi, String puolue, String koti, String ika, String ehdolle, String edistaa, String ammatti)
	{
		setEhdokas_id(ehdokas_id);
		this.sukunimi = sukunimi;
		this.etunimi = etunimi;
		this.puolue = puolue;
		this.kotikunta = koti;
		setIka(ika);
		this.ehdolle = ehdolle;
		this.edistaa = edistaa;
		this.ammatti = ammatti;
		
	}
	
	
	public Candidates(String sukunimi, String etunimi, String puolue, String koti, String ika, String ehdolle, String edistaa, String ammatti)
	{
		this.sukunimi = sukunimi;
		this.etunimi = etunimi;
		this.puolue = puolue;
		this.kotikunta = koti;
		setIka(ika);
		this.ehdolle = ehdolle;
		this.edistaa = edistaa;
		this.ammatti = ammatti;
		
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
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getPuolue() {
		return puolue;
	}
	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}
	public String getKotikunta() {
		return kotikunta;
	}
	public void setKotikunta(String kotikunta) {
		this.kotikunta = kotikunta;
	}
	public int getIka() {
		return ika;
	}
	public void setIka(int ika) {
		this.ika = ika;
	}
	
	public void setIka(String ika) {
		
		try {
			this.ika = Integer.parseInt(ika);
		}
		catch(NumberFormatException | NullPointerException e) {

		}
	}
	public String getEhdolle() {
		return ehdolle;
	}
	public void setEhdolle(String ehdolle) {
		this.ehdolle = ehdolle;
	}
	public String getEdistaa() {
		return edistaa;
	}
	public void setEdistaa(String edistaa) {
		this.edistaa = edistaa;
	}
	public String getAmmatti() {
		return ammatti;
	}
	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}
	public String toString() {
		return ehdokas_id+" "+sukunimi+" "+etunimi+" "+puolue+" "+kotikunta+" "+ika+" "+ehdolle+" "+edistaa+" "+ammatti;
	}
	
	

}
