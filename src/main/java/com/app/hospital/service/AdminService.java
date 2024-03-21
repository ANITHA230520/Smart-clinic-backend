package com.app.hospital.service;

import java.util.List;

import com.app.hospital.dto.AdminDTO;
import com.app.hospital.entity.Admin;


public interface AdminService {
	
	public Admin validate(Integer adminId, String password);

	public AdminDTO saveAdmin(AdminDTO adminDTO);

	public AdminDTO updateAdmin(AdminDTO adminDTO);

	public AdminDTO deleteAdmin(AdminDTO adminDTO);

	public AdminDTO getById(Integer adminId);
	
	public List<AdminDTO> findAll();

}
