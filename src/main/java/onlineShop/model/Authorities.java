package onlineShop.model;

import java.io.Serializable;
import javax.persistence.Entity; //table
import javax.persistence.GeneratedValue; //use for generated pk
import javax.persistence.GenerationType; //types for GeneratedValue
import javax.persistence.Id; //define pk in entity bean
import javax.persistence.Table; // set table name

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable{
	private static final long serialVersionUID = 8734140534986494039L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String emailId;
	private String authorities;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	
	
	
	

}
