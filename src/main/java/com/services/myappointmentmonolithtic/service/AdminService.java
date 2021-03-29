package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.exceptions.NoSuchAdminException;
import com.services.myappointmentmonolithtic.model.Admin;
import com.services.myappointmentmonolithtic.repository.JPAAdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final JPAAdminRepository adminRepository;

    private static final Logger LOG = LoggerFactory.getLogger(AdminService.class);

    public AdminService(JPAAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void saveAdmin(Admin admin) {
        LOG.debug("saveAdmin(), Admin saving");
        adminRepository.save(admin);
    }

    public List<Admin> findAdminByName(String name) throws NoSuchAdminException {
        LOG.debug("findAdminByName(), Admin finding");
        try {
            return adminRepository.findAdminByName(name);
        }
        catch (Exception e){
            throw new NoSuchAdminException("Admin with name " + name + "wasn't found");
        }

    }
    public List<Admin> getAllAdmins(){
        LOG.debug("getAllAdmins(), Receiving all admins");
        return adminRepository.findAll();
    }
    public Admin findAdminById(String id){
        LOG.debug("findAdminById(), Receiving admin by id");
        return adminRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
