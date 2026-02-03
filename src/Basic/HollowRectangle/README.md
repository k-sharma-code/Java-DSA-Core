# Hollow Rectangle Pattern in Java

## Title
**Pattern Printing: Hollow Rectangle Implementation using Nested Loops**

---

## Intuition
The core objective is to visualize an $M \times N$ grid and isolate its perimeter. Unlike a solid rectangle where every coordinate is filled, a hollow rectangle only renders symbols at the boundaries.

Think of it as a coordinate system where we only "activate" the pixels that form the outer frame, leaving the interior as a structured void. This helps in understanding how to apply specific filters to 2D data structures.

---

## Logic & Algorithm
The program utilizes two nested loops to traverse the grid:
1. **Outer Loop (Rows):** Iterates from `i = 1` up to `m`.
2. **Inner Loop (Columns):** Iterates from `j = 1` up to `n`.

### The Boundary Condition
For every position $(i, j)$, a star is printed **only** if it satisfies at least one of these conditions:
- **First Row:** `i == 1`
- **Last Row:** `i == m`
- **First Column:** `j == 1`
- **Last Column:** `j == n`

**Execution Steps:**
- **Check Condition:** If `(i == 1 || i == m || j == 1 || j == n)` is true, print `* `.
- **Else (Internal Void):** Print `  ` (two spaces) to maintain vertical and horizontal alignment.
- **Row Transition:** After the inner loop completes, `System.out.println()` is called to move to the next row.

---

## What I Learned
- **Boundary Mapping:** Gained the ability to identify and isolate perimeter coordinates in a 2D plane.
- **Logical OR (`||`) Application:** Learned how to combine multiple boundary checks into a single efficient conditional statement.
- **Visual Symmetry:** Understood that for a perfect hollow shape, the "empty space" must occupy the exact same width as the "star + space" (`* `) to prevent the shape from skewing.
- **2D Grid Control:** Improved mastery over nested loops, which is a foundational skill for Matrix and Array problems.

---

## Time Complexity
**$O(M \times N)$** The algorithm visits every cell in the $M \times N$ grid exactly once to evaluate the boundary condition, making the time complexity proportional to the total number of elements.

---

## Example Trace
**Input:** `m = 4, n = 5`

**Output:**
```
* * * * *
*       *
*       *
* * * * *