package com.team2.householdledger.notice.controller;

import com.team2.householdledger.common.dto.CommonDTO;
import com.team2.householdledger.notice.dto.NoticeDTO;
import com.team2.householdledger.notice.service.NoticeService;
import com.team2.householdledger.member.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    /**
     * 내 알림 목록 조회
     */
    @GetMapping("/list")
    public CommonDTO<List<NoticeDTO>> getNoticeList(HttpSession session) {
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
        if (loginUser == null) {
            return CommonDTO.error(401, "로그인이 필요합니다.");
        }

        List<NoticeDTO> list = noticeService.getMyNotices(loginUser.getUserNo());
        return CommonDTO.success(list);
    }

    /**
     * 알림 읽음 처리
     */
    @PostMapping("/read/{noticeNo}")
    public CommonDTO<String> readNotice(@PathVariable Long noticeNo) {
        noticeService.readNotice(noticeNo);
        return CommonDTO.success("읽음 처리되었습니다.");
    }
}
