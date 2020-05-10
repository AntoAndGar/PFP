#include "dotprod.h"

int dotprod(int* A, int* B, int n) {
	int i, s = 0;
	for (i=0; i<n; ++i) s += A[i] * B[i];
	return s;
}
