package com.tobabogi.demo.eventboard.dto;

import com.tobabogi.demo.common.dto.PageRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EventReplyListDTO extends PageRequestDTO {

    private Long enbno_id;


}
