package com.app.hospital.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.app.hospital.entity.Admin;



//CrudRepository-Create,retrieve,update and delete
@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>{
	
	
}
