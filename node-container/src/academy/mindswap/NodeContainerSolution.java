package academy.mindswap;

import java.util.Iterator;

public class NodeContainerSolution <T> implements Iterable<T>{

    private Node head;
    private int length;

    public NodeContainerSolution() {
        head = new Node(null);
        length = 0;
    }

    public int size() {
        return length;
    }

    public void add(T data) {

        Node node = new Node(data);
        Node i = head;

            for (T o:this) {
                i = i.getNext();
            }

        i.setNext(node);
        length++;
    }

    public int indexOf(T data) {

        int index = 0;
        Node i = head;

        if (head.getNext() == null){
            return -1;
        }

        for (T o:this) {
            i = i.getNext();
            if (i.getData().equals(data)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    public T get(int index) {

        if(index >= length || index < 0){
            return null;
        }

        Node i = head.getNext();
        int counter = 0;

        if (head.getNext() == null){
            return null;
        }

        while (counter < index){
            i = i.getNext();
            counter++;
        }

        return i.getData();

    }

     public boolean remove(T data) {

        Node previous = head;
        Node i = head.getNext();

       if (head.getNext() == null){
           return  false;
       }

       int counter =0;

        Iterator it = iterator();
        for (T o:this) {
            if (data.equals(it.next())){
                previous.setNext(i.getNext());
                length--;
                return true;
            }
            previous = i;
            i = i.getNext();
        }
        return false;
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

    private class Node {

        private Node next;
        private T data;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
