package com.hkprogrammer.api.domain.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User user;
	
	@NotBlank
	@Size(max = 255)
	private String description;
	
	@NotNull
	private Integer quantity;
	
	@NotNull
	@Column(name = "start")
	private Date dtStart;
	
	@NotNull
	@Column(name = "end")
	private Date dtEnd;
	
	@NotNull
	private Boolean status;
	
	@PrePersist
	public void prePersist() {
		if(this.id == null) {
			this.status = true;
		}
	}
	
	public void changeStatus() {
		this.status = !this.status;
	}
	
}
