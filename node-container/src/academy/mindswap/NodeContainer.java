package academy.mindswap;


public class NodeContainer {
    private Node head;
    private int length;

    public NodeContainer() {
        this.head = new Node(null);
        length = 0;
    }

    public int size(){
        return length;
    }

    public void add(Object data){
        Node node = this.head.next;
        if (node == null) {
            this.head.next = new Node(data);
            length++;
        }else{
            while (node.next != null){
                node = node.next;
            }
            node.next = new Node(data);
            length++;
        }
    }

    public int indexOf(Object data){
        Node node = head.next;
        int counter = 0;

        if (data.equals(head.next.data)){
            return counter;
        }else{
            while(node.next!=null) {
                if (data.equals(node.next.data)) {
                    return ++counter;
                }
                node = node.next;
                counter++;
            }
        }
        return -1;
    }

    public Object get(int index){
        if(index<0 || index>=length){
            return null;
        }

        int counter = 0;
        Node node = head.next;

        while (counter != index){
            counter++;
            node = node.next;
        }

        return node.data;
    }

    public void removeLast(){
        Node node = head.next;

        if (head.next == null){
            return;
        }

        if (node.next==null){
            head.next = null;
        }

        for (int i = 0; i < length-2; i++) {
            node = node.next;
        }

        length--;
        node.next=null;
    }

    public boolean remove(Object data){
        Node node = head.next;

        if (head.next == null){
            return false;
        }

        if(!(data.equals(head.next.data))) {
            while (node.next != null) {
                node = node.next;
                if (data.equals(node.data)) {
                    break;
                }
            }
        }

        if (!data.equals(node.data)){
            return false;
        }

        if (indexOf(node.data) == length-1) {
            removeLast();
            return true;
        }

        length--;

        node.data = null;
        node = head.next;

        if (length== 0) {
            head.next = null;
            return true;
        }

        while(node.data!=null){
            node = node.next;
        }
        node.data = node.next.data;
        node.next = node.next.next;

        return true;
    }

    public void printContainer(){
        Node node = head.next;

        if (head.next == null){
            return;
        }

        System.out.println(head.next.data);

        for (int i = 0; i < length-1; i++) {
            node = node.next;
            System.out.println(node.data);
        }
    }

    public void replace(Object data, Object newData) {
        Node node = head.next;

        if (head.next == null) {
            System.out.println("Container is empty.");
            return;
        }

        if (data.equals(head.next.data)) {
            head.next.data = newData;
            return;
        } else {
            while (node.next != null) {
                if (data.equals(node.next.data)) {
                    node.next.data = newData;
                    return;
                } else {
                    node = node.next;
                }
            }
            System.out.println("Data not found.");
        }
    }

    public void replaceAll(Object data, Object newData) {
        Node node = head.next;

        if (head.next == null) {
            System.out.println("Container is empty.");
            return;
        }

        if (data.equals(head.next.data)) {
            head.next.data = newData;
            replaceAll(data, newData);
            return;
        }
        while (node.next != null) {
            if (data.equals(node.next.data)) {
                node.next.data = newData;
                replaceAll(data, newData);
                return;
            } else {
                node = node.next;
            }
        }
    }

    public int counter(Object data){
        Node node = head.next;
        if (head.next == null){
            return -1;
        }

        int counter = 0;

        if (data.equals(head.next.data)) {
            counter++;
        }
        while(node.next!=null) {
            if (data.equals(node.next.data)) {
                ++counter;
            }
            node = node.next;
        }
        return counter;
    }

    public void reset(){
        head.next=null;
    }


    private class Node{
       private Object data;
       private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

    }
}
