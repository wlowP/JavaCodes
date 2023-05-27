package wlow02._0_Test;


import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d+([.]\\d{1,2})?");
        Matcher m = p.matcher(null);
        if(!m.matches()){
            System.out.println("不符合");
        }
        System.out.println(Double.parseDouble("011.11"));
    }
}