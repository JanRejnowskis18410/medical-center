package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Referral;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ReferralDTO {

    private Long id;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    private MedicalServiceDTO medicalService;

    public ReferralDTO(Referral referral) {
        this.id = referral.getId();
        this.issueDate = referral.getIssueDate();
        this.expiryDate = referral.getExpiryDate();
        this.medicalService = new MedicalServiceDTO(referral.getMedicalService());
    }
}
