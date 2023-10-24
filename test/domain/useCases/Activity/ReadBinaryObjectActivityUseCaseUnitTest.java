package domain.useCases.Activity;

import infra.controllers.ActivityController;
import java.io.File;
import java.io.ObjectInputStream;
import mocks.FileOptions;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReadBinaryObjectActivityUseCaseUnitTest {
    public static ActivityController activityController = ActivityController.getInstance();
    public FileOptions fileOptions = new FileOptions();
    
    // Foi ajustado tratamento de erro para arquivos nulos
    @Test
    public void testReadWithoutFile() {
        System.out.println("read without file defined");
        
        File arquivo = null;
        ObjectInputStream reader = null;
        ReadBinaryObjectActivityUseCase instance = new ReadBinaryObjectActivityUseCase();
        
        boolean expResult = false;
        boolean result = instance.read(arquivo, reader);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReadWithoutReader() {
        System.out.println("read without reader defined");
        
        fileOptions.saveFile();
        File file = activityController.getFile();
        
        ObjectInputStream reader = null;
        ReadBinaryObjectActivityUseCase instance = new ReadBinaryObjectActivityUseCase();
        
        boolean expResult = true;
        boolean result = instance.read(file, reader);
        
        assertEquals(expResult, result);
    }
}
