#include <stdio.h>
#include <immintrin.h>

int arraysum(int *v, int n) {
    int i, res[4], sum = 0;
    __m128i s = _mm_set_epi32(0,0,0,0);
    for (i=0; i+3<n; i+=4) {
        __m128i vv = _mm_loadu_si128((const __m128i*)(v+i));
        s = _mm_add_epi32(s, vv);
    }
    _mm_storeu_si128((__m128i*)res, s);
	for (; i<n; ++i) sum += v[i];
    return sum+res[0]+res[1]+res[2]+res[3];
}

int main() {
	int v[] = { 1,1,1,1,1,1,1,1,1,1 };
	int x = arraysum(v,10);
	printf("x=%d\n", x);
}
