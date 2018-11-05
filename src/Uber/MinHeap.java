package Uber;

public class MinHeap {
    private int capacity;//initial size
    public int[] arr;
    private int size;

    public MinHeap(int initialsize){
        this.capacity = initialsize;
        arr = new int[capacity];
        this.size = 0;
    }

    private void swap(int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    private int getParent(int idx){
        return (idx-1)/2;
    }

    private int getLeftChild(int idx){
        return 2*idx+1;
    }

    private int getRightChild(int idx){
        return 2*idx+2;
    }

    private void shiftUp(int idx){
        while(idx>0 && arr[getParent(idx)]>arr[idx]){
            swap(idx, getParent(idx));
            idx = getParent(idx);
        }
    }

    private void shiftDown(int idx){
        while(getLeftChild(idx)<size){
            int minChild = idx;
            if(arr[getLeftChild(idx)]<arr[idx]){
                minChild = getLeftChild(idx);
            }
            if(getRightChild(idx)<size && arr[getRightChild(idx)]<arr[minChild]){
                minChild = getRightChild(idx);
            }
            if(minChild!=idx) {
                swap(idx, minChild);
                idx = minChild;
            } else {
                break;
            }
        }
    }

    public boolean offer(int val){
        if(size==capacity) return false; // can replace with changing size;
        size ++;
        arr[size-1] = val;
        shiftUp(size-1);
        return true;
    }

    public int poll(){
        int res = arr[0];
        arr[0] = arr[size-1];
        size--;
        shiftDown(0);
        return res;
    }
}
