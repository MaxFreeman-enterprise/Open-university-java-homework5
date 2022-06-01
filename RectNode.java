/**
 * Make a node in a linked list that has a rectnagle in it.
 *
 * @author Max Freeman
 * @version 15.01.22
 */
public class RectNode
{
    private RectangleA _rect;
    private RectNode _next;
    
    /**
     * Constructor for objects of class RectNode, Initializing the _rect to the givin RectangleA and the _next to null
     * @param r - object from RectangleA class
     * Time Complexity = O(1) - constant number of actions.
     * Space complexity = O(1) - constant number of variables.
     */
    public RectNode (RectangleA r){
        _rect = new RectangleA(r);
        _next = null;
    }
    
    
    /**
     * Constructor for objects of class RectNode, Initializing the _rect to the givin RectangleA and the _next to the givin RectNode
     * @param r - object from RectangleA class
     * @param n - object from RectNode class
     * Time Complexity = O(1) - constant number of actions.
     * Space complexity = O(1) - constant number of variables.
     */
    public RectNode (RectangleA r, RectNode n){
        _rect = new RectangleA(r);
        _next = n;
    }
    
    
    /**
     * copy Constructor for objects of class RectNode, Constructs RectNode using another RectNode
     * @param r - object from RectNode class
     * Time Complexity = O(1) - constant number of actions.
     * Space complexity = O(1) - constant number of variables.
     */
    public RectNode (RectNode r){
        
        this(r._rect,r._next);
    }
    
    
    /**
     * return Rectangle of this node
     * @return Rectangle of this node
     * Time Complexity = O(1) - constant number of actions.
     * Space complexity = O(1) - constant number of variables.
     */
    public RectangleA getRect(){
        return new RectangleA(_rect);
    }
    
    /**
     * Return the next RectNode of this node
     * @return the next RectNode of this node
     * Time Complexity = O(1) - constant number of actions.
     * Space complexity = O(1) - constant number of variables.
     */
    public RectNode getNext(){
        return _next;
            
    }
        
    /**
     * Set the Rectangle of this node
     * @param r the object r that the Rectnagle set to
     * Time Complexity = O(1) - constant number of actions.
     * Space complexity = O(1) - constant number of variables.
     */
    public void setRect(RectangleA r){
        _rect = new RectangleA(r);
    }
    
    
    /**
     * Set the next Rectangle of this node
     * @param next the object r that the Rectnagle set to
     * Time Complexity = O(1) - constant number of actions.
     * Space complexity = O(1) - constant number of variables.
     */
    public void setNext( RectNode next){
        _next = next;
    }
 
}
        