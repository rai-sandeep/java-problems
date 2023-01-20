# Largest Product of 3

Given a list of integers, write a function that returns the largest product that can be made by multiplying any three integers.

For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

This problem is a bit more tricky than finding the largest product of two numbers, because now we have to consider negative numbers.

## Solution

```java
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class MaximumProduct {
    public static int maximumProductOfThree(List<Integer> lst) {
        Collections.sort(lst);
        int n = lst.size();
        int a = lst.get(n - 1) * lst.get(n - 2) * lst.get(n - 3);
        int b = lst.get(0) * lst.get(1) * lst.get(n - 1);
        return Math.max(a, b);
    }
}

```

This solution first sorts the input list in non-descending order. Then we take the product of the three largest integers in the sorted list, which could be the last three integers in the list and the product of the smallest two integers and the largest one, which could be the first two integers and the last one. Finally, we return the maximum of these two products.

Note:

1. **`Collections.sort`** will sort the array in ascending order
2. Also this solution assumes that input list is not empty
3. In case of negative numbers, there are chances that negative numbers will give you a bigger product than the positive numbers, thus above solution works.


### Time Complexity

The time complexity of this solution is O(n log n) because of the sorting step. The Collections.sort() method uses a variation of the merge sort algorithm which has a time complexity of O(n log n) for sorting an array of n elements.

The other steps in the solution have a time complexity of O(n) because we're iterating through the sorted list only once. So, overall the time complexity of this solution is O(n log n).

Note: This solution is not the most optimal one, there are better solutions with O(n) time complexity.


### O(n) Solution

```java
import java.util.List;

public class MaximumProduct {
    public static int maximumProductOfThree(List<Integer> lst) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : lst) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}

```

This solution uses a single pass through the input list to keep track of the three largest and two smallest elements in the list.
It maintains the max1, max2, max3 variables to keep track of top 3 maximum number and min1, min2 variables to keep track of top 2 minimum number.
Finally, it returns the maximum of the product of the three largest elements and the product of the largest element and the two smallest elements.

The time complexity of this solution is O(n), because we are iterating through the input list only once.

This is more efficient solution than the previous one as it avoids sorting and thus reduces the time complexity from O(n log n) to O(n).

### Test Cases

Here are some test cases including edge cases for the function **`maximumProductOfThree`**:

```java
import java.util.Arrays;

public class MaximumProductTest {
    public static void main(String[] args) {
        // Test case 1: Normal case
        int[] test1 = {-10, -10, 5, 2};
        int expectedOutput1 = 500;
        int output1 = MaximumProduct.maximumProductOfThree(Arrays.asList(test1));
        System.out.println("Test case 1: " + (expectedOutput1 == output1));

        // Test case 2: Normal case
        int[] test2 = {1, 2, 3, 4, 5};
        int expectedOutput2 = 60;
        int output2 = MaximumProduct.maximumProductOfThree(Arrays.asList(test2));
        System.out.println("Test case 2: " + (expectedOutput2 == output2));

        // Test case 3: Edge case 1 (All elements are same)
        int[] test3 = {5, 5, 5, 5};
        int expectedOutput3 = 125;
        int output3 = MaximumProduct.maximumProductOfThree(Arrays.asList(test3));
        System.out.println("Test case 3: " + (expectedOutput3 == output3));

        // Test case 4: Edge case 2 (All elements are negative)
        int[] test4 = {-1, -2, -3, -4};
        int expectedOutput4 = -6;
        int output4 = MaximumProduct.maximumProductOfThree(Arrays.asList(test4));
        System.out.println("Test case 4: " + (expectedOutput4 == output4));

        // Test case 5: Edge case 3 (All elements are zero)
        int[] test5 = {0, 0, 0, 0};
        int expectedOutput5 = 0;
        int output5 = MaximumProduct.maximumProductOfThree(Arrays.asList(test5));
        System.out.println("Test case 5: " + (expectedOutput5 == output5));

    }
}

```

Test case 1: The input list is [-10, -10, 5, 2], the expected output is 500 which is the product of -10 * -10 * 5, the expected output and the function output should match.

Test case 2: The input list is [1, 2, 3, 4, 5], the expected output is 60 which is the product of 3 * 4 * 5, the expected output and the function output should match.

Test case 3: The input list is [5, 5, 5, 5], the expected output is 125 which is the product of 5 * 5 * 5, the expected output and the function output should match.

Test case 4: The input list is [-1, -2, -3, -4], the expected output is -6 which is the product of -1 * -2 * -3, the expected output and the function output should match.

Test case 5: The input list is [0, 0, 0, 0], the expected output is 0 which is the product of 0 * 0 * 0, the expected output and the function output should match.
