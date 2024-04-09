package wlow02_java_advance._3_IOstream._0_0_File;

import java.io.File;
import java.io.IOException;

// 重命名文件:
public class _1_4_Rename {
    public static void main(String[] args) throws IOException {
        File f = new File("IOPractice/newname.txt");

        if (!f.exists())
            f.createNewFile();
        f.renameTo(new File("IOPractice/configFiles/newname.txt"));
    }
}
