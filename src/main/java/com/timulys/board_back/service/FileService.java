package com.timulys.board_back.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * packageName :   com.timulys.board_back.service
 * fileName    :   FileService
 * author      :   user
 * date        :   2024-10-05
 * description :
 * -----------------------------------------------------------
 * DATE                    AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2024-10-05             user                 최초 생성
 */
public interface FileService {
    // 파일 업로드
    String upload(MultipartFile file);
    Resource getImage(String fileName);
}
