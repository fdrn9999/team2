package com.team2.householdledger.notice.service;

import com.team2.householdledger.notice.dto.NoticeDTO;
import com.team2.householdledger.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeMapper noticeMapper;

    /**
     * 내 알림 조회
     */
    public List<NoticeDTO> getMyNotices(Long userNo) {
        return noticeMapper.selectNoticeList(userNo);
    }

    /**
     * 알림 읽음 처리
     */
    public void readNotice(Long noticeNo) {
        noticeMapper.updateReadStatus(noticeNo);
    }

    /**
     * (시스템 내부용) 알림 발송
     * 예: 가계부 등록 서비스에서 예산 초과 시 호출
     */
    public void sendNotice(Long userNo, String message) {
        NoticeDTO notice = new NoticeDTO();
        notice.setUserNo(userNo);
        notice.setMessage(message);
        noticeMapper.insertNotice(notice);
    }
}
