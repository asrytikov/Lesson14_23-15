package org.example;

/*
Д/з Расширим предыдущую задачу.
Замерить время добавления, поиска и удаления объектов из коллекции в LinkedList, ArrayList, TreeSet, HashSet.
Сравнить время и сделать вывод о том, в каких условиях какая коллекция работает быстрее.
 */

import java.util.*;

public class Main {

    public static final int SIZE = 500000;

    public static void main(String[] args) {

        List<MyClass> arrList = new ArrayList<>();
        List<MyClass> linkList = new LinkedList<>();
        TreeSet<MyClass> treeSet = new TreeSet<>();
        HashSet<MyClass> hashSet = new HashSet<>();
        System.out.println(addElements(arrList));
        System.out.println(addElements(linkList));
        System.out.println(addElements(treeSet));
        System.out.println(addElements(hashSet));
        /*System.out.println("----------------------");
        System.out.println(removeElement(arrList));
        System.out.println(removeElement(linkList));
        System.out.println(removeElement(treeSet));
        System.out.println(removeElement(hashSet));*/
        System.out.println("--------------------------");
        MyClass myClass = new MyClass((int)(Math.random()*SIZE), new String());
        System.out.println(findElement(arrList, myClass));
        System.out.println(findElement(linkList, myClass));
        System.out.println(findElement(treeSet, myClass));
        System.out.println(findElement(hashSet, myClass));




        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        if (scanner.hasNextLine()){
            System.out.printf("Вы ввели какую-то дичь!");

        }else{
            String str = scanner.nextLine();
            System.out.println(str);
        }



    }

    public static long addElements(Collection collection){
        long result = 0;
        long startTime = System.currentTimeMillis();
          generateCollection(collection);
        result = System.currentTimeMillis() - startTime;
        return result;
    }

    public static long removeElement(Collection collection){
        long startTime = System.currentTimeMillis();
        while (collection.iterator().hasNext()){
            collection.remove(collection.iterator().next());
        }
        return System.currentTimeMillis() - startTime;
    }

    public static Collection generateCollection(Collection collection){
        for(int i =0; i<SIZE; i++){
            collection.add(new MyClass(i, new String()));
        }
        System.out.println("Size:" + collection.size());
        return collection;
    }

    public static long findElement(Collection collection, MyClass myClass){
        long startTime = System.currentTimeMillis();
        Iterator<MyClass> iterator = collection.iterator();
        int i = 0;
        while (iterator.hasNext()){
            if (iterator.next().equals(myClass)){
                System.out.println("Find " + myClass.getId());
                break;
            }
        }
        /*for (Object item : collection){
            if (item.equals(myClass)){
                System.out.println("Find " + myClass.getId());
                break;
            }
        }*/
        return System.currentTimeMillis() - startTime;
    }
}