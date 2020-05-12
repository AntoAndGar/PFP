__kernel void vecsum(__global const int *A, 
                     __global const int *B, 
                     __global int *C,
                     int n) {
    
    // Get the index of the current element to be processed
    int i = get_global_id(0);

    if (i>=n) return;
    
    // Do the operation
    C[i] = A[i] + B[i];
}
