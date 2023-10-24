package domain.useCases.Activity;

import infra.controllers.ActivityController;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteBinaryObjectActivityUseCase {
    public static ActivityController activityController = ActivityController.getInstance();

    public boolean write(boolean append, File arquivo, ObjectOutputStream writer) {
        Boolean response = false;
        
        if (arquivo != null) {
            try {
                writer = new ObjectOutputStream(new FileOutputStream(arquivo, append));
                writer.writeObject(activityController);
                
                writer.close();
                
                response = true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + "Error on write binary file!");
            } finally {
                return response;
            }
        } else {
            return false;
        }
    }
}
