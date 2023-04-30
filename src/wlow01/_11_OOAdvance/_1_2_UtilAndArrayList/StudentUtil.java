package wlow01._11_OOAdvance._1_2_UtilAndArrayList;

import java.util.ArrayList;

public class StudentUtil {
    private StudentUtil(){}
    public static int getEldest(ArrayList<Student> list){
        int max = list.get(0).getAge();
        for (int i = 1; i < list.size(); i++) {
            int age = list.get(i).getAge();
            max = age > max ? age : max;
        }
        return max;
    }
}
