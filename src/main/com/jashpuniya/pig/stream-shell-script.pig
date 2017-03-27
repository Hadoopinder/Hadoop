-- Description: Demonstrates how shell commands can be executed in Pig through Streaming

data = LOAD 'data/input/rest.txt' USING PigStorage(',');
filtered = STREAM data THROUGH `cut -f2,5,6`;
DUMP filtered;
