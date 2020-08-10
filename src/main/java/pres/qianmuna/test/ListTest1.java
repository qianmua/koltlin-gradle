package pres.qianmuna.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HJC
 * @version 1.0
 * @date 2020/7/20  22:36
 * @description :
 */
public class ListTest1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        System.out.println(list.contains(2));
        int a = 1;
        Integer b = 1;
        System.out.println(a == b);
        System.out.println(b.equals(a));
    }
}
