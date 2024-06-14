package com.ekotomitl.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="buyer")
public class Buyer {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idbuyer")
	private int idbuyer;
	
	@OneToOne
	@JoinColumn(name="user_iduser") // the names must be IDENTICAL to the ones in the DB
	private User user;
	
	@OneToOne(mappedBy="buyer") 
	private Cart cart;
	
	@OneToMany(mappedBy="buyer", cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	private List<Orders> orders;

	public Buyer() {
		super();
	}

	public Buyer(int idbuyer, User user, Cart cart, List<Orders> orders) {
		super();
		this.idbuyer = idbuyer;
		this.user = user;
		this.cart = cart;
		this.orders = orders;
	}

	public int getIdbuyer() {
		return idbuyer;
	}

	public void setIdbuyer(int idbuyer) {
		this.idbuyer = idbuyer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Buyer [idbuyer=" + idbuyer + ", user=" + user + ", cart=" + cart + ", orders=" + orders + "]";
	}

	
}