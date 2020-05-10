#include <immintrin.h>

int cdiff(const char *x, const char *y, int n)
{
    int i, cnt = 0;
    unsigned char mcnt[16];

    __m128i xv, yv, res, vcnt, vone;
    vone = _mm_set_epi8(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    vcnt = _mm_set_epi8(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    for (i = 0; i + 15 < n; i += 16)
    {
        xv = _mm_loadu_si128((const __m128i *)(x + i));
        yv = _mm_loadu_si128((const __m128i *)(y + i));
        res = _mm_cmpeq_epi8(xv, yv);
        res = _mm_add_epi8(res, vone);
        vcnt = _mm_add_epi8(vcnt, res);
        if (i % 255 == 0)
        {
            int j;
            _mm_storeu_si128((__m128i *)mcnt, vcnt);
            for (j = 0; j < 16; ++j)
                cnt += mcnt[j];
            vcnt = _mm_set_epi8(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        }
    }
    for (; i < n; ++i)
        if (x[i] != y[i])
            ++cnt;

    _mm_storeu_si128((__m128i *)mcnt, vcnt);
    for (i = 0; i < 16; ++i)
        cnt += mcnt[i];
    return cnt;
}
