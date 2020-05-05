#include <immintrin.h>
#include "e2.h"


// ---------------------------------------------------------------------
// count_occ
// ---------------------------------------------------------------------
// SSE version

int count_occ(const char* v, int n, char x) {
	int i, cnt = 0;
    unsigned char mc[16];
    __m128i a, c;
    __m128i b = _mm_set1_epi8(x);
    __m128i vc = _mm_setzero_si128();
    for(i=0; i+15<n; i+=16) {
        a = _mm_loadu_si128((const __m128i*) (v+i));
        c = _mm_cmpeq_epi8(a, b);
        c = _mm_sign_epi8(c,c);
        vc = _mm_add_epi8(vc, c);
        if(i%255 == 0) {
            int j;
            _mm_storeu_si128((__m128i *)mc, vc);
            for(j=0; j<16; ++j) {
                cnt += mc[j];
            }
            vc = _mm_setzero_si128();
        }
    }
    for (; i < n; ++i) cnt += v[i] == x;

    _mm_storeu_si128((__m128i *)mc, vc);
    for (i=0; i < 16; ++i) cnt += mc[i];
	return cnt;
}


// ---------------------------------------------------------------------
// count_occ_seq
// ---------------------------------------------------------------------
// sequential version

int count_occ_seq(const char* v, int n, char x) {
    int i, cnt = 0;
    for (i=0; i<n; ++i) cnt += v[i] == x;
    return cnt;
}
