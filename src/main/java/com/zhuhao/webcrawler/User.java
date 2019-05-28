package com.zhuhao.webcrawler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    //职位名
    private String jobTitle;
    //公司名
    private String companyName;
    //工作地点
    private String workingPlace;
    //薪资
    private String salary;
    //发布时间
    private String releaseTime;

}
