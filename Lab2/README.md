### The idea
I will implement the basic game of chess, by the use of OOP principles.

### Progress
For now, there is not much going on, as for this laboratory work I am limited only with the first principle in OOP, which is `Encapsulation`. Unfortunatelly, for me to be able to write a simple for loop, which will, for example, update every chess figure on the board, I wouldve need to create first an `Interface` with all the field and methods, so that the collection in which the loop will go over will be not of type `Any`. 
So, for now, just a basic representation of random pawn movements, was implemented. 

### The Structure
There are 2 classes for each distinct chess piece, and a class, which represents the chess board. The chess board is moving the pieces, and has all the logic.
The pieces are having field that determine their symbol, position, and they have methods for getting the row and column on which they are right now, also the pieces have a method for moving from one point to another. 
