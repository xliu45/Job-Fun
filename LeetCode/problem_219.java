package com.mark.brushproblem_219;

/*
219. Contains Duplicate II

Given an array of integers and an integer k, find out whether there are two distinct indices i and j 
in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
Example:
in array [1, 2, 3, 4, 1], k= 4 should return the true value.

Author: Huaqing Zhang
*/


import java.lang.Math;

public class problem_219 {

    

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Boolean isExist = false;
        for (int i =0; i<nums.length;i++ ){
            for (int j=0; j< nums.length; j++ ){
                if (nums[i]==nums[j] && i!=j && Math.abs(i-j)<=k){
                     isExist = true;
                }   
            }
        }
     return isExist;
    }


public static void main(String[] args) {
    int k=4;
    int[] nums = {1,2,3,4,1};
    problem_219 model= new problem_219();
    boolean finaldecision = model.containsNearbyDuplicate(nums, k);
    System.out.println(finaldecision);
}

}