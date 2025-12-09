import java.util.*;
public class Main 
{	
    
    static Scanner reader = new Scanner(System.in);

	
////////////////////////////////////////////////////////

	public static Node<Integer> builder (int[] a) 
	{
		Node<Integer> h = new Node<Integer>(-1);
		Node<Integer> p = h;
		Node<Integer> x;
		for (int i = 0
		; i < a.length; i++) {
			x = new Node<Integer>(a[i]);
			p.setNext(x);
			p = p.getNext();
		}
		return h.getNext();
	}

///////////////////////////////////////////////////////	
	
	
	
	
	public static Node<Integer> ex1 (Node <Integer> a, Node <Integer> b)
	{
	    Node <Integer> a1 = a;
	    Node <Integer> b2 = b;
	    Node <Integer> p = new Node<Integer>(-1,null);
	    Node <Integer> h = p;
	    
	    
	    while (a1 != null && b2 != null)
	    {
	        if (a1.getValue() > b2.getValue())
	        {
	            p.setNext(b2);
	            p = p.getNext();
	            b2 = b2.getNext();
	        }
	        else 
	        {
                p.setNext(a1);
                p = p.getNext();
	            a1 = a1.getNext();
	        }
	    }
	    if (a1 == null)
	    {
	       p.setNext(b2);
	    }
	    else
	    {
	        p.setNext(a1);
	    }  
	    return h.getNext();
	}
	
	
	
	
	
////////////////////////////////////////////////////////////////////////////////	
	
	public static Node <Integer> ex2min (Node <Integer> a)
    {
	    Node <Integer> p = a;
        
        while (a.getNext() != null)
        {
            if (a.getNext().getValue() < p.getNext().getValue())
            {
                p = a;
            }
            a = a.getNext();
        }
        return p;
    }
	
	
		
		
    public static Node <Integer> remove (Node <Integer> a, int x)
    {
        Node<Integer> d =  new Node<Integer> (-1, a);
        Node<Integer> p = d;
        while (d.getNext() != null) 
        {
            if(d.getNext().getValue()== x)
            {
                d.setNext(d.getNext().getNext());
                return p.getNext();
            }
            d = d.getNext();
        }
        return p.getNext();
    }
	
////////////////////////////////////////////////////////////////////////////////


	
	public static Node<Integer> ex2 (Node <Integer> a)
	{
        Node <Integer> p = new Node<Integer>(-1);
        p.setNext(a);
        Node <Integer> x = new Node<Integer>(-1);
        Node <Integer> h = x;
        
        while (p.getNext()!=null)
        {
            x.setNext(ex2min(p).getNext());
            p=remove(p,ex2min(p).getNext().getValue());
            x=x.getNext();
        }
        return h.getNext();
        
    }
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////	
	
	public static int size(Node<Integer> h) 
	{
        int count = 0;
        Node<Integer> p = h;
        while (p != null) 
        {
            count++;
            p = p.getNext();
        }
        return count;
    }
	
	
	
	public static boolean contains(Node<Integer> h, int num) 
	{
        Node<Integer> p = h;
        while (p != null) 
        {
            if (p.getValue() == num)
            {
                return true;
            }
            p = p.getNext();
        }
        return false;
    }
 /////////////////////////////////////////////////////////////////////////////////// 
    
    
	public static int ex3 (Node <Integer> a, int num)
	{
	    if (!contains(a, num))
	    {
	        return -1;
	    }
	    
	    Node <Integer> p = a;
	    int length = size(a);
	    int sum = 0;
	    int count=1;
	    
	    while (p!=null)
	    {
	        if (p.getValue()==num)
	        {
	            if(count > length - count)
	            {
	                sum += (length-count);
	            }
	            else
	            {
	                sum+= count-1;   
	            }
	        }
	        count++;
	        p=p.getNext();
	    }
	    return sum;
	}
	
	

	

	public static boolean ex4 (Node<Integer> list)
	{
	    while (list != null)
	    {
	        Node <Integer> p = list.getNext();
	        while (p != null)
	        {
	            if (list.getValue() == p.getValue())
	            {
	                return false;   
	            }
	            p = p.getNext();
	        }
	        list = list.getNext();
	    }
	    return true;
	}
	
	
		
		
		
	public static Node<Integer> ex5  (Node<Integer> list)
	{
	    Node <Integer> h = list;
	    
	    while (list != null)
	    {
            Node<Integer> prev = list;
            Node<Integer> p = list.getNext();
            
	        while (p != null)
	        {
	            if (list.getValue() == p.getValue())
	            {
	                prev.setNext(p.getNext());
	                p = prev.getNext();
	            }
	            else 
	            {
	                prev = p;
                    p = p.getNext();
	            }
	        }
	        list = list.getNext();
	    }
	    return h;
	}
	

	



	

 

	
	
	
	public static void main(String [] args)
	{
	    int [] a = {0,9,5,9,9,9,3};
	    int [] b = {1,8,10,10,20};

	    System.out.println(ex1(builder(a), builder(b)));
	    System.out.println(ex2(builder(a)));
	    System.out.println(ex3(builder(a), 0));
	    System.out.println(ex5(builder(a)));
	    System.out.println(ex4(builder(a)));
	}
	

}   




