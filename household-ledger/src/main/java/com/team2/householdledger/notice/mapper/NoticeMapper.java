package com.team2.householdledger.notice.mapper;

import com.team2.householdledger.notice.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NoticeMapper {

    /**
     * 알림 목록 조회 (안 읽은 것 우선 등)
     */
    List<NoticeDTO> selectNoticeList(Long userNo);

    /**
     * 알림 생성 (예산 초과 시 자동 호출용)
     */
    void insertNotice(NoticeDTO notice);

    /**
     * 알림 읽음 처리
     */
    void updateReadStatus(Long noticeNo);
}
