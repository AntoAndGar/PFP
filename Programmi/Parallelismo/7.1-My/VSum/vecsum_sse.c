#include <immintrin.h>
#include "vecsum.h"

static void sum_sse(int A[4], int B[4], int C[4]);

void vecsum(int* A, int* B, int* C, int n) {
	int i;
	for(i=0; i+3 < n; i+=4) sum_sse(A+i, B+i, C+i);
	for(; i < n; ++i) C[i] = A[i] + B[i];
}

void sum_sse(int A[4], int B[4], int C[4]) {
	__m128i a, b, c;                           // dich. variabili vettoriali
	a = _mm_load_si128((const __m128i*)A);     // copia primo vettore in a
	b = _mm_load_si128((const __m128i*)B);     // copia secondo vettore in b
	c = _mm_add_epi32(a,b);                    // calcola la somma vett. di a e b
	_mm_store_si128((__m128i*)C, c);           // copia risultato c in C
}
