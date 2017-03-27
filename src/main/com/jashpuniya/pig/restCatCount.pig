-- Count the number of restaurant in each catagory

restData = LOAD 'data/input/rest.txt' USING PigStorage(',') AS (ID:chararray, name:chararray, cat:chararray, add1:chararray, city:chararray, state:chararray, zip:chararray);
grpByCat = GROUP restData BY cat;

countByCat = FOREACH grpByCat GENERATE group, COUNT (restData);
DUMP countByCat;
