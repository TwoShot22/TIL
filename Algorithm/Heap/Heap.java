package week14;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Character> heap = new ArrayList<>();

    public Heap(){
        heap.add(null);
    }

    public boolean isEmpty(){
        if(sizeOf() == 0)
            return true;
        else
            return false;
    }

    public int sizeOf(){
        return heap.size() -1;
    }

    public ArrayList<Character> insertHeap(char x){
        int k = heap.size();
        heap.add(k, x);

        int parentIndex = (int) k / 2;
        while(parentIndex > 0){
            if(x < heap.get(parentIndex))
                return heap;
            else{
                heap.set(k, heap.get(parentIndex));
                heap.set(parentIndex, x);
                k = parentIndex;
                parentIndex = (int) k / 2;
            }
        }

        return heap;
    }

    public Character deleteHeap(){
        if(heap.size() == 1)
            return null;
        char returnVal = heap.get(1);

        if(heap.size() == 2)
            heap.remove(1);
        else{
            heap.set(1, heap.remove(heap.size() -1));
            makeHeap(1);
        }

        return returnVal;
    }

    private void makeHeap(int i){
        if(2*i >= heap.size() || (2*i + 1) >= heap.size())
            return;

        int k = 2*i;
        if(k+1 < heap.size() && heap.get(k+1) > heap.get(k))
            k++;

        if(heap.get(k) > heap.get(i)){
            char temp = heap.get(k);
            heap.set(k, heap.get(i));
            heap.set(i, temp);
            makeHeap(k);
        } else
            return;
    }

    public void showHeap(){
        System.out.println(heap);
    }

    public static void main(String[] args) {
        Heap mh = new Heap();

        mh.insertHeap('M');
        mh.insertHeap('Y');
        mh.insertHeap('O');
        mh.insertHeap('N');
        mh.insertHeap('G');
        mh.insertHeap('J');
        mh.insertHeap('I');

        mh.showHeap();

        while(!mh.isEmpty()){
            System.out.println(mh.deleteHeap());
        }
    }
}
