package com.pjatk.medicalcenter.service;

import com.pjatk.medicalcenter.model.Referral;
import com.pjatk.medicalcenter.repository.ReferralRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReferralService {

    private final ReferralRepository referralRepository;

    public ReferralService(ReferralRepository referralRepository) {
        this.referralRepository = referralRepository;
    }

    public Referral addReferral(Referral referral) { return referralRepository.save(referral); }

    public Referral getReferralById(long id){
        return referralRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Referral does not exists"));
    }

    public List<Referral> getReferrals(){
        return referralRepository.findAll();
    }

    public void deleteReferralsExpiredOneMonthAgo(){
        List<Referral> expiredReferrals = referralRepository
                                            .findAll()
                                            .stream()
                                            .filter(ref -> ref.getExpiryDate().plusMonths(1).equals(LocalDate.now()))
                                            .collect(Collectors.toList());
        referralRepository.deleteAll(expiredReferrals);
    }
}
