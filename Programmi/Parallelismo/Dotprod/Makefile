CC=gcc
FLAGS=-O1 -Wall
TIME=time

all: dotprod dotprod_sse dotprod_avx Makefile

dotprod: dotprod_main.c dotprod.c dotprod.h
	$(CC) $(FLAGS) dotprod_main.c dotprod.c -o dotprod

dotprod_sse: dotprod_main.c dotprod_sse.c dotprod.h
	$(CC) $(FLAGS) dotprod_main.c dotprod_sse.c -o dotprod_sse

dotprod_avx: dotprod_main.c dotprod_avx.c dotprod.h
	$(CC) $(FLAGS) dotprod_main.c dotprod_avx.c -o dotprod_avx -mavx2

.phony: clean test

test:
	@echo "\n--- Test #1: (10 ripetizioni su array di 100000000 elementi)"
	@$(TIME) ./dotprod     10 100000000
	@$(TIME) ./dotprod_sse 10 100000000
	@$(TIME) ./dotprod_avx 10 100000000
	@echo "\n-- Test #2: (1000 ripetizioni su array di 1000000 elementi)"
	@$(TIME) ./dotprod     1000 1000000
	@$(TIME) ./dotprod_sse 1000 1000000
	@$(TIME) ./dotprod_avx 1000 1000000

asm: dotprod.c dotprod_sse.c dotprod_avx.c
	$(CC) $(FLAGS) dotprod.c -S
	$(CC) $(FLAGS) dotprod_sse.c -S
	$(CC) $(FLAGS) dotprod_avx.c -S -mavx2

clean:
	rm -f dotprod dotprod_sse dotprod_avx *.s
