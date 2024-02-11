package com.DSA.basicJava;

class CloneGFG implements Cloneable {

    // Method 1
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        // Super() keyword refers to parent class
        return super.clone();
    }

    // Declaring and initializing string
    String name = "GeeksForGeeks";

    // Method 2
    // main driver method
    public static void main(String[] args)
    {
        CloneGFG obj1 = new CloneGFG();
        System.out.println(obj1.hashCode());

        // Try block to check for exceptions
        try {

            // Using the clone() method
            CloneGFG obj2 = (CloneGFG)obj1.clone();
            System.out.println(obj2.hashCode());

            // Print and display the main class object
            // as created above
            System.out.println(obj2.name);
        }

        // Catch block to handle the exceptions
        catch (CloneNotSupportedException e) {

            // Display the exception
            // using printStackTrace() method
            e.printStackTrace();
        }
    }
}