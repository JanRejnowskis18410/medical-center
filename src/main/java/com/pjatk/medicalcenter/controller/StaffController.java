//package com.pjatk.medicalcenter.controller;
//
//import com.pjatk.medicalcenter.model.Staff;
//import com.pjatk.medicalcenter.service.StaffService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//@RequestMapping("/staffs")
//@CrossOrigin
//public class StaffController {
//
//    private final StaffService staffService;
//
//    public StaffController(StaffService staffService) {
//        this.staffService = staffService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Staff>> getStaffs(){
//        return ResponseEntity.ok(staffService.getStaffs());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Staff> getStaffById(@PathVariable long id){
//        return ResponseEntity.ok(staffService.getStaffById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<Staff> addStaff(@RequestBody Staff Staff){
//        Staff createdStaff = staffService.addStaff(Staff);
//        return ResponseEntity.created(URI.create(String.format("/staffs/%d", createdStaff.getId()))).build();
//    }
//
//    @PutMapping
//    public ResponseEntity<Staff> updateStaff(@RequestBody Staff Staff){
//        Staff updatedStaff = staffService.updateStaff(Staff);
//        return ResponseEntity.created(URI.create(String.format("/staffs/%d", updatedStaff.getId()))).build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteStaff(@PathVariable long id){
//        staffService.deleteStaffById(id);
//        return ResponseEntity.ok("Success");
//    }
//}
