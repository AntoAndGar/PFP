ifeq ($(shell uname -s),Linux)
		LFLAGS = -lOpenCL
endif

ifeq ($(shell uname -s),Darwin)
		LFLAGS = -framework OpenCL
endif

CC = gcc
CFLAGS = -O2

devinfo: devinfo.c
	$(CC) $(CFLAGS) devinfo.c -o devinfo $(LFLAGS)

.phony: clean

clean:
	rm -f devinfo
