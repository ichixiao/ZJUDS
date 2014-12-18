//First add the node in the stack, then create the list
//import java.util.Scanner;
import java.util.*;
public class RevLinkedList {
  private class Node {
    int data;
    Node next;
    //Node constructr
    public Node(int value) {
      data = value;
      next = null;
    }
    public Node(int value, Node nextNode) {
      data = value;
      next = nextNode;
    }
    
    public int getValue() {
      return data;
    }
    public void setValue(int value) {
      data = value;
    }
    public Node getNext() {
      return next;
    }
    public void setNext(Node nextNode) {
      next = nextNode;
    }
  }
  class list {
    private Node head;
    private int size;
    
    public list() {
      head = new Node();
      size = 0;
    }
    public void addNode(int data) {
      Node newNode = new Node(data);
      Node current = head;
      while(!current) {
        current = current.getNext();
      }
      current.setValue(data);
      size ++;
    }
    
    public Node getNode(int index) {
      if(index <= 0 || index > size) return null;
      
      if(index == 1) return head;
      else {
        Node current = head;
        for(int i = 2; i <= index; i++) {
          current = current.getNext();
        }
        
        return current;
      }
    }
    public int getNodeValue(int index) {
      if(index <= 0 || index > size) return -1;
      
      Node current = head;
      for(int i = 1; i < index; i++)
        current = current.getNext();
      
      return current.getValue();
     }
    public int length() {
      return size;
    }
  }
  public static void main(String[] args) {
    //The first input is an address
    Scanner sc = new Scanner(System.in);
    String[] firstLine = sc.nextLine().split(" ");
    
    int firstaddress = Integer.parseInt(firstLine[0]);
    int N = Integer.parseInt(firstLine[1]);
    int K = Integer.parseInt(firstLine[2]);
    
    if(K >= N) return;
    
    //Deal the input
    int[] values = new int[N];
    int[] address = new int[N];
    int[] next = new int[N];
    for(int i = 0; i < N; i++) {
      String[] temp = sc.nextLine().split(" ");
      address[i] = Integer.parseInt(temp[0]);
      values[i] = Integer.parseInt(temp[1]);
      next[i] = Integer.parseInt(temp[2]);
    }
    int index = -1;
    for(int i = 0; i < N; i++) {
      if(address[i] == firstaddress) {
        index = i;
        break;
      }
    }
    if (index == -1) return;
    boolean flag = true;
    Stack st = new Stack();
    for(int count = 0; count < K; count++) {
      st.push(new Integer(values[index]));
      int nextAddress = next[index];
      if (nextAddress == -1) {
        flag = false;
        break;
        }
      else {
        for(int i = 0; i < N; i++) {
          if(address[i] == nextAddress) {
            index = i;
            break;
          }
        }
      }
    }
    //Reverse the list
    list resList = new list();
    while(!st.empty()) {
      int insert = st.pop();
      resList.addNode(insert);
    }
    
    while(flag) {
      if(next[index] == -1) {
        flag = false;
        break;
      }
      else {
        int nextAddress = next[index];
        for(int i = 0; i < N; i++) {
          if(address[i] == nextAddress) {
            index = i;
            break;
          }
        }
        resList.addNode(values[index]);
      }
    }
    
    Node top = resList.getNode(1);
    while(top != null) {
      System.out.println(top.getValue());
      top = top.getNext();
    }
    
    sc.close();
  }
  
}