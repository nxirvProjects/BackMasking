**Vishnu Nair | CS 3345.003**

**<span style="text-decoration:underline;">ArrayStack:  (Is an Array implementation of a Stack Data Structure)</span>**

**Methods: **



* ArrayStack() Constructor:
    * All this constructor does is set the initial size of the array along with making the array that will hold elements. It also sets the index of the top element to -1. It’s -1 because the stack is empty currently. This also helps later in the program when seeing if the size of the array is empty.  
* resizeArray():
    * All this method does is that whenever an element is being added to the stack and the array is full, it will double the array size and copy the elements to the new array that way we can add more elements to the existing array.  This should avoid overflow. **Time complexity is O(n) because it uses a for loop to go throw all elements of the old array and put them into the new array.  **
* isEmpty():
    * As mentioned before in the constructor we set the top index to -1 to represent that no elements have been added to the stack yet. The isEmpty() method’s job is to see if the stack is empty by using the top variable and seeing if it equals -1. Because -1 is an index that the computer cannot access due to having no negative indexes, this means the array implementation of a stack is empty. **Time complexity is O(1).**
* count():
    * The count method will just return how many elements are in the stack whenever it is called. **Time complexity is O(1). **
* push(double d): 
    * The push method’s job is to take an element and put it on top of the stack. Before pushing an element on the stack I made sure to check if the array was first full. I did this because if the array is full then we have to resize the array by doubling its size that way we can push more elements onto the stack. To push an element to the next index we increment top by 1 and then store that index into the stackArray. We then return that value. **Time complexity is O(n). This is because if a resize is needed then its worst case would be using a for loop.  **
* pop(): 
    * The pop method’s job is to take an element out of the stack and then make the first element point to the next element of the stack. Before popping an element out of the stack I made sure to check if the stack was empty. I did this because you cannot take an element out of a stack that contains no elements, therefore if the array was empty I threw an EmptyStackException. To pop an element out of the array all that was done was to make the top index point to the next element in the stack by decrementing the top by 1 and to return the popped element. **Time complexity is O(1). **
* peek():
    * Likewise, with the pop method, you cannot take a look at the first element if the stack contains nothing. Because of this, I made the program throw an EmptyStackException if the stack was empty. Unlike pop which takes the element on top of the stack out of the array, all peek() does is look at what the top element is. Therefore I just used stackArray[top] to return the element that was on top of the stack. **Time complexity is O(1). **

<span style="text-decoration:underline;"> </span>

**<span style="text-decoration:underline;">ListStack: (Is a list implementation of a Stack Data Structure)</span>**

**Methods: **



* ListStackNode class: 
    * The class contains attributes of data and an address. In a linked list nodes contain the element data and the address of the the next node. 
* ListStack() Constructor: 
    * All this constructor does is set the top of the stack to empty. 
* isEmpty(): 
    * This method checks if the stack is empty by checking if the top element in the stack is null. If it is null then it returns true because the stack is empty and false because the stack is not empty. **Time complexity is O(1).** 
* count(): 
    * This method uses an enhanced for loop to go through the instance of the list stack to check how many elements are in the stack. It then returns the count. **Time complexity is O(n). This is because it uses an enhanced for loop** **to iterate through all elements in the stack. **
    * 
* push(): 
    * I created a node in the push method to hold the element data and the address that points to the next node. I then made this instance of a node hold the data that gets passed through the method’s parameters and made this node hold the address of the next node. I then made the top of the stack hold the instance called temp’s attribute data because temp will become the new top of the stack. I also had a modCount integer variable here to count the number of modifications done whenever push() was called. **Time complexity is O(1). **
* pop(): 
    * Like the Array implementation of a stack, it is not possible to pop elements of a stack that contains none so I invoked the method isEmpty() to check for this case. The method will throw an exception if it is empty.  To pop elements of a stack that contains elements all I did was create a double data type variable to hold the top elements' data so that I could return it. Then I made the top element point to the next element in the stack that way it deletes the element I am trying to pop off. I then returned the variable called dataStore which holds the data of the top element before I pointed to the element below it. I also had a modCount integer variable here to count the number of modifications done whenever pop() was called. **Time complexity is O(1). **
* peek(): 
    * Since you cannot peek an empty stack I made the same exception be called in pop() in this method to be thrown if the stack was indeed empty. This method’s job is to return the top of the stack’s element without modifying the stack. **Time complexity is O(1).** 
* StackIt stands for **stack iterator**: 
    * Made two instance variables called current and finalModCount. Current is an instance of the ListStackNode class and all it does is hold the top of the stack. finalModCount is a variable that holds the expected modification made to the stack which will track for concurrent modifications. This variable is mainly to throw a ConcurrentModificaitonException to make sure no modifications were done while iterating. The hasNext() method job in this private class is to make sure there is a next node in the stack. The next() method’s job in the stack is to return the next node's data or its element that was stored in the stack. The next() method returns an EmptyStackException() if there is no next node in the stack. **Time complexity is O(1).** 

    ** **
