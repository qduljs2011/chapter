package com.baobaotao.study.array;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class ArraysTest {
	public static void main(String[] args) {
		int[] arrays={2,-1,4,5,1};
		Arrays.parallelPrefix(arrays, new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				return right+left;
			}
		});
		System.out.println(Arrays.toString(arrays));
	}
}
