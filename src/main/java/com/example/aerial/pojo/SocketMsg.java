package com.example.aerial.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketMsg {
    private String send_id;

    private String receiver_id;
    private String content;
}
