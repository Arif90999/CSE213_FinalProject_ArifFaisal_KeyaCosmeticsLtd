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
public class FinanceAccountsData {

    private Integer id;
    private Integer faID;
    private String password;
    private String fullName;
    private Long mobileNumber;
    private String address;
    private String image;
    private String description;
    private String balance;
    private String transaction;
    private String administrator;
    private String specialized;
    private String gender;
    private Date date;
    private Date dateModify;
    private Date dateDelete;
    private String status;

    public FinanceAccountsData(Integer id, Integer faID, String password, String fullName, Long mobileNumber,
            String gender, String address, String image, String description, String balance, String transaction,
            String administrator, String specialized, Date date, Date dateModify,
            Date dateDelete, String status) {
        this.id = id;
        this.faID = faID;
        this.password = password;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.address = address;
        this.image = image;
        this.description = description;
        this.balance = balance;
        this.transaction = transaction;
        this.administrator = administrator;
        this.specialized = specialized;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
        this.status = status;

    }

    public FinanceAccountsData(Integer id, Integer faID, String fullName, String gender,
            Long mobileNumber, String address, String status, Date date,
            Date dateModify, Date dateDelete) {
        this.id = id;
        this.faID = faID;
        this.fullName = fullName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.status = status;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
    }
    
     public Integer getId(){
        return id;
    }

    public Integer getfaID() {
        return faID;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public String getTransaction() {
        return transaction;
    }

    public String getAdministrator() {
        return administrator;
    }

    public String getSpecialized() {
        return specialized;
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
}
