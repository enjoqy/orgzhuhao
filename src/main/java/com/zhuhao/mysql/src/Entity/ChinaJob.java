package com.zhuhao.mysql.src.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 *  @author: zhuhao
 * @date: 2019/5/13 0013 10:43
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChinaJob {

    private Long id;
    private String province;
    private String jobTitle;
    private String companyName;
    private String workingPlace;
    private String salary;
    private String releaseTime;
    private String district;
    private String workExp;
    private String degree;
    private String hiringNumber;

}
