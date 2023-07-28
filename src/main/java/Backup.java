import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.rmi.RemoteException;
import java.util.Arrays;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


public class Backup {
    public static void backupFiles(String sourcePath, String destinationPath) throws Exception {
        File source = new File(sourcePath);
        File destination = new File(destinationPath);
        if (!destination.exists()) {
            destination.mkdir();
        }
        File[] list = source.listFiles();
        for (File file : list) {
            String fileSrc = source + "//" + file.getName();
            String fileDest = destination + "//" + file.getName();
            try {
                copyFiles(fileSrc, fileDest);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void copyFiles(String fileSrc, String fileDest) throws Exception {
        try (FileInputStream in = new FileInputStream(fileSrc); FileOutputStream out = new FileOutputStream(fileDest))
        {
                byte[] buf = new byte[1024];
                int r;
                do {
                    r = in.read(buf, 0, buf.length);
                    if (r > 0) {
                        out.write(buf, 0, r);
                    }
                } while (r > 0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

