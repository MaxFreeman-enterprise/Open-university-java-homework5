/**
 * The RectList class will represent a linked list of rectangles.
 *
 * @author Max Freeman
 * @version 15.01.22
 */
public class RectList
{
    private RectNode _head;
    
    /**
     * Constructor for objects of class RecList, Crate an empty linked list
     * Time Complexity = O(1) - constant number of actions.
     * Space complexity = O(1) - constant number of variables.
     */
    public RectList(){
        _head = null;
    }
    
    

    /**
     * Add a Rectangle to the end of the linked list
     * @param r the Rectnagle add Rectangle to the end of the linked list
     * Time Complexity O(n): we ierate over a linked list with n indexes once.
     * Space complexity = O(1) - constant number of variables.
     */
    public void addRect(RectangleA r){
        
        if(_head == null){
            _head = new RectNode(r);
            return;
        }
        
        RectNode ptr = _head;
        while(ptr.getNext() != null){
            if (ptr.getRect().equals(r)){
                return;
            }
            ptr = ptr.getNext();
            if (ptr.getNext() == null && ptr.getRect().equals(r)){
                return;
            }
        }

        ptr.setNext(new RectNode(r));
    }
    
    
    /**
     * Return how many rectangles with givin point p in the linked list
     * @param p the givin point
     * @return how many rectangles with givin point p in the linked list
     * Time Complexity O(n): we ierate over an linked list with n indexes once.
     * Space complexity = O(1) - constant number of variables.
     */
    public int howManyWithPoint(Point p){
        int count = 0;
        RectNode ptr = _head;
        while(ptr != null){
            if(ptr.getRect().getPointSW().equals(p)){
                count++;
            }
            ptr = ptr.getNext();
        }
        return count;
    }
    
    
    /**
     * Return the value of the longest digonal in the linked list
     * @return the value of the longest diagonal in the linked list
     * Time Complexity O(n): we ierate over an linked list with n indexes once.
     * Space complexity = O(1) - constant number of variables.
     */
    public double longestDiagonal(){
        double longestDiagonal = 0;
        RectNode ptr = _head;
        while(ptr != null){
            longestDiagonal = Math.max(longestDiagonal,ptr.getRect().getDiagonalLength());
            ptr = ptr.getNext();
        }

        return longestDiagonal;
    }
    
    
    /**
     * Return the SW point of the most left rectangle
     * @return the SW point of the most left rectangle
     * Time Complexity O(n): we ierate over an linked list with n indexes once.
     * Space complexity = O(1) - constant number of variables.
     */
    public Point mostLeftRect(){
        if(_head == null){
            return null;
        }
        Point mostLeftSW = null;   
        RectNode ptr = _head;
        while(ptr != null){
            if(mostLeftSW == null || ptr.getRect().getPointSW().isLeft(mostLeftSW)){
                mostLeftSW = ptr.getRect().getPointSW();
            }
            ptr = ptr.getNext();
        }
        return new Point(mostLeftSW);
    }
    
    
    
    /**
     * Return the NE point of the most highest rectangle
     * @return the NE point of the most highest rectangle
     * Time Complexity O(n): we ierate over an linked list with n indexes once.
     * Space complexity = O(1) - constant number of variables.
     */
    public Point highestRect(){
        if(_head == null){
            return null;
        }

        Point highestNE = null;   
        RectNode ptr = _head;
        while(ptr != null){
            if(highestNE == null || ptr.getRect().getPointNE().isAbove(highestNE)){
                highestNE = ptr.getRect().getPointNE();

            }
            ptr = ptr.getNext();
        }
        return new Point(highestNE);
    }
    
    
    
    /**
     * Return new RectangleA that overlaps the rest of the rectnagles in the list.
     * @return new RectangleA that overlaps the rest of the rectnagles in the list.
     * Time Complexity O(n): we ierate over an linked list with n indexes once.
     * Space complexity = O(1) - constant number of variables.
     */
    public RectangleA minimalContainer(){
        if(_head == null){
            return null;
        }
        int minX = _head.getRect().getPointSW().getX();
        int minY = _head.getRect().getPointSW().getY();
        int maxX = _head.getRect().getPointNE().getX();
        int maxY = _head.getRect().getPointNE().getY();
        RectNode ptr = _head.getNext();

        while(ptr != null){
            minX = Math.min(ptr.getRect().getPointSW().getX(),minX);
            minY = Math.min(ptr.getRect().getPointSW().getY(),minY);
            maxX = Math.max(ptr.getRect().getPointNE().getX(),maxX);
            maxY = Math.max(ptr.getRect().getPointNE().getY(),maxY);
            ptr = ptr.getNext();
        }

        return new RectangleA(new Point(minX,minY),new Point(maxX,maxY));
    }

    
    /**
     * Returns a string that displays all the rectnalges in the list with their values.
     * @returns a string that displays all the rectnalges in the list with their values.
     * Time Complexity O(n): we ierate over an linked list with n indexes once.
     * Space complexity = O(n) - we have string at the size of our input. 
     */
    public String toString(){
        int count = 0;
        RectNode ptr = _head;
        String str = "";
        if(_head == null){
            return "The list has 0 rectangles.";
        }
        while(ptr != null){
            count++;

            str += count + ". " + ptr.getRect() +"\n";

            ptr = ptr.getNext();
        }

        return "The list has " + count + " rectangles.\n" + str;
    }

}