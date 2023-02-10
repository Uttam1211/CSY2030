package part1.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import part1.EgameCompetitor;
import part1.Name;


public class EgameCompetitorTest{

@Test
public void testGetCompetitorNumber() throws Exception {
    Name n =new Name("joe","j",29);

    EgameCompetitor ec = new EgameCompetitor(100,n,"novice","uk", new int[]{1,2,3,4} );
    assertEquals(100 ,ec.getCompetitorNumber());
} 


/** 
* 
* Method: getCompetitorName() 
* 
*/ 
@Test
public void testGetCompetitorName() throws Exception {

    Name n =new Name("joe","j",29);

    EgameCompetitor ec = new EgameCompetitor(100,n,"novice","uk", new int[]{1,2,3,4} );
    assertEquals("joe" ,n.getFirstName());
} 



/** 
* 
* Method: getLevel() 
* 
*/ 
@Test
public void testGetLevel() throws Exception {

    Name n =new Name("joe","j",29);

    EgameCompetitor ec = new EgameCompetitor(100,n,"novice","uk", new int[]{1,2,3,4} );
    assertEquals("novice" ,ec.getLevel());
} 

} 
