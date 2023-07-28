import java.io.*;

public class xo {
    public static String makeString (String path) throws IOException {

        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(path))) {
            return new String(stream.readAllBytes());
        }
    }

    public static void writeFile (String pathField, String pathResult) throws IOException {
        String string = makeString(pathField);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char field = string.charAt(i);
            switch (field){
                case '0': {
                    result.append("_");
                    break;
                }
                case '1':{
                    result.append("X");
                    break;
                }
                case '2':{
                    result.append("0");
                    break;
                }
            }
        }
        try (FileWriter writer = new FileWriter(pathResult)){
            writer.write(String.valueOf(result));
        }
    }
}
