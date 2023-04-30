package wlow02._3_IOstream;

import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

// 压缩流
public class _9_0_ZipStream {
    public static void main(String[] args) throws IOException {
        // 📌📌注意Java只能处理.zip格式的压缩包

        // 压缩包源文件
        // 📌📌创建压缩包时别用win11自带的'压缩为zip'(好压可以), 那样的话ZipInputStream会
        // 读不到压缩包里的第一级文件夹
        File src = new File("IOPractice/zipStream/myzip.zip");
        // 解压到的目的地
        File dest = new File("IOPractice/zipStream/decompression");
        unzipTo(src, dest);

        // 压缩单个文件
        File src1 = new File("IOPractice/zipStream/txtToBeZipped.txt");
        File dest1 = new File("IOPractice/zipStream");
        // zipFile(src1, dest1);

        // 压缩文件夹
        File src2 = new File("IOPractice/zipStream/dirToBeZipped");
        File dest2 = new File("IOPractice/zipStream");
        // zipDir(src2, dest2);

        // 压缩文件夹 - model answer
        //toZip(src2);
    }

    // 解压缩: 把压缩包里面每一个文件/文件夹读取出来, 按照层级拷贝到对应目的地中
    public static void unzipTo(File src, File dest) throws IOException{
        /*因为Windows环境下默认字符集为GBK(ANSI), 当右键创建.zip压缩包时使用的GBK编码
        * 📌📌而ZIS默认用的UTF-8, 所以当压缩包里面有名字含中文的文件/文件夹时会报错
        * 📌📌所以此时可以在ZIS构造方法里面传递Charset指定字符集.
        * */
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src), Charset.forName("GBK"));
        // 压缩包里面的每一个文件/文件夹实质上都是一个ZipEntry对象, 要先获取之
        // getNextEntry方法会递归遍历压缩包, 获取每一个文件/文件夹, 获取完了再获取会返回null
        ZipEntry entry;
        byte[] buffer = new byte[1024 * 5];
        int count;
        File target;
        BufferedOutputStream bos;
        while ((entry = zis.getNextEntry()) != null){
            // 用ZipEntry对象的isDirectory方法判定其是否为文件夹(没有isFile)
            if (entry.isDirectory()){
                // 如果是文件夹, 创建对应目录
                new File(dest, entry.getName()).mkdirs();
            }else {
                // 如果是文件, 按照层级复制过去.
                target = new File(dest, entry.getName());
                // 📌📌有时候getNextEntry会返回a/b.txt而不是第一级目录a/, 所以最好mkdir
                target.getParentFile().mkdirs();
                bos = new BufferedOutputStream(new FileOutputStream(target));
                while ((count = zis.read(buffer)) != -1)
                    bos.write(buffer, 0, count);
                bos.close();
            }
            zis.closeEntry(); // 📌表示在压缩包中的一个文件处理完毕了
        }
        zis.close();
    }



    // 压缩单个文件: 📌实质是把文件变成ZipEntry对象放到压缩包中
    // --> 在文件同级目录下创建压缩包
    public static void zipFile(File src, File dest) throws IOException{
        // 创建ZOS对象包装FOS对象, 关联对应dest路径
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dest, "compressed.zip")));
        // 📌📌创建ZipEntry对象表示压缩包里面的每一个文件/文件夹
        ZipEntry entry = new ZipEntry(src.getName());
        // 📌📌接着把ZipEntry对象放到压缩包中, 调用ZOS的putNextEntry方法
        zos.putNextEntry(entry);
        // 📌📌然后再将数据写入ZipEntry对象中(字节流读取, ZOS写出)
        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream(src));
        int count;
        byte[] buffer = new byte[1024 * 5];
        while ((count = bis.read(buffer)) != -1)
            zos.write(buffer, 0, count);
        bis.close();
        zos.closeEntry();
        zos.close();
    }



    // 压缩文件夹 (📌📌ZipEntry构造方法传递多层文件夹路径再putNextEntry的话会在对应的压缩包中体现出层级来.)
    public static void zipDir(File src, File dest) throws IOException{
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest + "/" + src.getName() + ".zip"));
        byte[] buffer = new byte[1024 * 1024 * 5]; // 5MB缓存
        // 📌📌第一次传入文件夹时: 为防止putNextEntry的时候将entry看做文件而不是文件夹, 在文件夹的路径后面加个"/"
        zipDir(src, new File(src.getName(), "/"), zos, buffer);
        zos.close();
    }
    private static void zipDir(File src, File dest, ZipOutputStream zos, byte[] buffer) throws IOException{
        if (src.isFile()){
            ZipEntry entry = new ZipEntry(dest.toString()); // ZipEntry构造方法必须传递字符串
            zos.putNextEntry(entry);
            BufferedInputStream bis =
                    new BufferedInputStream(new FileInputStream(src));
            int count;
            while ((count = bis.read(buffer)) != -1)
                zos.write(buffer, 0, count);
            bis.close();
            zos.closeEntry();
        }else {
            // 遇到文件夹时, 📌📌※※由于ZipEntry对象构造方法可以传递带层级的文件夹路径, 故不需要特地为文件夹创建ZipEntry对象
            for (File nextSrc : src.listFiles()) {
                zipDir(nextSrc, new File(dest, nextSrc.getName()), zos, buffer);
            }
        }
    }
    // 不传递dest的话默认压缩至原文件夹同级目录
    public static void zipDir(File src) throws IOException{
        File parent = src.getParentFile(); // 获取到src文件的父级目录(返回File对象)
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(parent + "/" + src.getName() + ".zip"));
        byte[] buffer = new byte[1024 * 1024 * 5];
        zipDir(src, new File(src.getName(), "/"), zos, buffer);
        zos.close();
    }



    // 压缩文件夹model(压缩到原文件夹的同级目录):
    public static void toZip(File src) throws IOException{
        File destParent = src.getParentFile();
        // 创建File对象表示压缩包的路径
        File dest = new File(destParent,src.getName() + ".zip");
        // 创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        // 获取src里面的每一个文件，变成ZipEntry对象，放入到压缩包当中
        toZip(src,zos,src.getName());
        zos.close();
    }
    private static void toZip(File src,ZipOutputStream zos,String name) throws IOException {
        // 进入src文件夹
        File[] files = src.listFiles();
        // 遍历数组
        for (File file : files) {
            if(file.isFile()){
                // 判断-文件，变成ZipEntry对象，放入到压缩包当中
                ZipEntry entry = new ZipEntry(name + "\\" + file.getName());//aaa\\no1\\a.txt
                zos.putNextEntry(entry);
                //读取文件中的数据，写到压缩包
                FileInputStream fis = new FileInputStream(file);
                int b;
                while((b = fis.read()) != -1){
                    zos.write(b);
                }
                fis.close();
                zos.closeEntry();
            }else{
                toZip(file,zos,name + "/" + file.getName());
            }
        }
    }
}
