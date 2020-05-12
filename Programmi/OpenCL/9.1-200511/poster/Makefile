CC     = gcc
CFLAGS = -O2 -Wall
ifeq ($(shell uname -s),Linux)
		LFLAGS = -lOpenCL
endif

ifeq ($(shell uname -s),Darwin)
		LFLAGS = -framework OpenCL
endif

poster: main.o clut.o pgm.o poster.o
	$(CC) $(CFLAGS) main.o clut.o pgm.o poster.o \
        -o poster $(LFLAGS)

main.o: main.c clut.h poster.h pgm.h
	$(CC) $(CFLAGS) main.c -c

poster.o: poster.c poster.h clut.h
	$(CC) $(CFLAGS) poster.c -c

clut.o: clut.c clut.h
	$(CC) $(CFLAGS) clut.c -c

pgm.o: pgm.c pgm.h
	$(CC) $(CFLAGS) pgm.c -c

test:
	./poster colosseo.pgm colosseo-poster.pgm

.phony: clean

clean:
	rm -f *.o poster colosseo-poster.pgm
