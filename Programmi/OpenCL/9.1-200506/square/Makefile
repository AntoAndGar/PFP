ifeq ($(shell uname -s),Linux)
		LFLAGS = -lOpenCL
endif

ifeq ($(shell uname -s),Darwin)
		LFLAGS = -framework OpenCL
endif

CFLAGS = -O2
CC = gcc

square: square.c
	$(CC) $(CFLAGS) square.c -o square $(LFLAGS)

.phony: clean

clean:
	rm -f square
