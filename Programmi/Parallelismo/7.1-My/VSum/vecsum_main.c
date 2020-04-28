#include <stdio.h>
#include <stdlib.h>
#include "vecsum.h"

#ifndef M
#define M 1
#endif

#ifndef N
#define N 100000000
#endif

static void init(int* v, int n);

// provare anche con M=1 e N=100000000:
// array A, B, C da 100 milioni di int => 1.2 GB per 3 array di int
// (collo di bottiglia memoria vanifica parallelismo)

int main(int argc, char* argv[]) {
	int j;
    
    int m = M;
    int n = N;

    if (argc >= 3) {
        m = atoi(argv[1]);
        n = atoi(argv[2]);
    }
    
    printf("Running test with m=%d, n=%d\n", m, n);

	int* A = malloc(n*sizeof(int));
	int* B = malloc(n*sizeof(int));
	int* C = malloc(n*sizeof(int));

    init(A, n);
    init(B, n);

	// ripete per rendere misurabili i tempi
	for (j=0; j<m; j++) vecsum(A, B, C, n);

	printf("%d %d %d %d %d\n", C[0], C[1], C[2], C[3], C[4]);
    
    free(A);
    free(B);
    free(C);

	return 0;
}

void init(int* v, int n) {
	int i;
	for (i=0; i<n; ++i) v[i] = i % 97;
}
