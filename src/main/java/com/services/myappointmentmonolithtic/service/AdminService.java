package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.model.Admin;
import com.services.myappointmentmonolithtic.repository.JPAAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final JPAAdminRepository adminRepository;

    public AdminService(JPAAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public List<Admin> findAdminByName(String name) {
        return adminRepository.findAdminByName(name);
    }
    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }
}
