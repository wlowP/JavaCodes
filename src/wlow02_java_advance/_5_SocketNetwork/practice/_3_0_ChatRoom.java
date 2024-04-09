package wlow02_java_advance._5_SocketNetwork.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 聊天室
// 服务端
public class _3_0_ChatRoom {
    private static final ExecutorService threadPool = Executors.newCachedThreadPool();
    // 存储所有客户连接对象的ArrayList
    private static final ArrayList<Socket> links = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9090);
        Socket link;
        // 模拟服务端命令行操作
        new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            String command;
            while (sc.hasNextLine()) {
                command = sc.nextLine();
                switch (command) {
                    // 查看已经建立的连接个数(在线用户个数)
                    case "/links" -> System.out.println("links.size = " + links.size());
                    // 查看ServerSocket是否能关闭(没什么用)
                    case "/closeable" -> System.out.println("server.isClosed = " + server.isClosed());
                    // 关闭服务器
                    case "/shutdown" -> System.exit(0);
                    default -> System.out.println("\"" + command + "\" 不是支持的命令");
                }
            }
        }).start();
        while (!server.isClosed()) {
            link = server.accept();
            links.add(link);
            threadPool.submit(new Chat(link));
        }
    }

    static class Chat implements Runnable {
        private final Socket link;

        public Chat(Socket link) {
            this.link = link;
        }

        @Override
        public void run() {
            BufferedReader br;
            BufferedWriter bw;
            // 限制每次最多只能发送500字的消息
            char[] buffer = new char[500];
            int length;
            String message;
            InetAddress addr = link.getInetAddress();
            System.out.println("<system> " + addr.getHostAddress() + ":" + link.getPort() + " 进入了聊天室");
            try {
                br = new BufferedReader(new InputStreamReader(link.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(link.getOutputStream()));
                while ((length = br.read(buffer)) != -1) {
                    message = new String(buffer, 0, length);
                    System.out.println("<" + addr.getHostAddress() + ":" + link.getPort() + "> ");
                    System.out.print(message);
                    bw.write(message);
                    bw.flush();
                }
                System.out.println("<system> " + addr.getHostAddress() + ":" + link.getPort() + " 退出了聊天室");
                // 客户端退出时要在links列表里面删除对应的连接对象
                links.remove(link);
                link.close();
            } catch (IOException e) {
                System.err.println(Thread.currentThread().getName() + " >>> 发生异常!");
            }
        }
    }
}

class Client extends JFrame {
    private Socket link;
    private BufferedWriter bw;
    private BufferedReader br;
    private final char[] buffer = new char[500];
    private int length;
    private JTextArea msgInputArea;
    private JPanel chatView;

    public Client() {
        initFrame();
        initView();
        connect();
        setVisible(true);
    }

    private void connect() {
        try {
            link = new Socket("localhost", 9090);
            bw = new BufferedWriter(new OutputStreamWriter(link.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(link.getInputStream()));
        } catch (IOException e) {
            System.err.println("连接失败, 服务端未响应!");
        }
    }

    private void initView() {
        JLabel label;
        JScrollPane scrollPane;
        JButton button;

        label = new JLabel("输入聊天文字");
        label.setBounds(15, 301, 160, 50);
        label.setFont(new Font("微软雅黑", Font.BOLD, 20));
        add(label);

        msgInputArea = new JTextArea();
        scrollPane = new JScrollPane(msgInputArea);
        scrollPane.setBounds(15, 360, 400, 150);
        add(scrollPane);

        button = new JButton("发送");
        button.addActionListener(this::sendMessage);
        button.setBounds(15, 520, 75, 40);
        add(button);

        button = new JButton("退出聊天");
        button.addActionListener(e -> {
            try {
                if (link != null)
                    link.close();
            } catch (IOException ex) {
                System.err.println("断开连接时发生异常!");
            }
            // 彻底关闭窗口, 用JFrame的dispose方法
            dispose();
        });
        button.setBounds(100, 520, 100, 40);
        add(button);

        chatView = new JPanel();
        chatView.setLayout(null);
        chatView.setSize(600, 280);
        scrollPane = new JScrollPane(chatView);
        scrollPane.setBounds(15, 15, 400, 280);
        add(scrollPane);

        button = new JButton("测试");
        button.addActionListener(e -> {
            System.out.println("测试");
            JLabel label1 = new JLabel("<b>啊啊啊啊啊啊啊啊啊啊</b>啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
            label1.setBounds(10, 10, 1900, 50);
            chatView.add(label1);
            // 📌📌记得刷新节点, 不然界面更改显示不出来
            chatView.repaint();
        });
        button.setBounds(210, 520, 75, 40);
        add(button);
    }

    private void sendMessage(ActionEvent e) {
        String message = msgInputArea.getText();
        if (message.length() > 500){
            System.err.println("每次最多发送500个字!");
            return;
        }
        try {
            // 服务器那边是readLine读取信息的话这边记得newLine. 也不要忘了flush因为是缓存流
            bw.write(message);
            bw.newLine();
            bw.flush();
            msgInputArea.setText("");
            length = br.read(buffer);
            System.out.println(new String(buffer, 0, length));
        } catch (IOException ex) {
            System.err.println("发送消息时出现错误!");
        }
    }

    private void initFrame() {
        setSize(603, 680);
        setLocationRelativeTo(null);
        setTitle("多人聊天室");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        // 关闭窗口时把连接关了
        // WindowAdapter - 适配器设计模式 (适配了 WindowListener 接口)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if (link != null)
                        link.close();
                } catch (IOException ex) {
                    System.err.println("断开连接时发生异常!");
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}