// =====================================================================
//  cdiff.c
// =====================================================================

//  Author:         (c) 2018-2020 Camil Demetrescu
//  License:        See the end of this file for license information
//  Created:        Feb 22, 2018

//  Last changed:   $Date: 2018/01/30 --:--:-- $
//  Changed by:     $Author: demetres $
//  Revision:       $Revision: 1.00 $


#include <stdio.h>
#include <stdlib.h>
#include <immintrin.h>
#include "cdiff.h"


// ---------------------------------------------------------------------
// cdiff
// ---------------------------------------------------------------------
// SSE version

int cdiff(const char* x, const char* y, int n) {

    int i, j, cnt = 0;
    unsigned char mcnt[16];

    __m128i xv, yv, res, vcnt, vone;
    vone = _mm_set_epi8(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
    vcnt = _mm_set_epi8(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

    for (i=0; i+15<n; i+=16) {
        xv   = _mm_loadu_si128((__m128i const*)(x+i));
        yv   = _mm_loadu_si128((__m128i const*)(y+i));
        res  = _mm_cmpeq_epi8(xv, yv);
        res  = _mm_add_epi8(res, vone);
        vcnt = _mm_add_epi8(vcnt, res);
        if (i % 255 == 0) {
            _mm_storeu_si128((__m128i*)mcnt, vcnt);
            for (j=0; j<16; ++j) cnt += mcnt[j];
            vcnt = _mm_set_epi8(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        }
    }

    for (; i<n; ++i)
        if (x[i] != y[i]) ++cnt;

    _mm_storeu_si128((__m128i*)mcnt, vcnt);
    for (j=0; j<16; ++j) cnt += mcnt[j];

    return cnt;
}


// Copyright (C) 2018-2020 Camil Demetrescu

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
