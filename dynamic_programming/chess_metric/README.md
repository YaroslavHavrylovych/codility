## Chess Metric

[Original](https://community.topcoder.com/stat?c=problem_statement&pm=1592&rd=4482)

Preconditions: Suppose you had an n by n chess board and a super piece called 
a kingknight. In other words, the kingknight can move either one space in any
direction (vertical, horizontal or diagonally) or can make an 'L' shaped move.
An 'L' shaped move involves moving 2 spaces horizontally then 1 space
vertically or 2 spaces vertically then 1 space horizontally. 
In addition, a kingknight may never jump off the board.

Note, two ways of getting from start to end are distinct if their respective
move sequences differ in any way. In addition, you are allowed to use spaces
on the board (including start and finish) repeatedly during a particular path
from start to finish. We will ensure that the total number of paths is less
than or equal to 2^63-1 (the upper bound for a long).

TODO: 
Given the size of the board, the start position of the kingknight and the end
position of the kingknight, your method will return how many possible ways
there are of getting from start to end in exactly numMoves moves.
start and finish are int[]s each containing 2 elements. The first element will
be the (0-based) row position and the second will be the (0-based) column
position. Rows and columns will increment down and to the right respectively.
The board itself will have rows and columns ranging from 0 to size-1 inclusive.
