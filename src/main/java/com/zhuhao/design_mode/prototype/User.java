package com.zhuhao.design_mode.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现深拷贝
 *
 * @Author halk
 * @Date 2020/11/4 9:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Cloneable, Serializable {

    private String username;
    private Integer age;
    private Integer id;

    private Sheep sheep;

    private List<Sheep> sheepList;

    /**
     * 深拷贝，方式1：使用clone方法
     *
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        User user = (User) super.clone();

        //对类引用的类需要克隆一份
        user.sheep = (Sheep) user.sheep.clone();

        //对类引用的集合中元素也需要重新克隆一份，集合中的类也需要重写clone方法
        ArrayList<Sheep> sheepList = new ArrayList<>();
        this.sheepList.forEach(x -> {
            try {
                sheepList.add((Sheep) x.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });

        user.sheepList = sheepList;

        return user;
    }

    /**
     * 深拷贝方式二：通过输入输出流将对象深度拷贝
     * @return
     */
    public Object deepClone(){

        //创建流对象，序列化
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ByteArrayInputStream bais = null;

        try {
            //序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            //当前这个对象以对象流的方式输出
            oos.writeObject(this);

            //反序列化
            bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            User copyObject = (User)ois.readObject();

            return copyObject;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bais != null){
                try {
                    bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
