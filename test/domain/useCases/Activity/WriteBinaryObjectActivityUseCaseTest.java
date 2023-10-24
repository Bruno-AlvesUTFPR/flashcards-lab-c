package domain.useCases.Activity;

import infra.controllers.ActivityController;
import java.io.File;
import java.io.ObjectOutputStream;
import mocks.FileOptions;
import org.junit.Test;
import static org.junit.Assert.*;

public class WriteBinaryObjectActivityUseCaseTest {
    public static ActivityController activityController = ActivityController.getInstance();
    public FileOptions fileOptions = new FileOptions();
        
    @Test
    public void testWriteWithoutFile() {
        System.out.println("write without file defined");
        
        boolean append = false;
        File file = null;
        ObjectOutputStream writer = null;
        WriteBinaryObjectActivityUseCase instance = new WriteBinaryObjectActivityUseCase();
        
        boolean expResult = false;
        boolean result = instance.write(append, file, writer);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testWriteWithoutWriter() {
        System.out.println("write without writer defined");
        
        fileOptions.saveFile();
        File file = activityController.getFile();
        
        boolean append = false;
        ObjectOutputStream writer = null;
        WriteBinaryObjectActivityUseCase instance = new WriteBinaryObjectActivityUseCase();
        
        boolean expResult = true;
        boolean result = instance.write(append, file, writer);
        
        assertEquals(expResult, result);
    }
}
