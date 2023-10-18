package org.example;

import java.util.Objects;

public class MyClass implements Comparable<MyClass>{
    private int id;
    private String test;

    public MyClass(int id, String test) {
        this.id = id;
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return id == myClass.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(MyClass o) {
        if (id> o.getId())
            return 1;
        else if (id< o.getId()) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getId() {
        return id;
    }

}
