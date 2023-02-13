package org.example.model;

import java.io.IOException;
import java.util.List;

public class Repository {

    private final FileOperationTXT fileOperationTXT;
    private final Mapper mapper = new Mapper();

    public Repository(FileOperationTXT fileOperationTXT){
        this.fileOperationTXT = fileOperationTXT;
    }
    public void saveUser(List<String> result) throws IOException {
//        String firstName = result.get(0);
        String fileName = result.get(0);
        if (result.get(5).equalsIgnoreCase("f")){
            fileName = fileName.replaceFirst(".$","");

        }
        String user = mapper.map(result);
        fileOperationTXT.saveAllLines(user, fileName);
    }
}
