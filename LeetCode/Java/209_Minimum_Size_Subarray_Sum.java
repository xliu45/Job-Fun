package com.huaqingzhang.msss;

import java.util.*;
/*
209. minimum size subarray sum 

Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array {7,2,3,4,1,14,5} and s = 14,
the subarray [14] has the minimal length under the problem constraint.



Author: Huaqing Zhang
*/

public class Minimum_Size_Subarray_Sum {
    //public int minSubArrayLen(int s, int[] nums) {
        
    //}
    
    public static void main(String[] args) {
        int s=14;
        int[] nums = {7,2,3,4,1,14,5};
        int comparer=0;
        int minlength=0;
        int start=0;
        int end=0;
        int new_minlength;
        	for (int move_end=end; move_end<nums.length;move_end++){
        		comparer=comparer+nums[move_end];
        		if (comparer>=s){
            		minlength=move_end-start+1;
            		end=move_end;
            		break;
            	}
        	}
        	if (minlength==0){
        		//return minlength;
        		System.out.println(minlength);
        		
        	}
        	for (int move_start=start; move_start<end; move_start++){
        		comparer=comparer-nums[move_start];
        		if (comparer<s){
            		comparer=comparer+nums[move_start];
            		start=move_start;
            		minlength=end-start+1;
            		break;
            	}
        		if(move_start==end-1){
        			minlength=1;
        			break;
        		}
        	}
        	for (int move_end=end+1; move_end<nums.length;move_end++){
        		comparer=comparer+nums[move_end];
        		
        		for (int move_start=start; move_start<move_end; move_start++){
            		comparer=comparer-nums[move_start];
            		if (comparer<s){
                		comparer=comparer+nums[move_start];
                		start=move_start;
                		new_minlength=move_end-start+1;
                		if (new_minlength<minlength){
                			minlength=new_minlength;
                		}
                		break;
                	}
            		if(move_start==move_end-1){
            			minlength=1;
            			break;
            		}
            	}
        	}
        	//return minlength;
        System.out.println(minlength);
       
    }

}