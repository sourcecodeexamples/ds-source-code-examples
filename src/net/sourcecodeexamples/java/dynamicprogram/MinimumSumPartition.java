package net.sourcecodeexamples.java.dynamicprogram;
// Partition a set into two subsets such that the difference of subset sums is minimum

/* 
Input:  arr[] = {1, 6, 11, 5} 
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11    

Input:  arr[] = {36, 7, 46, 40}
Output: 23
Explanation:
Subset1 = {7, 46} ;  sum of Subset1 = 53
Subset2 = {36, 40} ; sum of Subset2  = 76
 */

import java.util.*;
import java.lang.*;
import java.io.*;
public class MinimumSumPartition
{
	public static void main (String[] args)
	{
	 	Scanner sc = new Scanner(System.in);
	 	int t = sc.nextInt();
	 	while(t-->0)
	 	{
			int n = sc.nextInt();
		     	int arr[] = new int[n];
		     	int sum = 0;
		     	for(int i = 0;i < n;i++)
		     	{
				arr[i] = sc.nextInt();
			 	sum += arr[i];
		     	}
		     	int ans[] = new int[sum];
		     	ans = subset(arr,sum);
		     	int min = Integer.MAX_VALUE;
		     	for (int i = 0; i < ans.length; i++)
		     	    min = Math.min(min,(sum-2*ans[i]));
			System.out.println(min);
		}
	 }
	 static int[] subset(int arr[],int sum)
	 {
	 	int n = arr.length;
	     	boolean dp[][] = new boolean[n+1][sum+1];
	    	for(int i = 0; i <= n; i++)
	     		dp[i][0] = true;
	     	for(int i = 1; i <= sum; i++)
	     		dp[0][i] = false;
	     	// subset sum concept
	    	for(int i = 1; i <= n; i++)
	    	{
	        	for(int j = 1; j <= sum; j++)
	        	{
	            		if(arr[i-1] <= j)
	            			dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            		else
	            			dp[i][j] = dp[i-1][j];
	        	}
	    	}
	    	//storing last dp column whose value is true till sum/2
	    	int index[] = new int[sum];
	    	int p = 0;
	    	for(int i = 0 ; i <= sum / 2; i++)
	    	{
	        	if(dp[n][i] == true)
	            		index[p++] = i;
	    	}
	    	return index;
	 }
}
