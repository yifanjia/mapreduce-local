#!/usr/bin/env python
import sys
import re

def strip_non_alphanumeric(s):
    # Use regex to remove non-digit and non-letter characters from the start and end
    return re.sub(r'^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$', '', s)

# Read input from standard input (STDIN)
for line in sys.stdin:
    # Strip leading/trailing whitespace and split into words
    words = line.strip().split()

    # For each word in the line, emit it with count 1
    for word in words:
        print(f"{strip_non_alphanumeric(word.lower())}\t1")