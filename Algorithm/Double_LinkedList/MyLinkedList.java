
import java.util.NoSuchElementException;

public class MyLinkedList<E extends Comparable<E>> {
    int size = 0;

    /**
     * Pointer to fisrt node.
     */
    Node<E> first; // head
    Node<E> last; // tail

    /**
     * Constructs an empty list.
     */
    public MyLinkedList(){

    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */

    public E removeFirst(){
        Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        else{
            first = f.next;
            size--;
            if(first == null){
                last = null;
            } else {
                first.prev = null;
            }
            return f.item;
        }
    }

    /**
     * Removes and returns the last element from this list
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */

    public E removeLast(){
        Node<E> l = last;
        if(l==null)
            throw new NoSuchElementException();
        else{
            last = l.prev;
            size--;

            if(last == null){
                first = null;
            } else {
                last.next = null;
            }
            return l.item;
        }
    }

    public boolean remove(E e){
        Node<E> f = first;

        while(f!=null){
            if(e.equals(f.item)) {
                if (f.prev == null){
                    removeFirst();
                    return true;
                } else if (f.next == null) {
                    removeLast();
                    return true;
                } else {
                    f.prev.next = f.next;
                    f.next.prev = f.prev;
                    size--;
                    return true;
                }
            } else {
                f = f.next;
            }
        }

        return false;
    }

    public void addFirst(E e){
        Node<E> newNode = new Node<>(null, e, first);
        first = newNode;
        size++;
        if(newNode.next == null){
            last = newNode;
        } else {
            newNode.next.prev = newNode;
        }
    }

    public void addLast(E e){
        Node<E> newNode = new Node<>(last, e, null);
        last = newNode;
        size++;
        if(newNode.prev == null){
            first = newNode;
        } else {
            newNode.prev.next = newNode;
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
        Node<E> newNode = new Node<>(node, element, node.next);
        node.next = newNode;
        size++;
        if(newNode.next == null){
            last = newNode;
        } else {
            newNode.next.prev = newNode;
        }
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
        else if(index == size-1)
            return removeLast();
        else {

        }
        Node<E> temp = node(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;

        return temp.item;
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
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next){
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }
}
