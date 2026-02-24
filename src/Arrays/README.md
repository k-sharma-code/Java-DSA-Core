#  Array Masterclass: Logic & Optimization

A collection of high-performance Array solutions. Each problem is solved with a focus on **Edge-Case Stability** and **Optimal Complexity**.

##  Problem Directory
| # | Problems                                              | Difficulty | Pattern                   | Documentation                                |
|---|-------------------------------------------------------|------------|---------------------------|----------------------------------------------|
| 01 | [Maximum Product Subarray](./MaxProductSubarray.java) | Medium | Dual-State Tracking       | [View Details](#01-maximum-product-subarray) |
| 02 | [Next Permutation](./NextPermutation.java)            | Medium | Lexicographical Swap      | [View Details](#02-next-permutation)         |
| 03 | [Trapping Rain Water](./TrappingRainWater.java)       | Hard | Prefix-Suffix/Two-Pointer | [View Details](#03-trapping-rain-water)      |

---

#  Problem Breakdown

## 01. Maximum Product Subarray

### Problem Statement 
   Find the contiguous subarray (at least one number) which has the largest product.

### Intuition:
   A standard Kadane’s algorithm fails here because two negative numbers can multiply to create a large positive product. I used a **Dual-State** approach, keeping track of both the maximum and minimum products at each step to handle these sign-flips.

### Algorithm:**
1. **Variables:** I used `maxProd`, `minProd`, and `result`, all initialized to `nums[0]`.
2. **The Swap:** If `current < 0`, I swap `maxProd` and `minProd`. This is because a small negative number becomes a large positive when multiplied by another negative.
3. **Execution:** At each step, I update `maxProd` and `minProd` using `Math.max/min(current, current * previous)`.
4. **Global Capture:** The `result` variable stores the highest `maxProd` found during the entire traversal.

### Complexity analysis:
- **Time:** $O(N)$ — Single pass through the array.
- **Space:** $O(1)$ — Constant space, no extra arrays used.

### Example Trace:
- **Input:** `[2, 3, -2, 4]` ⮕ **Output:** `6`
- **Input:** `[-2, -1, -3]` ⮕ **Output:** `3`

### What I Learned :
- **State Preservation:** Why a separate `result` variable is crucial—it prevents losing the "Global Best" when a local product resets to zero or a small number.
- **Handling Inversions:** Using a simple `swap` is more efficient than writing complex `if-else` blocks for negative numbers.


---

## 02. Next Permutation

### Problem:
  Implement the function that rearranges numbers into the lexicographically next greater permutation. If no such arrangement is possible (i.e., the array is sorted in descending order), it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

### Intuition:
  The next larger sequence is found by identifying the rightmost "dip" (pivot) where the increasing sequence from the right breaks, swapping it with its next greater successor, and reversing the suffix to minimize the increment.

### Algorithm:
1. **Find Pivot:** Scan from right to find index `i` such that `nums[i] < nums[i+1]`.
2. **Find Successor:** If `pivot != -1`, find index `j` from right such that `nums[j] > nums[pivot]`.
3. **Swap & Reverse:** Swap `nums[pivot]` with `nums[j]` and reverse the suffix starting from `pivot + 1`.

### Complexity analysis:
- **Time:** $O(N)$ (At most three linear passes)
- **Space:** $O(1)$ (In-place operations)

### Example:
- **Input:** `[1, 2, 3]` → **Output:** `[1, 3, 2]`
- **Input:** `[3, 2, 1]` → **Output:** `[1, 2, 3]`

### What I Learned:
- I got to know manual implementation of lexicographical logic without built-in helpers.
- Practiced clean encapsulation using `private static` helper methods for `swap` and `reverse`.

---

## 03. Trapping Rain Water

### Problem Statement
Given an array `height` representing an elevation map where the width of each bar is 1, calculate the total units of water it can trap after raining.

---

### Intuition
The amount of water trapped at any bar is determined by the lower of the two tallest boundaries (left and right).
- **Goal:** Achieve $O(n)$ time complexity with minimal auxiliary space.

---

###  Algorithm :

#### Approach 1: (Prefix & Suffix Arrays):
**Method:** `trapPrefixSuffix(int[] height)`
1.  **Boundary Tracking:** Pre-compute two arrays, `leftMax[]` and `rightMax[]`.
2.  **Filling:** `leftMax[i]` stores max height from start to $i$; `rightMax[i]` stores max height from end to $i$.
3.  **Calculation:** `totalWater += Math.min(leftMax[i], rightMax[i]) - height[i]`.

#### Approach 2: (Two-Pointer Strategy (Optimal))
**Method:** `trapTwoPointer(int[] height)`
1.  **Pointers:** Initialize `left = 0` and `right = height.length - 1`.
2.  **Key Insight:** By maintaining running `leftMax` and `rightMax`, we compute water without extra arrays.
3.  **Movement:** Always move the pointer pointing to the smaller height to ensure the "limiting boundary" is correctly tracked.

---

### Complexity Analysis:

#### Approach 1: Prefix-Suffix
- **Time:** $O(n)$ – Multiple passes to fill arrays and calculate sum.
- **Space:** $O(n)$ – Extra arrays `leftMax` and `rightMax` are required.

#### Approach 2: Two-Pointer
- **Time:** $O(n)$ – Single pass through the array.
- **Space:** $O(1)$ – Constant space, no extra arrays used.

---

### Example
**Input:** `height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]`
- **Prefix-Suffix Trace:** Computes boundaries $O(n)$ and sums water. **Output: 6**
- **Two-Pointer Trace:** Converges pointers dynamically and sums water. **Output: 6**

---

###  What I Learned
- **Space Optimization:** Successfully transitioned from $O(n)$ auxiliary space to $O(1)$ constant space.
- **Pointer Convergence:** Learned how moving pointers based on boundary height ensures accurate trapping logic.
