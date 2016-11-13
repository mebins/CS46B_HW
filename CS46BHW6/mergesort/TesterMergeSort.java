package mergesort;

import java.util.Random;

public class TesterMergeSort {
	
	public final static int[] TEST_1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};// already even sorted
	public final static int[] TEST_2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};// already odd sorted
	public final static int[] TEST_3 = {5,2,8,42,3,7,9,15,30,59,35,32,80,53,13,24,63,22};//nonsorted even
	public final static int[] TEST_4 = {5,2,8,42,3,7,9,30,59,35,32,80,53,13,24,63,22};//nonsorted even
	public final static int[] TEST_5 = {5,2,8,42,3,7,9,0,30,59,35,32,80,53,13,24,63,22};//nonsorted with a 0 
	public final static int[] TEST_6 = {5,2,8,42,3,7,15,30,59,35,32,80,53,13,24,63,22};//nonsorted odd
	public final static int[] TEST_7 = {5,2,8,42,3,7,9,15,30,59,35,32,4,5,53,13,24,63,22};//nonsorted odd repeating
	public final static int[] TEST_8 = {5,2,8,42,5,3,7,9,15,30,59,35,32,1,53,13,24,63,22,94};//nonsorted even
	public final static int[] TEST_9 = {5,5,2,8,42,3,7,9,15,30,59,35,32,80,53,13,24,63,22};//nonsorted odd adjacent duplicate
	public final static int[] TEST_10 = {5,5,2,8,42,3,7,9,15,30,59,35,32,80,53,13,24,63,22,94};//nonsorted even adjacent duplicate
	
	public final static int[] TEST_11 = new int[300];
	public static Random gen = new Random();

	public static void main(String[] args) {
		MergeSorter sorter; 
		for(int i =0; i < 300; i++)
		{
			TEST_11[i] = gen.nextInt(200);
		}
		
		sorter = new MergeSorter(TesterMergeSort.TEST_1);
		for (int e : sorter.mergeSort()) {
			System.out.print(e + " ");
		}
		System.out.println();
		sorter = new MergeSorter(TesterMergeSort.TEST_2);
		for (int e : sorter.mergeSort()) {
			System.out.print(e + " ");
		}
		System.out.println();
		sorter = new MergeSorter(TesterMergeSort.TEST_3);
		for (int e : sorter.mergeSort()) {
			System.out.print(e + " ");
		}
		System.out.println();
		sorter = new MergeSorter(TesterMergeSort.TEST_4);
		for (int e : sorter.mergeSort()) {
			System.out.print(e + " ");
		}
		System.out.println();
		sorter = new MergeSorter(TesterMergeSort.TEST_5);
		for (int e : sorter.mergeSort()) {
			System.out.print(e + " ");
		}
		System.out.println();
		sorter = new MergeSorter(TesterMergeSort.TEST_6);
		for (int e : sorter.mergeSort()) {
			System.out.print(e + " ");
		}
		System.out.println();
		sorter = new MergeSorter(TesterMergeSort.TEST_7);
		for (int e : sorter.mergeSort()) {
			System.out.print(e + " ");
		}
		System.out.println();
		sorter = new MergeSorter(TesterMergeSort.TEST_8);
		for (int e : sorter.mergeSort()) {
			System.out.print(e + " ");
		}
		System.out.println();
		sorter = new MergeSorter(TesterMergeSort.TEST_9);
		for (int e : sorter.mergeSort()) {
			System.out.print(e + " ");
		}
		System.out.println();
		sorter = new MergeSorter(TesterMergeSort.TEST_10);
		for (int e : sorter.mergeSort()) {
			System.out.print(e + " ");
		}
		System.out.println();
		sorter = new MergeSorter(TesterMergeSort.TEST_11);
		for (int e : sorter.mergeSort()) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
}

