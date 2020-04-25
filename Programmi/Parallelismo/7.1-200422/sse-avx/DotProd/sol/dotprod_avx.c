#include <immintrin.h>
#include "../dotprod.h"

int dotprod(int* A, int* B, int n) {
	int i, s = 0, C[8] = { 0 };
	__m256i a, b, c;
	c = _mm256_loadu_si256((const __m256i*)C);
	for (i=0; i+7 < n; i += 8) {
		a = _mm256_loadu_si256((const __m256i*)(A+i));
		b = _mm256_loadu_si256((const __m256i*)(B+i));
		c = _mm256_add_epi32(c, _mm256_mullo_epi32(a,b));
	}
	_mm256_storeu_si256((__m256i*)C, c);
	for (; i<n; ++i) s += A[i] * B[i];
	for (i=0; i<8; i++) s += C[i];
	return s;
}
