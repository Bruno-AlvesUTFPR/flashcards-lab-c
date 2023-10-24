package domain.useCases.Activity;

import infra.controllers.ActivityController;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadBinaryObjectActivityUseCase {
    public static ActivityController activityController = ActivityController.getInstance();

    public boolean read(File arquivo, ObjectInputStream reader) {
        try {
            reader = new ObjectInputStream(new FileInputStream(arquivo));
            activityController = (ActivityController) reader.readObject();
            
            reader.close();
            
            return true;
        } catch (ClassNotFoundException erro) {
            System.err.println(erro.getMessage() + ": Class not found!");
            return false;
        } catch (IOException erro) {
            System.err.println(erro.getMessage() + ": Error on read binary file!");
            return false;
        } catch (NullPointerException erro) {
            System.err.println(erro.getMessage() + ": Null File!");
            return false;
        }
    }
}
