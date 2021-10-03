package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Service;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServiceDTO {

    private Long id;

    private String name;

    public ServiceDTO(Service service) {
        this.id = service.getId();
        this.name = service.getName();
    }

}
