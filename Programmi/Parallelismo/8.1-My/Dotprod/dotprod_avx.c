#include "dotprod.h"
#include <immintrin.h>

int dotprod(int* A, int* B, int n) {
	int i, C[8];
	__m256i c = _mm256_set_epi32(0,0,0,0,0,0,0,0);
	for(i=0; i+7<n; i+=8) { //c += A[i] * B[i];
		__m256i a, b;
		a = _mm256_loadu_si256((const __m256i*) (A+i));
		b = _mm256_loadu_si256((const __m256i*) (B+i));
		c = _mm256_add_epi32(c, _mm256_mullo_epi32(a, b));
	}
	_mm256_store_si256((__m256i*)C, c);
	for(; i<n; ++i) C[0] += A[i]*B[i];
	return C[0]+C[1]+C[2]+C[3]+C[4]+C[5]+C[6]+C[7];
}
