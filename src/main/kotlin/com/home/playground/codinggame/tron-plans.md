# Plans

## 1️⃣ Predicting traps

Currently, the algorithm simply chooses the direction with the largest number of reachable cells. However, this does not take into
account whether the path is a dead end.

Improvement:

* Instead of counting all reachable cells, BFS can check for the existence of large clusters of free space.
* For example, if BFS sees two large but isolated areas, it can choose the path leading to a more open region.

## 2️⃣ Assessing the probability of encountering enemies

Opponents also move and fill the board. If they are close, it is worth considering their potential routes.

Improvement:

* You can run BFS from the positions of all players and take into account which areas are occupied by opponents faster.
* Choose routes that remain safe longer.

## 3️⃣ Greedy survival strategy

Sometimes it is important not just to find the "best" direction, but to choose a move where you can survive longer.
Improvement:

* Instead of one BFS, run multiple BFSs with 3-5 steps ahead prediction.
* You can use the Minimax algorithm or even *A (A-Star)** to take into account what other players might do.

## 4️⃣ Extra weight for the center of the map

In most games, it is more advantageous to stay closer to the center, since it is harder to maneuver from the edges.
Improvement:

* Add distance estimation to the center to BFS to avoid cornering.
