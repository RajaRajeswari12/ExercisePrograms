package com.example.javabasic.datastructure;

public class MergeSort {

	

	public static void split(int[] listToSort,int[] firstHalfList,int[] secondHalfList) {
		int index = 0;
		int secondHalfStartIndex = firstHalfList.length;
		for(int element:listToSort) {
			if(index < secondHalfStartIndex) {
				firstHalfList[index] = listToSort[index];
			}else {
				secondHalfList[index-secondHalfStartIndex] =  listToSort[index];
			}
			index++;
		}
	}

	public static void merge(int[] listToSort,int[] firstHalfList,int[] secondHalfList) {
		int mergeIndex=0;
		int firstHalfIndex = 0;
		int secondHalfIndex = 0;

		while((firstHalfIndex < firstHalfList.length)  && (secondHalfIndex < secondHalfList.length)) {
			if(firstHalfList[firstHalfIndex] < secondHalfList[secondHalfIndex]) {

				listToSort[mergeIndex] = firstHalfList[firstHalfIndex];
				firstHalfIndex++;
			}else if(secondHalfIndex < secondHalfList.length) {
				listToSort[mergeIndex] = secondHalfList[secondHalfIndex];
				secondHalfIndex++;
			}
			mergeIndex++;
		}


		if(firstHalfIndex < firstHalfList.length) {
			while(mergeIndex < listToSort.length) {
				listToSort[mergeIndex++] = firstHalfList[firstHalfIndex++];
			}
		}
		if(secondHalfIndex < secondHalfList.length) {
			while(mergeIndex < listToSort.length) {
				listToSort[mergeIndex++] = secondHalfList[secondHalfIndex++];
			}
		}
	}


	public static void mergeSort(int[] listToSort) {
		if(listToSort.length == 1) {
			return;
		}		
		
		int midIndex = listToSort.length/2 + listToSort.length % 2;
		int[] firstHalfList = new int[midIndex];
		int[] secondHalfList = new int[listToSort.length - midIndex];
		split(listToSort, firstHalfList,secondHalfList);
		mergeSort(firstHalfList);
		mergeSort(secondHalfList);
		merge(listToSort, firstHalfList, secondHalfList);
		System.out.println("\t After Sorting ");
		print(listToSort);

	}

	static void print(int[] listToSort) {
		for(int element:listToSort) {
			System.out.print(" "+element);
		}
		System.out.println("\n");
	}

	public static void main(String args[]) {
		int[] listToSort = {2,1,7,8,6,4,10,3,5,9};

		MergeSort.mergeSort(listToSort);
	}
}
