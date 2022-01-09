package com.pjatk.medicalcenter.scheduler;

import com.pjatk.medicalcenter.mail.EmailService;
import com.pjatk.medicalcenter.model.Appointment;
import com.pjatk.medicalcenter.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import com.pjatk.medicalcenter.util.MessageTemplates;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.pjatk.medicalcenter.service.ReferralService;

import java.time.LocalDateTime;

import java.util.List;

@Component @Slf4j
public class TasksScheduler {

    private final ReferralService referalService;
    private final AppointmentService appointmentService;
    private final EmailService mailService;

    public TasksScheduler(ReferralService referalService, AppointmentService appointmentService, EmailService mailService) {
        this.referalService = referalService;
        this.appointmentService = appointmentService;
        this.mailService = mailService;
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

    @Scheduled(cron = "00 00 00 * * ?")
    public void scheduleDeletingUnusedAppointments() {
        appointmentService.deleteUnusedAppointments();
        log.info("Task: delete unused appointments executed at {}", LocalDateTime.now());
    }

    @Scheduled(cron = "00 00 12 * * ?")
    public void scheduleSendingEmailForVisitsIn2days() {

        List<Appointment> appointments = appointmentService.getConfirmedAndReservedAppointmentsIn2days();
        appointments.forEach(app -> {
            String message = String.format(MessageTemplates.confirmedAppointmentHTML,
                app.getDate().toLocalDate().toString(),
                app.getMedicalService().getName(),
                app.getDoctor().getFirstName() + " " + app.getDoctor().getLastName(),
                app.getState().equals(Appointment.AppointmentState.RESERVED) ?
                        "W celu potwierdzenia lub odwołania wizyty zapraszamy do portalu pacjenta." : "");

            mailService.sendEmail(app.getPatient().getUser().getEmail(),"Nadchodząca wizyta", message);
        });
        log.info("Task: schedule sending emails, executed at {}", LocalDateTime.now());
    }
}
