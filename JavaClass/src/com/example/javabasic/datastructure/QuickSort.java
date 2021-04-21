package com.example.javabasic.datastructure;

public class QuickSort {

	
	public static int partition(int[] listToSort,int low, int high) {
		int pivot = listToSort[low];
		int partLow = low;
		int partHigh = high;
//		System.out.println("Pivot1 "+pivot+ " partLow1 "+ partLow +" partHigh1 " + partHigh);
		while(partLow < partHigh) {
			while(listToSort[partLow] <= pivot && partLow < partHigh) {
				partLow++;
			}
			while(listToSort[partHigh] > pivot) {
				partHigh--;
			}
			if(partLow < partHigh) {
				swap(listToSort,partLow,partHigh);
			}
		}
		swap(listToSort,low,partHigh);
		
//		System.out.println("Pivot "+pivot+ " partLow "+ partLow +" partHigh " + partHigh);
		MergeSort.print(listToSort);
		return partHigh;
	}
	
	
	public static void swap(int[] listToSort,int low, int high) {
		
		int temp = listToSort[high];
		listToSort[high] = listToSort[low];
		listToSort[low] = temp;
	}
	public static void quickSort(int[] listToSort,int low,int high) {
		if(low >= high) {
			return;
		}
		int pivotIndex = partition(listToSort, low, high);
		System.out.println("PivotIndex "+pivotIndex + " " +low +" "+ high);
		quickSort(listToSort, low, pivotIndex-1);
		System.out.println("1st Low "+ low+ "High "+ (pivotIndex-1));
		quickSort(listToSort, pivotIndex+1, high);
		System.out.println("2nd Low "+ (pivotIndex+1)+"High "+ high);
	}
	

	public static void main(String args[]) {
		int[] listToSort = {90,23,101,45,65,23,67,89,34,23};
//			{2,1,7,8,6,4,10,3,5,9};
		int low = 0;
		int high = listToSort.length-1;
		quickSort(listToSort, low, high);
	}
}
