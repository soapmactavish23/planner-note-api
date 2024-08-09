package com.hkprogrammer.api.domain.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "goal_id")
	private Goal goal;
	
	@NotNull
	private Boolean status;
	
	@NotNull
	private LocalDateTime date;
	
	@PrePersist
	public void prePersist() {
		this.status = !this.status;
	}
	
	public void changeStatus() {
		this.status = !this.status;
	}
	
}
