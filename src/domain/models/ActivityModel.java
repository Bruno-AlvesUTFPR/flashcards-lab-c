package domain.models;

import java.io.File;
import javax.swing.JFileChooser;

public abstract class ActivityModel implements java.io.Serializable {
    private static long serialVersionUID = 23489071L;
    public String title;
    public String description;
    public int priority;
    public int id;
    protected File file = null;

    @Override
    public String toString() {
        if (this != null)
            return ("título: " + title + " descrição: " + description + " prioridade: " + priority + " identificador: " + id);
        
        return (null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

   
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
    }
       
    public abstract boolean read();
        
    public abstract Boolean write(boolean append);
    
    public abstract Boolean delete();
        
    public File getFile() {
        return file;
    }
    
    public void setFile(String textOption) {
        String initialDir = System.getProperty("user.dir");
        JFileChooser chooser = new JFileChooser(initialDir);
                
        if (chooser.showDialog(null, textOption) == JFileChooser.APPROVE_OPTION)
            file = chooser.getSelectedFile();
    }
}
