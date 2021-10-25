package com.tobabogi.demo.eventboard.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventRemoveDTO {

    Integer enbno_id;
    boolean isDelete;
}
