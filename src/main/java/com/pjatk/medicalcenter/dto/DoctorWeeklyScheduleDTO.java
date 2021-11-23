package com.pjatk.medicalcenter.dto;

import com.pjatk.medicalcenter.model.Schedule;
import com.pjatk.medicalcenter.model.Schedule.DayOfWeek;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class DoctorWeeklyScheduleDTO {

    private Map<Schedule.DayOfWeek,List<ScheduleDTO>> weeklySchedule = new HashMap<>();

    public DoctorWeeklyScheduleDTO(List<ScheduleDTO> schedules){
        weeklySchedule.put(DayOfWeek.MONDAY,schedules.stream()
                .filter(s -> s.getDayOfWeek().equals(DayOfWeek.MONDAY)).collect(Collectors.toList()));
        weeklySchedule.put(DayOfWeek.TUESDAY,schedules.stream()
                .filter(s -> s.getDayOfWeek().equals(DayOfWeek.TUESDAY)).collect(Collectors.toList()));
        weeklySchedule.put(DayOfWeek.WEDNESDAY,schedules.stream()
                .filter(s -> s.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)).collect(Collectors.toList()));
        weeklySchedule.put(DayOfWeek.THURSDAY,schedules.stream()
                .filter(s -> s.getDayOfWeek().equals(DayOfWeek.THURSDAY)).collect(Collectors.toList()));
        weeklySchedule.put(DayOfWeek.FRIDAY,schedules.stream()
                .filter(s -> s.getDayOfWeek().equals(DayOfWeek.FRIDAY)).collect(Collectors.toList()));
        weeklySchedule.put(DayOfWeek.SATURDAY,schedules.stream()
                .filter(s -> s.getDayOfWeek().equals(DayOfWeek.SATURDAY)).collect(Collectors.toList()));
        weeklySchedule.put(DayOfWeek.SUNDAY,schedules.stream()
                .filter(s -> s.getDayOfWeek().equals(DayOfWeek.SUNDAY)).collect(Collectors.toList()));
    }
}
