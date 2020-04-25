#include <immintrin.h>
#include "../vecsum.h"

static void sum_avx(int A[8], int B[8], int C[8]);

void vecsum(int* A, int* B, int* C, int n) {
	int i;
	for (i=0; i+7<n; i+=8) sum_avx(A+i, B+i, C+i);
    for (; i<n; ++i) C[i] = A[i] + B[i];
}

void sum_avx(int A[8], int B[8], int C[8]) {
    __m256i a, b, c;                             // dich. variabili vettoriali
    a = _mm256_loadu_si256((const __m256i*)A);   // copia primo vettore in a
    b = _mm256_loadu_si256((const __m256i*)B);   // copia secondo vettore in b
    c = _mm256_add_epi32(a,b);                   // calcola la somma vett. di a e b
    _mm256_storeu_si256((__m256i*)C, c);         // copia risultato c in C
}

