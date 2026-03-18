#  Recursion And Backtracking : State-Space Analysis
comprehensive collection of algorithms focusing on recursive problem-solving, binary decision trees, and Systematic Backtracking.

## Problem Directory

| #  | Problems                                         | Difficulty | Pattern                    | Documentation                 |
|:---|:-------------------------------------------------| :--- |:---------------------------|:------------------------------|
| 01 | [Power Set (Non-Empty subsets)](./PowerSet.java) | Medium | Backtracking (Pick & Skip) | [View Details](#01-power-set) |

---

#  Problem Breakdown

## 01. Power Set

### Problem Statement
Generate all possible **non-empty subsets** (subsequences) of a given string `s`.  
The final output is sorted in **lexicographical order** for consistency and readability.


### Intuition
At each index, we make a binary decision:
- Include the current character
- Exclude the current character

These decisions form a **decision tree**, where each path represents a unique subset.  
By recursively exploring both choices at every step, all possible combinations are generated.


### Algorithm
1. **Initial Call**: Start with an empty string `ans` and index `idx = 0`.
2. **Base Case**:
    - If `idx == s.length()`, add `ans` to the result if it is not empty.
    - Return to stop the current branch.
3. **Recursive Exploration**:
    - Include the current character and move to the next index.
    - Exclude the current character and move to the next index.
4. **Post-Processing**:
    - Sort the result list lexicographically.


### Complexity Analysis
- **Time Complexity**: `O(2^n * n)` — There are `2^n` subsets, each taking up to `O(n)` time to build.
- **Space Complexity**: `O(n)` — Due to recursion stack depth.


### Example
**Input**: `s = "abc"`  
**Output**: `["a", "ab", "abc", "ac", "b", "bc", "c"]`


### What I Learned
- **Decision Tree Thinking**: Understanding how binary choices generate all subsets
- **Recursive Exploration**: Using recursion to explore all possible paths
- **State Handling**: Managing values without explicit undo by passing new strings