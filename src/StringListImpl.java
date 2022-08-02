import exception.NoSachString;
import exception.OutOfSize;
import exception.ParametrIsNull;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private int lenght;
    private String[] array;
    private int arraySize;


    public StringListImpl() {
        this.lenght = 10;
        this.array = new String[lenght];
        this.arraySize = 0;
    }

    private void checkArrayLengght(){
        if(array[lenght - 1] != null){
            lenght += 10;
            String[] newArray = new String[lenght];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }


    private void checkParametr(int index){
         if(index > size()){
             throw new OutOfSize("The index is larger than the actual size of the array");
         }
         if(index < 0){
             throw new OutOfSize("The index less than zero");
         }
    }

    private void checkParametr(String string) {
        if (string == null) {
            throw new ParametrIsNull("The resulting string parameter is null");
        }
    }

    @Override
    public String add(String item) {
        checkParametr(item);
        checkArrayLengght();
        array[size()] = item;
        System.out.println(Arrays.toString(array));
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkParametr(item);
        checkParametr(index);
        checkArrayLengght();
        String[] newArray = new String[lenght];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = item;
        System.arraycopy(array, index, newArray, index + 1, size() - index);
        array = newArray;
        System.out.println(Arrays.toString(array));
        return array[index];
    }

    @Override
    public String set(int index, String item) {
        checkParametr(item);
        checkParametr(index + 1);
        array[index] = item;
        System.out.println(Arrays.toString(array));
        return array[index];
    }

    @Override
    public String remove(String item) {
        checkParametr(item);
        if(indexOf(item) == -1) {
            throw new NoSachString("Such a string was not found in the array");
        } else {
            this.remove(indexOf(item));
            return item;
        }
    }

    @Override
    public String remove(int index) {
        checkParametr(index + 1);
        String removingItem = array[index];
        String[] newArray = new String[lenght];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size() - index);
        array = newArray;
        System.out.println(Arrays.toString(array));
        return removingItem;
    }

    @Override
    public boolean contains(String item) {
        checkParametr(item);
        return indexOf(item) != -1;

    }

    @Override
    public int indexOf(String item) {
        checkParametr(item);
        for (int i = 0; i < size(); i++) {
            if(Objects.equals(array[i], item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkParametr(item);
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if(Objects.equals(array[i], item)){
                index = i;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        checkParametr(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(this.size() != otherList.size()){
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if(!Objects.equals(this.get(i), otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size(){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                arraySize = i;
                break;
            }
        }
        return arraySize;
    }

    @Override
    public boolean isEmpty() {
        return array[0] == null;
    }

    @Override
    public void clear() {
        this.lenght = 10;
        this.array = new String[lenght];
        this.arraySize = 0;
        System.out.println(Arrays.toString(array));
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[this.size()];
        for (int i = 0; i < this.size(); i++) {
            newArray[i] = this.get(i);
        }
        return newArray;
    }
}
