package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Service;

public class ServiceDTO {

    private Long id;

    private String name;

    public ServiceDTO(Service service) {
        this.id = service.getId();
        this.name = service.getName();
    }

}
