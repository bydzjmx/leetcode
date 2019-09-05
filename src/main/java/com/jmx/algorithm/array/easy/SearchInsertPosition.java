package com.jmx.algorithm.array.easy;

/**
 * 搜索插入位置。
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
    }
}

/**
 * 方法1. 暴力法
 * 解题思路：遍历数组，逐个比较大小，确定插入索引位置
 * 时间复杂度O（n)
 */
class SearchInsertSolution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //如果当前元素大于等于目标值，则下标所在位置是目标值或者目标值应插入的位置
            if(nums[i]>target){
                return i;
            }
        }
        //如果数组中没有比target大的，则插入到最后
        return nums.length;
    }
}

/**
 * 方法2，二分法
 * 利用二分查找减低时间复杂度，时间复杂度为O（logn)
 */
class SearchInsertSolution2 {
    public int searchInsert(int[] nums, int target) {
        //边界及非空判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
