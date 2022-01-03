package com.pjatk.medicalcenter.scheduler;

import com.pjatk.medicalcenter.service.AppointmentService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.pjatk.medicalcenter.service.ReferralService;


@Component
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
    }

    @Scheduled(cron = "00 00 00 * * ?")
    public void scheduleDeleteUsedReferralsAfterVisit() {
        referalService.deleteUsedReferrals();
    }

    @Scheduled(cron = "00 00 00 * * ?")
    public void scheduleConfirmingAppointments() {
        appointmentService.confirmTodaysAppointment();
    }

    @Scheduled(cron = "00 19 00 * * ?")
    public void scheduleDeletingUnusedAppointments() { appointmentService.deleteUnusedAppointments(); }
}
