package testCode;
import java.util.Arrays;

public class MyArrayList<T>{
    
	private final int SIZE=5;
    private Object[] test = new Object[SIZE];
    private int actualSize=0;

    public boolean add(T data){
        if (actualSize>=test.length/2){
            increaseSize();
        }
        test[actualSize++] = data;
        return true;//when can it be false?
    }

    private void increaseSize()throws RuntimeException{
        test = Arrays.copyOf(test, test.length*2);
    }

    public T get(int index) throws RuntimeException{
        if (index >= actualSize){
            throw new IndexOutOfBoundsException(); 
        }
        return (T) test[index];
    }

    public static void main(String[] args) {
        MyArrayList<String> arList = new MyArrayList<>();
        arList.add("Robert");
        arList.add("Javier");
        arList.add("Bruce");
        arList.add("Vinish");
        arList.add("John");
        System.out.println(arList.get(6));// prints Javier

    }
}
