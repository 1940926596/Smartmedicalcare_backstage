package com.example.aerial.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    public String doctorId;
    public String doctorName;
    public String doctorImage;
    public Character doctorGender;
    public String doctorPhone;
    public String doctorCompany;
    public String doctorDepartment;
    public String doctorStartTime;
    public Integer doctorScore;
    public String doctorPassword;
    public String doctorCreateTime;
    public String doctorShortIntroduction;
    public String doctorLongIntroduction;


}
