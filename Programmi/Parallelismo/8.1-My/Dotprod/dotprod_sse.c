#include "dotprod.h"
#include <immintrin.h>

int dotprod(int* A, int* B, int n) {
    int i, C[4];
    __m128i c = _mm_set_epi32(0,0,0,0);
    for(i=0; i+3<n; i+=4) {
        __m128i a, b;
        a = _mm_loadu_si128((const __m128i*) (A+i));
        b = _mm_loadu_si128((const __m128i*) (B+i));
        c = _mm_add_epi32(c, _mm_mullo_epi32(a, b));
    }
    _mm_storeu_si128((__m128i*)C, c);
    for(; i<n; ++i) C[0] += A[i]*B[i];
    return C[0]+C[1]+C[2]+C[3];

}