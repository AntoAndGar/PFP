// uguaglianza di array di int - vettorizzazione

// Scrivere una funzione C int veq32(const int* a, int na, const int* b, int nb) che, dati due array di interi a e b di lunghezza 
// rispettivamente na e nb, restituisce 1 se gli array sono uguali e 0 altrimenti. La funzione deve usare vettorizzazione SSE o AVX.

// Suggerimento: si usino gli intrinsic _mm_cmpeq_epi32 e _mm_test_all_ones descritti nella guida Intel.

#include "veq32.h"

// ---------------------------------------------------------------------
// veq32
// ---------------------------------------------------------------------
// versione vettorizzata

int veq32(const int* a, int na, const int* b, int nb) {
    // da completare...
    return 1;
}


// ---------------------------------------------------------------------
// veq32_seq
// ---------------------------------------------------------------------
// versione sequenziale

int veq32_seq(const int* a, int na, const int* b, int nb) {
    int i;
    if (na != nb) return 0;
    for (i=0; i<na; ++i)
        if (a[i] != b[i]) return 0;
    return 1;
}