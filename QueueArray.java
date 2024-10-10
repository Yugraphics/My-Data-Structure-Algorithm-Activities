import java.util.Scanner;
public class QueueArray{

	private int[] queueArray;
	private int front;
	private int rear;
	private int maxSize;
	private int currentSize;

	//Constructor to initialliaze the queue

	public QueueArray(int size){
	    maxSize = size;
	    queueArray = new int[maxSize];
	    front= 0;
	    rear =  -1;
	    currentSize=0;
	}
	//Enqueue method to add an element to thr rear of the queue
	public void enqueue(int value){
	    if(isFull()){
	        System.out.println("Queue is full. Cannot enqueue"+value);
	    }else{
	        rear= (rear + 1) % maxSize;//Circular increment
	        queueArray[rear] = value;
	        currentSize++;
	    }
	}
	//Dequeue method to remove and return the fornt element of the queue
	public int dequeue(){
	    if(isEmpty()){
	        System.out.println("Queue is empty. Cannot dequeue.");
	        return -1;
	    }else{
	        int value= queueArray[front];
	        front = (front + 1) % maxSize;//Circular increment
	        currentSize--;
	        return value;
	    }
	}


	//Peek method to view the front element without removing it.
	public int peek(){
	    if(isEmpty()){
	        System.out.println("Queue is empty.");
	        return -1;
	    }else{
	        return queueArray[front];
	    }
	}
	//Method queue empty

	public boolean isEmpty(){
	        return (currentSize == 0);
	}
	//Method to check full
	public boolean isFull(){
	        return(currentSize == maxSize);
	}
	public static void main(String[] args){
	    QueueArray queue = new QueueArray(5);


	queue.enqueue(10);
	queue.enqueue(20);
	queue.enqueue(30);
	queue.enqueue(40);
	queue.enqueue(50);
	queue.enqueue(60);//this will display

	System.out.println("Front Element is:" +queue.peek());
	        System.out.println("Dequeue element: " + queue.dequeue());
	        System.out.println("Front element after dequeue:" +queue.peek());


}
}