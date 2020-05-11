
import java.util.NoSuchElementException;

public class MyLinkedList<E extends Comparable<E>> {
    int size = 0;

    /**
     * Pointer to fisrt node.
     */
    Node<E> first;

    /**
     * Constructs an empty list.
     */
    public MyLinkedList(){

    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws java.util.NoSuchElementException if this list is empty
     */

    public E removeFirst(){
        Node<E> f = first;
        if (f==null)
            throw new NoSuchElementException();
        else{
            first = f.next;
            size--;
            return f.item;
        }
    }

    /**
     * Removes and returns the last element from this list
     *
     * @return the last element from this list
     * @throws java.util.NoSuchElementException if this list is empty
     */

    public E removeLast(){
        Node<E> f = first;
        if(f==null)
            throw new NoSuchElementException();
        else{
            if(f.next==null){
                return removeFirst();
                //first = null; size--; return f.item;
            }
            while(f.next.next != null)
                f=f.next;
            E element= f.next.item;
            size--;
            f.next = null;
            return element;
        }
    }

    public boolean remove(E e){
        Node<E> f1 = first;
        if(f1==null)
            return false;
        if(e.equals(f1.item)){
            removeFirst();
            return true;
        }

        Node<E> f2 = f1.next;
        while(f2!=null){
            if(e.equals(f2.item)){
                f1.next = f2.next;
                size--;
                return true;
            } else{
                f1 = f1.next;
                f2 = f2.next;
            }
        }

        return false;
    }

    public void addFirst(E e){
        Node<E> newNode = new Node<>(e, first);
        first = newNode;
        size++;
    }

    public void addLast(E e){
        Node<E> f = first;
        if(f==null)
            addFirst(e);
        else{
            while(f.next!=null)
                f = f.next;
            Node<E> newNode = new Node<>(e, null);
            f.next = newNode;
            size++;
        }
    }

    public boolean add(E e){
        addLast(e);
        return true;
    }

    public boolean contains(E e){
        return (indexOf(e) >= 0);
    }

    public int size(){
        return size;
    }

    public E get(int index){
        checkElementIndex(index);
        return node(index).item;
    }

    private void checkElementIndex(int index){
        if(index>=0 && index<size)
            return;
        else
            throw new IndexOutOfBoundsException();
    }
    public E set(int index, E element){
        checkElementIndex(index);
        Node<E> f = node(index);
        E oldVal = f.item;
        f.item = element;
        return oldVal;
    }

    public void add(int index, E element){
        checkPositionIndex(index);
        if(index==1)
            addFirst(element);
        else
            addAfter(element, node(index-1));
    }

    private void addAfter(E element, Node<E> node){
        Node<E> next = node.next;
        node.next = new Node<>(element, next);
        size++;
    }

    private void checkPositionIndex(int index){
        if(index>0 && index<=size)
            return;
        else
            throw new IndexOutOfBoundsException();
    }

    public E remove(int index){
        checkElementIndex(index);
        if(index==0)
            return removeFirst();
        else
            return removeAfter(node(index-1));
    }

    private E removeAfter(Node<E> node){
        E element = node.next.item;
        node.next = node.next.next;
        size--;
        return element;
    }

    /**
     * Sorts this list.
     */

    Node<E> node(int index){
        checkElementIndex(index);
        if(index==0)
            return first;
        else{
            Node<E> f = first;
            for(int i=1; i<=index; i++)
                f = f.next;
            return f;
        }
    }

    public int indexOf(E e){
        int index = 0;
        for(Node<E> x = first; x!=null; x=x.next){
            if(e.equals(x.item))
                return index;
            index++;
        }
        return -1;
    }

    public void sort(){
        if(size<=1)
            return;
        E temp = null;
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                if(get(i).compareTo(get(j))<0){
                    temp = get(i);
                    set(i,get(j));
                    set(j, temp);
                }
            }
        }
    }

    private class Node<E>{
        E item;
        Node<E> next;

        Node(E element, Node<E> next){
            this.item = element;
            this.next = next;
        }
    }
}
