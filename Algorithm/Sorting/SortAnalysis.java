package week6;

import java.util.Arrays;

public class SortAnalysis {

	public static void main(String[] args) {
		int dataSize = 50;
		SortBase sortBase = new SortBase(dataSize);
		int[] original = sortBase.createData();
		sortBase.sort();
		sortBase.showInfo();
		
		// Arrays.sort
//		for (int a : original) System.out.print(a+ "  ");
//		Arrays.sort(original);
//		System.out.println();
//		for (int a : original) System.out.print(a+ "  ");
//		System.out.println();
//		System.out.println(Arrays.binarySearch(original, 200));
		
		int[] myData = new int[dataSize];
		
		// Selection Sort
		copyData(myData, original);
		MySelection mySelection = new MySelection(myData);
		mySelection.sort();
		mySelection.showInfo();
		
		// Bubble Sort
		copyData(myData, original);
		MyBubble myBubble = new MyBubble(myData);
		myBubble.sort();
		myBubble.showInfo();
		
		// Quick Sort
		copyData(myData, original);
		MyQuick myQuick = new MyQuick(myData);
		myQuick.sort();
		myQuick.showInfo();
		
		// Merge Sort
		copyData(myData, original);
		MyMerge myMerge = new MyMerge(myData);
		myMerge.sort();
		myMerge.showInfo();
	}

	private static void copyData(int[] myData, int[] original) {
		for(int i=0; i<original.length; i++)
			myData[i] = original[i];
	}
}
