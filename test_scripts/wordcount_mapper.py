#!/usr/bin/env python
import sys

# Read input from standard input (STDIN)
for line in sys.stdin:
    # Strip leading/trailing whitespace and split into words
    words = line.strip().split()

    # For each word in the line, emit it with count 1
    for word in words:
        print(f"{word}\t1")