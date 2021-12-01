package persistencia;

import java.io.File;

public class DataFiles {
    
    private final File file;
    
    public DataFiles(String arquivo) throws Exception {
        file = new File("./Lifenance_Data/" + arquivo);
        if (file.isFile() == false) {
             File pasta = new File("./Lifenance_Data/");
            if (pasta.exists()) {
                file.createNewFile();
            } else {
                pasta.mkdir();
                file.createNewFile();
            }
        }
    }
    
    public File getFile() {
        return file;
    }
}
