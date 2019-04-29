# pyramidBinarySum

You will have a triangle (which is a binary tree) input below and you need to find the maximum sum of the numbers per the given rules below:
1. You will start from the top and move downwards to an adjacent number as in below.
2. You are only allowed to walk downwards and diagonally.
3. You should walk over the numbers as evens and odds subsequently. Suppose that you are on an even number the next number you walk must be odd, or if you are stepping over an odd number the next number must be even. In other words, the final path would be like
Odd -> even -> odd -> even …
4. You must reach to the bottom of the pyramid.
Your goal is to find the maximum sum if you walk the path. Assume that there is at least 1 valid path to the bottom. If there are multiple paths giving the same sum, you can choose any of them.
Sample Input:
1
8 9
1 5 9
4 5 2 3
Output:
Max sum: 16
Path: 1, 8, 5, 2
Explanation:
As you can see this triangle has several paths: 1->8->5->2, 1->9->9->3, 1->8->1->4, etc…
The correct answer is 1 + 8 + 5 + 2 = 16. Because since 1 (top most number) is odd we cannot walk onto 9 because 9 is an odd number too. The only place we can step is 8. From 8 we can walk to 1 or 5. Only 1 -> 8 -> 5 -> 2 sequence gives us the maximum sum. The other path 1-> 8 -> 1 -> 4 is also a valid path but it sums up to 14. Since 16 is greater than 14, 16 is the solution. Also, note that the solution is in the form of odd > even > odd > even.
