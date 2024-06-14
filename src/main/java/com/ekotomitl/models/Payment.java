package com.ekotomitl.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="payment")
public class Payment {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpayment")
    private int idPayment;

    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "status", nullable = false, length = 30)
    private String status;
    
    @OneToOne(mappedBy = "payment")
    private Orders orders;

	public Payment() {
		super();
	}

	public Payment(int idPayment, LocalDate paymentDate, BigDecimal amount, String status, Orders orders) {
		super();
		this.idPayment = idPayment;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.status = status;
		this.orders = orders;
	}

	public int getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
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

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Payment [idPayment=" + idPayment + ", paymentDate=" + paymentDate + ", amount=" + amount + ", status="
				+ status + ", orders=" + orders + "]";
	}

	
    
}