-- Explains various ways to lookup columns in a relation

data = LOAD 'data/input/student-result.txt' AS (rollNo:int, name:map[], midtermResult:bag{result:tuple(subject:chararray, marks:int)});

by_pos = FOREACH data GENERATE $0;
DUMP by_pos;

by_field = FOREACH data GENERATE name#'first_name';
DUMP by_field;

by_pos_in_bagField = FOREACH data GENERATE midtermResult.$0;
DUMP by_pos_in_bagField;
