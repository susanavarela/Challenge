package com.challenge.Accenture.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.Accenture.entities.Permission;

@Repository
public interface PermissionRepository  extends JpaRepository<Permission, Serializable>{

	
}
