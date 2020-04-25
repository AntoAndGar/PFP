# ============================================================================
#  Makefile
# ============================================================================

#  Author:         (c) 2013-2015 Camil Demetrescu
#  Created:        April 27, 2013
#  Last changed:   $Date: 2018/11/29 10:41:13 $
#  Changed by:     $Author: demetres $
#  Revision:       $Revision: 1.00 $


CC = gcc
CFLAGS = -O1 -mavx2
LFLAGS = -pthread
PERF = perf stat -e L1-dcache-load-misses,L1-dcache-loads,cycles,instructions,branch-misses,branches
N = 1300
TIME = time -p

all: mat_test

mat_test: mat_test.o mat.o
	$(CC) $(LFLAGS) mat_test.o mat.o -g -o mat_test

mat_test.o: mat_test.c mat.h
	$(CC) $(CFLAGS) mat_test.c -c -g

mat.o: mat.c mat.h
	$(CC) $(CFLAGS) mat.c -c -g
	$(CC) $(CFLAGS) mat.c -S

run:
	$(TIME) ./mat_test $(N) 0
	$(TIME) ./mat_test $(N) 1
	$(TIME) ./mat_test $(N) 2
	$(TIME) ./mat_test $(N) 3
	$(TIME) ./mat_test $(N) 4
	$(TIME) ./mat_test $(N) 5
	$(TIME) ./mat_test $(N) 6
	$(TIME) ./mat_test $(N) 7

perf:
	$(PERF) ./mat_test $(N) 0
	$(PERF) ./mat_test $(N) 1
	$(PERF) ./mat_test $(N) 2
	$(PERF) ./mat_test $(N) 3
	$(PERF) ./mat_test $(N) 4
	$(PERF) ./mat_test $(N) 5
	$(PERF) ./mat_test $(N) 6
	$(PERF) ./mat_test $(N) 7

check:
	./mat_test $(N) 0 1
	./mat_test $(N) 1 1
	./mat_test $(N) 2 1
	./mat_test $(N) 3 1
	./mat_test $(N) 4 1
	./mat_test $(N) 5 1
	./mat_test $(N) 6 1
	./mat_test $(N) 7 1

.phony: clean

clean:
	rm -f ./mat_test *.o *.s

