package wlow02_java_advance._3_IOstream;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 处理FIS和FOS相关异常
public class _2_1_HandleException {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("D:/somedir/something.lol");
            fos = new FileOutputStream("IOPractice");

            // ...一些处理逻辑...
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            // fis和fos都可能因为找不到文件或父级路径而为null
            // 所以要先进行非空判断
            if (fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
