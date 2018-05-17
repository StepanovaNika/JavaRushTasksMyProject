package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E>{
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet(){
        map = new HashMap<>();
    }
    public AmigoSet(Collection<? extends E> collection){
        map = new HashMap<E, Object>(Math.max((int)Math.ceil(collection.size() / 0.75F), 16));
        this.addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return null == map.put(e,PRESENT);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }


    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Object clone() throws InternalError{
        AmigoSet amigoSet;
        try {
            amigoSet = (AmigoSet) super.clone();
            amigoSet.map = (HashMap) map.clone();
        } catch (Exception e) {
            throw new InternalError();
        }
        return amigoSet;
    }
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();

        oos.writeObject(map.size());
        for (E e: map.keySet()){
            oos.writeObject(e);
        }
        oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));


    }
    private void readObject (ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        int size = (int) ois.readObject();
        Set<E> set = new HashSet<>();
        for (int i = 0; i < size; i++){
            set.add((E) ois.readObject());
        }

        int capacity = (int) ois.readObject();
        float loadFactor = (float) ois.readObject();
        map = new HashMap<>(capacity,loadFactor);
        for (E e: set){
            map.put(e, PRESENT);
        }


    }
}
