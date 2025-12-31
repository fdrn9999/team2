package com.team2.dbbuddy.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SampleDTO {
    private Integer sampleId;
    private Integer tblId; // Foreign Key to TBL_META (TBL_ID)
    private String dataJson;
    private String activeFl;
    private LocalDateTime regDt;
    private LocalDateTime chgDt;
}
