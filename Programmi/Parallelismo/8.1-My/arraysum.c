#include <stdio.h>
#include <immintrin.h>

int arraysum(int *v, int n) {
    int i, sum = 0;
    for(i=0; i<n; ++i) sum += v[i];
    return sum;
}

int arraysum_unroll(int *v, int n) {
    int i, C[4] = {0}, sum = 0;
    for(i=0; i+3<n; i+=4) {
        C[0] += v[i+0];
        C[1] += v[i+1];
        C[2] += v[i+2];
        C[3] += v[i+3];
    }
    for(; i<n; ++i) sum += v[i]; 
    return sum+C[0]+C[1]+C[2]+C[3];
}

int arraysum_sse(int *v, int n) {
    int i, C[4] = {0}, sum = 0;
    __m128i s =_mm_set_epi32(0,0,0,0);
    for(i=0; i+3<n; i+=4) {
        __m128i vv = _mm_loadu_si128((const __m128i*) (v+i));
        s = _mm_add_epi32(s, vv);
    }
    _mm_storeu_si128((__m128i*)C, s);
    for(; i<n; ++i) sum += v[i];
    return sum+C[0]+C[1]+C[2]+C[3];
}

int main() {
    int v[] = {1,1,1,1,1,1,1,1,1,1};
    int x = arraysum_sse(v, 10);
    printf("x=%d\n", x);
}