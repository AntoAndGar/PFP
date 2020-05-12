ifeq ($(shell uname -s),Linux)
		LFLAGS = -lOpenCL
endif

ifeq ($(shell uname -s),Darwin)
		LFLAGS = -framework OpenCL
endif

CC = gcc
CFLAGS = -O2
CLUT = ../clut/
OBJ = $(CLUT)clut.o

vecsum: vecsum.c
	$(CC) $(CFLAGS) -I $(CLUT) vecsum.c $(OBJ) -o vecsum $(LFLAGS)

.phony: clean

clean:
	rm -f vecsum
