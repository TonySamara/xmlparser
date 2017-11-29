package solution.tools;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    public static List<File> getAllXMLFilesInFolder(String directory){
    File folder = new File(directory);
    File[] files = folder.listFiles(new FileFilter() {
         @Override
         public boolean accept(File pathname) {
             if (pathname.isFile()&&pathname.getAbsolutePath().endsWith(".xml")){
                 return true;
             }
             else return false;
         }
     });
        return Arrays.asList(files);
    }
}
