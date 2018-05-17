package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {

    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null) return false;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return Objects.equals(first, n.first) && Objects.equals(last, n.last);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = first != null ? first.hashCode() : 0;
        result = prime * result + (last != null ? last.hashCode() : 0);
        return result;
    }
    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
