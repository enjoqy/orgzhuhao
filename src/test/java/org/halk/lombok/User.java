package org.halk.lombok;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author halk
 * @Date 2020/5/21 0021 11:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends People {

    private String name;
}
