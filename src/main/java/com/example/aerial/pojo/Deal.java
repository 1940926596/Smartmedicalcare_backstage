package com.example.aerial.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deal {
    String dealId;
    String dealOldId;
    String dealDoctorId;
    String dealCreateTime;
    String dealEndTime;

}
