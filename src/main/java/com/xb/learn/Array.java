package com.xb.learn;

import java.util.Arrays;

/**
 * 算法刷题: 数组相关
 *
 * @author 莫问
 * @date 2018/11/9
 */
public class Array {

    /**
     * 移动零
     * 给定一个数组，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * @param nums 数组
     */
    public static void moveZeroes(int[] nums) {

        // 必须在原数组上操作，不能拷贝额外的数组。
        // 尽量减少操作次数。
        // 输入: [0,1,0,3,12]
        // 输出: [1,3,12,0,0]

        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 移动元素
     * <p>
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums 数组
     * @param val  比较的值
     * @return 返回移除后数组的新长度
     */
    public static int removeElement(int[] nums, int val) {

        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len] = nums[i];
                len++;
            }
        }

        System.out.println(len);
        return len;
    }

    /**
     * 删除排序数组中的重复项 II
     *
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums 数组 TODO 还有问题
     * @return 返回移除后数组的新长度
     */
    public static int removeDuplicates(int[] nums) {

        int i = 0;
        int count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                if (count > 2) {
                    for (int k = 0; k < count - 2; k++) {
                        nums[k + 3] = nums[j];
                        i++;
                    }
                    count = 1;
                }
            } else {
                count++;
            }
        }

        System.out.println(i);
        return i;
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] value = new boolean[p.length()+1][s.length()+1];
        value[0][0] = true;
        for(int i = 1;i <= s.length();i++){
            value[0][i] = false;
        }
        for(int i = 1;i <= p.length(); i++){
            if(p.charAt(i-1) == '*'){
                value[i][0] = value[i-1][0];
                for(int j = 1;j <= s.length(); j++){
                    value[i][j] = (value[i][j-1] || value[i-1][j] || value[i-1][j-1]);
                }
            }else if(p.charAt(i-1) == '?'){
                value[i][0] = false;
                for(int j = 1;j <= s.length(); j++){
                    value[i][j] = value[i-1][j-1];
                }
            }else {
                value[i][0] = false;
                for(int j = 1;j <= s.length(); j++){
                    value[i][j] = s.charAt(j-1) == p.charAt(i-1) && value[i-1][j-1];
                }
            }

        }
        return value[p.length()][s.length()];
    }

//    public static int climbStairs(int n) {
//        if(n < 2){
//            return 1;
//        }
//        int a = 1 , b = 1 , c = 0;
//        for(int i = 2; i <= n ; i ++){
//            c = a + b ;
//            a = b;
//            b = c;
//        }
//        return c;
//    }

    public static int climbStairs(int n) {
        return climb(0, n);
    }
    public static int climb(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }

        int i1 = climb(i + 1, n);
        int i2 = climb(i + 2, n);

        return  i1 + i2;
    }

    public static void main(String[] args) {

        System.out.println(climbStairs(3));
    }
}
