import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;

public class ListStack implements BKStack, Iterable<Double> {
    
    // Should store the address of the top element
    ListStackNode top; 
    private int modCount = 0; // This should track the count of modifications done to the stack.

    ListStack(){
        top = null; // Set top stacknode to empty
    }
    
    // Checks if stack isEmpty
    public boolean isEmpty(){
        if(top == null){ // If element on top does not contain an address, it must be empty. 
            return true; 
        }
        else
            return false; 
    }

    // Function counts how many elements are in stack. 
    public int count(){
        // This function should use a enhanced for loop to count how many elements are in the stack
        int c = 0; 

        for(Double e : this){ // this represents the current instance of the class listStack 
            c++; // C will increment everytime there is another element in the stack. 
        }

        return c; // Returns count of elements in stack. 
    }


    // Push function takes "double d" argument and pushes this element to the top of the stack
    public void push(double d){
        // Create temp node to help in holding  element get passed through the function push(double d)
        ListStackNode temp = new ListStackNode();  

        temp.data = d; // holds the element data 
        temp.addr = top; // holds the elements address
        top = temp; // top will change to temp's object attributes like the address and the data of the element in the stack. 

        modCount++; // Everytime a push is done this increments because a modification is done. 
    }


    // Pop function will take the top of the stack out 
    public double pop(){
        // Cannot pop an element if the stack is empty so it will throw a exception
        if(isEmpty()){ 
            throw new EmptyStackException(); 
        }

        double dataStore = top.data; // This will store the element on top of the stack
        top = top.addr; // This should store the next address of the element after popping the current element. 

        modCount++; // Everytime a pop method is called this will increment because a modification was done. 

        return dataStore; // This will return the popped data
    } 


    // Peek function will take a look at the element on the top
    public double peek(){
        // Cannot peek an element if it is empty
        if(isEmpty()){ 
            throw new EmptyStackException(); 
        } 


        return top.data; // Returns the element that is on the top
    }

    


    private class stackIt implements Iterator<Double>{
        ListStackNode current = top; // top of stack
        int finalModCount = modCount; // Tracks the expected modifications made through calling the pop and push methods of the stack. 

        public boolean hasNext(){ 
           
            //All this means is if the modCount before iterating through the stack does not equal to it after iterating through the stack it should throw a exception. 
            if(finalModCount != modCount){
                throw new ConcurrentModificationException(); 
            }

            if(current != null){ // If the current element is null that means there should not be a next element in the list. 
                return true; // Return true when not null.  
            }
            else
                return false; 
        }

        public Double next(){
            if(!hasNext()){
                throw new EmptyStackException(); // basically all this says is that if there isn't a next element then the stack must be empty 
            }

            double elementD = current.data; // element data is equal to the current data on the stack. 

            current = current.addr; // makes current equal the next address of the element in the stack. 

            return elementD; 
        }

    }




    @Override
    public Iterator<Double> iterator() {
        return new stackIt(); // Resp for going through elements in stack. 
    }
}
