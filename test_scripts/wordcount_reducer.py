#!/usr/bin/env python
import sys

current_word = None
current_count = 0

# Read the sorted input (from mapper output)
for line in sys.stdin:
    word, count = line.strip().split('\t', 1)

    try:
        count = int(count)
    except ValueError:
        continue

    if current_word == word:
        current_count += count
    else:
        if current_word:
            # Output the current word and its count
            print(f"{current_word}\t{current_count}")
        current_word = word
        current_count = count

# Output the last word if any
if current_word == word:
    print(f"{current_word}\t{current_count}")