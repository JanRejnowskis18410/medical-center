package com.pjatk.medicalcenter.scheduler;

import com.pjatk.medicalcenter.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.pjatk.medicalcenter.service.ReferralService;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Component @Slf4j
public class TasksScheduler {

    private final ReferralService referalService;
    private final AppointmentService appointmentService;

    public TasksScheduler(ReferralService referalService, AppointmentService appointmentService) {
        this.referalService = referalService;
        this.appointmentService = appointmentService;
    }

    @Scheduled(cron = "00 00 00 * * ?")
    public void scheduleDeleteReferralsExpiredOneMonthAgo() {
        referalService.deleteReferralsExpiredOneMonthAgo();
        log.info("Task: delete referrals expired one month ago executed at {}", LocalDateTime.now());
    }

    @Scheduled(cron = "00 00 00 * * ?")
    public void scheduleDeleteUsedReferralsAfterVisit() {
        referalService.deleteUsedReferrals();
        log.info("Task: delete referrals used refferals after visit executed at {}", LocalDateTime.now());
    }

    @Scheduled(cron = "00 00 00 * * ?")
    public void scheduleConfirmingAppointments() {
        appointmentService.confirmTodaysAppointment();
        log.info("Task: confirm today's appointments executed at {}", LocalDateTime.now());
    }

    @Scheduled(cron = "00 19 00 * * ?")
    public void scheduleDeletingUnusedAppointments() {
        appointmentService.deleteUnusedAppointments();
        log.info("Task: delete unused appointments executed at {}", LocalDateTime.now());
    }
}
