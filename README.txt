Authors:
  harry moreno morenoh149@gmail.com
  ben leone   bleone@wpi.edu

TO RUN THIS PROJECT
in a command line navigate to the extracted directory. replace input.txt with your desisered input. IT MUST BE NAMED input.txt. then in command line
type "java -jar cs4341-hw1_BLHM.jar". output.txt will contain the results.

Congradulation! mozeltof!

cs4341-hw1:
  use DFS, BFS and A* to determine the fastest way to get ppl across a river.
BFS uses a queue, DFS uses a stack.

questions 
1)

Initial state: all persons on south shore

goal state: all persons on north shore

successor function: expand node (formulate Possibilities that drive the state forward). this function with send two people forward and one person back.

cost function: the sum of the previous costs plus the cost of the heaviest person being moved.

2) The number of possible states is 16. The optimal solution is 270.

3)Our heuristic for A* was the maximum of the value on the starting shore. This always gave an answer that was less than or equal to the 
actual cost with out going over. The heuristic did fail on input 2 where the numbers were all very low and close together, but did succeed 
on all other cases including the case in problem 2.
