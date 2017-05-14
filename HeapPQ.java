/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heappq;
import java.util.*;
/**
 *
 * @author rubynam
 */
public class HeapPQ <T extends Comparable <T>>{

    /**
     * @param args the command line arguments
     */
    private static final int CAPACITY =2;
    
    private int size;
    
    private T[] heap;
    
    public HeapPQ(){
        size = 0;
        heap =(T[]) new Comparable[CAPACITY];
        
    }
    public HeapPQ(T[] array){
        size= array.length;
        heap = (T[]) new Comparable[array.length+1];
        
        System.arraycopy(array, 0, heap, 1, array.length);
        
        buildHeapPQ();
    }
    public void buildHeapPQ(){
        for(int k =size/2;k>0;k--){
            percolatingDown(k);
        }
    }
    private void percolatingDown(int k){
        T tmp =heap[k];
        int child;
        
        for(;2*k<=size;k=child){
            child =2*k;
            if(child !=size && heap[child].compareTo(heap[child+1])>0)
                child++;
            if(tmp.compareTo(heap[child])>0)
                heap[k] = heap[child];
            else break;
        }
        heap[k]=tmp;
    }
    public void heapSort(T[] array){
        size = array.length;
        heap =(T[]) new Comparable[array.length+1];
        System.arraycopy(array, 0, heap, 1, size);
        buildHeapPQ();
        
        for(int i=size;i>0;i--){
            T tmp = heap[i];
            heap[i] =heap[1];
            size--;
            percolatingDown(1);
        }
        for(int k=0;k<size-1;k++){
            array[k] = heap[heap.length-1-k];
        }
    }
    public T deleteMin()throws RuntimeException{
        if(size==0)
            throw new RuntimeException();
        T min = heap[1];
        heap[1] = heap[size--];
        percolatingDown(1);
        return min;
    }
    
    public void insert(T x){
        if(size==heap.length-1)
            doubleSize();
        int pos =++size;
        for(;pos>1 && x.compareTo(heap[pos/2])<0;pos=pos/2){
            heap[pos] = heap[pos/2];
        }
        heap[pos]=x;
    }
    
	private void doubleSize() {
		T[] old = heap;
		heap = (T[]) new Comparable[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}
    public String toString(){
        String out = "";
		for (int k = 1; k <= size; k++)
			out += heap[k] + " ";
		return out;
    }
    public static void main(String[] args) {
		HeapPQ<String> h = new HeapPQ<String>();
		//note a single Random object is reused here
   	Random randomGenerator = new Random();
   	for (int idx = 1; idx <= 10; ++idx){
     		int xxx = 97 + randomGenerator.nextInt(25);
     		char cxxx = (char) xxx;
     		h.insert(Character.toString(cxxx));
     	}
		System.out.println(h);
		h.deleteMin();
		System.out.println(h);

		HeapPQ<Integer> tmp = new HeapPQ<Integer>();
		Integer[] a = new Integer[10];
		
   	for (int idx = 1; idx <= 10; ++idx){
     		a[idx-1] = randomGenerator.nextInt(100);
     	}
		tmp.heapSort(a);
		System.out.println(Arrays.toString(a));
	}
    
}
