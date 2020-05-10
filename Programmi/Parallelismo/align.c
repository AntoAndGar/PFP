#include <immintrin.h>
#include <stdio.h>
#include <stdlib.h> // per posix_memalign e free

int main() {
    printf("_mm256_load_si256\n");
    void *p256;


    // void *buf = malloc(32);
    // free(buf);
    posix_memalign(&p256, 32, 128);
    //p256 = malloc(32);  // nessuna garanzia che sia allineato a multipli di 32 byte
    __m256i p256v = _mm256_load_si256((const __m256i*) p256);  // segmentation fault con malloc
    //__m256i p256v = _mm256_loadu_si256((const __m256i*) p256);
    
    free(p256);

    return 0;
}