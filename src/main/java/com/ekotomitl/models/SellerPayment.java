package com.ekotomitl.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seller_payment")
public class SellerPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idseller_payment")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "seller_idseller")
	private Seller seller;

	@Column(name="payment_date", nullable=false)
	private LocalDate payment_date;
	
	@Column(name="amount", nullable=false)
	private BigDecimal amount;
	
	@Column(name="status", nullable=false, length=30)
	private String status;

	public SellerPayment() {
		super();
	}

	public SellerPayment(int id, Seller seller, LocalDate payment_date, BigDecimal amount, String status) {
		super();
		this.id = id;
		this.seller = seller;
		this.payment_date = payment_date;
		this.amount = amount;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public LocalDate getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(LocalDate payment_date) {
		this.payment_date = payment_date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SellerPayment [id=" + id + ", seller=" + seller + ", payment_date=" + payment_date + ", amount="
				+ amount + ", status=" + status + "]";
	}
}
