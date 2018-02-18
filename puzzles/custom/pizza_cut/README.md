## Pizza Cut

[Original](https://hashcodejudge.withgoogle.com/#/rounds/5736842779426816/)

Preconditions:
The pizza is represented as a rectangular, 2-dimensional grid of *R* rows
and *C* columns. The cells within the grid are referenced using a pair of
0-based coordinates [ r, c] , denoting respectively the row and the
column of the cell.

Each cell of the pizza contains either:
* mushroom, represented in the input file as M or
* tomato, represented in the input file as T


TODO: The goal is to cut correct slices out of the pizza maximizing
the total number of cells in all slices.


Input data set: The input data is provided as a data set file - a plain text
file containing exclusively ASCII characters with
lines terminated with a single ‘\n’ character at the end of
each line (UNIX-style line endings).

*Input file format*

The file consists of:
* one line containing the following natural numbers separated by single spaces:
* R ( 1 ≤ R ≤ 1 000) is the number of rows,
* C ( 1 ≤ C ≤ 1 000) is the number of columns,
* L ( 1 ≤ L ≤ 1 000) is the minimum number of each ingredient cells in a slice,
* H ( 1 ≤ H ≤ 1 000) is the maximum total number of cells of a slice
* R lines describing the rows of the pizza (one row after another).
Each of these lines contains C characters describing the ingredients in the
cells of the row (one cell after another). Each character
is either ‘M’ (for mushroom) or ‘T’ (for tomato).

*Result file format*

The file must consist of:
* one line containing a single natural number S ( 0 ≤ S ≤ R × C ),
representing the total number of
* slices to be cut, S lines describing the slices.
Each of these lines must contain the following natural numbers
separated by single spaces:
* r1, c1, r2,c2 ( 0 ≤ r 1 , r 2 < R , 0 ≤ c 1 , c 2 < C ) describe a slice of
pizza delimited by the rows r1 and r2 and the columns c1 and c2, including
the cells of the delimiting rows and columns. The rows (r1 and r2 ) can be
given in any order. The columns (c1 and c2 ) can be given in any order too.

*Scores*

The submission gets a score equal to the total number of cells in all slices.
