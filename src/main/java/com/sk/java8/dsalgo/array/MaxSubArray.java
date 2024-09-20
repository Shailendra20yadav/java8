package com.sk.java8.dsalgo.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] arr = {2, 3, -8, 7, -1, 2, 1};
		int result = sumOfMaxSubArrayUsingInnerLoop(arr);
        System.out.println("Sum= "+result);
        printSubArrayOfMaxSumUsingInnerLoop(arr);
        printSubArrayOfMaxSumUsingSingleLoop(arr);
        //assert( 11==result) :"Result does not match with value 11";
       // result = sumOfMaxSubArrayUsingSingleLoop(arr);
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
	
	private static void printSubArrayOfMaxSumUsingInnerLoop(int[] arr) {
		int result = arr[0];
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			int curSum = 0;
			for (int j = i; j < arr.length; j++) {
				curSum = curSum + arr[j];
				if (curSum > result) {
					result = curSum;
					startIndex = i;
					endIndex = j;
				}
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int i = startIndex; i <= endIndex; i++)
			res.add(arr[i]);
		System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(",")));

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
	
	private static void printSubArrayOfMaxSumUsingSingleLoop(int[] arr) {
		int result = arr[0];
		int startIndex = 0;
		int endIndex = 0;
		int maxEnding  =arr[0];
		int currStart = 0;
		for(int i=1;i<arr.length;i++) {
			
			if(maxEnding+arr[i] < arr[i]) {
				maxEnding = arr[i];
				currStart=i;
			}else {
				maxEnding = maxEnding+arr[i];
			}
			if(maxEnding>result) {
				result = maxEnding;
				startIndex = currStart;
				endIndex=i;
			}
			
		}
		
		List<Integer> res = new ArrayList<>();
		for (int i = startIndex; i <= endIndex; i++)
			res.add(arr[i]);
		System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(",")));
		
	}

}
