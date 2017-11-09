## Highway Billboard Problem

[Original](http://algorithms.tutorialhorizon.com/dynamic-programming-highway-billboard-problem/)

Preconditions: 
Sup­pose you’re man­aging construction of billboards on the 
Rocky & Bullwinkle Memorial Highway, a heavily traveled stretch of road that 
runs west-east for M miles. The possible sites for billboards are given 
by numbers x1 < x2 < · · · < xn, each in the inter­val [0, M], 
specifying their position in miles measured from the western end of the road. 
If you place a bill­board at position xi , you receive a revenue of ri > 0.
Regulations imposed by the High­way Department require that no two bill­boards
be within five miles or less of each other. 

You will be given the billboards and revenue of each.  Example:

int[] x = {6, 7, 12, 13, 14};

int[] revenue = {5, 6, 5, 3, 1};

int distance = 20;

int milesRestriction = 5;

TODO: Find out which positioning grants maximum revenue.

