package com.zhuhao.mysql.src.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 *  @author: zhuhao
 * @date: 2019/5/14 0014 9:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    private Long id;
    private String AccountName;
    private String AccountId;
    private Double AccountBalance;
}
