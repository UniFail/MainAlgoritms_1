import java.util.Arrays;

public class IntegerListImpl {
    private int size;
    private Integer[] storage;

    public IntegerListImpl() {
        storage = new Integer[100000];
    }

    public IntegerListImpl(int initSize) {

        storage = new Integer[initSize];
    }


    public Integer add(int item) {
        growNeeded();
        validatorItem(item);
        storage[size++] = item;
        return item;
    }

    public Integer add(int index, int item) {
        growNeeded();
        validatorItem(item);
        validatorIndex(index);
        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;

        return item;
    }

    public Integer set(int index, int item) {
        validatorIndex(index);
        validatorItem(item);
        storage[index] = item;
        return item;
    }

    public int remove(int item) {
        validatorItem(item);
        int index = indexOf(item);
        return removeTwo(index);
    }

    public int removeTwo(int index) {
        validatorIndex(index);
        Integer item = storage[index];
        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    public boolean contains(Integer item) {
        Integer[] storageCopy = toArray();
        sortInsertion(storageCopy);
        return binarySearch(storageCopy,item);
    }

    public Integer indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (storage[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public Integer lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index) {
        validatorIndex(index);
        return storage[index];
    }



    public Integer size() {
        return 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    public void getAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(storage[i]);
        }
    }

    private void validatorItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void growNeeded() {
        if (size == storage.length) {
            grow();
        }
    }

    private void validatorIndex(int index) {
        if (index < 0 || index > size) {
            throw new NotFoundExceprion();
        }
    }

    private void sortInsertion(Integer[] arr) {
        quickSort(arr,0,arr.length);
    }

    private void quickSort(Integer [] arr, int begin, int end){
       if (begin < end){
           int partitonIndex = partition(arr,begin,end);
           quickSort(arr,begin,partitonIndex);
           quickSort(arr,partitonIndex + 1,end);

       }
    }
    private int partition(Integer [] arr, int begin, int end){
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private boolean binarySearch(Integer[] arr, Integer item){
        int min = 0;
        int max = arr.length - 1;

        while (min < max){
            int mid = (min + max)/2;
            if (item.equals(arr[mid])){
                return true;
            }
            if (item < arr[mid]){
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow(){
        storage = Arrays.copyOf(storage, size + size / 2);
    }


}
