# Nearest Smaller Number on the Left

## Description

For each number in an array, find a smaller number nearest to its left.
If no smaller number, print -1.

### Examples

#### Example 1

Input: 1, 6, 2  
Output: -1, 1, 1  

#### Example 2

Input: 1, 5, 0, 3, 4, 5  
Output: -1, 1, -1, 0, 3, 4

[Test Cases](../../../../../../../../test/java/com/sdp/problems/medium/array/nearestsmallernum/TestCasesProvider.java)

### Links

* [Original Problem](https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1)
* [Original Problem Editorial](https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/)

## Solution Approaches

| Approach                      | Time Complexity | Space Complexity |
|-------------------------------|-----------------|------------------|
| [Simple](SimpleSolution.java) | O(n^2)          | O(1)             |
| [Stack](StackSolution.java)   | O(n)            | O(n)             |

### Stack Solution

* Previous numbers need to be stored and traversed only in LIFO fashion because we can stop when the nearest lesser number is found. A Stack data structure is ideal for this purpose.
* Since each number is pushed and popped at most once on the stack, time complexity reduces to O(n) (overall constant number of operations per element).
  * Think of the example {1, 6, 7, 8, 9, 5, 4, 3, 2} - With the simple solution approach, you will need to loop through all previous elements for 5, 4, 3 and 2. With the stack approach, when processing 5, all previous elements till 1 are removed from the stack. Similarly, for 4, 3 and 2. This means, the worse case scenario is addition and removal of each element once, which is constant number of operations per element. 
* Deque implementation is used instead of Stack class as per the [javadoc](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html).

#medium
#gfg
#stack
