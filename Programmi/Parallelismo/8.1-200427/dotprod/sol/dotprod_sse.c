#include <immintrin.h>
#include "dotprod.h"

int dotprod_equiv(int* A, int* B, int n) {
	int i, C[4] = { 0 };
	for (i=0; i+3 < n; i += 4) {
		C[0] += A[i+0] * B[i+0];
		C[1] += A[i+1] * B[i+1];
		C[2] += A[i+2] * B[i+2];
		C[3] += A[i+3] * B[i+3];
	}
	for (; i < n; i++)
		C[0] += A[i] * B[i];
	return C[0]+C[1]+C[2]+C[3];	
}

int dotprod(int* A, int* B, int n) {
	int i, D[4];
	__m128i a, b, c, d;
	d = _mm_set_epi32(0,0,0,0);
	for (i=0; i+3 < n; i += 4) {
		a = _mm_loadu_si128((const __m128i*)(A+i));
		b = _mm_loadu_si128((const __m128i*)(B+i));
		c = _mm_mullo_epi32(a, b);
		d = _mm_add_epi32(d, c);
	}
	_mm_storeu_si128((__m128i*)D, d);
	for (; i < n; i++)
		D[0] += A[i] * B[i];
	return D[0]+D[1]+D[2]+D[3];	
}
