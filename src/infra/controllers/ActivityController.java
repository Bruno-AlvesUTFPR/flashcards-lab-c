package infra.controllers;

import domain.models.ActivityModel;
import domain.useCases.Activity.WriteBinaryObjectActivityUseCase;
import domain.useCases.Activity.ReadBinaryObjectActivityUseCase;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class ActivityController extends ActivityModel {
    private final ObjectInputStream readerObject = null;
    private final ObjectOutputStream writerObject = null;
    private final WriteBinaryObjectActivityUseCase writeBinaryObjectActivityUseCase = new WriteBinaryObjectActivityUseCase();
    private final ReadBinaryObjectActivityUseCase readBinaryObjectActivityUseCase = new ReadBinaryObjectActivityUseCase(); 
    public static ActivityController activityController;
    
    static {
        try {
            activityController = new ActivityController();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }
    
    public static ActivityController getInstance() {
        return activityController;
    }    
    
    public ActivityController getActivity() {
        return activityController;
    }
    
    public void setActivity(ActivityController activityController) {
        this.activityController = activityController;
    }
       
    private ActivityController() {
        title = "não informado";
        description = "não informado";
        priority = 0;
        id = 0;
    }

    public ActivityController(int priority, int id) {
        this.priority = priority;
        this.id = id;
    }

    public ActivityController(String title, String description, int priority, int id) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.id = id;
    }
    
    @Override
    public boolean read() {
        return readBinaryObjectActivityUseCase.read(file, readerObject);
    }

    @Override
    public Boolean write(boolean append) {
        return writeBinaryObjectActivityUseCase.write(append, file, writerObject);
    }

    @Override
    public Boolean delete() {
        try {
            return file.delete();
        } catch(NullPointerException error) {
            System.err.println(error.getMessage() + ": Null File!");
            return false;
        }
        
    }
}