import java.util.Arrays;

public class IntegerListImpl {
    private int size;
    private int[] storage;

    public IntegerListImpl() {
        storage = new int[100000];
    }

    public IntegerListImpl(int initSize) {

        storage = new int[initSize];
    }


    public Integer add(int item) {
        validatorSize();
        validatorItem(item);
        storage[size++] = item;
        return item;
    }

    public Integer add(int index, int item) {
        validatorSize();
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

    public boolean contains(int item) {
        int min = 0;
        int max = size;
        while (min < max) {
            int mid = (min + max) / 2;
            if (item == storage[mid]){
                return  true;
            }
            if (item < storage[mid]){
                max = mid - 1;}
                else{
                    min = mid + 1;
                }
            }
        return false;
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

    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
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

    public int[] toArray() {
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

    private void validatorSize() {
        if (size == storage.length) {
            throw new FullStorageException();
        }
    }

    private void validatorIndex(int index) {
        if (index < 0 || index > size) {
            throw new NotFoundExceprion();
        }
    }

    public int[] sortInsertion() {
        for (int i = 1; i < size; i++) {
            int temp = storage[i];
            int j = i;
            while (j > 0 && storage[j - 1] >= temp) {
                storage[j] = storage[j - 1];
                j--;
            }
        }
        return Arrays.copyOf(storage, size);
    }


}
