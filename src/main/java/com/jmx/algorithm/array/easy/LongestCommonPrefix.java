package com.jmx.algorithm.array.easy;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefixSolution longestCommonPrefixSolution = new LongestCommonPrefixSolution();
        String s = longestCommonPrefixSolution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        String s1 = longestCommonPrefixSolution.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        System.out.println(s);
        System.out.println(s1);
    }
}

/**
 * 1. 找出数组里面的最短字符串
 * 2. 双层循环检查每一个字符串的每一位的一致性
 */
class LongestCommonPrefixSolution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int min_length = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (min_length > strs[i].length())
                min_length = strs[i].length();
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < min_length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i))
                    return res.toString();
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}
