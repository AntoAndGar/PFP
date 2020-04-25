#include "vecsum.h"

void vecsum(int* A, int* B, int* C, int n) {
	int i;
	for (i=0; i<n; ++i) C[i] = A[i] + B[i];
}
