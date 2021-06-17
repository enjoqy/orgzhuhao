package com.zhuhao.basic.collection;

import com.zhuhao.basic.collection.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * list for循环，循环删除
 *
 * @author junhi
 * @date 2019/11/6 19:54
 */
public class ForList {



    public static void main(String[] args) {

        List<User> userA = new ArrayList<>(
                Arrays.asList(
                        new User("a", 1, 2000.0),
                        new User("b", 2, 4000.0),
                        new User("c", 3, 5000.0),
                        new User("d", 4, 6000.0),
                        new User("e", 5, 7000.0),
                        new User("a", 7, 8000.0)
                )
        );

        List<User> userB = new ArrayList<>();
        userB.add(new User("a", 1, 2000.0));
        userB.add(new User("a", 1, 2000.0));
        userB.add(new User("b", 2, 4000.0));
        userB.add(new User("c", 3, 5000.0));
        userB.add(new User("d", 4, 6000.0));
        userB.add(new User("e", 5, 7000.0));
        userB.add(new User("f", 6, 8000.0));
        userB.add(new User("a", 6, 8000.0));

        List<Integer> integerList = new ArrayList<>(
                Arrays.asList(
                        1,
                        2,
                        3,
                        4,
                        5
                )
        );

        //将对象中的age单独组合给一个list
        List<Integer> ageList = userB.stream().map(x -> x.getAge()).collect(Collectors.toList());

        //只要有相邻元素A和B都满足删除条件，那么A被删掉，B一定会被保留下来。
//        for (int i = 0; i < userB.size(); i++) {
//            if ("a".equals(userB.get(i).getUsername())){
//                userB.remove(i);
//            }
//        }
        //倒序循环可以实现删除
        for (int i = userB.size() - 1; i >= 0; i--) {
            if ("a".equals(userB.get(i).getUsername())){
                userB.remove(i);
            }
        }

//        Iterator<User> iterator = userB.iterator();
//        while (iterator.hasNext()){
//            User next = iterator.next();
//            if ("a".equals(next.getUsername())){
//                iterator.remove();
//            }
//        }

        userB.forEach(System.out::println);

    }

}
