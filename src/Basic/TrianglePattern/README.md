# Basic Triangle Patterns (Java)

### Title
**Star and Alphabet Triangle Implementation**

### Intuition
The logic is based on the relationship between rows and columns. In a right-angled triangle, the number of elements in a row is exactly equal to the row number.
- Row 1 has 1 element.
- Row 2 has 2 elements.
  By using a nested loop where the inner loop limit is set to the current row index (`j <= i`), we can easily control this growth.

### Algorithm
1. **Input:** Take the number of rows (`m`) from the user using `Scanner`.
2. **Outer Loop:** Controls the rows (from 1 to `m`).
3. **Inner Loop:** Controls the columns (runs from 1 up to the current row number `i`).
4. **Printing Logic:**
    - **Star:** Just print `*`.
    - **Alphabet:** Use the ASCII value of 'A' (65). By calculating `(char)(j + 64)`, we get 'A' when `j=1`, 'B' when `j=2`, and so on.
5. **Line Break:** Move to the next line after the inner loop finishes to start a new row.

### Time Complexity
**$O(n^2)$**
Since we are using two loops (one inside the other), the work increases quadratically with the number of rows. It's a simple $n \times n$ logic where only half the work is done, but in Big O notation, it remains $O(n^2)$.

### Space Complexity
**$O(1)$**
We are not using any extra arrays or storage. We only use three integer variables (`i`, `j`, `m`), so the memory used stays constant regardless of the input size.

### My Learnings 
- Learned how nested loops work together to create shapes.
- Understood that `j <= i` creates a triangle, while `j <= m` creates a square.
- Practiced ASCII type-casting to convert numbers into characters dynamically.
-