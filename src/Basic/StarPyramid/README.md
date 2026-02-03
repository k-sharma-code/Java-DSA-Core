# Star Pyramid Pattern in Java

## Title
**Centered Star Pyramid Implementation Using Nested Loops**

---

## Intuition
The goal is to print a centered pyramid where each row has an odd number of stars. To achieve this, we first print decreasing spaces to push the stars towards the center, and then print stars that increase by 2 in each row.

---

## Algorithm
1. **Input:** Take the number of rows `n` from the user.
2. **Setup:** Initialize `nsp = n-1` (for leading spaces) and `nst = 1` (for stars).
3. **Outer Loop:** Runs from `1` to `n` to handle each row.
4. **Inner Loop 1 (Spaces):** Prints spaces to align the pyramid.
5. **Inner Loop 2 (Stars):** Prints the stars for the current row.
6. **Update:** - Decrement spaces (`nsp--`).
    - Increment stars by 2 (`nst += 2`).
    - Move to the next line.
7. **Resource Management:** Close the Scanner object after the loop.

---

## Time Complexity
**$O(n^2)$** The code uses nested loops. For every row (`n`), we iterate through spaces and stars (also proportional to `n`). Therefore, the total number of operations is $n \times n$.

---

## Example Trace (n = 3)
Row 1: 2 Spaces, 1 Star  -> `  *`
Row 2: 1 Space, 3 Stars  -> ` ***`
Row 3: 0 Spaces, 5 Stars -> `*****`