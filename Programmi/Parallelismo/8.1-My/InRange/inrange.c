#include <immintrin.h>

int inrange(const short *data, unsigned n, short min, short max)
{
    int i;
    __m128i minv, maxv, datav, res;
    minv = _mm_set_epi16(min - 1, min - 1, min - 1, min - 1, min - 1, min - 1, min - 1, min - 1);
    maxv = _mm_set_epi16(max + 1, max + 1, max + 1, max + 1, max + 1, max + 1, max + 1, max + 1);

    for (i = 0; i + 7 < n; i += 8)
    {
        datav = _mm_loadu_si128((const __m128i *)(data + i));
        res = _mm_cmpgt_epi16(datav, minv);
        if (!_mm_test_all_ones(res))
            return 0;
        res = _mm_cmpgt_epi16(maxv, datav);
        if (!_mm_test_all_ones(res))
            return 0;
    }

    for (; i < n; ++i)
        if (data[i] < min || data[i] > max)
            return 0;
    return 1;
}
