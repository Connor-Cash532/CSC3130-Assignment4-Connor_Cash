import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;


public class P3{
    public static void main(String[] args){
        Random rnd = new Random();
        Deque<Integer> d = new ArrayDeque<>();
        for(int i = 0; i < 10; i++){
            d.add(rnd.nextInt(7));
        }
        findInDeque<Integer> i1 = new findInDeque<>();
        findInDeque<String> f1 = new findInDeque<>();
        System.out.println(d);
        System.out.println(i1.findEInDeque(6,d));
        String c = "";
        Deque<String> s = new ArrayDeque<>();
        for(int i = 75; i < 90; i++){
            c += Character.toString(i);
            s.add(c);
        }
        System.out.println(s);
        System.out.println(f1.findEInDeque("KLMN", s));

    }

    public static int findInDeque(Integer y, Deque<Integer> c){
        if(c.isEmpty())
            return -1;
        int size = c.size()/2;
        for(int i = 0; i < size; i++){
            if(c.peekFirst().equals(y)){
                return i;
            }
            if(c.peekLast().equals(y))
                return ((size*2)-i)-1;
            c.removeFirst();
            c.removeLast();
        }

        return -1;
    }

}

class findInDeque<T>{
    public int findEInDeque(T y, Deque<T> c){
        if(c.isEmpty())
            return -1;
        int size = c.size()/2;
        for(int i = 0; i < size; i++){
            if(c.peekFirst().equals(y)){
                return i;
            }
            if(c.peekLast().equals(y))
                return ((size*2)-i)-1;
            c.removeFirst();
            c.removeLast();
        }

        return -1;
    }
}
