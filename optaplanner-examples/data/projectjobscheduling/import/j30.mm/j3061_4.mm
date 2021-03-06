************************************************************************
file with basedata            : mf61_.bas
initial value random generator: 1658292061
************************************************************************
projects                      :  1
jobs (incl. supersource/sink ):  32
horizon                       :  241
RESOURCES
  - renewable                 :  2   R
  - nonrenewable              :  2   N
  - doubly constrained        :  0   D
************************************************************************
PROJECT INFORMATION:
pronr.  #jobs rel.date duedate tardcost  MPM-Time
    1     30      0       28        1       28
************************************************************************
PRECEDENCE RELATIONS:
jobnr.    #modes  #successors   successors
   1        1          3           2   3   4
   2        3          3          10  16  21
   3        3          3           5   7   8
   4        3          3           6  11  14
   5        3          1          17
   6        3          2          12  23
   7        3          2           9  29
   8        3          2          16  21
   9        3          2          15  20
  10        3          3          13  18  19
  11        3          1          25
  12        3          2          13  25
  13        3          1          24
  14        3          3          15  19  25
  15        3          2          22  31
  16        3          2          17  18
  17        3          3          20  24  26
  18        3          1          22
  19        3          1          22
  20        3          1          27
  21        3          3          23  27  31
  22        3          1          26
  23        3          2          24  28
  24        3          2          29  30
  25        3          3          26  27  31
  26        3          1          28
  27        3          1          28
  28        3          1          30
  29        3          1          32
  30        3          1          32
  31        3          1          32
  32        1          0        
************************************************************************
REQUESTS/DURATIONS:
jobnr. mode duration  R 1  R 2  N 1  N 2
------------------------------------------------------------------------
  1      1     0       0    0    0    0
  2      1     5       4    7    3    6
         2     9       3    7    3    5
         3     9       2    7    3    6
  3      1     2       3    4    9    8
         2     5       2    1    9    8
         3     5       2    3    9    7
  4      1     1       3    5    5    4
         2     4       2    4    1    4
         3     4       3    5    2    1
  5      1     1       6    7    7    7
         2     7       6    5    6    6
         3     9       5    2    6    1
  6      1     5      10    3    9    8
         2     6       9    3    9    6
         3     9       8    2    7    5
  7      1     1       9    8    8    4
         2     8       9    5    7    3
         3     9       7    3    7    1
  8      1     2       7    6   10    5
         2     3       6    5    8    3
         3     8       5    4    4    2
  9      1     4      10    5    8    6
         2     7       7    3    8    4
         3     8       7    1    7    3
 10      1     2       8    4   10    9
         2     3       7    3    9    8
         3     8       7    3    9    7
 11      1     2       5    5    5    3
         2     3       4    5    5    2
         3     7       4    1    4    2
 12      1     4       6    8    9    9
         2     7       5    8    7    7
         3     9       5    8    6    4
 13      1     2       8    9    8    8
         2     7       7    8    4    4
         3     8       6    5    3    2
 14      1     5       7    4    8    6
         2     6       5    4    7    6
         3     8       5    2    7    4
 15      1     6       6    6    9    5
         2    10       6    3    4    5
         3    10       4    5    1    4
 16      1     1       6    9    9    4
         2     5       5    5    6    3
         3     6       4    2    3    3
 17      1     3       7    1    5    2
         2     5       6    1    4    2
         3    10       5    1    4    1
 18      1     3       6   10    4    3
         2     4       4    7    4    3
         3     7       1    4    4    3
 19      1     3       5    7    7    8
         2     6       5    5    5    8
         3    10       4    3    4    7
 20      1     1       7    7    1    4
         2     3       7    3    1    3
         3    10       7    2    1    3
 21      1     4       7    5   10    7
         2     6       6    3    8    6
         3    10       4    1    7    5
 22      1     1       3    4    7    7
         2     6       2    3    6    5
         3    10       1    3    5    4
 23      1     2       7    7    4    6
         2     6       4    4    4    5
         3     7       3    4    4    4
 24      1     3       7    9    9    5
         2     7       4    8    9    5
         3     9       3    8    8    5
 25      1     1       5    8    4    7
         2     2       4    7    4    7
         3     4       1    5    2    4
 26      1     5       8    9    9    4
         2     7       3    8    9    4
         3     7       6    8    9    3
 27      1     5       2    6    8    8
         2     6       2    5    7    8
         3    10       1    2    7    8
 28      1     4      10    1    6    3
         2     8       7    1    5    2
         3     8       6    1    4    3
 29      1     1       5    7    5    4
         2     3       5    7    4    4
         3     5       4    7    4    3
 30      1     5       7    7    8    6
         2    10       5    6    5    6
         3    10       6    6    6    5
 31      1     5       9    3    2    9
         2     6       6    3    2    8
         3     7       5    2    1    8
 32      1     0       0    0    0    0
************************************************************************
RESOURCEAVAILABILITIES:
  R 1  R 2  N 1  N 2
   18   17  206  175
************************************************************************
