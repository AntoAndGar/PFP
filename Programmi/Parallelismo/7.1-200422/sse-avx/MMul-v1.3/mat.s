	.section	__TEXT,__text,regular,pure_instructions
	.build_version macos, 10, 15	sdk_version 10, 15, 4
	.globl	_mat_new                ## -- Begin function mat_new
	.p2align	4, 0x90
_mat_new:                               ## @mat_new
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r12
	pushq	%rbx
	.cfi_offset %rbx, -48
	.cfi_offset %r12, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movl	%edi, %ebx
	movl	$16, %edi
	callq	_malloc
	movq	%rax, %r14
	movl	%ebx, %r15d
	leaq	(,%r15,8), %rdi
	callq	_malloc
	movq	%rax, (%r14)
	movl	%ebx, 8(%r14)
	testl	%ebx, %ebx
	je	LBB0_3
## %bb.1:
	leaq	(,%r15,4), %r12
	xorl	%ebx, %ebx
	.p2align	4, 0x90
LBB0_2:                                 ## =>This Inner Loop Header: Depth=1
	movq	%r12, %rdi
	callq	_malloc
	movq	(%r14), %rcx
	movq	%rax, (%rcx,%rbx,8)
	incq	%rbx
	cmpq	%rbx, %r15
	jne	LBB0_2
LBB0_3:
	movq	%r14, %rax
	popq	%rbx
	popq	%r12
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_mat_delete             ## -- Begin function mat_delete
	.p2align	4, 0x90
_mat_delete:                            ## @mat_delete
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r14
	pushq	%rbx
	.cfi_offset %rbx, -32
	.cfi_offset %r14, -24
	movq	%rdi, %r14
	cmpl	$0, 8(%rdi)
	movq	(%rdi), %rdi
	je	LBB1_3
## %bb.1:
	xorl	%ebx, %ebx
	.p2align	4, 0x90
LBB1_2:                                 ## =>This Inner Loop Header: Depth=1
	movq	(%rdi,%rbx,8), %rdi
	callq	_free
	incq	%rbx
	movl	8(%r14), %eax
	movq	(%r14), %rdi
	cmpq	%rax, %rbx
	jb	LBB1_2
LBB1_3:
	callq	_free
	movq	%r14, %rdi
	popq	%rbx
	popq	%r14
	popq	%rbp
	jmp	_free                   ## TAILCALL
	.cfi_endproc
                                        ## -- End function
	.globl	_mat_mul_get_desc       ## -- Begin function mat_mul_get_desc
	.p2align	4, 0x90
_mat_mul_get_desc:                      ## @mat_mul_get_desc
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movslq	%edi, %rax
	leaq	_mat_mul_desc(%rip), %rcx
	movq	(%rcx,%rax,8), %rax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_mat_init               ## -- Begin function mat_init
	.p2align	4, 0x90
_mat_init:                              ## @mat_init
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r12
	pushq	%rbx
	.cfi_offset %rbx, -48
	.cfi_offset %r12, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movl	%edx, %r14d
	movq	%rdi, %r12
	movl	%esi, %edi
	callq	_srand
	movl	8(%r12), %eax
	testl	%eax, %eax
	je	LBB3_6
## %bb.1:
	xorl	%r15d, %r15d
	testl	%eax, %eax
	jne	LBB3_3
	.p2align	4, 0x90
LBB3_5:                                 ## =>This Inner Loop Header: Depth=1
	incq	%r15
	movl	8(%r12), %eax
	cmpq	%rax, %r15
	jae	LBB3_6
## %bb.2:                               ##   in Loop: Header=BB3_5 Depth=1
	testl	%eax, %eax
	je	LBB3_5
LBB3_3:
	xorl	%ebx, %ebx
	.p2align	4, 0x90
LBB3_4:                                 ## =>This Inner Loop Header: Depth=1
	callq	_rand
	cltd
	idivl	%r14d
	movq	(%r12), %rax
	movq	(%rax,%r15,8), %rax
	movl	%edx, (%rax,%rbx,4)
	incq	%rbx
	movl	8(%r12), %eax
	cmpq	%rax, %rbx
	jb	LBB3_4
	jmp	LBB3_5
LBB3_6:
	popq	%rbx
	popq	%r12
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_mat_mul_check          ## -- Begin function mat_mul_check
	.p2align	4, 0x90
_mat_mul_check:                         ## @mat_mul_check
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%rbx
	.cfi_offset %rbx, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movl	8(%rdi), %ecx
	xorl	%eax, %eax
	cmpl	8(%rsi), %ecx
	jne	LBB4_11
## %bb.1:
	movl	8(%rdx), %r14d
	cmpl	%r14d, %ecx
	jne	LBB4_11
## %bb.2:
	movl	$1, %eax
	testl	%r14d, %r14d
	je	LBB4_11
## %bb.3:
	movq	(%rdx), %r8
	movq	(%rdi), %r9
	movq	(%rsi), %r15
	xorl	%r10d, %r10d
LBB4_4:                                 ## =>This Loop Header: Depth=1
                                        ##     Child Loop BB4_6 Depth 2
                                        ##       Child Loop BB4_7 Depth 3
	movq	(%r8,%r10,8), %r11
	movq	(%r9,%r10,8), %rdx
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB4_6:                                 ##   Parent Loop BB4_4 Depth=1
                                        ## =>  This Loop Header: Depth=2
                                        ##       Child Loop BB4_7 Depth 3
	xorl	%ebx, %ebx
	xorl	%ecx, %ecx
	.p2align	4, 0x90
LBB4_7:                                 ##   Parent Loop BB4_4 Depth=1
                                        ##     Parent Loop BB4_6 Depth=2
                                        ## =>    This Inner Loop Header: Depth=3
	movq	(%r15,%rcx,8), %rsi
	movl	(%rsi,%rdi,4), %esi
	imull	(%rdx,%rcx,4), %esi
	addl	%esi, %ebx
	incq	%rcx
	cmpq	%rcx, %r14
	jne	LBB4_7
## %bb.8:                               ##   in Loop: Header=BB4_6 Depth=2
	cmpl	(%r11,%rdi,4), %ebx
	jne	LBB4_9
## %bb.5:                               ##   in Loop: Header=BB4_6 Depth=2
	incq	%rdi
	cmpq	%r14, %rdi
	jb	LBB4_6
## %bb.10:                              ##   in Loop: Header=BB4_4 Depth=1
	incq	%r10
	cmpq	%r14, %r10
	jb	LBB4_4
	jmp	LBB4_11
LBB4_9:
	xorl	%eax, %eax
LBB4_11:
	popq	%rbx
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_mat_mul                ## -- Begin function mat_mul
	.p2align	4, 0x90
_mat_mul:                               ## @mat_mul
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movl	%ecx, %r8d
	movl	8(%rdi), %ecx
	movl	$-1, %eax
	cmpl	8(%rsi), %ecx
	jne	LBB5_3
## %bb.1:
	cmpl	8(%rdx), %ecx
	jne	LBB5_3
## %bb.2:
	movslq	%r8d, %rax
	leaq	_mat_mul_ver(%rip), %r8
	movq	(%rdi), %rdi
	movq	(%rsi), %rsi
	movq	(%rdx), %rdx
	callq	*(%r8,%rax,8)
	xorl	%eax, %eax
LBB5_3:
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ijk
_mat_mul_ijk:                           ## @mat_mul_ijk
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%rbx
	.cfi_offset %rbx, -24
	testl	%ecx, %ecx
	je	LBB6_7
## %bb.1:
	movl	%ecx, %r9d
	xorl	%r8d, %r8d
	.p2align	4, 0x90
LBB6_2:                                 ## =>This Loop Header: Depth=1
                                        ##     Child Loop BB6_3 Depth 2
                                        ##       Child Loop BB6_4 Depth 3
	movq	(%rdx,%r8,8), %r11
	movq	(%rdi,%r8,8), %r10
	xorl	%eax, %eax
	.p2align	4, 0x90
LBB6_3:                                 ##   Parent Loop BB6_2 Depth=1
                                        ## =>  This Loop Header: Depth=2
                                        ##       Child Loop BB6_4 Depth 3
	movl	$0, (%r11,%rax,4)
	xorl	%ecx, %ecx
	.p2align	4, 0x90
LBB6_4:                                 ##   Parent Loop BB6_2 Depth=1
                                        ##     Parent Loop BB6_3 Depth=2
                                        ## =>    This Inner Loop Header: Depth=3
	movq	(%rsi,%rcx,8), %rbx
	movl	(%rbx,%rax,4), %ebx
	imull	(%r10,%rcx,4), %ebx
	addl	%ebx, (%r11,%rax,4)
	incq	%rcx
	cmpq	%rcx, %r9
	jne	LBB6_4
## %bb.5:                               ##   in Loop: Header=BB6_3 Depth=2
	incq	%rax
	cmpq	%r9, %rax
	jne	LBB6_3
## %bb.6:                               ##   in Loop: Header=BB6_2 Depth=1
	incq	%r8
	cmpq	%r9, %r8
	jne	LBB6_2
LBB6_7:
	popq	%rbx
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ijk_sum
_mat_mul_ijk_sum:                       ## @mat_mul_ijk_sum
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r14
	pushq	%rbx
	.cfi_offset %rbx, -32
	.cfi_offset %r14, -24
	testl	%ecx, %ecx
	je	LBB7_7
## %bb.1:
	movl	%ecx, %r10d
	xorl	%r8d, %r8d
	.p2align	4, 0x90
LBB7_2:                                 ## =>This Loop Header: Depth=1
                                        ##     Child Loop BB7_3 Depth 2
                                        ##       Child Loop BB7_4 Depth 3
	movq	(%rdx,%r8,8), %r9
	movq	(%rdi,%r8,8), %r11
	xorl	%r14d, %r14d
	.p2align	4, 0x90
LBB7_3:                                 ##   Parent Loop BB7_2 Depth=1
                                        ## =>  This Loop Header: Depth=2
                                        ##       Child Loop BB7_4 Depth 3
	xorl	%ecx, %ecx
	xorl	%ebx, %ebx
	.p2align	4, 0x90
LBB7_4:                                 ##   Parent Loop BB7_2 Depth=1
                                        ##     Parent Loop BB7_3 Depth=2
                                        ## =>    This Inner Loop Header: Depth=3
	movq	(%rsi,%rbx,8), %rax
	movl	(%rax,%r14,4), %eax
	imull	(%r11,%rbx,4), %eax
	addl	%eax, %ecx
	incq	%rbx
	cmpq	%rbx, %r10
	jne	LBB7_4
## %bb.5:                               ##   in Loop: Header=BB7_3 Depth=2
	movl	%ecx, (%r9,%r14,4)
	incq	%r14
	cmpq	%r10, %r14
	jne	LBB7_3
## %bb.6:                               ##   in Loop: Header=BB7_2 Depth=1
	incq	%r8
	cmpq	%r10, %r8
	jne	LBB7_2
LBB7_7:
	popq	%rbx
	popq	%r14
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ijk_trans
_mat_mul_ijk_trans:                     ## @mat_mul_ijk_trans
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -56
	.cfi_offset %r12, -48
	.cfi_offset %r13, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movl	%ecx, %r14d
	movq	%rdx, %r15
	movq	%rsi, %r13
	movq	%rdi, %r12
	movq	%rsi, %rdi
	movl	%ecx, %esi
	callq	__mat_transpose
	testl	%r14d, %r14d
	je	LBB8_7
## %bb.1:
	movl	%r14d, %eax
	xorl	%r8d, %r8d
	.p2align	4, 0x90
LBB8_2:                                 ## =>This Loop Header: Depth=1
                                        ##     Child Loop BB8_3 Depth 2
                                        ##       Child Loop BB8_4 Depth 3
	movq	(%r15,%r8,8), %r9
	movq	(%r12,%r8,8), %rsi
	xorl	%r10d, %r10d
	.p2align	4, 0x90
LBB8_3:                                 ##   Parent Loop BB8_2 Depth=1
                                        ## =>  This Loop Header: Depth=2
                                        ##       Child Loop BB8_4 Depth 3
	movq	(%r13,%r10,8), %rbx
	xorl	%ecx, %ecx
	xorl	%edx, %edx
	.p2align	4, 0x90
LBB8_4:                                 ##   Parent Loop BB8_2 Depth=1
                                        ##     Parent Loop BB8_3 Depth=2
                                        ## =>    This Inner Loop Header: Depth=3
	movl	(%rbx,%rdx,4), %edi
	imull	(%rsi,%rdx,4), %edi
	addl	%edi, %ecx
	incq	%rdx
	cmpq	%rdx, %rax
	jne	LBB8_4
## %bb.5:                               ##   in Loop: Header=BB8_3 Depth=2
	movl	%ecx, (%r9,%r10,4)
	incq	%r10
	cmpq	%rax, %r10
	jne	LBB8_3
## %bb.6:                               ##   in Loop: Header=BB8_2 Depth=1
	incq	%r8
	cmpq	%rax, %r8
	jne	LBB8_2
LBB8_7:
	movq	%r13, %rdi
	movl	%r14d, %esi
	addq	$8, %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	jmp	__mat_transpose         ## TAILCALL
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ikj
_mat_mul_ikj:                           ## @mat_mul_ikj
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	pushq	%rax
	.cfi_offset %rbx, -56
	.cfi_offset %r12, -48
	.cfi_offset %r13, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	testl	%ecx, %ecx
	je	LBB9_9
## %bb.1:
	movq	%rdx, %r14
	movq	%rsi, %r13
	movq	%rdi, -48(%rbp)         ## 8-byte Spill
	movl	%ecx, %ebx
	leaq	(,%rbx,4), %r12
	xorl	%r15d, %r15d
	.p2align	4, 0x90
LBB9_2:                                 ## =>This Inner Loop Header: Depth=1
	movq	(%r14,%r15,8), %rdi
	movq	%r12, %rsi
	callq	___bzero
	incq	%r15
	cmpq	%r15, %rbx
	jne	LBB9_2
## %bb.3:
	xorl	%r8d, %r8d
	movq	-48(%rbp), %r11         ## 8-byte Reload
	.p2align	4, 0x90
LBB9_4:                                 ## =>This Loop Header: Depth=1
                                        ##     Child Loop BB9_5 Depth 2
                                        ##       Child Loop BB9_6 Depth 3
	movq	(%r11,%r8,8), %r9
	movq	(%r14,%r8,8), %rdx
	xorl	%r10d, %r10d
	.p2align	4, 0x90
LBB9_5:                                 ##   Parent Loop BB9_4 Depth=1
                                        ## =>  This Loop Header: Depth=2
                                        ##       Child Loop BB9_6 Depth 3
	movl	(%r9,%r10,4), %edi
	movq	(%r13,%r10,8), %rax
	xorl	%ecx, %ecx
	.p2align	4, 0x90
LBB9_6:                                 ##   Parent Loop BB9_4 Depth=1
                                        ##     Parent Loop BB9_5 Depth=2
                                        ## =>    This Inner Loop Header: Depth=3
	movl	(%rax,%rcx,4), %esi
	imull	%edi, %esi
	addl	%esi, (%rdx,%rcx,4)
	incq	%rcx
	cmpq	%rcx, %rbx
	jne	LBB9_6
## %bb.7:                               ##   in Loop: Header=BB9_5 Depth=2
	incq	%r10
	cmpq	%rbx, %r10
	jne	LBB9_5
## %bb.8:                               ##   in Loop: Header=BB9_4 Depth=1
	incq	%r8
	cmpq	%rbx, %r8
	jne	LBB9_4
LBB9_9:
	addq	$8, %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ikj_vec
_mat_mul_ikj_vec:                       ## @mat_mul_ikj_vec
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	subq	$24, %rsp
	.cfi_offset %rbx, -56
	.cfi_offset %r12, -48
	.cfi_offset %r13, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	testl	%ecx, %ecx
	je	LBB10_12
## %bb.1:
	movl	%ecx, %r12d
	movq	%rdx, %r14
	movq	%rsi, %r15
	movq	%rdi, -48(%rbp)         ## 8-byte Spill
	movl	%ecx, %r13d
	leaq	(,%r13,4), %rax
	movq	%rax, -56(%rbp)         ## 8-byte Spill
	xorl	%ebx, %ebx
	.p2align	4, 0x90
LBB10_2:                                ## =>This Inner Loop Header: Depth=1
	movq	(%r14,%rbx,8), %rdi
	movq	-56(%rbp), %rsi         ## 8-byte Reload
	callq	___bzero
	incq	%rbx
	cmpq	%rbx, %r13
	jne	LBB10_2
## %bb.3:
	addl	$-7, %r12d
	xorl	%r8d, %r8d
	movq	-48(%rbp), %r9          ## 8-byte Reload
	jmp	LBB10_4
	.p2align	4, 0x90
LBB10_11:                               ##   in Loop: Header=BB10_4 Depth=1
	incq	%r8
	cmpq	%r13, %r8
	je	LBB10_12
LBB10_4:                                ## =>This Loop Header: Depth=1
                                        ##     Child Loop BB10_9 Depth 2
                                        ##     Child Loop BB10_14 Depth 2
	xorl	%ecx, %ecx
	testl	%r12d, %r12d
	jne	LBB10_13
	jmp	LBB10_6
	.p2align	4, 0x90
LBB10_10:                               ##   in Loop: Header=BB10_4 Depth=1
	incq	%rcx
	cmpq	%r13, %rcx
	je	LBB10_11
## %bb.5:                               ##   in Loop: Header=BB10_4 Depth=1
	testl	%r12d, %r12d
	je	LBB10_6
LBB10_13:                               ##   in Loop: Header=BB10_4 Depth=1
	movq	(%r9,%r8,8), %rdx
	vpbroadcastd	(%rdx,%rcx,4), %ymm0
	xorl	%edx, %edx
	.p2align	4, 0x90
LBB10_14:                               ##   Parent Loop BB10_4 Depth=1
                                        ## =>  This Inner Loop Header: Depth=2
	movq	(%r15,%rcx,8), %rsi
	movq	(%r14,%r8,8), %rdi
	vpmulld	(%rsi,%rdx,4), %ymm0, %ymm1
	vpaddd	(%rdi,%rdx,4), %ymm1, %ymm1
	vmovdqu	%ymm1, (%rdi,%rdx,4)
	addq	$8, %rdx
	cmpq	%r12, %rdx
	jb	LBB10_14
## %bb.7:                               ##   in Loop: Header=BB10_4 Depth=1
	cmpq	%r13, %rdx
	jae	LBB10_10
	jmp	LBB10_8
	.p2align	4, 0x90
LBB10_6:                                ##   in Loop: Header=BB10_4 Depth=1
	xorl	%edx, %edx
	cmpq	%r13, %rdx
	jae	LBB10_10
LBB10_8:                                ##   in Loop: Header=BB10_4 Depth=1
	movq	(%r9,%r8,8), %rsi
	movq	(%r15,%rcx,8), %rdi
	movq	(%r14,%r8,8), %rbx
	.p2align	4, 0x90
LBB10_9:                                ##   Parent Loop BB10_4 Depth=1
                                        ## =>  This Inner Loop Header: Depth=2
	movl	(%rdi,%rdx,4), %eax
	imull	(%rsi,%rcx,4), %eax
	addl	%eax, (%rbx,%rdx,4)
	incq	%rdx
	cmpq	%rdx, %r13
	jne	LBB10_9
	jmp	LBB10_10
LBB10_12:
	addq	$24, %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ijk_trans_vec
_mat_mul_ijk_trans_vec:                 ## @mat_mul_ijk_trans_vec
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	andq	$-32, %rsp
	subq	$64, %rsp
	.cfi_offset %rbx, -56
	.cfi_offset %r12, -48
	.cfi_offset %r13, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movl	%ecx, %r14d
	movq	%rdx, %r15
	movq	%rsi, %r12
	movq	%rdi, %r13
	movq	%rsi, %rdi
	movl	%ecx, %esi
	callq	__mat_transpose
	testl	%r14d, %r14d
	je	LBB11_13
## %bb.1:
	movl	%r14d, %r11d
	leal	-7(%r14), %ecx
	leaq	7(%rcx), %r8
	andq	$-8, %r8
	xorl	%r9d, %r9d
	vxorps	%xmm0, %xmm0, %xmm0
	.p2align	4, 0x90
LBB11_2:                                ## =>This Loop Header: Depth=1
                                        ##     Child Loop BB11_3 Depth 2
                                        ##       Child Loop BB11_15 Depth 3
                                        ##       Child Loop BB11_8 Depth 3
                                        ##       Child Loop BB11_10 Depth 3
	xorl	%r10d, %r10d
	.p2align	4, 0x90
LBB11_3:                                ##   Parent Loop BB11_2 Depth=1
                                        ## =>  This Loop Header: Depth=2
                                        ##       Child Loop BB11_15 Depth 3
                                        ##       Child Loop BB11_8 Depth 3
                                        ##       Child Loop BB11_10 Depth 3
	vmovaps	%ymm0, (%rsp)
	testl	%ecx, %ecx
	je	LBB11_4
## %bb.14:                              ##   in Loop: Header=BB11_3 Depth=2
	movq	(%r13,%r9,8), %rdx
	movq	(%r12,%r10,8), %rsi
	vmovdqa	(%rsp), %ymm1
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB11_15:                               ##   Parent Loop BB11_2 Depth=1
                                        ##     Parent Loop BB11_3 Depth=2
                                        ## =>    This Inner Loop Header: Depth=3
	vmovdqu	(%rsi,%rdi,4), %ymm2
	vpmulld	(%rdx,%rdi,4), %ymm2, %ymm2
	vpaddd	%ymm1, %ymm2, %ymm1
	addq	$8, %rdi
	cmpq	%rcx, %rdi
	jb	LBB11_15
## %bb.5:                               ##   in Loop: Header=BB11_3 Depth=2
	vmovdqa	%ymm1, (%rsp)
	movq	%r8, %rbx
	jmp	LBB11_6
	.p2align	4, 0x90
LBB11_4:                                ##   in Loop: Header=BB11_3 Depth=2
	xorl	%ebx, %ebx
LBB11_6:                                ##   in Loop: Header=BB11_3 Depth=2
	xorl	%edx, %edx
	cmpq	%r11, %rbx
	jae	LBB11_9
## %bb.7:                               ##   in Loop: Header=BB11_3 Depth=2
	movq	(%r13,%r9,8), %rsi
	movq	(%r12,%r10,8), %rdi
	xorl	%edx, %edx
	.p2align	4, 0x90
LBB11_8:                                ##   Parent Loop BB11_2 Depth=1
                                        ##     Parent Loop BB11_3 Depth=2
                                        ## =>    This Inner Loop Header: Depth=3
	movl	(%rdi,%rbx,4), %eax
	imull	(%rsi,%rbx,4), %eax
	addl	%eax, %edx
	incq	%rbx
	cmpq	%rbx, %r11
	jne	LBB11_8
LBB11_9:                                ##   in Loop: Header=BB11_3 Depth=2
	movq	(%r15,%r9,8), %rsi
	movl	%edx, (%rsi,%r10,4)
	xorl	%edi, %edi
	.p2align	4, 0x90
LBB11_10:                               ##   Parent Loop BB11_2 Depth=1
                                        ##     Parent Loop BB11_3 Depth=2
                                        ## =>    This Inner Loop Header: Depth=3
	addl	(%rsp,%rdi,4), %edx
	incq	%rdi
	cmpq	$8, %rdi
	jne	LBB11_10
## %bb.11:                              ##   in Loop: Header=BB11_3 Depth=2
	movl	%edx, (%rsi,%r10,4)
	incq	%r10
	cmpq	%r11, %r10
	jne	LBB11_3
## %bb.12:                              ##   in Loop: Header=BB11_2 Depth=1
	incq	%r9
	cmpq	%r11, %r9
	jne	LBB11_2
LBB11_13:
	movq	%r12, %rdi
	movl	%r14d, %esi
	vzeroupper
	callq	__mat_transpose
	leaq	-40(%rbp), %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ikj_vec_2thread
_mat_mul_ikj_vec_2thread:               ## @mat_mul_ikj_vec_2thread
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r14
	pushq	%rbx
	subq	$112, %rsp
	.cfi_offset %rbx, -32
	.cfi_offset %r14, -24
	movq	%rdi, -128(%rbp)
	movq	%rsi, -120(%rbp)
	movq	%rdx, -112(%rbp)
	movl	%ecx, -104(%rbp)
	movq	$0, -96(%rbp)
	movq	%rdi, -80(%rbp)
	movq	%rsi, -72(%rbp)
	movq	%rdx, -64(%rbp)
	movl	%ecx, -56(%rbp)
	movl	%ecx, %eax
                                        ## kill: def $ecx killed $ecx def $rcx
	shrl	%ecx
	movq	%rcx, -88(%rbp)
	movq	%rcx, -48(%rbp)
	movq	%rax, -40(%rbp)
	leaq	__pthread_func(%rip), %r14
	leaq	-32(%rbp), %rdi
	leaq	-128(%rbp), %rcx
	xorl	%esi, %esi
	movq	%r14, %rdx
	callq	_pthread_create
	movl	%eax, %ebx
	leaq	-24(%rbp), %rdi
	leaq	-80(%rbp), %rcx
	xorl	%esi, %esi
	movq	%r14, %rdx
	callq	_pthread_create
	testl	%ebx, %ebx
	jne	LBB12_3
## %bb.1:
	testl	%eax, %eax
	jne	LBB12_4
## %bb.2:
	movq	-32(%rbp), %rdi
	xorl	%esi, %esi
	callq	_pthread_join
	movq	-24(%rbp), %rdi
	xorl	%esi, %esi
	callq	_pthread_join
	addq	$112, %rsp
	popq	%rbx
	popq	%r14
	popq	%rbp
	retq
LBB12_3:
	callq	_mat_mul_ikj_vec_2thread.cold.2
LBB12_4:
	callq	_mat_mul_ikj_vec_2thread.cold.1
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ikj_vec_4thread
_mat_mul_ikj_vec_4thread:               ## @mat_mul_ikj_vec_4thread
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r12
	pushq	%rbx
	subq	$224, %rsp
	.cfi_offset %rbx, -48
	.cfi_offset %r12, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
                                        ## kill: def $ecx killed $ecx def $rcx
	movq	%rdi, -256(%rbp)
	movq	%rsi, -248(%rbp)
	movq	%rdx, -240(%rbp)
	movl	%ecx, -232(%rbp)
	movq	$0, -224(%rbp)
	movq	%rdi, -208(%rbp)
	movq	%rsi, -200(%rbp)
	movq	%rdx, -192(%rbp)
	movl	%ecx, -184(%rbp)
	movl	%ecx, %eax
	movq	%rdi, -160(%rbp)
	movq	%rsi, -152(%rbp)
	movq	%rdx, -144(%rbp)
	movl	%ecx, -136(%rbp)
	movq	%rdi, -112(%rbp)
	leal	(%rcx,%rcx,2), %edi
	movq	%rsi, -104(%rbp)
	movq	%rdx, -96(%rbp)
	movl	%ecx, -88(%rbp)
	movl	%ecx, %edx
                                        ## kill: def $ecx killed $ecx killed $rcx def $rcx
	shrl	$2, %ecx
	movq	%rcx, -216(%rbp)
	movq	%rcx, -176(%rbp)
	shrl	%eax
	movq	%rax, -168(%rbp)
	movq	%rax, -128(%rbp)
	shrl	$2, %edi
	movq	%rdi, -120(%rbp)
	movq	%rdi, -80(%rbp)
	movq	%rdx, -72(%rbp)
	leaq	__pthread_func(%rip), %r15
	leaq	-64(%rbp), %rdi
	leaq	-256(%rbp), %rcx
	xorl	%esi, %esi
	movq	%r15, %rdx
	callq	_pthread_create
	movl	%eax, %r12d
	leaq	-56(%rbp), %rdi
	leaq	-208(%rbp), %rcx
	xorl	%esi, %esi
	movq	%r15, %rdx
	callq	_pthread_create
	movl	%eax, %r14d
	leaq	-48(%rbp), %rdi
	leaq	-160(%rbp), %rcx
	xorl	%esi, %esi
	movq	%r15, %rdx
	callq	_pthread_create
	movl	%eax, %ebx
	leaq	-40(%rbp), %rdi
	leaq	-112(%rbp), %rcx
	xorl	%esi, %esi
	movq	%r15, %rdx
	callq	_pthread_create
	testl	%r12d, %r12d
	jne	LBB13_5
## %bb.1:
	testl	%r14d, %r14d
	jne	LBB13_6
## %bb.2:
	testl	%ebx, %ebx
	jne	LBB13_7
## %bb.3:
	testl	%eax, %eax
	jne	LBB13_8
## %bb.4:
	movq	-64(%rbp), %rdi
	xorl	%esi, %esi
	callq	_pthread_join
	movq	-56(%rbp), %rdi
	xorl	%esi, %esi
	callq	_pthread_join
	movq	-48(%rbp), %rdi
	xorl	%esi, %esi
	callq	_pthread_join
	movq	-40(%rbp), %rdi
	xorl	%esi, %esi
	callq	_pthread_join
	addq	$224, %rsp
	popq	%rbx
	popq	%r12
	popq	%r14
	popq	%r15
	popq	%rbp
	retq
LBB13_5:
	callq	_mat_mul_ikj_vec_4thread.cold.4
LBB13_6:
	callq	_mat_mul_ikj_vec_4thread.cold.3
LBB13_7:
	callq	_mat_mul_ikj_vec_4thread.cold.2
LBB13_8:
	callq	_mat_mul_ikj_vec_4thread.cold.1
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function _mat_transpose
__mat_transpose:                        ## @_mat_transpose
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r14
	pushq	%rbx
	.cfi_offset %rbx, -32
	.cfi_offset %r14, -24
	testl	%esi, %esi
	je	LBB14_6
## %bb.1:
	movl	%esi, %r8d
	xorl	%r9d, %r9d
	movq	%rdi, %r10
	movq	%r8, %r11
	jmp	LBB14_3
	.p2align	4, 0x90
LBB14_2:                                ##   in Loop: Header=BB14_3 Depth=1
	decq	%r11
	addq	$8, %r10
	cmpq	%r8, %r9
	je	LBB14_6
LBB14_3:                                ## =>This Loop Header: Depth=1
                                        ##     Child Loop BB14_5 Depth 2
	movq	%r9, %r14
	incq	%r9
	cmpq	%r8, %r9
	jae	LBB14_2
## %bb.4:                               ##   in Loop: Header=BB14_3 Depth=1
	leaq	(,%r14,4), %rax
	addq	(%rdi,%r14,8), %rax
	movl	$1, %ecx
	.p2align	4, 0x90
LBB14_5:                                ##   Parent Loop BB14_3 Depth=1
                                        ## =>  This Inner Loop Header: Depth=2
	movl	(%rax,%rcx,4), %edx
	movq	(%r10,%rcx,8), %rbx
	movl	(%rbx,%r14,4), %esi
	movl	%esi, (%rax,%rcx,4)
	movl	%edx, (%rbx,%r14,4)
	incq	%rcx
	cmpq	%rcx, %r11
	jne	LBB14_5
	jmp	LBB14_2
LBB14_6:
	popq	%rbx
	popq	%r14
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function _pthread_func
__pthread_func:                         ## @_pthread_func
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	pushq	%r15
	pushq	%r14
	pushq	%r13
	pushq	%r12
	pushq	%rbx
	subq	$40, %rsp
	.cfi_offset %rbx, -56
	.cfi_offset %r12, -48
	.cfi_offset %r13, -40
	.cfi_offset %r14, -32
	.cfi_offset %r15, -24
	movq	(%rdi), %r9
	movq	8(%rdi), %r13
	movq	16(%rdi), %r12
	movl	24(%rdi), %r14d
	movq	32(%rdi), %r15
	movq	%rdi, -48(%rbp)         ## 8-byte Spill
	movq	40(%rdi), %rax
	movq	%rax, -72(%rbp)         ## 8-byte Spill
	cmpq	%rax, %r15
	jge	LBB15_5
## %bb.1:
	leaq	(,%r14,4), %rax
	movq	%rax, -56(%rbp)         ## 8-byte Spill
	movq	%r15, %rbx
	movq	%r9, -64(%rbp)          ## 8-byte Spill
	testl	%r14d, %r14d
	jne	LBB15_3
	.p2align	4, 0x90
LBB15_4:                                ## =>This Inner Loop Header: Depth=1
	incq	%rbx
	cmpq	-72(%rbp), %rbx         ## 8-byte Folded Reload
	jge	LBB15_5
## %bb.2:                               ##   in Loop: Header=BB15_4 Depth=1
	testl	%r14d, %r14d
	je	LBB15_4
LBB15_3:
	movq	(%r12,%rbx,8), %rdi
	movq	-56(%rbp), %rsi         ## 8-byte Reload
	callq	___bzero
	movq	-64(%rbp), %r9          ## 8-byte Reload
	jmp	LBB15_4
LBB15_5:
	movq	-48(%rbp), %rax         ## 8-byte Reload
	cmpq	40(%rax), %r15
	jge	LBB15_16
## %bb.6:
	leal	-7(%r14), %r8d
	testl	%r14d, %r14d
	jne	LBB15_8
	.p2align	4, 0x90
LBB15_15:                               ## =>This Inner Loop Header: Depth=1
	incq	%r15
	movq	-48(%rbp), %rax         ## 8-byte Reload
	cmpq	40(%rax), %r15
	jge	LBB15_16
## %bb.7:                               ##   in Loop: Header=BB15_15 Depth=1
	testl	%r14d, %r14d
	je	LBB15_15
LBB15_8:
	xorl	%ecx, %ecx
	testl	%r8d, %r8d
	jne	LBB15_17
	jmp	LBB15_10
	.p2align	4, 0x90
LBB15_14:
	incq	%rcx
	cmpq	%r14, %rcx
	je	LBB15_15
## %bb.9:
	testl	%r8d, %r8d
	je	LBB15_10
LBB15_17:
	movq	(%r9,%r15,8), %rdx
	vpbroadcastd	(%rdx,%rcx,4), %ymm0
	xorl	%edx, %edx
	.p2align	4, 0x90
LBB15_18:                               ## =>This Inner Loop Header: Depth=1
	movq	(%r13,%rcx,8), %rsi
	movq	(%r12,%r15,8), %rdi
	vpmulld	(%rsi,%rdx,4), %ymm0, %ymm1
	vpaddd	(%rdi,%rdx,4), %ymm1, %ymm1
	vmovdqu	%ymm1, (%rdi,%rdx,4)
	addq	$8, %rdx
	cmpq	%r8, %rdx
	jb	LBB15_18
## %bb.11:
	cmpq	%r14, %rdx
	jae	LBB15_14
	jmp	LBB15_12
	.p2align	4, 0x90
LBB15_10:
	xorl	%edx, %edx
	cmpq	%r14, %rdx
	jae	LBB15_14
LBB15_12:
	movq	(%r9,%r15,8), %rsi
	movq	(%r13,%rcx,8), %rdi
	movq	(%r12,%r15,8), %rbx
	.p2align	4, 0x90
LBB15_13:                               ## =>This Inner Loop Header: Depth=1
	movl	(%rdi,%rdx,4), %eax
	imull	(%rsi,%rcx,4), %eax
	addl	%eax, (%rbx,%rdx,4)
	incq	%rdx
	cmpq	%rdx, %r14
	jne	LBB15_13
	jmp	LBB15_14
LBB15_16:
	xorl	%eax, %eax
	addq	$40, %rsp
	popq	%rbx
	popq	%r12
	popq	%r13
	popq	%r14
	popq	%r15
	popq	%rbp
	vzeroupper
	retq
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ikj_vec_2thread.cold.1
_mat_mul_ikj_vec_2thread.cold.1:        ## @mat_mul_ikj_vec_2thread.cold.1
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	leaq	L___func__.mat_mul_ikj_vec_2thread(%rip), %rdi
	leaq	L_.str.8(%rip), %rsi
	leaq	L_.str.10(%rip), %rcx
	movl	$371, %edx              ## imm = 0x173
	callq	___assert_rtn
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ikj_vec_2thread.cold.2
_mat_mul_ikj_vec_2thread.cold.2:        ## @mat_mul_ikj_vec_2thread.cold.2
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	leaq	L___func__.mat_mul_ikj_vec_2thread(%rip), %rdi
	leaq	L_.str.8(%rip), %rsi
	leaq	L_.str.9(%rip), %rcx
	movl	$370, %edx              ## imm = 0x172
	callq	___assert_rtn
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ikj_vec_4thread.cold.1
_mat_mul_ikj_vec_4thread.cold.1:        ## @mat_mul_ikj_vec_4thread.cold.1
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	leaq	L___func__.mat_mul_ikj_vec_4thread(%rip), %rdi
	leaq	L_.str.8(%rip), %rsi
	leaq	L_.str.12(%rip), %rcx
	movl	$390, %edx              ## imm = 0x186
	callq	___assert_rtn
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ikj_vec_4thread.cold.2
_mat_mul_ikj_vec_4thread.cold.2:        ## @mat_mul_ikj_vec_4thread.cold.2
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	leaq	L___func__.mat_mul_ikj_vec_4thread(%rip), %rdi
	leaq	L_.str.8(%rip), %rsi
	leaq	L_.str.11(%rip), %rcx
	movl	$389, %edx              ## imm = 0x185
	callq	___assert_rtn
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ikj_vec_4thread.cold.3
_mat_mul_ikj_vec_4thread.cold.3:        ## @mat_mul_ikj_vec_4thread.cold.3
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	leaq	L___func__.mat_mul_ikj_vec_4thread(%rip), %rdi
	leaq	L_.str.8(%rip), %rsi
	leaq	L_.str.10(%rip), %rcx
	movl	$388, %edx              ## imm = 0x184
	callq	___assert_rtn
	.cfi_endproc
                                        ## -- End function
	.p2align	4, 0x90         ## -- Begin function mat_mul_ikj_vec_4thread.cold.4
_mat_mul_ikj_vec_4thread.cold.4:        ## @mat_mul_ikj_vec_4thread.cold.4
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	leaq	L___func__.mat_mul_ikj_vec_4thread(%rip), %rdi
	leaq	L_.str.8(%rip), %rsi
	leaq	L_.str.9(%rip), %rcx
	movl	$387, %edx              ## imm = 0x183
	callq	___assert_rtn
	.cfi_endproc
                                        ## -- End function
	.section	__DATA,__const
	.p2align	4               ## @mat_mul_desc
_mat_mul_desc:
	.quad	L_.str
	.quad	L_.str.1
	.quad	L_.str.2
	.quad	L_.str.3
	.quad	L_.str.4
	.quad	L_.str.5
	.quad	L_.str.6
	.quad	L_.str.7

	.p2align	4               ## @mat_mul_ver
_mat_mul_ver:
	.quad	_mat_mul_ijk
	.quad	_mat_mul_ijk_sum
	.quad	_mat_mul_ijk_trans
	.quad	_mat_mul_ikj
	.quad	_mat_mul_ikj_vec
	.quad	_mat_mul_ijk_trans_vec
	.quad	_mat_mul_ikj_vec_2thread
	.quad	_mat_mul_ikj_vec_4thread

	.section	__TEXT,__cstring,cstring_literals
L_.str:                                 ## @.str
	.asciz	"triple loop ijk"

L_.str.1:                               ## @.str.1
	.asciz	"triple loop ijk with accumulator"

L_.str.2:                               ## @.str.2
	.asciz	"triple loop ijk with accumulator and transposed b"

L_.str.3:                               ## @.str.3
	.asciz	"triple loop ikj"

L_.str.4:                               ## @.str.4
	.asciz	"triple loop ikj and vectorization"

L_.str.5:                               ## @.str.5
	.asciz	"triple loop ijk with accumulator, transposed b, and vectorization"

L_.str.6:                               ## @.str.6
	.asciz	"triple loop ikj, vectorization, and 2 threads"

L_.str.7:                               ## @.str.7
	.asciz	"triple loop ikj, vectorization, and 4 threads"

L___func__.mat_mul_ikj_vec_2thread:     ## @__func__.mat_mul_ikj_vec_2thread
	.asciz	"mat_mul_ikj_vec_2thread"

L_.str.8:                               ## @.str.8
	.asciz	"mat.c"

L_.str.9:                               ## @.str.9
	.asciz	"res1 == 0"

L_.str.10:                              ## @.str.10
	.asciz	"res2 == 0"

L___func__.mat_mul_ikj_vec_4thread:     ## @__func__.mat_mul_ikj_vec_4thread
	.asciz	"mat_mul_ikj_vec_4thread"

L_.str.11:                              ## @.str.11
	.asciz	"res3 == 0"

L_.str.12:                              ## @.str.12
	.asciz	"res4 == 0"


.subsections_via_symbols
