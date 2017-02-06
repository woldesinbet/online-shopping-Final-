package com.project.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Payment {
	@Id
	@GeneratedValue
	private Long id;
	private Date datePayed = new Date();
	@NotNull
	private Long cardNo;
	@NotEmpty
	private String name;
/*	@NotNull
	@DateTimeFormat(style = "YYYY-MM-dd")
	private Date expirationDate;
*/	@NotNull
	private Integer ccv;
	private BigDecimal amount;
	@NotEmpty
	private String destination;

	public Payment() {

	}

	public Payment(Long cardNo, Integer ccv, String name, Date datePayed, Date expirationdate, String destination) {
		super();
		this.cardNo = cardNo;
		this.ccv = ccv;
		this.name = name;
		this.datePayed = datePayed;
//		this.expirationDate = expirationdate;
		this.destination = destination;
	}

	public Date getDatePayed() {
		return datePayed;
	}

	public void setDatePayed(Date datePayed) {
		this.datePayed = datePayed;
	}

	public Long getCardNo() {
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationdate) {
		this.expirationDate = expirationdate;
	}*/

	public Integer getCcv() {
		return ccv;
	}

	public void setCcv(Integer ccv) {
		this.ccv = ccv;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Long getId() {
		return id;
	}

}
