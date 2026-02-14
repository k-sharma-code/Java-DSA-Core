#  Sorting Algorithms: Imperial Implementation:

This repository contains optimized sorting algorithms implemented in Java, focusing on **Asymptotic Efficiency**, **Stability**, and **State Persistence**.

##  Problem Directory:

| #  | Algorithm | Difficulty | Optimization          | Documentation                   |
|:---| :--- | :--- |:----------------------|:--------------------------------|
| 01 | [Bubble Sort](./BubbleSort.java) | Easy | Dual-State Early Exit | [View Details](#01-bubble-sort) |
| 02 | Selection Sort | Easy | TBD                   | Planned                         |

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

###  Asymptotic Analysis :
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


