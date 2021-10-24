package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Referral;
import com.pjatk.medicalcenter.repository.ReferralRepository;
import org.springframework.stereotype.Service;

@Service
public class ReferralService {

    private final ReferralRepository referralRepository;

    public ReferralService(ReferralRepository referralRepository) {
        this.referralRepository = referralRepository;
    }

    public Referral addReferral(Referral referral) { return referralRepository.save(referral); }
}
