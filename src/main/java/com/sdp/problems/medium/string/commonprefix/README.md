# Common Prefix

### **Problem statement**

Given an array of strings, find the longest common prefix of all the strings. If there is no common prefix, return an empty string "".

### **Solution 1: Simple approach**

The first solution uses a simple approach to solve the problem. We use a while loop to keep removing the last character of the prefix until a common prefix is found. The loop continues until we have checked all strings in the input array or the prefix becomes an empty string. The **`indexOf()`** method is used to check if the current prefix is present in the current string at the 0th index, which means it is the prefix. This solution has a time complexity of O(S) where S is the sum of all characters in the input array of strings.

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}

```

### **Solution 2: Sorting**

The second solution uses the property of the longest common prefix, which is that it must be a prefix of the first string, and a suffix of the last string in the sorted array of strings. We can sort the input array and use the first and last string to find the longest common prefix.

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        int n = strs.length;
        int end = Math.min(strs[0].length(), strs[n-1].length());
        int i = 0;
        while (i < end && strs[0].charAt(i) == strs[n-1].charAt(i)) i++;
        return strs[0].substring(0, i);
    }
}

```

### **Solution 3: Divide and Conquer**

The third solution uses the divide and conquer technique to find the longest common prefix. We can divide the input array into two parts, and recursively find the longest common prefix of each part, and then combine them to find the final longest common prefix.

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    public String longestCommonPrefix(String[] strs, int l, int r) {
        if (l== r) return strs[l];
				int mid = (l + r) / 2;
				String left = longestCommonPrefix(strs, l, mid);
				String right = longestCommonPrefix(strs, mid + 1, r);
				return commonPrefix(left, right);
		}

		public String commonPrefix(String left, String right) {
		    int min = Math.min(left.length(), right.length());
		    for (int i = 0; i < min; i++) {
		        if (left.charAt(i) != right.charAt(i))
		            return left.substring(0, i);
		    }
		    return left.substring(0, min);
		}
}

```

Test Cases

```java
class SolutionTest {
    Solution solution = new Solution();

    @Test
    void testCase1() {
        String[] strs = {"flower","flow","flight"};
        assertEquals("fl", solution.longestCommonPrefix(strs));
    }

    @Test
    void testCase2() {
        String[] strs = {"dog","racecar","car"};
        assertEquals("", solution.longestCommonPrefix(strs));
    }

    @Test
    void testCase3() {
        String[] strs = {"abab","aba","abc"};
        assertEquals("ab", solution.longestCommonPrefix(strs));
    }

    @Test
    void testCase4() {
        String[] strs = {};
        assertEquals("", solution.longestCommonPrefix(strs));
    }

    @Test
    void testCase5() {
        String[] strs = {"a"};
        assertEquals("a", solution.longestCommonPrefix(strs));
    }
}
```

### **Conclusion**

In this post, we discussed three different solutions to the problem of finding the longest common prefix in an array of strings. The first solution has a time complexity of O(S) where S is the sum of all characters in the input array of strings, the second solution has a time complexity of O(NlogN) and the last solution has a time complexity of O(N*logN) and space complexity of O(logN).