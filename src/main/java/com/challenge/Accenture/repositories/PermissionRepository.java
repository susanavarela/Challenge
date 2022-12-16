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

	@Query(value = "select * from permission p where p.album=:album and p.enable = true", nativeQuery = true)
	List<Permission> findPermissionByAlbum(@Param("album")int album);
	
	@Query(value = "select * from permission p where p.album=:album and p.user=:user and p.enable = true", nativeQuery = true)
	Permission findPermission(@Param("album")int album, @Param("user")int user);
	
	@Query(value = "select * from permission p where p.album=:album and p.permission_type=:permissionType and p.enable = true", nativeQuery = true)
	List<Permission> getUsersByAlbumAndPermission(@Param("album")int album, @Param("permissionType")int permissionType);

}
