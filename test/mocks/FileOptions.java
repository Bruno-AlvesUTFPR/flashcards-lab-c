package mocks;

import infra.controllers.ActivityController;

public class FileOptions {
    public static ActivityController activityController = ActivityController.getInstance();
    
    public void createActivity() {
        ActivityController activityController = new ActivityController(
            "test",
            "test",
            0,
            0
        );
        
        activityController.setActivity(activityController); 
    }

    public boolean saveFile() {
        activityController.setFile("Salvar");
        
        if (activityController.getFile() != null) {
            createActivity();
            activityController.write(false);
            return true;
        }
        
        return false;
    }
    
    public boolean openFile() {
        activityController.setFile("Abrir");
        
        if (activityController.getFile() != null && activityController.read()) {
            return true;
        }
        
        return false;
    }
}
