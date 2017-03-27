-- Count the number of occurrence of each word in the text file

linesInPara = LOAD 'data/input/para.txt' AS (line);

words = FOREACH linesInPara GENERATE FLATTEN(TOKENIZE(line)) AS word;

grpdWords  = GROUP words BY word;

countedWords  = FOREACH grpdWords GENERATE group, COUNT(words);

sortedWordOccurance = ORDER countedWords BY $0;

DUMP sortedWordOccurance;
