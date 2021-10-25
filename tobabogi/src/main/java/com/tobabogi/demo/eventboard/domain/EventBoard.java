package com.tobabogi.demo.eventboard.domain;


import com.tobabogi.demo.eventboard.dto.EventBoardDTO;
import com.tobabogi.demo.eventboard.dto.EventUploadResponseDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventBoard {
    private Long enbno_id;
    private String title,description;
    private LocalDateTime regDate,modDate;
    private int hits;
    private String tbl_member_id;
    private String isDelete;

    @Builder.Default
    private List<EventBoardAttach> attachList = new ArrayList<>();

    public EventBoardDTO getDTO(){
        EventBoardDTO eventBoardDTO = EventBoardDTO.builder()
                .enbno_id(enbno_id)
                .title(title)
                .description(description)
                .regDate(regDate)
                .modDate(modDate)
                .hits(hits)
                .build();
//
//        //BoardAttach -> UploadResponseDTO -> List
        List<EventUploadResponseDTO> uploadResponseDTOList = attachList.stream().map(EventBoardAttach -> {
            EventUploadResponseDTO eventUploadResponseDTO = EventUploadResponseDTO.builder()
                    .uuid(EventBoardAttach.getUuid())
                    .fileName(EventBoardAttach.getFileName())
                    .Path(EventBoardAttach.getPath())
                    .isImage(EventBoardAttach.isImage())
                    .img_thumbnail_name(EventBoardAttach.getImg_thumbnail_name())
                    .build();
            return eventUploadResponseDTO;

        }).collect(Collectors.toList());

        eventBoardDTO.setFiles(uploadResponseDTOList);


        return eventBoardDTO;
    }

    public void setBno(Long bno) {
        this.enbno_id = bno;
    }

    public void addAttach(EventBoardAttach eventboardAttach){
        attachList.add(eventboardAttach);
    }
}
