package academy.mindswap;

import java.util.Iterator;

/**
 * A CLASS THAT REPRESENTS A MUTABLE ARRAY
 */
public class DynamicObjectArray<T> implements Iterable<T> {

    private Object[] objects;
    private int objectsCreated;

    /**
     * BASE ARRAY INITIALIZED WITH DEFAULT SIZE
     */
    public DynamicObjectArray() {
        objects = new Object[2];
        objectsCreated = 0;
    }

    /**
     * ADD METHOD CHECKS IF ARRAY IS FULL.
     * IF IT IS, GROWS IT.
     * IF IT ISN'T, FINDS THE FIRST AVAILABLE INDEX AND STORES THE GIVEN OBJECT IN IT.
     * @param object - THE OBJECT TO ADD
     */
    public void add(T object) {
        if (objectsCreated == objects.length) {
            doubleArraySize();
        }

       objects[objectsCreated] = object; //{1,2,null,null} 2 objects created
        objectsCreated++;
    }

    /**
     * CREATES A NEW, TEMPORARY ARRAY WITH DOUBLE THE SIZE.
     * COPIES THE CONTENTS OF THE ORIGINAL ARRAY INTO THE NEW ONE.
     * SUBSTITUTES THE OBJECT REFERENCED BY THE objects PROPERTY.
     */
    private void doubleArraySize() {
        Object[] temp = new Object[objects.length * 2];

        for (int i = 0; i < objects.length; i++) {
            temp[i] = objects[i];
        }

        objects = temp;
    }

    /**
     * VERIFIES IF THE INDEX SPECIFIED EXISTS, AND IF IT DOES, CHECKS IF THERE'S AN ACTUAL OBJECT STORED IN IT.
     * IF BOTH CONDITIONS ARE VERIFIED, THE OBJECT IN THE SPECIFIED POSITION WILL BE REMOVED
     * FINALLY, IT CHECKS IF HALF THE POSITIONS OF THE ARRAY ARE EMPTY. IF THEY ARE, THE ARRAY SHRINKS IN SIZE.
     * @param index - REPRESENTS THE INDEX WHERE THE OBJECT TO BE DELETED IS
     */
    public void remove(int index) {
        if (isEmpty(index)) {
            return;
        }
       // objects[index] = null;
        objectsCreated--;
        moveLeft(index);

        if (objectsCreated == objects.length / 2) {
            shrinkArray();
        }
    }

    /**
     * MOVE ALL THE OBJECTS AFTER THE INDEX SPECIFIED TO THE LEFT.
     */
    private void moveLeft(int index){
        for (int i = index; i < objects.length - 1; i++){
            if (objects[i+1] == null){
                return;
            }
            objects[i] = objects[i + 1];
        }
    }

    /**
     * CREATES A NEW, TEMPORARY ARRAY, WITH HALF THE SIZE OF THE ORIGINAL ONE.
     * COPIES THE ELEMENTS OF THE ORIGINAL ARRAY INTO THE NEW ONE.
     * SUBSTITUTES THE OBJECT REFERENCED BY THE objects PROPERTY.
     */
    private void shrinkArray() {
        Object[] temp =  new Object[objects.length / 2];

        for (int i = 0; i < temp.length; i++) {
            if (objects[i] == null) {
                break;
            }
            temp[i] = objects[i];
        }

        objects = temp;
    }

    /**
     * @return THE OBJECT IN THE SPECIFIED POSITION.
     */
    public T get(int index) {
        if (isEmpty(index)) {
            return null;
        }
        return (T) objects[index];
    }

    public void set(int index, T object) {
        if (isEmpty(index) || object == null) {
            return;
        }

        objects[index] = object;
    }

    /**
     * @return true IF THE SPECIFIED INDEX IS OUT OF BOUNDS. FALSE OTHERWISE.
     */
    public boolean isEmpty(int index) {
        if (index < 0 || index >= objectsCreated || objects[index] == null) {
            System.out.println("Index out of bounds");
            return true;
        }
        return false;
    }


    /**
     * @return THE SIZE OF THE ARRAY.
     */
    public int size() {
        return objectsCreated;
    }

    /**
     * @return THE LENGTH OF THE BASE ARRAY
     */
    public int getLength(){
        return objects.length;
    }

    /**
     * PRINTS THE ELEMENTS INSIDE THE ARRAY
     */

    public void printElements(){
        for (int i = 0; i < objectsCreated; i++){
            System.out.println(objects[i]);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objectsCreated; i++){
            sb.append(objects[i]).append(",\n");
        }
        return "{\n" + sb.substring(0,sb.length() - 2).concat("\n}");
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return  index < size();
            }

            @Override
            public T next() {
                return get(index++);
            }
        };
    }
}
