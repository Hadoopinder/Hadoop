-- File: myParser.pig
-- Author: Jash Puniya
-- Description: Parse fields with multiple delimiters (, and |) using UDF

REGISTER myudfs.jar

data = LOAD 'data/input/myParserData.txt' as (record: chararray);

parsedData = FOREACH data GENERATE myudfs.myParserUDF(record);

DUMP parsedData;
