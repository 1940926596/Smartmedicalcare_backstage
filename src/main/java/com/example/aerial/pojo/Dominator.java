package com.example.aerial.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dominator {

    //内部账号，不支持添加，修改
    public String dominatorId;

    public String dominatorPassword;

}
