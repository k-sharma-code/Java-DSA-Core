#  Sorting Algorithms: Imperial Implementation:

This repository contains optimized sorting algorithms implemented in Java, focusing on **Asymptotic Efficiency**, **Stability**, and **State Persistence**.

##  Problem Directory:

| #  | Algorithm                              | Difficulty | Optimization          | Documentation                      |
|:---|:---------------------------------------| :--- |:----------------------|:-----------------------------------|
| 01 | [Bubble Sort](./BubbleSort.java)       | Easy | Dual-State Early Exit | [View Details](#01-bubble-sort)    |
| 02 | [Selection Sort](./SelectionSort.java) | Easy | Defensive Early Exit  | [view Details](#02-selection-sort) |

---

##  01. Bubble Sort

###  Problem Statement:
Sort an array `nums` of size `n` in non-decreasing order. The implementation must detect if the input is already sorted to achieve $O(N)$ time complexity.

###  Intuition :
Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order. Larger elements bubble toward the end of the array. The optimization relies on detecting a pass with zero swaps, which guarantees the array is sorted.



###  Algorithm steps :
1. **Initialize `alreadySorted = true`**: Assume input is sorted until a swap occurs.
2. **Outer Loop (`i` from `0` to `n-1`)**: Controls the maximum number of passes.
3. **Inner Loop (`j` from `0` to `j < n-1-i`)**:
    - Compares `nums[j]` and `nums[j+1]`.
    - Boundary `n-1-i` prevents redundant comparisons of already sorted tail elements.
4. **Execution**: If `nums[j] > nums[j+1]`, swap them, set `isSwap = true`, and `alreadySorted = false`.
5. **Early Exit**: If `isSwap` remains `false` after a pass, `break` the execution.

###  complexity Analysis :
- **Best Case:** $O(N)$ (Array is already sorted).
- **Worst Case:** $O(N^2)$ (Array is reverse sorted).
- **Space Complexity:** $O(1)$ (In-place sorting).

###  Edge Cases :
- **Already Sorted:** Handled by `isSwap` in one pass.
- **Duplicates:** Stable; equal elements are not swapped, preserving original order.
- **Single Element:** Handled by loop condition `i < n-1`.

###  What I Learned:
- **flag-based optimization **: Using `isSwap` (pass-level) and `alreadySorted` (input-level)  to track sorting status.
- **Boundary Management**: Using `n-1-i` to avoid `ArrayIndexOutOfBoundsException`.

---

## 02. Selection Sort

### Problem Statement
Sort an integer array using Selection Sort and include a preliminary check to detect if the array is already sorted in order to reduce unnecessary processing.

### Intuition
Selection Sort is inherently non-adaptive with an $O(n^2)$ complexity. To enhance the program's execution flow, I implemented an **Early Exit Strategy**. By validating the array's state before entering nested loops, we avoid redundant $O(n^2)$ operations on already sorted datasets.

### Algorithm
1. **Defensive Validation**
   - Execute `isSorted(arr)` to perform a linear scan $O(n)$.
   - If `true`, bypass the sorting logic entirely to save computational cycles.

2. **Selection Mechanism**
   - Iterate from $i = 0$ to $n-1$.
   - Maintain `minIdx` to track the smallest element in the unsorted sub-array.

3. **Inner Scan**
   - Compare `arr[j]` with `arr[minIdx]` for all $j > i$ to find the absolute minimum.

4. **Minimal Swapping**
   - Perform exactly one swap per outer iteration between `arr[i]` and `arr[minIdx]`.


### Complexity Analysis
- **Time Complexity:**
   - **Best Case:** $O(n)$ (Due to early exit check).
   - **Average/Worst Case:** $O(n^2)$ (Standard Selection Sort behavior).
- **Space Complexity:** $O(1)$ (In-place sorting).

### Example & Output
**Input:** `[5, 1, 4, 2]`

1. **Pre-check:** `isSorted` returns `false`. Proceeding to sort.
2. **Pass 1:** Min found at index 1 (value 1). Swap with index 0. `[1, 5, 4, 2]`
3. **Pass 2:** Min found at index 3 (value 2). Swap with index 1. `[1, 2, 4, 5]`
4. **Pass 3:** Min found at index 2 (value 4). Position is correct. `[1, 2, 4, 5]`

**Console Output:**

Sorted array = 1 2 4 .

### What I Learned

- Selection Sort still takes O(n²) time because it always scans the unsorted part.
- A simple pre-check can skip sorting when the array is already sorted.
- The algorithm uses very few swaps (one per pass).
- Correct loop boundaries are important to avoid index errors.
- Selection Sort is unstable since swaps can change the order of equal elements.


