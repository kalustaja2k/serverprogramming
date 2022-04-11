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
			count=stmt.executeUpdate("insert into ehdokkaat(ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika,"
					+ " miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti)"
					+ " values('"+candidate.getEhdokas_id()+"','"+candidate.getSukunimi()+"','"+candidate.getEtunimi()+"','"
					+candidate.getPuolue()+"','"+candidate.getKotikunta()+"','"
			+candidate.getIka()+"','"+candidate.getEhdolle()+"','"+candidate.getEdistaa()+"','"+candidate.getAmmatti()+"')");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
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
				candidate.setEhdokas_id(rs.getInt("ehdokas_Id"));
				candidate.setEtunimi(rs.getString("etunimi"));
				candidate.setSukunimi(rs.getString("sukunimi"));
				candidate.setPuolue(rs.getString("puolue"));
				candidate.setKotikunta(rs.getString("kotipaikkakunta"));
				candidate.setIka(rs.getInt("ika"));
				candidate.setEhdolle(rs.getString("miksi_eduskuntaan"));
				candidate.setEdistaa(rs.getString("mita_asioita_haluat_edistaa"));
				candidate.setAmmatti(rs.getString("ammatti"));
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
		String sql = "update ehdokkaat set etunimi = ?, sukunimi = ?, puolue = ?, kotipaikkakunta = ?, ika = ?,"
				+ "miksi_eduskuntaan = ?, mita_asioita_haluat_edistaa = ?, ammatti= ?"
				+ " where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, candidate.getEtunimi());
			stmt.setString(2, candidate.getSukunimi());
			stmt.setInt(9, candidate.getEhdokas_id());
			stmt.setString(3, candidate.getPuolue());
			stmt.setString(4, candidate.getKotikunta());
			stmt.setInt(5, candidate.getIka());
			stmt.setString(6, candidate.getEhdolle());
			stmt.setString(7, candidate.getEdistaa());
			stmt.setString(8, candidate.getAmmatti());
			
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
				result.setEhdokas_id(resultset.getInt("ehdokas_id"));
				result.setEtunimi(resultset.getString("etunimi"));
				result.setSukunimi(resultset.getString("sukunimi"));
				result.setPuolue(resultset.getString("puolue"));
				result.setKotikunta(resultset.getString("kotipaikkakunta"));
				result.setIka(resultset.getInt("ika"));
				result.setEhdolle(resultset.getString("miksi_eduskuntaan"));
				result.setEdistaa(resultset.getString("mita_asioita_haluat_edistaa"));
				result.setAmmatti(resultset.getString("ammatti"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int saveQuestion(Questions question) {
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate("insert into kysymykset(kysymys_id, kysymys) values('"+question.getKysymys_id()+"','"+question.getKysymys()+"')");
			
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
				question.setKysymys_id(rs.getInt("kysymys_id"));
				question.setKysymys(rs.getString("kysymys"));
				list.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}
	
	public int updateQuestion(Questions question) {
		int count = 0;
		String sql = "update kysymykset set kysymys = ? where kysymys_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			
			stmt.setString(1, question.getKysymys());
			stmt.setInt(2, question.getKysymys_id());
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return count;
	}
	
public int deleteQuestion(int Kysymys_id) throws SQLException {
		
		int count = 0;
		String sql = "DELETE from kysymykset WHERE kysymys_id=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, Kysymys_id);
			
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

public Questions getQuestionInfo(int kysymys_id) {
	Questions result = null;
	String sql = "select * from kysymykset where kysymys_id = ?";
	try {
		PreparedStatement stmt = conn.prepareStatement(sql);
					
		stmt.setInt(1, kysymys_id);
		
		ResultSet resultset = stmt.executeQuery();
		
		if (resultset.next()) {
			result = new Questions();
			result.setKysymys_id(resultset.getInt("kysymys_id"));
			result.setKysymys(resultset.getString("kysymys"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return result;
}

public void addUser(String username, String pw, String salt) {
	String sql = "insert into kirjautuminen (email, salasana, nimi) values (?,?,?)";
	
	try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, username);
		stmt.setString(2, pw);
		stmt.setString(3, salt);
		
		stmt.executeUpdate();
	}
	catch (SQLException e) {
		e.printStackTrace();
		
	}
	
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
     user.setNimi(result.getString("nimi"));
     user.setEmail(email);
 } 

 conn.close();

 return user;
}
}
