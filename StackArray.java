public class StackArray {

	private int[] stackArray;
	private int top;
	private int maxSize;

	// COnstructor to initialize the stack
	public StackArray(int size){
		maxSize = size;
		stackArray = new int [maxSize];
		top = -1 ; // top is initialized tp - 1, meaning the stack is empty

	}

	// push method to add elements to the stack
	public void push ( int value){
		if(isFull()){
			System.out.println("Stack is full . Cannot push" + value);
			} else{
				stackArray[++top]= value;
				}
			}

	// pop method to remove and return the top element of the stack
		public int pop() {
			if(isEmpty()){
				System.out.println("Stack is empty . Cannot pop" );
				return -1 ; // return -1 if stack is empty
				} else{
					return stackArray[top--];
					}
			}

	 //peek method to view the top element without removing it
	public int peek(){
			if(isEmpty()){
			System.out.println("Stack is empty");
			return -1;
		}else{
			return stackArray[top];
			}
		}

		// method to check if the stack is empty
		public boolean isEmpty(){
			return (top == -1);
			}

		//method to check if the stackc is full
		public boolean isFull(){
		 return (top == maxSize -1);
	}

	//run/debug

		public static void main (String[] args){
		StackArray stack = new StackArray (99);// create a stack with a size 5

			stack.push(5);
			stack.push(10);
			stack.push(15);
			stack.push(20);
  			stack.push(25);
			stack.push(30);


	// this will display is full


	System.out.println("Top element is;" + stack.peek());
	System.out.println("Popped element is;" + stack.pop());
	System.out.println("Top element after pop;" + stack.peek());



	}
}
