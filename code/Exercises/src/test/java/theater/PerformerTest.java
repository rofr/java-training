package theater;

import org.testng.annotations.Test;
import mockit.*;
import theater.Collaborator;
import theater.Model;
import theater.Performer;


public class PerformerTest {
 
    @Injectable
    private Collaborator collaborator;
 
    @Tested
    private Performer performer;
 
    @Mocked Model model;
    
    @Test
    public void testThePerformMethod() {
    	
    	//record
        new Expectations() {{
            model.getInfo();result = "bar";
            collaborator.collaborate("bar"); result = true;
        }};
        
        //replay
        performer.perform(model);
        
        //verify
        new Verifications() {{
            collaborator.receive(true);
        }};
    }
}