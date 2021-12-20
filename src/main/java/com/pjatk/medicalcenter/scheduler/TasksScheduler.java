package com.pjatk.medicalcenter.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.pjatk.medicalcenter.service.ReferralService;

@Component
public class TasksScheduler {

    private final ReferralService referalService;

    public TasksScheduler(ReferralService referalService) {
        this.referalService = referalService;
    }

    @Scheduled(cron = "00 00 00 * * ?")
    public void scheduleDeleteReferralsExpiredOneMonthAgo() {
        referalService.deleteReferralsExpiredOneMonthAgo();
    }
}
