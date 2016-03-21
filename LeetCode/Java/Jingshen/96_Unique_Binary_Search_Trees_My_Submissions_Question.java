/**
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   Jingshen
   */


public class Solution {
    public int numTrees(int n) {
        if(n==0)
            return 1;
        List<Integer> sum=new ArrayList<Integer>(Arrays.asList(1));
        for(int count=1;count<=n;count++)
           sum(count,sum);
        return sum.get(n-1);
    }
    private void sum(int n, List<Integer> sum) {
        if(n<=1)
            return;
        int temp=0;
        for(int m=2;m<n;m++)
            temp+=sum.get(n-m-1)*sum.get(m-2);
        temp+=2*sum.get(n-2);
        sum.add(temp);
    }
}
