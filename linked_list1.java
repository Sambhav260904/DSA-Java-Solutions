public class linked_list1 {
    class node
    {
        String data;
        node next;
        node(String data)
        {
            this.data=data;
            this.next=null;
        }
    }
    node head=null;
    //insert at starting
    public void addfirst(String data)
    {
        node newnode = new node(data);
        if (head== null) {
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    //insert at  last
    public void addlast(String data)
    {
        node newnode = new node(data);
        if (head== null) {
            head=newnode;
            return;
        }
        node temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        temp.next=newnode;
    }
    public void printvalues()
    {
        node newnode = head;
        if (newnode==null) {
            System.out.println("list is empty");
            return;
        }
        while (newnode!=null) {
            System.out.print(newnode.data+" -> ");
            newnode=newnode.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        linked_list1 l1 = new linked_list1();
        l1.addfirst("sambhav");
        l1.addfirst("ram");
        l1.addlast("sam");
        l1.printvalues();
    }
}
