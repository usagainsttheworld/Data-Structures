/**
 * Created by Ling on 2015-09-09.
 */

public class Lab5 {
    /**
     * *Let Y be a subclass of X, and let y and x be variables of classes Y and X
     respectively. Suppose xa is an array of X's, and ya is an
     array of Y's.
     (a)  At compile-time, can we assign xa to ya, and vice versa?  When is a cast
     required?
     (b)  At run-time, if ya references an array of Y's, can we assign it to xa?
     Can we then assign it back from xa to ya?
     (c)  If xa references an array of X's (that are not Y's), can we assign it to
     ya?  Can we then assign it back from ya to xa?  Does it make a difference
     if the array of type X[] references objects that are all of class Y?  Why
     do you think this is the case?
     */
    public static void main(String[] args){
        X[] xa = new X[5];
        Y[] ya = new Y[6];
        xa = ya;
    }
}
