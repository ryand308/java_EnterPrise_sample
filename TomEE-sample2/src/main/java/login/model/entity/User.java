package login.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import login.model.converter.LocalDateTimeAttributeConverter;

@Entity
@Table( name = "users")
public class User implements Serializable{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="user", length = 20)	
	private String user;
	@Column(name="account", length = 50, nullable = false, unique = true)
	private String account;
	@Column(name = "hashPossword", length = 150, nullable = false)
	private String hashPossword;
	@Column(name = "email", length = 50, nullable = false,unique = true)
	private String email;
	//--------------------------信箱認證-----------------------------------------------------
	@Column(name = "token", length = 100, nullable = false)
	private String token = UUID.randomUUID().toString();
	@Column( name ="date", columnDefinition = "TIMESTAMP")
	@Convert( converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime date = LocalDateTime.now().plusHours(6);
	@Column(name = "verified", columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE" )
	private boolean isVerified = false;
	
	public User() {
		super();
	}

	public User(int id, String user, String account, String hashPossword, String email, String token,
			LocalDateTime date, boolean isVerified) {
		super();
		this.id = id;
		this.user = user;
		this.account = account;
		this.hashPossword = hashPossword;
		this.email = email;
		this.token = token;
		this.date = date;
		this.isVerified = isVerified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getHashPossword() {
		return hashPossword;
	}

	public void setHashPossword(String hashPossword) {
		this.hashPossword = hashPossword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

		
}
