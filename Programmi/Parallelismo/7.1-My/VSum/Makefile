CC=gcc
FLAGS=-O1 -Wall
TIME=time

all: vecsum vecsum_sse vecsum_avx Makefile

vecsum: vecsum_main.c vecsum.c vecsum.h
	$(CC) $(FLAGS) vecsum_main.c vecsum.c -o vecsum

vecsum_sse: vecsum_main.c vecsum_sse.c vecsum.h
	$(CC) $(FLAGS) vecsum_main.c vecsum_sse.c -o vecsum_sse

vecsum_avx: vecsum_main.c vecsum_avx.c vecsum.h
	$(CC) $(FLAGS) vecsum_main.c vecsum_avx.c -o vecsum_avx -mavx2

.phony: clean test

test:
	@echo "\n--- Test #1: (10 ripetizioni su array di 100000000 elementi)"
	@$(TIME) ./vecsum     10 100000000
	@$(TIME) ./vecsum_sse 10 100000000
	@$(TIME) ./vecsum_avx 10 100000000
	@echo "\n-- Test #2: (1000 ripetizioni su array di 1000000 elementi)"
	@$(TIME) ./vecsum     1000 1000000
	@$(TIME) ./vecsum_sse 1000 1000000
	@$(TIME) ./vecsum_avx 1000 1000000

asm: vecsum.c vecsum_sse.c vecsum_avx.c
	$(CC) $(FLAGS) vecsum.c -S
	$(CC) $(FLAGS) vecsum_sse.c -S
	$(CC) $(FLAGS) vecsum_avx.c -S -mavx2

clean:
	rm -f vecsum vecsum_sse vecsum_avx *.s
