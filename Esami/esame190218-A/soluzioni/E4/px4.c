// =====================================================================
//  px4.h
// =====================================================================

//  Author:         (c) 2019 ---
//  License:        See the end of this file for license information
//  Created:        Feb 17, 2019
 
//  Last changed:   $Date: 2019/02/17 11:00:00 $
//  Changed by:     $Author: --- $
//  Revision:       $Revision: 1.00 $


#include "px4.h"

#define LOCAL_SIZE  8
#define KERNEL_NAME "px4"


// ---------------------------------------------------------------------
// px4
// ---------------------------------------------------------------------
// data-parallel GPU version

void px4(unsigned char* in, unsigned char* out, int h, int w, 
         double* t, clut_device* dev) {

    int       err;      // error code
    cl_kernel kernel;   // execution kernel
    cl_mem    din;      // input matrix on device
    cl_mem    dout;     // output matrix on device
    cl_event  evt;      // performance measurement event

    // create the compute kernel
    kernel = clCreateKernel(dev->program, KERNEL_NAME, &err);
    clut_check_err(err, "failed to create kernel");

    // allocate input matrix on device as a copy of input matrix on host
    din = clCreateBuffer(dev->context, 
                         CL_MEM_READ_ONLY | CL_MEM_COPY_HOST_PTR, 
                         h*w*sizeof(unsigned char), in, NULL);
    if (!din) clut_panic("failed to allocate input matrix on device memory");

    // allocate output matrix on device
    dout = clCreateBuffer(dev->context, 
                          CL_MEM_WRITE_ONLY, 
                          h*w*sizeof(unsigned char), NULL, NULL);
    if (!dout) clut_panic("failed to allocate output matrix on device memory");

    // set the arguments to our compute kernel
    err  = clSetKernelArg(kernel, 0, sizeof(cl_mem), &din);
    err |= clSetKernelArg(kernel, 1, sizeof(cl_mem), &dout);
    err |= clSetKernelArg(kernel, 2, sizeof(int), &h);
    err |= clSetKernelArg(kernel, 3, sizeof(int), &w);
    clut_check_err(err, "failed to set kernel arguments");

    // execute the kernel over the range of our 2D input data set
    size_t local_dim[]  = { LOCAL_SIZE, LOCAL_SIZE };
    size_t global_dim[] = { w/2, h/2 };
    global_dim[0] = ((global_dim[0]+LOCAL_SIZE-1)/LOCAL_SIZE)*LOCAL_SIZE; // round up
    global_dim[1] = ((global_dim[1]+LOCAL_SIZE-1)/LOCAL_SIZE)*LOCAL_SIZE; // round up

    err = clEnqueueNDRangeKernel(dev->queue, kernel, 2, 
                                 NULL, global_dim, local_dim, 0, NULL, &evt);
    clut_check_err(err, "failed to execute kernel");

    // copy result from device to host
    err = clEnqueueReadBuffer(dev->queue, dout, CL_TRUE, 0, 
                              h*w*sizeof(unsigned char), out, 0, NULL, NULL);
    clut_check_err(err, "failed to read output result");

    // return kernel execution time
    *t = clut_get_duration(evt);

    // cleanup
    clReleaseMemObject(din);
    clReleaseMemObject(dout);
    clReleaseKernel(kernel);
}


// Copyright (C) 2019 ---

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
