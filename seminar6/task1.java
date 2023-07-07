package seminar6;

// Разработать программу, имитирующую поведение коллекции HashSet. 
// В программе содать метод add добавляющий элемент, 
// метод toString возвращающий строку с элементами множества и метод позволяющий читать элементы по индексу.
// *Реализовать все методы из семинара.

import java.util.*;

public class task1 {

    public static void main(String[] Args) {
        SetImitation setImitation = new SetImitation();
        System.out.println(setImitation.add(9));
        System.out.println(setImitation.add(9));
        System.out.println(setImitation.add(2));
        System.out.println(setImitation.size());
        System.out.println(setImitation.delete(9));
        System.out.println(setImitation.delete(9));
        System.out.println(setImitation.size());
        System.out.println(setImitation.isEmpty());
        System.out.println(setImitation.contains(9));
        System.out.println(setImitation.contains(2));
        for (int i = 0; i < 10; i++) {
            setImitation.add(new Random().nextInt(1000));
        }

        System.out.println(setImitation.toString());
        System.out.println(setImitation.getElementByIndex(3));
    }
}

class SetImitation<E> {
    private HashMap<E, Object> map = new HashMap<>();
    private static final Object OBJECT = new Object();

    public boolean add(E num) {
        return map.put(num, OBJECT) == null;
    }

    public boolean delete(E num) {
        return map.remove(num, OBJECT);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object num) {
        return map.containsKey(num);
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    public E getElementByIndex(int index) {
        E[] mapArray = (E[]) map.keySet().toArray();
        return mapArray[index];
    }

    public String toString() {
        String result = "";
        Iterator<E> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            result += iterator.next().toString() + " ";
        }
        return result.strip();
    }
}