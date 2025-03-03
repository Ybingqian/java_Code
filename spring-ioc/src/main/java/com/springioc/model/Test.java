package com.springioc.model;

public class Test {
    public static void main(String[] args) {
         int[] nums={2,3,1,2,4,3};
         int[] nums1={1,1,1,1,1,1,1};
         int target=11;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums1.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=nums1[k];
                    if(sum>=target){
                        min = Math.min(min,j-i+1);
                        break;
                    }
                }
            }
        }
        System.out.println(min==Integer.MAX_VALUE?0:min);
    }
}
