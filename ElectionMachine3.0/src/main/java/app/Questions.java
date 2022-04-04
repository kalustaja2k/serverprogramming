package app;

public class Questions {
	
	private int id;
	private String kysymys;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public void setId(String id) {
		
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {

		}
	}
	public Questions() {
		
	}
	
	public Questions(int id, String kysymys) {
		setId(id);
		this.kysymys = kysymys;
	}
	public Questions(String kysymys) {
		this.kysymys = kysymys;
	}
	
}
