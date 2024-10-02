public class reverse_LL{
    class node
{
    int data;
    node next;
    node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
node head=null;
//insert at starting
public void addfirst(int data)
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
public void addlast(int data)
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
// reverse through iterative
public void reverse()
    {
        if (head==null|| head.next==null) {
            return;
        }
        node prevnode = head;
        node currnode = head.next;
        while (currnode != null) {
            node nextnode = currnode.next;
            currnode.next  = prevnode;
            // update the prevnode and currnode
            prevnode = currnode;
            currnode = nextnode;
        }    
        head.next=null;
        head = prevnode;
    }
    //reverse through recursive
public static node ReverseRecursive(node head)
{
    if (head==null || head.next == null) {
        return head;
    }
    node newnode= ReverseRecursive(head.next);
    head.next.next= head;
    head.next=null;
    return newnode;
}
public static void main(String[] args) {
    reverse_LL l1 = new reverse_LL();
    l1.addfirst(1);
    l1.addlast(2);
    l1.addlast(3);
    l1.addlast(44);
    l1.printvalues();
    l1.head=ReverseRecursive(l1.head); // recursive reverse
    l1.printvalues();
    l1.reverse();  // iterative reverse
    l1.printvalues();
}
}