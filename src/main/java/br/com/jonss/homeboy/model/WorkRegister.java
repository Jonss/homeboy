package br.com.jonss.homeboy.model;

import br.com.jonss.homeboy.util.TimeUtil;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "work_register")
public class WorkRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String userId;
    private LocalDateTime arrivalTime;
    @Enumerated(value = EnumType.STRING)
    private RegisterType registerType;
    private LocalDateTime departureTime = TimeUtil.januaryAtMidnight();

    public WorkRegister() {
    }

    public WorkRegister(String userName, String userId, LocalDateTime timeRegister, RegisterType registerType) {
        this.userName = userName;
        this.userId = userId;
        this.arrivalTime = timeRegister;
        this.registerType = registerType;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getTimeRegister() {
        return arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public RegisterType getRegisterType() {
        return registerType;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return String.format(":house: %s: %s - %s %s \n", userName,
                TimeUtil.dateToString(arrivalTime),
                TimeUtil.timeToString(arrivalTime),
                departureTime(departureTime));
    }

    private String departureTime(LocalDateTime time) {
        return TimeUtil.hadNotLeave(time) ? "- Saída não registrada": "à " + TimeUtil.timeToString(time);
    }
}
