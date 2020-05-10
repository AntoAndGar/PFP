#include "dotprod.h"

#include <immintrin.h>

int dotprod(int* A, int* B, int n) {
	int i, D[8];
	__m256i a, b, c, d;
	d = _mm256_set_epi32(0,0,0,0,0,0,0,0);
	for (i=0; i+7 < n; i += 8) {
		a = _mm256_loadu_si256((const __m256i*)(A+i));
		b = _mm256_loadu_si256((const __m256i*)(B+i));
		c = _mm256_mullo_epi32(a, b);
		d = _mm256_add_epi32(d, c);
	}
	_mm256_storeu_si256((__m256i*)D, d);
	for (; i < n; i++)
		D[0] += A[i] * B[i];
	return D[0]+D[1]+D[2]+D[3]+D[4]+D[5]+D[6]+D[7];	
}
