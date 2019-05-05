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

    private String jobTitle;  //职位名
    private String companyName;  //公司名
    private String workingPlace;  //工作地点
    private String salary;  //薪资
    private String releaseTime;  //发布时间

 /*   public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public User() {
    }

    public User(String jobTitle, String companyName, String workingPlace, String salary, String releaseTime) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.workingPlace = workingPlace;
        this.salary = salary;
        this.releaseTime = releaseTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "jobTitle='" + jobTitle + '\'' +
                ", companyName='" + companyName + '\'' +
                ", workingPlace='" + workingPlace + '\'' +
                ", salary='" + salary + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                '}';
    }*/
}
