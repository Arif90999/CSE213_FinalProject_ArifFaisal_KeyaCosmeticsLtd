/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package keyacosmeticsltd;

import java.sql.Date;

/**
 *
 * @author Azmary
 */
public class AppointmentData {

    private Integer appointmentID;
    private Integer finance_accounts_id;
    private String name;
    private String gender;
    private String description;
    private String balance;
    private String transaction;
    private Long mobileNumber;
    private String address;
    private Date date;
    private Date dateModify;
    private Date dateDelete;
    private String status;
    private String administratorID;
    private String specialized;
    private Date schedule;

    public AppointmentData(int appointmentID, String name, String gender, long mobileNumber, String description, String balance, String transaction, String address, Date date, Date dateModify, Date dateDelete, String status, Date schedule) {

        this.appointmentID = appointmentID;
        this.name = name;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.description = description;
        this.balance = balance;
        this.transaction = transaction;
        this.address = address;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
        this.status = status;
        this.schedule = schedule;

    }

    public Integer getAppointmentID() {
        return appointmentID;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getBalance() {
        return balance;
    }

    public String getTransaction() {
        return transaction;
    }
    
    public String getAddress() {
        return address;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public Date getDateDelete() {
        return dateDelete;
    }

    public String getStatus() {
        return status;
    }
    
    public Date getSchedule() {
        return schedule;
    }

}
