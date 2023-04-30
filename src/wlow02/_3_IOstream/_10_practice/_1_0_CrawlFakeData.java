package wlow02._3_IOstream._10_practice;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// 网络爬虫爬取数据
public class _1_0_CrawlFakeData {
    public static void main(String[] args) throws IOException {
        // 数据源网址:
        // 百家姓
        String lastNamesURL = "https://hanyu.baidu.com/shici/detail?from=kg1&highlight=&pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&srcid=51369";
        // 男名
        String boyNamesURL = "http://www.haoming8.cn/baobao/10881.html";
        // 女名
        String girlNamesURL = "http://www.haoming8.cn/baobao/7641.html";

        // 以下操作都可以用Hutool包里的API实现

        ArrayList<String> lnRaw = filter(webCrawler(lastNamesURL), ".{4}(?=[，。])", 0);
        ArrayList<String> boyNamesRaw = filter(webCrawler(boyNamesURL), "[一-龥]{2}(?=、|。)", 0);
        // 📌📌当目标中格式相似的字符串太多时, 可以扩大格式搜索范围.
        // 比如查找aa bb cc dd , 用regex: ..{2}, 但是这个匹配范围太广了, 应该更独特--> ..{2}( ..{2}){3}
        ArrayList<String> girlNamesRaw = filter(webCrawler(girlNamesURL), "..( ..){4}", 0);

        // 处理获得的初始数据
        // 分割
        ArrayList<String> lastNames = lnRaw.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<String> girlNames = girlNamesRaw.stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toCollection(ArrayList::new));
        // 去重
        ArrayList<String> boyNames = boyNamesRaw.stream()
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

        // 写入处理好的数据到txt文件中. 格式: 姓名-性别-年龄
        PrintWriter pw = new PrintWriter(new FileWriter("IOPractice/crawledData/data.txt"));
        ArrayList<String> info = createInfo(lastNames, boyNames, girlNames, 15, 15);
        for (String s : info) {
            pw.println(s);
        }
        pw.close();
    }

    // 从网络上爬取数据, 拼接成一个字符串并返回
    public static String webCrawler(String url) throws IOException {
        URL u = new URL(url);
        URLConnection conn = u.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null) {
            sb.append(str).append("\n");
        }
        return sb.toString();
    }

    // 过滤爬取到的数据 第三个参数传递最终捕获分组后要获取的组号
    public static ArrayList<String> filter(String raw, String regex, int group) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(raw);
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group(group));
        }
        // 或者利用捕获分组: regex=(.)(.)(.)(.)，(.)(.)(.)(.)。(?=</br>|</div>),
        // 然后获取m.group(1) + m.group(2) + m.group(3) + m.group(4) + m.group(5) + m.group(6) + m.group(7) + m.group(8)
        return list;
    }

    // 根据爬取到的数据创建包含符合格式数据(姓名-性别-年龄)的集合
    // 后两个参数分别传递男名个数, 女名个数
    public static ArrayList<String> createInfo(ArrayList<String> lastNames, ArrayList<String> boys, ArrayList<String> girls, int boyCount, int girlCount) {
        ArrayList<String> infoList = new ArrayList<>(), tar;
        StringBuilder sb = new StringBuilder();
        // 利用HashSet生成不重复的名字
        LinkedHashSet<String> names = new LinkedHashSet<>(boyCount + girlCount);
        // 因为可能生成重复的名字, 所以不能用(boyCount + girlCount).fori
        while (names.size() < boyCount + girlCount){
            tar = names.size() < boyCount ? boys : girls;
            sb.append(lastNames.get((int) (Math.random() * lastNames.size())))
                    .append(tar.get((int) (Math.random() * tar.size())))
                    .append("-").append(names.size() < boyCount ? "男" : "女").append("-");
            names.add(sb.toString());
            sb.delete(0, sb.length());
        }
        for (String name : names) {
            infoList.add(name + (int) (Math.random() * 13 + 18)); // 18 ~ 30
        }
        Collections.shuffle(infoList);
        return infoList;
    }
}
