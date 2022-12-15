package com.challenge.Accenture.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Setter
@Getter
@Table(name="permission")
public class Permission {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user", nullable=true)
	private int user; 
	
	@Column(name="album", nullable=true)
	private int album;

	@Column(name="permission_type", nullable=true)
	private int permissionType;
	
	@CreationTimestamp
	@Column(name="created_at", nullable=false)
	private LocalDate createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at", nullable=false)
	private LocalDate updatedAt;
	
	@Column(name="enable", nullable=false)
	private boolean enable;
	
	public Permission(int album, int user, int permissionType) {
		this.album = album;
		this.user = user;
		this.permissionType = permissionType;
	}
}
