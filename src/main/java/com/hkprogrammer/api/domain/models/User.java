package com.hkprogrammer.api.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Size(max = 150)
	private String name;
	
	@Email
	@NotBlank
	@Size(max = 150)
	private String email;
	
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
