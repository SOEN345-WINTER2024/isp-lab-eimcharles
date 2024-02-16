import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


public class IteratorTest {
	
	
    public List<String> studentName = new ArrayList<String>();
    public Iterator<String> itr;

    
    @Test
    public void listHasNextElement(){
        studentName.add("Charles");
        itr = studentName.iterator();
        assertTrue(itr.hasNext());
    }
    
    @Test
    public void listNextElement(){
        studentName.add("Dan");
        itr = studentName.iterator();
        assertEquals("Dan", itr.next());
    }
    
    @Test
    public void listRemoveElement(){
        studentName.add("Nic");
        itr = studentName.iterator();
        
        while (itr.hasNext()) {
        	itr.next(); 
        	itr.remove();	
        }
        assertFalse(itr.hasNext());
    }
    
    
    @Test(expected=ConcurrentModificationException.class)
    public void listHasNextElementConcurrentModification(){
        studentName.add("Nic");     
        itr = studentName.iterator();
        itr.next();
    }
    
    	
    @Test(expected=NoSuchElementException.class)
    public void listNextElementNoSuchElementException(){
	studentName.add("Charles");
	studentName.add("Dan"); 
    	itr = studentName.iterator();
        itr.next(); 
        itr.next();
        assertFalse(itr.next());
    }
    
    
    
    @Test(expected=UnsupportedOperationException.class)
    public void listNextElementUnsupportedOperationException(){
    	studentName = Collections.unmodifiableList(list);
    	itr = studentName.iterator();
    	itr.next();
    	itr.remove();
    }

    
    
    @Test (expected=IllegalStateException.class)
    public void listNextElementUnsupportedOperationException(){
        itr = studentName.iterator();
    	itr.remove();
    }
    
  
    @Test (expected=ConcurrentModificationException.class)
    public void listHasNextElementConcurrentModification(){
        itr = studentName.iterator(); 
        itr.next();
    	studentName.add("Charles");
        itr.remove();
    }

}
