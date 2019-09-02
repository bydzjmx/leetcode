package com.jmx.algorithm.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Array 标签下的第一题
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * Example:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 26;
        int[] result = Solution1.twoSum(nums, target);
        int[] result2 = Solution2.twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        for (int i = 0; i < result2.length; i++) {
            System.out.println(result2[i]);
        }
    }
}

/**
 * 方法1： 暴力法
 * 从头开始遍历每个元素x，查看数组中是否存在一个值等于target-x
 * 算法分析：遍历两次，时间复杂度为O(n2), 空间复杂度O(1)
 */
class Solution1 {
    /**
     * 传入目标数组和目标值，得到对应的两个值
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        throw new RuntimeException("Cannot find the nums.");
    }
}

/**
 * 哈希表查找法
 * 原理，哈希表在最优情况下（没有hash碰撞）时，查找的时间复杂度为O（1），依此降低时间复杂度
 * 做两个结构，一个数组，一个hashMap（key为num[i]，value为i）
 * 1. 遍历数组，检查hashMap中是否有target-num[i]的key，如果没有，则将（num[i]，i）放入hashMap中）
 * 2. 如果找到了，则返回对应的value即可
 * 总过程循环1次，时间复杂度为O（n），空间复杂度为O（n），因为需要将数据存入hash表
 */
class Solution2{
    public static int[] twoSum(int[] nums,int target){
        //建立hashMap
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //判断map中是否存在对应的key
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }else {
                //放入hashMap中
                map.put(nums[i],i);
            }
        }
        throw new RuntimeException("Cannot find the nums.");
    }
}
