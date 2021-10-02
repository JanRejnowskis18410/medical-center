package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Staff;
import com.pjatk.medicalcenter.repository.StaffRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getStaffs(){
        return staffRepository.findAll();
    }

    public Staff getStaffById(long id){
        return staffRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Staff does not exists"));
    }

    public Staff addStaff(Staff staff){
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Staff staff){
        if(staffRepository.findById(staff.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Staff does not exists")) != null)
            return staffRepository.save(staff);

        return null;
    }

    public void deleteStaffById(long id){
        staffRepository.delete(staffRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Staff does not exists")));
    }
}
