package pres.qianmuna.alg;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author HJC
 * @version 1.0
 * @date 2020/7/18  23:36
 * @description :
 */
public class InitTest {

    @Test
    public void m1(){

        Integer v1 = 100;
        Integer v2 = 100;
        Integer v3 = 1000;
        Integer v4 = 1000;
        System.out.println(v1.equals(v2));



    }

    /// 数组 交集1
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int up = 0 , down = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        while (up < nums1.length && down < nums2.length){
            if (nums1[up] == nums2[down]){
                integers.add(nums1[up]);
                up++;
                down++;
                continue;
            }

            if (nums1[up] > nums2[down])
                down++;
            else
                up++;
        }
        int[] arr = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            arr[i] = integers.get(i);
        }
        return arr;
    }

    @Test
    public void m2(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("A", 18, "a"));
        students.add(new Student("A", 18, "a"));
        students.add(new Student("B", 19, "a"));
        students.add(new Student("C", 18, "b"));
        students.add(new Student("C", 18, "b"));

        ArrayList<Student> students1 = new ArrayList<>();
        students.forEach(v1 -> {
            if (!students1.contains(v1))
                students1.add(v1);
        });

        students1.forEach(System.out::println);

    }

    class Student{
        private String name;
        private int age;
        private String sex;

        public Student(String name, int age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        @Override
        public boolean equals(Object obj) {
            if ( ! (obj instanceof Student ))
                return false;
            Student v1 = (Student) obj;
            return this.name.equals(v1.name) && age == v1.age && sex.equals(v1.sex);

        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }


    @Test
    public void m3(){
        byte a1 = 'Z';
        byte a2 = (byte)'Z';

        int 好的  = 234;

        String  str = "罗长姑姑噶哈哈哈a";
        byte[] sb = str.getBytes();

        System.out.println(new String(sb , StandardCharsets.UTF_8));
        System.out.println(new String(sb));

    }

    @Test
    public void m4(){
        /*switch (false){

        }*/
    }

}
