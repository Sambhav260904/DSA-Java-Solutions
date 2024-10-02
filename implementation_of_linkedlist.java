// Define the LinkedList class
public class implementation_of_linkedlist {
    
    // Node class to represent each element in the list
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    Node head;

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            // Traverse to the end of the list
            while (current.next != null) {
                current = current.next;
            }
            // Add the new node at the end
            current.next = newNode;
        }
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        // Traverse the list and print each node's data
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Method to delete a node with a given key
    public void delete(int key) {
        Node current = head, prev = null;

        // If the head node itself holds the key to be deleted
        if (current != null && current.data == key) {
            head = current.next; // Change head
            return;
        }

        // Search for the key to be deleted, keep track of the previous node
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // If the key was not present in the list
        if (current == null) return;

        // Unlink the node from the linked list
        prev.next = current.next;
    }

    // Method to search for a node with a given key
    public boolean search(int key) {
        Node current = head;
        // Traverse the list and check if the key exists
        while (current != null) {
            if (current.data == key) {
                return true; // Key found
            }
            current = current.next;
        }
        return false; // Key not found
    }

    public static void main(String[] args) {
        implementation_of_linkedlist list = new implementation_of_linkedlist();

        // Insert elements into the linked list
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        // Print the linked list
        list.printList();

        // Search for an element
        System.out.println("Is 20 in the list? " + list.search(20)); // true
        System.out.println("Is 50 in the list? " + list.search(50)); // false

        // Delete an element
        list.delete(20);

        // Print the linked list again
        list.printList();
    }
}
