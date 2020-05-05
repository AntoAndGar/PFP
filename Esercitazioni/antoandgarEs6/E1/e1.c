#include "e1.h"
#include <immintrin.h>


// ---------------------------------------------------------------------
// matmul
// ---------------------------------------------------------------------
// SSE version

static void add_prod(const short* src, short* dst, short x, int n) {
	int i;
    __m128i y = _mm_set1_epi16(x);
    for (i=0; i+7<n; i+=8) {
         __m128i s, d; 
        s = _mm_loadu_si128((const __m128i*) (src+i));
        d = _mm_loadu_si128((const __m128i*) (dst+i));
        d = _mm_add_epi16(d, _mm_mullo_epi16(y, s));
        _mm_storeu_si128((__m128i*) (dst+i), d);
    }
    for(; i<n; ++i) dst[i] += x*src[i]; 
}

void matmul(const short** a, const short** b, short** c, int n) {
    int i, j, k;
    for (i=0; i<n; ++i)
        for (j=0; j<n; ++j) c[i][j] = 0;
    for (i=0; i<n; ++i)
        for (k=0; k<n; ++k)
            add_prod(b[k], c[i], a[i][k], n);
}


// ---------------------------------------------------------------------
// matmul_seq
// ---------------------------------------------------------------------
// sequential version

static void add_prod_seq(const short* src, short* dst, short x, int n) {
    int j;
    for (j=0; j<n; ++j) dst[j] += x * src[j];
}

void matmul_seq(const short** a, const short** b, short** c, int n) {
    int i, j, k;
    for (i=0; i<n; ++i)
        for (j=0; j<n; ++j) c[i][j] = 0;
    for (i=0; i<n; ++i)
        for (k=0; k<n; ++k) 
            add_prod_seq(b[k], c[i], a[i][k], n);
}
