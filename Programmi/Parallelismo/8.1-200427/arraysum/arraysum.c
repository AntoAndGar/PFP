#include <stdio.h>

int arraysum(int *v, int n) {
    int i, sum = 0;
	for (i=0; i<n; ++i) sum += v[i];
    return sum;
}

int arraysum_unroll(int *v, int n) {
	int i, c[4] = {0}, sum = 0;
	for (i=0; i+3<n; i += 4) {
		c[0] += v[i+0];	// c[0] = *(v+i)
		c[1] += v[i+1];
		c[2] += v[i+2];
		c[3] += v[i+3];
	}
	for (; i<n; ++i) sum += v[i];
	return sum+c[0]+c[1]+c[2]+c[3];
}

int arraysum_sse(int *v, int n) {
	// scrivere la soluzione vettorizzata qui...
	return 0;
}

int main() {
	int v[] = { 1,1,1,1,1,1,1,1,1,1 };
	int x = arraysum_sse(v,10);
	printf("x=%d\n", x);
}
