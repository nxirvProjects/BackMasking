import java.util.EmptyStackException;

public class ArrayStack implements BKStack{ 
    
    //Upping the capacity may make program more efficient but it comes with a tradeoff of having more unused memory.
    private final int INTIAL_CAPACITY = 50; // Intial size of array shouldn't be modified. 
    
    private int maxSize = 0; 
    private double[] stackArray; 
    private int top; // Keeps track of index of top element 

    // Constructor
    public ArrayStack(){
        maxSize = INTIAL_CAPACITY; 
        stackArray = new double[maxSize]; 
        top = -1; // Intialized to -1 in case of stack being empty. If stack is empty you cannot store something at index -1. 
    }


    // Method should resize the array whenever the array gets full 
    private void resizeArray(){
        int newMax = maxSize *2; // Double the array if it gets full 
        double[] resizedArray = new double[newMax]; // Create new array with double size

        // Put elements in old array to new array
        for(int i = 0; i <= top; i++){ 
            resizedArray[i] = stackArray[i]; 
        }

        stackArray = resizedArray; // Take address of the new array and replace the old stackarray address with the new one
        maxSize = newMax; 

    }


    //Method checks if array is empty
    public boolean isEmpty(){
        if(top == -1){ // top index -1 then it is empty because index -1 dne 
            return true; 
        }
        else
            return false; 
    }


    // Method returns number of elements in stack
    public int count(){
        return top -1; // counts the amount of elements in array  
    }


    // Method adds element into array
    public void push(double d){
       
        if(top == maxSize -1){ //If stack is full then resize the array. 
            resizeArray();
        } 

        top++; // push to next index 
        stackArray[top] = d; 
    }


    // Method removes element from array. 
    public double pop(){
        if(isEmpty()){
            throw new EmptyStackException(); // Throws exception because you cannot take a element out that does not exist. 
        }

        top -= 1; 
        
        return stackArray[top]; // Removes top element and points to the element below it. 
    } 

    // Method views the element on top of stack
    public double peek(){
        if(isEmpty()){
            throw new EmptyStackException(); // Throws exception if stack is empty because u cannot look at element if it is empty. 
        }

        return stackArray[top];    

    }
}  