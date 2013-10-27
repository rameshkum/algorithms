package hr.grubic.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Find the no of positive integral solutions for the equations (1/x) + (1/y) = 1/N! (read 1 by n factorial) 
 * Print a single integer which is the no of positive integral solutions modulo 1000007. 
 * @author maja
 *
 */
public class Equation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		List<Integer> primes = generatePrimes(N);
		int[] multiplier = generateMultiplier(N, primes);
		long sum = 1L;
		for (int i = 1; i <= N; i++)
			if (multiplier[i] != 0) {
				sum *= (long) (2 * multiplier[i] + 1) % 1000007;
				sum %= 1000007;
			}
		System.out.println(sum);
	}

	public static List<Integer> generatePrimes(int N) {
		boolean[] isPrime = new boolean[N + 1];
		for (int i=0;i<N+1;i++) {
			isPrime[i] = true;
		}
		List<Integer> prime = new ArrayList<Integer>();
		for (int i = 2; i <= N; i++)
			if (isPrime[i]) {
				prime.add(i);
				for (int j = 2; j * i <= N; j++)
					isPrime[i * j] = false;
			}
		return prime;
	}

	public static int[] generateMultiplier(int N, List<Integer> prime) {
		int[] multiplier = new int[N + 1];
		for (int j : prime) {
			int cpy = N;
			int e = 0;
			while (cpy != 0) {
				e += cpy / j;
				cpy /= j;
			}
			multiplier[j] = e;
		}
		return multiplier;
	}

}
