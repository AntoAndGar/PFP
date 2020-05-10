#include "inrange.h"

// ---------------------------------------------------------------------
// inrange_seq
// ---------------------------------------------------------------------
// versione sequenziale

int inrange_seq(const short* data, unsigned n, short min, short max) {
    int i;
    for (i=0; i<n; ++i) 
        if (data[i]<min || data[i]>max) return 0;
    return 1;
}


// ---------------------------------------------------------------------
// inrange
// ---------------------------------------------------------------------
// versione SSE

int inrange(const short* data, unsigned n, short min, short max) {
	// scrivere la soluzione SSE qui...
	return 1;
}
