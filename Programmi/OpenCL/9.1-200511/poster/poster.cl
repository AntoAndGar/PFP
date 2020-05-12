// =====================================================================
//  poster.cl
// =====================================================================

//  Author:         (c) 2016 -- --
//  Created:        Feb 10, 2016

//  Last changed:   $Date: 2016/02/10 --:--:-- $
//  Changed by:     $Author: -- $
//  Revision:       $Revision: 1.00 $


#define IDX(x,y,w) ((y)*(w)+(x))

__kernel void poster(__global unsigned char* I,
                     __global unsigned char* O,
                     int h, int w) {

    int x = get_global_id(0);
    int y = get_global_id(1);

    if (x >= w || y >= h) return;

    unsigned pixel = I[IDX(x,y,w)];

    O[IDX(x,y,2*w)]     = pixel;
    O[IDX(w+x,y,2*w)]   = pixel;
    O[IDX(x,h+y,2*w)]   = pixel;
    O[IDX(w+x,h+y,2*w)] = pixel;
}

