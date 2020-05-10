CC     = gcc
CFLAGS = -O2 -Wall -g
LFLAGS = -msse4.2

cdiff: main.o cdiff.o
	$(CC) $(CFLAGS) main.o cdiff.o -o cdiff $(LFLAGS)

main.o: main.c cdiff.h
	$(CC) $(CFLAGS) main.c -c

cdiff.o: cdiff.c cdiff.h
	$(CC) $(CFLAGS) cdiff.c -c $(LFLAGS)

.phony: clean

clean:
	rm -f *.o cdiff
