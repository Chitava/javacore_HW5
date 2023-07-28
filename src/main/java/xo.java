import java.io.*;

public class xo {
    public static String makeString(String path) throws IOException {

        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(path))) {
            return new String(stream.readAllBytes());
        }
    }

    public static void writeFile(String pathField, String pathResult) throws IOException {
        int field = Integer.parseInt(makeString(pathField));
        StringBuilder result = new StringBuilder();
        int symbol;
        while (field > 0) {
            symbol = field % 10;
            field = field / 10;
            switch (symbol) {
                case 0: {
                    result.append("•");
                    break;
                }
                case 1: {
                    result.append("X");
                    break;
                }
                case 2: {
                    result.append("0");
                    break;
                }
            }
        }
        result.reverse();
        try (FileWriter writer = new FileWriter(pathResult)) {
            writer.write(String.valueOf(result));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}
