package com.sk.java8.dsalgo.array;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] arr = {2, 3, -8, -7, -1, 2, 1};
		int result = sumOfMaxSubArrayUsingInnerLoop(arr);
        System.out.println(result);
        //assert( 11==result) :"Result does not match with value 11";
        result = sumOfMaxSubArrayUsingSingleLoop(arr);
        System.out.println("Result using single loop="+result);
	}
	
	private static int sumOfMaxSubArrayUsingInnerLoop(int[] arr) {
		int result=arr[0];
		for(int i=0;i<arr.length;i++) {
			int curSum =0;
			for (int j = i; j < arr.length; j++) {
				curSum = curSum+arr[j];
				result = Math.max(result, curSum);
			}
		}
		
		return result;
	}
	
	private static int sumOfMaxSubArrayUsingSingleLoop(int[] arr) {
		int result=arr[0];
		int maxEnding  =arr[0];
		for(int i=1;i<arr.length;i++) {
			System.out.println(" Before for i= "+i+" Element = "+ arr[i]+"  MaxEnding = "+ maxEnding+ " , result = "+result);
			maxEnding  = Math.max(maxEnding +arr[i], arr[i]);
			result= Math.max(result , maxEnding);
			System.out.println(" After for i= "+i+" Element = "+ arr[i]+"  MaxEnding = "+ maxEnding+ " , result = "+result);
			
		}
		
		return result;
	}

}
