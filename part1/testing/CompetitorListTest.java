package part1.testing;
import static org.junit.Assert.*;

import org.junit.Test;
import part1.CompetitorList;
import part1.EgameCompetitor;
import part1.Name;

import java.util.ArrayList;
import java.util.List;


public class CompetitorListTest {


/** 
* 
* Method: addCompetitor(EgameCompetitor competitor) 
* 
*/ 
@Test
public void testAddCompetitor() throws Exception {
    Name n =new Name("joe","j",29);
    EgameCompetitor ec = new EgameCompetitor(100,n,"novice","uk", new int[]{1,2,3,4} );
    CompetitorList competitors = new CompetitorList();
    Name name1 = new Name("John", "Doe", 22);
    Name name2 = new Name("Jane", "Doe", 25);
    competitors.addCompetitor(ec);
    assertEquals(100, competitors.getCompetitorList().get(0).getCompetitorNumber());
}
    @Test
    public void testCountCompetitors() throws Exception {
        Name n =new Name("joe","j",29);
        EgameCompetitor ec = new EgameCompetitor(100,n,"novice","uk", new int[]{1,2,3,4} );
        EgameCompetitor ec1 = new EgameCompetitor(100,n,"novice","uk", new int[]{1,2,3,4} );
        CompetitorList competitors = new CompetitorList();
        Name name1 = new Name("John", "Doe", 22);
        Name name2 = new Name("Jane", "Doe", 25);
        competitors.addCompetitor(ec);
        competitors.addCompetitor(ec1);
        assertEquals(2, competitors.getCompetitorList().size());
    }



} 
