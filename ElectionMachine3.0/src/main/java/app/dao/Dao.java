package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.User;

import app.Candidates;
import app.Questions;


public class Dao {

	private Connection conn;

	
	// When new instance is created, also DB-connection is created
	public Dao() {
		try {
			// com.mysql.cj.jdbc.Driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	// Manually close DB-connection for releasing resource
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int saveCandidate(Candidates candidate) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			//count=stmt.executeUpdate("insert into ehdokkaat(ehdokas_id, etunimi, sukunimi, puolue, ikä, kotipaikkakunta, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) "
			//		+ "values('"+candidate.getEhdokas_id()+"', '"+candidate.getEtunimi()+"' '"+candidate.getSukunimi()+"' '"+candidate.getPuolue()+" '"+candidate.getKotikunta()+"'"
			//				+ "'"+candidate.getAmmatti()+"''"+candidate.getIka()+"' '"+candidate.getEhdolle()+"' '"+candidate.getEdistaa()+"')");
			//count=stmt.executeUpdate("insert into ehdokkaat(ehdokas_id, etunimi, sukunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) "
			//				+"values('"+candidate.getEhdokas_id()+"', '"+candidate.getEtunimi()+"' '"+candidate.getSukunimi()+"' '"+candidate.getPuolue()+" '"+candidate.getKotikunta()+"'"
			//				+ "'"+candidate.getIka()+"''"+candidate.getEhdolle()+"' '"+candidate.getEdistaa()+"' '"+candidate.getAmmatti()+"')");
			//count=stmt.executeUpdate("insert into ehdokkaat(ehdokas_id, etunimi, sukunimi, puolue, ikä, kotipaikkakunta, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) "
			// + "values('"+candidate.getEhdokas_id()+"', '"+candidate.getEtunimi()+"' '"+candidate.getSukunimi()+"' '"+candidate.getPuolue()+" '"+candidate.getKotikunta()+"'"
			// + "'"+candidate.getAmmatti()+"''"+candidate.getIka()+"' '"+candidate.getEhdolle()+"' '"+candidate.getEdistaa()+"')");
			count=stmt.executeUpdate("insert into ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values('"+candidate.getEhdokas_id()+"'"+candidate.getSukunimi()+"'"+candidate.getEtunimi()+"'"+candidate.getPuolue()+"'"+candidate.getKotikunta()+"'"
			+"'"+candidate.getIka()+"'"+candidate.getEhdolle()+"'"+candidate.getEdistaa()+"'"+candidate.getAmmatti()+"')");
			//count=stmt.executeUpdate("insert into ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values("+candidate.getEhdokas_id()+candidate.getSukunimi()+candidate.getEtunimi()+candidate.getPuolue()+candidate.getKotikunta()
			//+candidate.getIka()+candidate.getEhdolle()+candidate.getEdistaa()+candidate.getAmmatti()+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public ArrayList<Questions> readAllQuestions() {
		ArrayList<Questions> list=new ArrayList<>();
		Statement stmt=null;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from kysymykset");
			while (rs.next()) {
				Questions question=new Questions();
				question.setKysymys_id(rs.getInt("Kysymys_id"));
				question.setKysymys(rs.getString("Kysymys"));
				list.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}
	
	public ArrayList<Candidates> readAllCandidates() {
		ArrayList<Candidates> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Candidates candidate=new Candidates();
				candidate.setEhdokas_id(rs.getInt("Ehdokas_Id"));
				candidate.setEtunimi(rs.getString("Etunimi"));
				candidate.setSukunimi(rs.getString("Sukunimi"));
				candidate.setPuolue(rs.getString("Puolue"));
				candidate.setKotikunta(rs.getString("Kotipaikkakunta"));
				candidate.setIka(rs.getInt("Ika"));
				candidate.setEhdolle(rs.getString("Miksi_eduskuntaan"));
				candidate.setEdistaa(rs.getString("Mita_asioita_haluat_edistaa"));
				candidate.setAmmatti(rs.getString("Ammatti"));
				list.add(candidate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateCandidate(Candidates candidate) {
		int count = 0;
		String sql = "update ehdokkaat set etunimi = ?, sukunimi = ? where ehdokas_id = ? where puolue =? where kotipaikkakunta =?"
				+ "where ika = ? where miksi_eduskuntaan = ? where mita_asioita_haluat_edistaa = ? where ammatti = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, candidate.getEtunimi());
			stmt.setString(2, candidate.getSukunimi());
			stmt.setInt(3, candidate.getEhdokas_id());
			stmt.setString(4, candidate.getPuolue());
			stmt.setString(5, candidate.getKotikunta());
			stmt.setInt(6, candidate.getIka());
			stmt.setString(7, candidate.getEhdolle());
			stmt.setString(8, candidate.getEdistaa());
			stmt.setString(9, candidate.getAmmatti());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return count;
	}
	
	public int deleteCandidate(int Ehdokas_id) throws SQLException {
		
		int count = 0;
		String sql = "DELETE from ehdokkaat WHERE Ehdokas_id=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, Ehdokas_id);
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	
	public Candidates getCandidateInfo(int id) {
		Candidates result = null;
		String sql = "select * from ehdokkaat where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setInt(1, id);
			
			ResultSet resultset = stmt.executeQuery();
			
			if (resultset.next()) {
				result = new Candidates();
				result.setEhdokas_id(resultset.getInt("Ehdokas_id"));
				result.setEtunimi(resultset.getString("Etunimi"));
				result.setSukunimi(resultset.getString("Sukunimi"));
				result.setPuolue(resultset.getString("Puolue"));
				result.setKotikunta(resultset.getString("Kotipaikkakunta"));
				result.setIka(resultset.getInt("ika"));
				result.setEhdolle(resultset.getString("Miksi_eduskuntaan"));
				result.setEdistaa(resultset.getString("Mita_asioita_haluat_edistaa"));
				result.setAmmatti(resultset.getString("Ammatti"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	 public User checkLogin(String email, String password) throws SQLException,
     ClassNotFoundException {
 String sql = "SELECT * FROM kirjautuminen WHERE nimi = ? and salasana = ?";
 PreparedStatement statement = conn.prepareStatement(sql);
 statement.setString(1, email);
 statement.setString(2, password);

 ResultSet result = statement.executeQuery();

 User user = null;

 if (result.next()) {
     user = new User();
     user.setNimi(result.getString("Nimi"));
     user.setEmail(email);
 } 

 conn.close();

 return user;
}
}
