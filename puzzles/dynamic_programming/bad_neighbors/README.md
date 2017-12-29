## Bad neighbors

[Original](https://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009)

Preconditions: 
The old song declares "Go ahead and hate your neighbor", and the residents 
of Onetinville have taken those words to heart. Every resident hates his 
next-door neighbors on both sides. Nobody is willing to live farther away 
from the town's well than his neighbors, so the town has been arranged 
in a big circle around the well. Unfortunately, the town's well is in 
disrepair and needs to be restored. You have been hired to collect 
donations for the Save Our Well fund.

Each of the town's residents is willing to donate a certain amount, 
as specified in the int[] donations, which is listed in clockwise order 
around the well. However, nobody is willing to contribute to a fund to 
which his neighbor has also contributed. Next-door neighbors are 
always listed consecutively in donations, except that the first 
and last entries in donations are also for next-door neighbors.

Constraints
    -	donations contains between 2 and 40 elements, inclusive.
    -	Each element in donations is between 1 and 1000, inclusive.

TODO: 
Calculate and return the maximum amount of donations that can be collected. 
 
Example:

{ 10, 3, 2, 5, 7, 8 }

Returns: 19

The maximum donation is 19, achieved by 10+2+7. 
It would be better to take 10+5+8 except that the 10 and 8 donations are from 
neighbors.
