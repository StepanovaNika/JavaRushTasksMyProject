package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;

        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution cloneSolution = new Solution();
        for (Map.Entry<String,User> cloneUser : users.entrySet())
        {
            cloneSolution.users.put(cloneUser.getKey(), cloneUser.getValue().clone());
        }
        return cloneSolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return users != null ? users.equals(solution.users) : solution.users == null ;
    }

    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{

        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        protected User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;

            User user = (User) o;

            if (age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}
