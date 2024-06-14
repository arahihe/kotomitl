package com.ekotomitl.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_has_product")
public class CartHasProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcart_has_product")
	private int idcart_has_product;
	
	@ManyToOne
	@JoinColumn(name = "cart_idcart")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "cart_buyer_idbuyer")
	private Buyer buyer;
	
	@ManyToOne
	@JoinColumn(name = "product_idproduct")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "product_category_idcategory")
	private Category category;

	public CartHasProduct() {
		super();
	}

	public CartHasProduct(int idcart_has_product, Cart cart, Buyer buyer, Product product, Category category) {
		super();
		this.idcart_has_product = idcart_has_product;
		this.cart = cart;
		this.buyer = buyer;
		this.product = product;
		this.category = category;
	}

	public int getIdcart_has_product() {
		return idcart_has_product;
	}

	public void setIdcart_has_product(int idcart_has_product) {
		this.idcart_has_product = idcart_has_product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CartHasProduct [idcart_has_product=" + idcart_has_product + ", cart=" + cart + ", buyer=" + buyer
				+ ", product=" + product + ", category=" + category + "]";
	}
}
