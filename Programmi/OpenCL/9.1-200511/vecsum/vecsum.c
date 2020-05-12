#include <stdio.h>
#include <stdlib.h>
#include "clut.h"

#define N                   1009
#define LOCAL_SIZE          16               // work items per work group

int main(void) {

    clut_device dev;	// context, device queue & program
    int       err;      // error code
    cl_kernel kernel;   // execution kernel

    // create the two input vectors + output vector
    int i, n = N;
    int *A = (int*)malloc(sizeof(int)*n);
    int *B = (int*)malloc(sizeof(int)*n);
    int *C = (int*)malloc(sizeof(int)*n);

    for (i = 0; i < n; i++) {
        A[i] = i;
        B[i] = n - i;
    }

	clut_open_device(&dev, "vecsum.cl");

    clut_print_device_info(&dev);

    // create memory buffers a, b, c on the device for each vector
    cl_mem a = clCreateBuffer(dev.context,
    						CL_MEM_READ_ONLY | CL_MEM_COPY_HOST_PTR,
    						n * sizeof(int), A, NULL);
    if (!a) clut_panic("failed to allocate input vec on device memory");

    cl_mem b = clCreateBuffer(dev.context,
    						CL_MEM_READ_ONLY | CL_MEM_COPY_HOST_PTR,
    						n * sizeof(int), B, NULL);
    if (!b) 	("failed to allocate input vec on device memory");

    cl_mem c = clCreateBuffer(dev.context, CL_MEM_WRITE_ONLY,
    						n * sizeof(int), NULL, NULL);
    if (!a) clut_panic("failed to allocate output vec on device memory");

    // create an OpenCL kernel
    kernel = clCreateKernel(dev.program, "vecsum", &err);
    clut_check_err(err, "clCreateKernel failed");

    // set the arguments of the kernel
    err  = clSetKernelArg(kernel, 0, sizeof(cl_mem), (void *)&a);
    err |= clSetKernelArg(kernel, 1, sizeof(cl_mem), (void *)&b);
    err |= clSetKernelArg(kernel, 2, sizeof(cl_mem), (void *)&c);
    err |= clSetKernelArg(kernel, 3, sizeof(int), (void *)&n);
    clut_check_err(err, "clSetKernelArg failed");

    // execute the OpenCL kernel on the list
    size_t local_item_size[1]  = { LOCAL_SIZE };
    size_t global_item_size[1] = { ((n+LOCAL_SIZE-1)/LOCAL_SIZE)*LOCAL_SIZE } ;

    printf("data size: %d\n", n);
    printf("global size: %lu\n", global_item_size[0]);

    err = clEnqueueNDRangeKernel(dev.queue, kernel, 1, NULL,
                                 global_item_size,
                                 local_item_size, 0, NULL, NULL);
    clut_check_err(err, "clEnqueueNDRangeKernel failed");

    // read the memory buffer C on the device to the local variable C
    err = clEnqueueReadBuffer(dev.queue, c, CL_TRUE, 0,
                              n * sizeof(int), C, 0, NULL, NULL);
    clut_check_err(err, "clEnqueueReadBuffer failed");

    // display the result to the screen
    for (i = 0; i < n; i++)
        if (A[i] + B[i] != C[i]) break;

	if (i < n) printf("correctness test: FAILED\n");
	else       printf("correctness test: PASSED\n");

    clReleaseMemObject(a); // "free" sulla GPU
    clReleaseMemObject(b);
    clReleaseMemObject(c);
    clReleaseKernel(kernel);

    clut_close_device(&dev);

    free(A);
    free(B);
    free(C);
    return 0;
}
