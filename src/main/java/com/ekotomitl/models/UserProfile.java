package com.ekotomitl.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserProfile")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iduser_profile")
	private int iduser_profile;
	
	@OneToOne
	@JoinColumn(name="user_iduser")
	private User user;

	public UserProfile() {
		super();
	}

	public UserProfile(int iduser_profile, User user) {
		super();
		this.iduser_profile = iduser_profile;
		this.user = user;
	}

	public int getIduser_profile() {
		return iduser_profile;
	}

	public void setIduser_profile(int iduser_profile) {
		this.iduser_profile = iduser_profile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserProfile [iduser_profile=" + iduser_profile + ", user=" + user + "]";
	}
}