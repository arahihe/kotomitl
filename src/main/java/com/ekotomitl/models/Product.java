package com.ekotomitl.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idproduct")
    private int idproduct;

    @ManyToOne
    @JoinColumn(name="category_idcategory", nullable=false)
    private Category category; 

    @Column(name="product_name", nullable=false, length=45)
    private String product_name;

    @Column(name="description", nullable=false, length=45)
    private String description;

    @Column(name="price", nullable=false)
    private BigDecimal price;

    @Column(name="discount", nullable=true)
    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name="seller_idseller")
    private Seller seller;

	public Product() {
		super();
	}

	public Product(int idproduct, Category category, String product_name, String description, BigDecimal price,
			BigDecimal discount, Seller seller) {
		super();
		this.idproduct = idproduct;
		this.category = category;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.seller = seller;
	}

	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Product [idproduct=" + idproduct + ", category=" + category + ", product_name=" + product_name
				+ ", description=" + description + ", price=" + price + ", discount=" + discount + ", seller=" + seller
				+ "]";
	} 

	
}
