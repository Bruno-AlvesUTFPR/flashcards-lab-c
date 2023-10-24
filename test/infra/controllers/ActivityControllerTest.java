package infra.controllers;

import mocks.FileOptions;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityControllerTest {
    public static ActivityController activityController = ActivityController.getInstance();
    public FileOptions fileOptions = new FileOptions();
    
    @Test
    public void testDeleteWithoutFile() {
        System.out.println("delete without file defined");
        
        Boolean expResult = false;
        Boolean result = activityController.delete();
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDelete() {
        System.out.println("delete with file defined");
        
        fileOptions.openFile();
        
        Boolean expResult = true;
        Boolean result = activityController.delete();
        
        assertEquals(expResult, result);
    }
}
