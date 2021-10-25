package com.tobabogi.demo.eventboard.dto;

import com.tobabogi.demo.common.dto.PageMaker;
import com.tobabogi.demo.common.dto.PageResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventReplyPageResponseDTO<E> extends PageResponseDTO<E> {

    private PageMaker pageMaker;

}
