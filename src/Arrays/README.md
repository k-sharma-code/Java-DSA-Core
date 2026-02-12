#  Array Masterclass: Logic & Optimization

A collection of high-performance Array solutions. Each problem is solved with a focus on **Edge-Case Stability** and **Optimal Complexity**.

##  Problem Directory
| # | Problems                                              | Difficulty | Pattern | Documentation                                |
|---|-------------------------------------------------------|------------|-------------|----------------------------------------------|
| 01 | [Maximum Product Subarray](./MaxProductSubarray.java) | Medium | Dual-State Tracking | [View Details](#01-maximum-product-subarray) |
| 02 | [Next Permutation](./NextPermutation.java)            | Medium | Lexicographical Swap | [View details](#02-next-permutation)         |
| 03 | Trapping Rain Water                                   | Hard | Two-Pointer | Planned                                      |

---

##  Problem Breakdown

### 01. Maximum Product Subarray

**Problem Statement:** Find the contiguous subarray (at least one number) which has the largest product.

**Intuition:** A standard Kadane’s algorithm fails here because two negative numbers can multiply to create a large positive product. I used a **Dual-State** approach, keeping track of both the maximum and minimum products at each step to handle these sign-flips.

**Surgical Strategy (The "Swap" Logic):**
1. **Variables:** I used `maxProd`, `minProd`, and `result`, all initialized to `nums[0]`.
2. **The Swap:** If `current < 0`, I swap `maxProd` and `minProd`. This is because a small negative number becomes a large positive when multiplied by another negative.
3. **Execution:** At each step, I update `maxProd` and `minProd` using `Math.max/min(current, current * previous)`.
4. **Global Capture:** The `result` variable stores the highest `maxProd` found during the entire traversal.

**What I Learned :**
- **State Preservation:** Why a separate `result` variable is crucial—it prevents losing the "Global Best" when a local product resets to zero or a small number.
- **Handling Inversions:** Using a simple `swap` is more efficient than writing complex `if-else` blocks for negative numbers.

**Complexity Profile:**
- **Time:** $O(N)$ — Single pass through the array.
- **Space:** $O(1)$ — Constant space, no extra arrays used.

**Example Trace:**
- **Input:** `[2, 3, -2, 4]` ⮕ **Output:** `6`
- **Input:** `[-2, -1, -3]` ⮕ **Output:** `3`



---

## 02. Next Permutation

**Problem:** Implement the function that rearranges numbers into the lexicographically next greater permutation. If no such arrangement is possible (i.e., the array is sorted in descending order), it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

**Intuition:** The next larger sequence is found by identifying the rightmost "dip" (pivot) where the increasing sequence from the right breaks, swapping it with its next greater successor, and reversing the suffix to minimize the increment.

**Algorithm:**
1. **Find Pivot:** Scan from right to find index `i` such that `nums[i] < nums[i+1]`.
2. **Find Successor:** If `pivot != -1`, find index `j` from right such that `nums[j] > nums[pivot]`.
3. **Swap & Reverse:** Swap `nums[pivot]` with `nums[j]` and reverse the suffix starting from `pivot + 1`.

**Complexity:**
- **Time:** $O(N)$ (At most three linear passes)
- **Space:** $O(1)$ (In-place operations)

**Example:**
- **Input:** `[1, 2, 3]` → **Output:** `[1, 3, 2]`
- **Input:** `[3, 2, 1]` → **Output:** `[1, 2, 3]`

**What I Learned:**
- I got to know manual implementation of lexicographical logic without built-in helpers.
- Practiced clean encapsulation using `private static` helper methods for `swap` and `reverse`.
