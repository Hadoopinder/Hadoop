-- Description: Explain how to load data using multiple delimiters

outerbag = LOAD 'data/input/multi-delimiter.txt' USING PigStorage('\t') AS (f1, f2);
DUMP outerbag;
--Look at Output 1

innerbag1 = FOREACH outerbag GENERATE f1, STRSPLIT(f2, ':');
DUMP innerbag1;
-- Look at Output 2

innerbag2 = FOREACH outerbag GENERATE f1, FLATTEN(STRSPLIT(f2, ':'));
DUMP innerbag2;
-- Look at Output 3
