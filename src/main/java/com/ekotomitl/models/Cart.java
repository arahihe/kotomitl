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
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcart")
	private int idcart;

	@OneToOne
	@JoinColumn(name="buyer_idbuyer")
	private Buyer buyer;
	
	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<CartHasProduct> cartHasProduct;

	public Cart() {
		super();
	}

	public Cart(int idcart, Buyer buyer, List<CartHasProduct> cartHasProduct) {
		super();
		this.idcart = idcart;
		this.buyer = buyer;
		this.cartHasProduct = cartHasProduct;
	}

	public int getIdcart() {
		return idcart;
	}

	public void setIdcart(int idcart) {
		this.idcart = idcart;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public List<CartHasProduct> getCartHasProduct() {
		return cartHasProduct;
	}

	public void setCartHasProduct(List<CartHasProduct> cartHasProduct) {
		this.cartHasProduct = cartHasProduct;
	}

	@Override
	public String toString() {
		return "Cart [idcart=" + idcart + ", buyer=" + buyer + ", cartHasProduct=" + cartHasProduct + "]";
	}

		
}
