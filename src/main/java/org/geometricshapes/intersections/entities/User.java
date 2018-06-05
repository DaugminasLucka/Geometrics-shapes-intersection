package org.geometricshapes.intersections.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Mindaugas Lucka
 *
 */
@Entity
public class User {

	public static final PasswordEncoder PASSWORDENCODED = new BCryptPasswordEncoder();
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@Column(nullable = false)
	private String username;
    @JsonIgnore
    @Column(nullable = false)
    private String password;
	
    public User() {
    	super();
    }
    
    public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
    
    public void setPassword(String password) {
        this.password = password;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
