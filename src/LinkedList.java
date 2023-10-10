

public class LinkedList
{
    public static void main(String[] args) {

        LinkedList myLL = new LinkedList();
        myLL.add(3);
        myLL.add(0);
        myLL.add(-2);

        myLL.print();
        myLL.reverseList();
        myLL.print();


        LinkedList stringLL = new LinkedList();
        stringLL.add("hello");
        stringLL.add("world");
        stringLL.print();
        stringLL.reverseList();
        stringLL.print();

    }

    /*----------------------------------------------------- */
    /* Private Data Members -- LinkedList                   */
    /*----------------------------------------------------- */

    private Link head;
    private Link tail;
    private int length;

    /*----------------------------------------------------- */
    /* Constructor -- LinkedList                            */
    /*----------------------------------------------------- */

    LinkedList()
    {
        head = tail = new Link();
        length = 0;
    }
    public void reverseList() {
        Link last = null;
        Link curr = head.next;
        Link next;

       //error check
        if (length <= 1) {
            return;
        }

        while (curr != null) { //while the potential next element is not empty, continue loop
            next = curr.next; //storing variable value
            curr.next = last; // next points to the last node
            last = curr;
            curr = next;
        }

        head.next = last; //new inserted element becomes head

    }

    /*----------------------------------------------------- */
    /* Public Methods -- LinkedList                         */
    /*----------------------------------------------------- */

    public void clear()
    {
        head.setNext(null);
        tail = head;
        length = 0;
    }

    public int size()
    {
        return length;
    }

    public void add(Object elem)
    {
        tail.setNext(new Link(elem, null));
        tail = tail.next();
        length++;
    }

    public void add(int index, Object elem)
    {
        assert (index >= 0 && index <= length) : "Index not in list";
        Link tmp = head;
        for (int i = 0; i < index; i++)
        {
            tmp = tmp.next;
        }
        tmp.next = new Link(elem, tmp.next);
        length++;
    }

    public void remove(int index)
    {
        assert (index >= 0 && index < length) : "Index not in list";
        Link tmp = head;
        for (int  i = 0; i < index; i++)
        {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        length--;
    }

    public void remove(Object elem)
    {
        Link tmp = head;
        while (tmp.next != null && !tmp.next.element.equals(elem))
        {
            tmp = tmp.next;
        }
        if (tmp.next != null)
        {
            tmp.next = tmp.next.next;
            length--;
        }

    }

    public Object get(int index)
    {
        assert (index >= 0 && index < length) : "Index not in list";
        Link tmp = head.next;
        for (int i = 0; i < index; i++)
        {
            tmp = tmp.next;
        }
        return tmp.element;
    }


    public void print()
    {
        Link curLink = head;
        while (curLink.next != null){
            curLink = curLink.next;
            System.out.print(curLink.element + " ");
        }
        System.out.print("\n");
    }


    /*----------------------------------------------------- */
    /* Nested class -- Link                                 */
    /*----------------------------------------------------- */


    private class Link {

        /*----------------------------------------------------- */
        /*  Private Data Members -- Link                        */
        /*----------------------------------------------------- */

        private Object element;
        private Link next;

        /*----------------------------------------------------- */
        /*  Constructors -- Link                                */
        /*----------------------------------------------------- */

        Link(Object elem, Link nextelem) {
            element = elem;
            next = nextelem;
        }

        Link(Object elem) {
            element = elem;
        }

        Link() { }

        /*----------------------------------------------------- */
        /*  Access Methods -- Link                              */
        /*----------------------------------------------------- */

        Link next() {
            return next;
        }

        Object element() {
            return element;
        }

        void setNext(Link nextelem) {
            next = nextelem;
        }

        void setElement(Object elem) {
            element = elem;
        }
    }

}