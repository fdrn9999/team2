package com.team2.householdledger.notice.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 알림 DTO
 * (예산 초과 알림 등)
 */
@Data
public class NoticeDTO {
    private Long noticeNo; // 알림 번호 (PK)
    private Long userNo; // 수신자 (FK)
    private String message; // 알림 내용
    private String readYn; // 읽음 여부 ('Y'/'N')
    private LocalDateTime regDt;// 생성 일시
}
