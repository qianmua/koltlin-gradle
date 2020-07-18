package pres.qianmuna.alg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author HJC
 * @version 1.0
 * 谦谦君子 卑以自牧也
 * @date 2020/7/18  23:36
 * @description :
 */
public class InitTest {

    @Test
    public void m1(){

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

}
