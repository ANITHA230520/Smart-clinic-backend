package com.app.hospital.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.hospital.dto.AdminDTO;

import com.app.hospital.entity.Admin;

import com.app.hospital.repository.AdminRepository;
import com.app.hospital.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
    // enables to inject the object dependency implicitly
	@Autowired
	private AdminRepository adminRepository;

	
//method to save the details
	@Override
	public AdminDTO saveAdmin(AdminDTO adminDTO) {
		Admin admin = new Admin();
		BeanUtils.copyProperties(adminDTO, admin); //copy the entity to DTO
		adminRepository.save(admin);
		return adminDTO;
	}
//method to edit  the details
	@Override
	public AdminDTO updateAdmin(AdminDTO adminDTO) {
		Admin admin = new Admin();
		BeanUtils.copyProperties(adminDTO, admin); //copy the entity to DTO
		adminRepository.save(admin);
		return adminDTO;
	}
//method to delete the  details
	@Override
	public AdminDTO deleteAdmin(AdminDTO adminDTO) {
		Admin admin = new Admin();
		BeanUtils.copyProperties(adminDTO, admin); //copy the entity to DTO
		adminRepository.delete(admin);
		return adminDTO;
	}

//method to get the details by adminId
	@Override
	public AdminDTO getById(Integer adminId) {
		Optional<Admin> admin = adminRepository.findById(adminId);
		if (admin.isPresent()) {
			AdminDTO dto = new AdminDTO();
			BeanUtils.copyProperties(admin.get(), dto); //convert the entity to DTO
			return dto;

		}
		return null;
	}
	@Override
	public List<AdminDTO> findAll() {
		Iterable<Admin> list = adminRepository.findAll();
		List<AdminDTO> dtos = new ArrayList<>();
		for (Admin p : list) {
			AdminDTO dto = new AdminDTO();
			BeanUtils.copyProperties(p, dto); //copy the entity to DTO
			dtos.add(dto);

		}
		return dtos;
	}
	
	public Admin validate(Integer adminId, String password) {
		Optional<Admin> admin = adminRepository.findById(adminId);
        if(admin.isPresent() && admin.get().getPassword().equals(password)) {
            return admin.get();
        }
        return null;
    }
	


	
}
