package com.santosh.sorting;


public class HeapSortAlgo
{
 public void sort(int A[])
 {
     int n = A.length;

     for (int i = n / 2 - 1; i >= 0; i--)
    	 heapifyArray(A, n, i);

     print(A);

     for (int i=n-1; i>=0; i--)
     {

         int temp = A[0];
         A[0] = A[i];
         A[i] = temp;


         heapifyArray(A, i, 0);
     }
 }

 void heapifyArray(int A[], int n, int i)
 {
     int largest = i;  
     int l = 2*i + 1;  
     int r = 2*i + 2;  
 
     
     

     if (l < n && A[l] > A[largest])
         largest = l;

     if (r < n && A[r] > A[largest])
         largest = r;


     if (largest != i)
     {
         int swap = A[i];
         A[i] = A[largest];
         A[largest] = swap;


         heapifyArray(A, n, largest);
     }
 }


 static void print(int A[])
 {
     int n = A.length;
     for (int i=0; i<n; ++i)
         System.out.print(A[i]+" ");
     System.out.println();
 }


 public static void main(String args[])
 {
     int A[] = {11, 19, 10, 15, 2, 11, 9};
     int n = A.length;

     HeapSortAlgo ob = new HeapSortAlgo();
     ob.sort(A);

     System.out.println("Output of Sorted array");
     print(A);
 }
}