package part1.testing;
import static org.junit.Assert.*;

import org.junit.Test;
import part1.Name;


public class NameTest { 
Name n = new Name("joe","jj",20);

@Test
public void testGetFirstName() throws Exception { 
assertEquals("joe",n.getFirstName());
} 

/** 
* 
* Method: setFirstName(String firstName) 
* 
*/ 
@Test
public void testSetFirstName() throws Exception {
   n.setFirstName("Zoe");
assertEquals("Zoe",n.getFirstName());
} 

/** 
* 
* Method: getLastName() 
* 
*/ 
@Test
public void testGetLastName() throws Exception { 
assertEquals("jj",n.getLastName());
} 

/** 
* 
* Method: setLastName(String lastName) 
* 
*/ 
@Test
public void testSetLastName() throws Exception { 
n.setLastName("smith");
assertEquals("smith", n.getLastName());
} 

/** 
* 
* Method: getAge() 
* 
*/ 
@Test
public void testGetAge() throws Exception { 
assertEquals(20,n.getAge());
} 

/** 
* 
* Method: setAge(int age) 
* 
*/ 
@Test
public void testSetAge() throws Exception { 
n.setAge(22);
assertEquals(22,n.getAge());
} 

/** 
* 
* Method: getFullName() 
* 
*/ 
@Test
public void testGetFullName() throws Exception { 
assertEquals("joe jj",n.getFullName());
} 


} 
