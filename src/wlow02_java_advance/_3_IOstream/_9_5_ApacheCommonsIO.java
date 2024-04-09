package wlow02_java_advance._3_IOstream;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

// 体验Apache的 Commons-io 包的功能
public class _9_5_ApacheCommonsIO {
    public static void main(String[] args) throws IOException {
        // 复制文件
        File src = new File("IOPractice/济南的冬天.txt");
        File dest = new File("IOPractice/济南的冬天_copy1.txt");
        FileUtils.copyFile(src, dest);

        // 复制文件夹
        File src1 = new File("IOPractice/zipStream");
        File dest1 = new File("IOPractice/zipStream_copy");
        //FileUtils.copyDirectory(src1, dest1);
        // 📌📌copyDir把src中的内容复制到dest, 而copyDirToDir会把src本身也搬过去
        //FileUtils.copyDirectoryToDirectory(src1, dest1);

        // 清空文件夹
        FileUtils.cleanDirectory(dest1);
    }
}
