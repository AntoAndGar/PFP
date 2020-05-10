// =====================================================================
//  main.c
// =====================================================================

//  Author:         (c) 2018 Camil Demetrescu
//  License:        See the end of this file for license information
//  Created:        Feb 22, 2018

//  Last changed:   $Date: 2018/02/22 --:--:-- $
//  Changed by:     $Author: demetres $
//  Revision:       $Revision: 1.00 $


#include <sys/time.h>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

#include "cdiff.h"

#define N    200000
#define M    1000
#define SEED 971


// ---------------------------------------------------------------------
// cdiff_seq
// ---------------------------------------------------------------------
// sequential version

static
int cdiff_seq(const char* x, const char* y, int n) {
    int i, cnt = 0;
    for (i=0; i<n; ++i)
        if (x[i] != y[i]) ++cnt;
    return cnt;
}


// ---------------------------------------------------------------------
// get_real_time
// ---------------------------------------------------------------------
double get_real_time() {
    struct timeval tv;
    gettimeofday(&tv, NULL);
    return tv.tv_sec+tv.tv_usec*1E-06;
}


// ---------------------------------------------------------------------
// do_test
// ---------------------------------------------------------------------
static void do_test(const char* x, const char* y, int n, int test_no) {

    double start, tseq, tsse;
    int i, rseq, rsse;

    printf("\nTest #%d\n", test_no);

    // sequential
    start = get_real_time();
    for (i=0; i<M; ++i) rseq  = cdiff_seq(x, y, n);
    tseq  = get_real_time()-start;

    // SSE
    start = get_real_time();
    for (i=0; i<M; ++i) rsse = cdiff(x, y, n);
    tsse  = get_real_time()-start;

    printf("- result: %d [expected: %d]\n", rsse, rseq);
    printf("- sequential version: %.2f msec\n", tseq*1000);
    printf("- SSE version: %.2f msec\n", tsse*1000);
    printf("- speedup: %.2fx\n", tseq/tsse);
}


// ---------------------------------------------------------------------
// main
// ---------------------------------------------------------------------
int main(int argc, char** argv) {

    int i;
    char* x = malloc(N*sizeof(char));
    char* y = malloc(N*sizeof(char));
    char* z = malloc(N*sizeof(char));
    char* w = malloc(N*sizeof(char));
    assert(x != NULL);
    assert(y != NULL);
    assert(z != NULL);
    assert(w != NULL);

    srand(SEED);

    for (i=0; i<N; ++i) {
        x[i] = y[i] = z[i] = 33 + i % 94;
        w[i] = x[i] + 1;
    }

    for (i = 0; i<100; i++)
        y[rand() % N] = 32;

    for (i = 0; i<565*16; i++)
        z[rand() % N] = 32;

    do_test(x, x, N, 1);
    do_test(x, y, N, 2);
    do_test(x, z, N, 3);
    do_test(x, w, N, 4);

    free(x);
    free(y);
    free(z);
	free(w);

    return 0;
}


// Copyright (C) 2018 Camil Demetrescu

// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.

// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.

// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
// USA
