# SEI

1. Given the following class, write 3 methods that can be used to return an array that has no
duplicates.
2. You should define a method signature that you feel is appropriate to the problem.
3. We would prefer to see three implementations (one that should take into consideration #4
below) and an explanation of what use-cases are suitable to each implementation
4. What if we need to retain the original order?
5. What are the positives and negatives of your solution?
   a. Can you implement it another way so as to avoid the negatives?
6. Your solution should be testable and “production ready.”

To answer for 5 and 5.a:
The positive of using set over other two will the time complexity for that will be only O(n). We can do parallel stream for larger data set as a negative point we not streaming that fast in this solution.
