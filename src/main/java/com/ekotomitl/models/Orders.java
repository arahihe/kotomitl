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

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idorder")
	private int idorder;

	@ManyToOne
	@JoinColumn(name="buyer_idbuyer")
	private Buyer buyer; 

	@Column(name="order_date", nullable=false)
	private LocalDate order_date;

	@Column(name="total", nullable=false)
	private BigDecimal total;

	@Column(name="status", nullable=false, length=40)
	private String status;

	@OneToOne
	@JoinColumn(name="payment_idpayment")
	private Payment payment;

	public Orders() {
		super();
	}

	public Orders(int idorder, Buyer buyer, LocalDate order_date, BigDecimal total, String status, Payment payment) {
		super();
		this.idorder = idorder;
		this.buyer = buyer;
		this.order_date = order_date;
		this.total = total;
		this.status = status;
		this.payment = payment;
	}

	public int getIdorder() {
		return idorder;
	}

	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public LocalDate getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Orders [idorder=" + idorder + ", buyer=" + buyer + ", order_date=" + order_date + ", total=" + total
				+ ", status=" + status + ", payment=" + payment + "]";
	}

	
}