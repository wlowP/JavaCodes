package wlow02._0_Test;


import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new File("").getCanonicalFile());
    }
}