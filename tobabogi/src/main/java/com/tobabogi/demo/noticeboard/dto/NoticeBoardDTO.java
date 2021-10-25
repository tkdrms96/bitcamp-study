package com.tobabogi.demo.noticeboard.dto;

import com.tobabogi.demo.common.dto.UploadResponseDTO;
import com.tobabogi.demo.noticeboard.domain.NoticeBoard;
import com.tobabogi.demo.noticeboard.domain.NoticeBoardAttach;
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
public class NoticeBoardDTO {


    private Long nbno_id;
    private String title;
    private String description;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private int hits;
    private String isDelete;


    @Builder.Default
    private List<NoticeUploadResponseDTO> files = new ArrayList<>();

    public NoticeBoard getDomain(){

        NoticeBoard noticeboard = NoticeBoard.builder()
                .nbno_id(nbno_id)
                .title(title)
                .description(description)
                .regDate(regDate)
                .modDate(modDate)
                .hits(hits)
                .build();

        files.forEach(NoticeUploadResponseDTO -> {
            NoticeBoardAttach noticeBoardAttach = NoticeBoardAttach.builder()
                    .nano_id(NoticeUploadResponseDTO.getNano_id())
                    .fileName(NoticeUploadResponseDTO.getFileName())
                    .Path(NoticeUploadResponseDTO.getPath())
                    .isImage(NoticeUploadResponseDTO.isImage())
                    .img_thumbnail_name(NoticeUploadResponseDTO.getImg_thumbnail_name())
                    .build();

            noticeboard.addAttach(noticeBoardAttach);
        });

        return noticeboard;
    }

}
