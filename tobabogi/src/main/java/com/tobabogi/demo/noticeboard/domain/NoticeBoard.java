package com.tobabogi.demo.noticeboard.domain;

import com.tobabogi.demo.common.dto.UploadResponseDTO;
import com.tobabogi.demo.noticeboard.dto.NoticeBoardDTO;
import com.tobabogi.demo.noticeboard.dto.NoticeUploadResponseDTO;
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
public class NoticeBoard {

    private Long nbno_id;
    private String title,description;
    private LocalDateTime regDate,modDate;
    private int hits;
    private String isDelete;

    @Builder.Default
    private List<NoticeBoardAttach> attachList = new ArrayList<>();

    public NoticeBoardDTO getDTO(){
        NoticeBoardDTO noticeboardDTO = NoticeBoardDTO.builder()
                .nbno_id(nbno_id)
                .title(title)
                .description(description)
                .regDate(regDate)
                .modDate(modDate)
                .hits(hits)
                .build();
//
//        //BoardAttach -> UploadResponseDTO -> List
        List<NoticeUploadResponseDTO> uploadResponseDTOList = attachList.stream().map(NoticeBoardAttach -> {
            NoticeUploadResponseDTO noticeUploadResponseDTO = NoticeUploadResponseDTO.builder()
                    .nano_id(NoticeBoardAttach.getNano_id())
                    .fileName(NoticeBoardAttach.getFileName())
                    .Path(NoticeBoardAttach.getPath())
                    .isImage(NoticeBoardAttach.isImage())
                    .img_thumbnail_name(NoticeBoardAttach.getImg_thumbnail_name())
                    .build();
            return noticeUploadResponseDTO;

        }).collect(Collectors.toList());

        noticeboardDTO.setFiles(uploadResponseDTOList);


        return noticeboardDTO;
    }

    public void setBno(Long bno) {
        this.nbno_id = bno;
    }

    public void addAttach(NoticeBoardAttach noticeboardAttach){
        attachList.add(noticeboardAttach);
    }
}
