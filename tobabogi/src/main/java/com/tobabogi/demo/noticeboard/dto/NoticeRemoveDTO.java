package com.tobabogi.demo.noticeboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRemoveDTO {

    Integer nbno_id;
    boolean isDelete;
}
