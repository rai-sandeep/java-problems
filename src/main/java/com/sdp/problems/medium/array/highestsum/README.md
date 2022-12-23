# Find subarray with highest sum

## Description

Given an integer array, find the subarray which has the largest sum and return its sum.

### Examples

#### Example 1

Input: -2,1,-3,4,-1,2,1,-5,4  
Output: 6  
Explanation: [4,-1,2,1] has the largest sum = 6.  

#### Example 2

Input: 1  
Output: 1

[Test Cases](../../../../../../../../test/java/com/sdp/problems/medium/array/highestsum/TestCasesProvider.java)

### Links

* [Original Problem](https://leetcode.com/problems/maximum-subarray)

## Solution Approaches

| Approach                        | Time Complexity | Space Complexity |
|---------------------------------|-----------------|------------------|
| [Simple](SimpleSolution.java)   | O(n^2)          | O(1)             |
| [Optimal](OptimalSolution.java) | O(n)            | O(1)             |

### Optimal Solution

* Based on the idea that all previous numbers are not needed to compute sum at every element.
* Instead, hold a sum in the memory that will maximize the sum when the next element is added.
  * If current element is greater than (sum + element), there is no point in storing the sum anymore. Instead, the current element can be used for future sum calculations because it has a higher value.

#medium
#leetcode
