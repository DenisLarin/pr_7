import java.util.Arrays;

/**
 * Created by denis__larin on 25.05.17.
 */
public class Perestanovka {
    private int[] numbers;
    private int[] directs;
    private int n;
    private int[] checked = {5,4,6,2,1,3};
    private boolean print = false;

    public Perestanovka(int n) {
        this.n = n;
        numbers = new int[n];
        directs = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i+1;
            directs[i] = -1;
        }
        print();
        start();
    }
    private void start(){
        int breakPoint = 0;
        while (true){
            breakPoint = -1;
            for (int i = 0; i <n ; i++) {
                if(mbil(i) &&((breakPoint==-1)|| (numbers[i]>numbers[breakPoint])))
                    breakPoint = i;
            }
            if(breakPoint == -1)
                break;
            redirect(breakPoint);
            swap(breakPoint);
            print();
        }
    }

    private void swap(int breakPoint) {
        int temp = numbers[breakPoint];
        int temp2 = directs[breakPoint];
        int count = breakPoint+directs[breakPoint];
        numbers[breakPoint] = numbers[count];
        numbers[count] = temp;
        directs[breakPoint] = directs[count];
        directs[count] =temp2;
    }

    private void redirect(int breakPoint) {
        for (int i = 0; i < n; i++) {
            if(numbers[i]>numbers[breakPoint]){
                directs[i] = -directs[i];
            }
        }
    }

    private boolean mbil(int i) {
        int j = i + directs[i];
        if(j>=0&&j<n){
            if(numbers[i]>numbers[j])
                return true;
        }
        return false;
    }

    private void print(){
        if(print) {
            for (Integer i :
                    numbers) {
                System.out.print(i + " ");
            }
            System.out.println();
            print = false;
        }
        if(Arrays.equals(numbers,checked)){
            /*for (Integer i :
                    numbers) {
                System.out.print(i + " ");
            }*/
            System.out.println();
               print = true;
        }
    }
}
