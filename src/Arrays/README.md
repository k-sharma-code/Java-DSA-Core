#  Array : Logic & Optimization

A collection of high-performance Array solutions. Each problem is solved with a focus on **Edge-Case Stability** and **Optimal Complexity**.

##  Problem Directory
| #  | Problems                                                     | Difficulty    | Pattern                                                 | Documentation                                    |
|----|--------------------------------------------------------------|---------------|---------------------------------------------------------|--------------------------------------------------|
| 01 | [Maximum Product Subarray](./MaxProductSubarray.java)        | Medium        | Dual-State Tracking                                     | [View Details](#01-maximum-product-subarray)     |
| 02 | [Next Permutation](./NextPermutation.java)                   | Medium        | Lexicographical Swap                                    | [View Details](#02-next-permutation)             |
| 03 | [Trapping Rain Water](./TrappingRainWater.java)              | Hard          | Prefix-Suffix/Two-Pointer                               | [View Details](#03-trapping-rain-water)          |
| 04 | [Product Of Array Except Self](./ProdOfArrayExceptSelf.java) | Hard          | Prefix-Suffix                                           | [View Details](#04-product-of-array-except-self) |
| 05 | [Stock Buy And Sell](StockBuyAndSell.java)                   | Easy          | Greedy Approach                                         | [View Details](#05-stock-buy-and-sell)           |
| 06 | [Find The Duplicate Number ](FindDuplicateNumber.java)       | Easy - Medium | Slow-fast pointer(Floyd's cycle detection) /<br/> Hashset | [View Details](#06-find-the-duplicate-number)    |
| 07 | [Book Allocation ](./BookAllocation.java)                    | Hard | Binary Search on Answer + Greedy strategy               | [View Details ](#07-book-allocation) |
| 08 | [Aggressive Cows](./AggressiveCows.java)                     | Hard |  Binary Search on Answer + Greedy strategy | [View Details](#08-aggressive-cows) |
| 09 | [Majority Elements ](./MajorityElement.java)                 | Easy |  Boyer-Moore Voting Algorithm | [View Details](#09-majority-element) |
| 10 | [Spiral Matrix Traversal](./SpiralMatrix.java)| Medium | Simulation (Boundary Traversal) | [View Details](#10-spiral-matrix-traversal) |

---

#  Problem Breakdown

## 01. Maximum Product Subarray

### Problem Statement 
   Find the contiguous subarray (at least one number) which has the largest product.

### Intuition:
   A standard Kadane’s algorithm fails here because two negative numbers can multiply to create a large positive product. I used a **Dual-State** approach, keeping track of both the maximum and minimum products at each step to handle these sign-flips.

### Algorithm:
1. **Variables:** I used `maxProd`, `minProd`, and `result`, all initialized to `nums[0]`.
2. **The Swap:** If `current < 0`, I swap `maxProd` and `minProd`. This is because a small negative number becomes a large positive when multiplied by another negative.
3. **Execution:** At each step, I update `maxProd` and `minProd` using `Math.max/min(current, current * previous)`.
4. **Global Capture:** The `result` variable stores the highest `maxProd` found during the entire traversal.

### Complexity analysis:
- **Time:** $O(N)$ — Single pass through the array.
- **Space:** $O(1)$ — Constant space, no extra arrays used.

### Example :
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


### Intuition
The amount of water trapped at any bar is determined by the lower of the two tallest boundaries (left and right).
- **Goal:** Achieve $O(n)$ time complexity with minimal auxiliary space.


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


### Complexity Analysis:

#### Approach 1: Prefix-Suffix
- **Time:** $O(n)$ – Multiple passes to fill arrays and calculate sum.
- **Space:** $O(n)$ – Extra arrays `leftMax` and `rightMax` are required.

#### Approach 2: Two-Pointer
- **Time:** $O(n)$ – Single pass through the array.
- **Space:** $O(1)$ – Constant space, no extra arrays used.
- 

### Example
**Input:** `height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]`
- **Prefix-Suffix Trace:** Computes boundaries $O(n)$ and sums water. **Output: 6**
- **Two-Pointer Trace:** Converges pointers dynamically and sums water. **Output: 6**


###  What I Learned
- **Space Optimization:** Successfully transitioned from $O(n)$ auxiliary space to $O(1)$ constant space.
- **Pointer Convergence:** Learned how moving pointers based on boundary height ensures accurate trapping logic.


---


## 04. Product of Array Except Self

### Problem Statement:
Return an array `ans` where `ans[i]` is the product of all elements in `arr` except `arr[i]`.

**Constraints:**
- Time: $O(n)$ | Space: $O(1)$ (Auxiliary)
- **No Division Operator.**

### Intuition:
Combining **Prefix Product** (elements to the left) and **Suffix Product** (elements to the right) in two linear passes.


### Algorithm Approach:
1. **Forward Pass:** Store cumulative prefix products in `result[]`.
2. **Backward Pass:** Use a `suffix` variable to multiply existing prefix values and update on-the-fly.


### Edge Cases:
- **Single Zero:** `[0, 1, 2]` → `[2, 0, 0]` (Handled natively)
- **Multiple Zeros:** `[0, 0, 2]` → `[0, 0, 0]` (No division error)
- **Single Element:** `[1]` → `[1]` (Boundary safe)


### Complexity:
- **Time:** $O(n)$
- **Auxiliary Space:** $O(1)$
- **Total Space:** $O(n)$
- 

### Example:
**Input:** `[1, 2, 3, 4]`
- **Prefix:** `[1, 1, 2, 6]`
- **Suffix Integration:** `[24, 12, 8, 6]`.

### What I learned :
- Prefix-Suffix technique to compute result without using division.
- How to achieve O(n) time with two linear passes .
- Space optimization by storing prefix values directly int the output array.
- Handling edge cases with zeros naturally without special conditions.


---

## 05. Stock Buy And Sell

### Problem Statement
Maximize profit from a single buy-sell transaction in $O(n)$ time and $O(1)$ space.


### Intuition
The algorithm treats **every day as a potential Selling Day**. To maximize profit for any day $i$, we must have bought at the lowest possible price between day $0$ and $i-1$. By tracking this "Historical Minimum" (`minPrice`), we find the optimal profit in a single pass.

### Algorithm Approach
1. **Initial State:** `maxProfit = 0`, `minPrice = prices[0]`.
2. **One-Pass Logic:** For each day's price:
    - **Sell Today?** If `price > minPrice`, calculate profit and update `maxProfit`.
    - **Buy Today?** Update `minPrice` if the current price is the new historical minimum.
3. **Result:** Global `maxProfit` found in $O(n)$.


### Complexity Analysis
- **Time Complexity:** $O(n)$ — Single linear scan.
- **Auxiliary Space:** $O(1)$ — Only two variables used.


### Example
**Input:** `[7, 1, 5, 3, 6, 4]`
- **If Selling Day is 5 (Price 6):** Best Buy Day was 1 (Price 1). **Profit = 5**.
- **If Selling Day is 6 (Price 4):** Best Buy Day was 1 (Price 1). **Profit = 3**.
  **Max Profit:** `5`

### What I Learned
- **Dynamic Candidate Selection:** Every element is a candidate for "selling," compared against the best "buying" candidate from the past.
- **Temporal Consistency:** Solved without nested loops by carrying forward the minimum state.
- **Efficiency:** Achieved peak optimization ($O(n)$ time, $O(1)$ space).
   

---

## 06. Find the Duplicate Number

### Problem Statement
Identify the single duplicate number in an array `nums` of $n+1$ integers where each integer is in the range $[1, n]$.


### Constraints
 **1 : Floyd's Cycle Detection**
- **Array Size:** $n+1$
- **Number Range:** $1$ to $n$
- **Requirement:** At least one duplicate must exist.
- **Strict Rule:** Do not modify the array; Use $O(1)$ space.

 **2 : HashSet**
- **Flexibility:** Works for any integer array.
- **Duplicate Rule:** Duplicate may or may not exist; handles multiple duplicates.


### Intuition

#### **1. Floyd's Cycle Detection**
- **Logic:** Treat the array as a **Linked List** (index $\to$ value). A duplicate value means two different indices point to the same "node," inevitably creating a **Cycle**. The duplicate is the **Entrance Node** of that cycle.



#### **2. HashSet**
- **Logic:** Maintain a **Historical Memory** (Hash Table) of visited elements. The first element that "collides" with an existing entry in our memory is the duplicate.


### Algorithm

#### **1. Floyd's Cycle Detection**
1. **Phase 1 (Meeting):** Initialize `slow` and `fast` at `nums[0]`. Move `slow` by 1 step and `fast` by 2 steps until they collide.
2. **Phase 2 (Entrance):** Reset `slow` to `nums[0]`. Move both pointers 1 step at a time. The point where they meet is the duplicate number.

#### **2. HashSet**
1. Iterate through the array.
2. For each value, check if it exists in the set.
3. If found, return the value; else, add it to the set.


### Complexity Analysis
| Strategy | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| **Floyd's Cycle** | $O(n)$ | $O(1)$ |
| **HashSet** | $O(n)$ | $O(n)$ |


### Example
**Input:** `[1, 3, 4, 2, 2]`
- **HashSet:** Stores `1, 3, 4`. Next `2` is not in set, so added. Final `2` is already in set $\to$ **Result: 2**.
- **Floyd's:** Pointers collide in cycle $\to$ `slow` reset $\to$ Meeting at value **2**.


### What I Learned
- **Virtual Linking:** Transforming array values into directed graph pointers.
- **Mathematical Convergence:** Understanding how Phase 2 synchronization finds the cycle entrance.
- **Efficiency Trade-off:** Choosing between absolute memory efficiency ($O(1)$) and logic simplicity ($O(n)$).

---

## 07. Book Allocation

### Problem statement :
Minimize the **maximum number of pages** assigned to a student such that books are allocated contiguously among `m` students.


### Intuition :
Since the answer follows a **Monotonic** property (if `X` pages work, `X+1` also works), we apply **Binary Search** on the range of possible answers instead of the array itself.


### Algorithm :
1. **Edge Case:** If `m > n`, return `-1` (Each student needs at least one book).
2. **Search Space:**
    - `st` = `max(arr)` (A student must carry at least the largest book).
    - `end` = `sum(arr)` (One student gets everything).
3. **Binary Search Loop:**
    - While `st <= end`:
        - If `isValid(mid)` is **True**: `ans = mid`, search left (`end = mid - 1`).
        - Else: Search right (`st = mid + 1`).
4. **Validation (`isValid`):** Greedily sum pages. If `current_sum > mid`, increment student count and reset sum. Return `true` if `students <= m`.


### Complexity Analysis :
- **Time:** $O(N \cdot \log(\sum \text{pages}))$ — Efficient for large inputs.
- **Space:** $O(1)$ — No extra memory used.


### Example :
**Input:** `[10, 20, 30, 40]`, `m = 2`  
**Output:** `60` (Student 1: 10+20+30, Student 2: 40)


### What I Learned :
- Applied Binary search on answer using a monotonic search space .
- Used Greedy Strategy to book allocation.

---

## 08. Aggressive Cows

### Problem Statement
Given `n` stalls at different positions and `c` aggressive cows,
place the cows such that the **minimum distance** between any
two cows is **as large as possible**. Return that maximum
possible minimum distance.

### Intuition
The moment I saw this problem, it reminded me of Book Allocation —
both problems ask us to **maximize a minimum value**, which is
a classic sign of binary search on answer. Instead of searching
in the array, we search for the best possible distance in a range.

### Algorithm
1. Sort the stall positions
2. Set binary search range: `start = 1`, `end = stalls[n-1] - stalls[0]`
3. For each `mid`, check if placing all cows with minimum
   distance `mid` is possible using `isPossible()`
4. In `isPossible()` — greedily place each cow at the first
   stall that is far enough from the last placed cow
5. If possible → save answer, search right half
6. If not possible → search left half

### Complexity Analysis
- **Sorting:** O(n log n)
- **Binary Search × Greedy Check:** O(log(max\_range)) × O(n) = O(n log(max\_range))
- **Total: O(n log n + n log(max\_range))**

In most cases `max_range >> n`, so the dominant term is
**O(n log(max\_range))**.

### Example
Stalls = `[1, 2, 4, 8, 9]`, Cows = `3`  
Search Range = `[1, 8]`

- **mid = 3** → cows at `1, 4, 8` → distances `3, 4` → Possible
- **mid = 4** → cows at `1, 8` → next required stall ≥ `12` → Not Possible

**Maximum Minimum Distance = 3**

### What I Learned
- How to apply **Binary Search on Answer** instead of searching in the array
- How to use a **greedy feasibility check (`isPossible`)** to validate a candidate distance
- Recognizing the pattern used in problems like **Book Allocation** .

---

## 09. Majority Element

### Problem Statement
Given an array `nums` of size `n`, the objective is to identify the **Majority Element**. By definition, this element appears more than `⌊n / 2⌋` times in the sequence. The solution must aim for linear time complexity and constant auxiliary space.

### Intuition
The algorithm operates on the principle of **Moore's Voting Algorithm**. The core idea is that if we cancel out each occurrence of a candidate element with all other different elements, the majority element will remain as the "survivor" because its frequency is strictly greater than half of the total population.

### Algorithm
1. **Candidate Identification:**
   - Initialize `ans` (candidate) and `freq` (counter) to 0.
   - Iterate through the array. If `freq == 0`, assign the current element to `ans`.
   - If the current element matches `ans`, increment `freq`; otherwise, decrement it.
2. **Verification Step (Crucial for Integrity):**
   - After finding the candidate, perform a second pass to count its actual occurrences (`count`).
   - If `count > n/2`, return `ans`. Otherwise, return -1 (indicating no majority element exists).

### Complexity Analysis
* **Time Complexity:** $O(n)$ — The algorithm performs two linear scans of the array.
* **Space Complexity:** $O(1)$ — No additional data structures are utilized, maintaining a constant memory footprint.

### Example
* **Input:** `nums = [2, 2, 1, 1, 1, 2, 2]`
* **Execution:**
   - `i=0`: freq=0, ans=2, freq becomes 1.
   - `i=1`: matches ans, freq=2.
   - `i=2`: mismatch, freq=1.
   - `i=3`: mismatch, freq=0.
   - `i=4`: freq=0, ans=1, freq=1.
   - `i=5`: mismatch, freq=0.
   - `i=6`: freq=0, ans=2, freq=1.
* **Result:** Candidate `2` is verified with count 4 ($4 > 7/2$), returning **2**.

### What I Learned
* How the Boyer–Moore Voting Algorithm identifies a majority candidate using pairwise cancellation.
* Why a verification step is necessary when the existence of a majority element is not guaranteed.

---

## 10. Spiral Matrix Traversal

### Problem Statement
Given an `m x n` matrix, the goal is to extract all its elements in a **Spiral Order**. The traversal starts from the top-left and moves clockwise, covering the outer boundaries first before moving to the inner layers.


### Intuition
The logic revolves around four boundaries: **stRow, endRow, stCol, and endCol**. By systematically iterating through these boundaries and shrinking them after each step (Top -> Right -> Bottom -> Left), we can visit every element in a spiral pattern.


### Algorithm
1. **Setup:** Identify the total rows (`m`) and columns (`n`). Initialize the starting and ending pointers for both rows and columns.
2. **Layer Traversal:** Use a `while` loop that runs as long as the boundaries don't cross each other.
3. **Four-Step Movement:**
    - **Top:** Move from `stCol` to `endCol` along the `stRow`.
    - **Right:** Move from `stRow + 1` to `endRow` along the `endCol`.
    - **Bottom:** Move back from `endCol - 1` to `stCol` along the `endRow`.
    - **Left:** Move up from `endRow - 1` to `stRow + 1` along the `stCol`.
4. **Boundary Protection:** Added specific `if` checks (`stRow == endRow` and `stCol == endCol`) inside the loops to prevent duplicate printing in single-row or single-column scenarios.
5. **Shrink:** Update all pointers to move to the next inner layer of the matrix.


### Complexity Analysis
- **Time Complexity:** $O(m \times n)$ — Every element in the matrix is accessed exactly once during the simulation.
- **Space Complexity:** $O(m \times n)$ —  the space is $O(m \times n)$ to store the result in the output list. However, the **Auxiliary Space** used for boundary pointers is $O(1)$.


### Example
**Input (2x3 Rectangular):**
`[[1, 2, 3], [4, 5, 6]]`  
**Output:** `[1, 2, 3, 6, 5, 4]`

**Input (3x3 Square):**
`[[1, 2, 3], [4, 5, 6], [7, 8, 9]]`  
**Output:** `[1, 2, 3, 6, 9, 8, 7, 4, 5]`


### What I Learned
- **Manual Boundary Management:** How to control multiple pointers simultaneously without overlap.
- **Edge Case Handling:** Successfully handled unique shapes like 1x4 (Single Row) and 3x1 (Single Column) by using targeted `break` conditions.
