package com.tobabogi.demo.eventboard.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.tobabogi.demo.eventboard.domain.EventBoard;
import com.tobabogi.demo.eventboard.domain.EventBoardAttach;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventBoardDTO {

    private Long enbno_id;
    private String title;
    private String description;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private int hits;
    private String isDelete;


    @Builder.Default
    private List<EventUploadResponseDTO> files = new ArrayList<>();

    public EventBoard getDomain(){

        EventBoard eventBoard = EventBoard.builder()
                .enbno_id(enbno_id)
                .title(title)
                .description(description)
                .regDate(regDate)
                .modDate(modDate)
                .hits(hits)
                .build();

        files.forEach(EventUploadResponseDTO -> {
            EventBoardAttach eventBoardAttach = EventBoardAttach.builder()
                    .uuid(EventUploadResponseDTO.getUuid())
                    .fileName(EventUploadResponseDTO.getFileName())
                    .Path(EventUploadResponseDTO.getPath())
                    .isImage(EventUploadResponseDTO.isImage())
                    .img_thumbnail_name(EventUploadResponseDTO.getImg_thumbnail_name())
                    .build();

            eventBoard.addAttach(eventBoardAttach);
        });

        return eventBoard;
    }





}
