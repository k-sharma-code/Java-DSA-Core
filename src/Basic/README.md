## Basic Programming & Pattern: Imperial Logic

This directory contains fundamental programming challenges and coordinate-based pattern generation,focusing on control of  nested loop.

##  Problem Directory:
| #  | Pattern name                               | Difficulty | Key logic | Documentation                        |
|:---|:-------------------------------------------|:------------|:----------|:-------------------------------------|
| 01 | [Triangle Pattern](./TrianglePattern.java) | Easy | Row-Column Mapping | [View Details](#01-triangle-pattern) |

---

### 01. Triangle Pattern

*Problem Statement:* Print $i$ stars for each row $i$, up to $n$ rows.



*Intuition:* The star count in each row is directly dependent on the row index.

*Implementation:*
- *Outer Loop (i):* Runs $1$ to $n$ to manage rows.
- *Inner Loop (j):* Runs $1$ to $i$ to print stars.
- *Action:* print("* ") in inner loop; println() in outer loop.

*Complexity Analysis:*
- *Time:* $O(n^2)$ | *Space:* $O(1)$

*Example (n=3):
```text
*
* *
* * *
```
*what I learn*:

Learned how nested loops control pattern printing.
