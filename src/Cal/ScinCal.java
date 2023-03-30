package Cal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ScinCal {


    private JFrame frame;

    private JTextField textField;

    private JButton[] button;

    private JPanel panel;


    /**
     * data：当前输入的数据
     */
    private String data = "";
    double lingshi;

    /**
     * isLeftAvailable：判断数据应该向哪一个操作数中存储
     */
    private boolean isLeftAvailable;

    /**
     * left, right：左右操作数
     */
    private double left, right;

    private String prevOperaotor = "";

    private double huanchong=0;

    public void init()
    {
        setMyFrame();
        setMyTextField();
        setMyButton();
        display();
    }

    private void setMyFrame()
    {
        frame = new JFrame();

        // 设置 frame 的坐标
        frame.setLocation(700, 150);
        // 设置 frame 的大小
        frame.setSize(550, 640);
        // 设置 frame 的标题
        frame.setTitle("科学计算器");
        // 禁用窗口大小调整
        frame.setResizable(true);
        //设置布局，自定义
        frame.setLayout(null);
        // 关闭窗体
        JMenuBar bar = new JMenuBar();
        JMenu M_fun = new JMenu("功能");


        frame.setJMenuBar(bar);
        bar.add(M_fun);
        JMenuItem MI_Stad = new JMenuItem("标准计算器");
        JMenuItem MI_caogao = new JMenuItem("草稿");
        JMenuItem MI_Scin = new JMenuItem("科学计算器");


        M_fun.add(MI_Stad);
        M_fun.add(MI_Scin);
        M_fun.add(MI_caogao);
        MI_Stad.addActionListener( new ActionListener() {

                                       @Override
                                       public void actionPerformed(ActionEvent e) {
                                           // TODO 自动生成的方法存根
                                           StanCal bz = new StanCal();
                                           bz.init();
                                           frame.setVisible(false);
                                       }
                                   }
        );
        MI_caogao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                HandDraw hDraw = new HandDraw();
                JFrame jf1 = new JFrame("草稿");
                jf1.add(hDraw);
                jf1.setVisible(true);
                jf1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jf1.setSize(500,500);
            }
        });
    }

    /**
     *  setMyTextField：
     *  设置文本域
     */
    private void setMyTextField()
    {
        textField = new JTextField("0");

        // 设置文本框大小位置
        textField.setBounds(20,15,500,60);
        // 设置文本框字体
        textField.setFont(new Font("黑体", Font.BOLD, 35));
        // 设置背景颜色
        textField.setBackground(new Color(	230, 230, 250));

        frame.add(textField);
    }

    private void setMyButton()
    {
        // 按钮文本
        String[] arr =
                { "|x|","^2","^3","MC","M+","M-","MR",
                        "acos","3√","2√","1/x","C","*","/",
                        "asin","e","PI","7","8","9","→",
                        "atan","ln","log","4","5","6","+",
                        "X!","sin","cos","1","2","3","-",
                        "^","tan","+/-","%","0",".","="};
        // 按钮
        button = new JButton[arr.length];

        // 创建面板
        panel = new JPanel();

        // 设置面板的布局方式
        panel.setBounds(20, 90, 500, 450);

        // 网格布局
        panel.setLayout(new GridLayout(6, 7, 8, 8));

        for(int i = 0; i < button.length; i++)
        {
            // 创建按钮
            button[i] = new JButton(arr[i]);

            // 设置按钮字体
            button[i].setFont(new Font("黑体", Font.CENTER_BASELINE, 10));
            // 设置按钮背景颜色
            button[i].setBackground(new Color(242, 240, 235));

            // 设置 = 号的特殊颜色
            if(button.length - 1 == i)
            {
                button[i].setBackground(new Color(211, 120, 129));
            }

            // 添加事件
            int idx = i;
            // 设置鼠标监听
            button[i].addMouseListener(new MouseAdapter() {
                // 点击事件
                @Override
                public void mouseClicked(MouseEvent e) {
                    // 获取按钮上的内容
                    click(button[idx].getText());
                }

                // 鼠标进入组件事件
                @Override
                public void mouseEntered(MouseEvent e) {
                    button[idx].setFont(new Font("黑体", Font.CENTER_BASELINE, 20));
                    button[idx].setBackground(new Color(240, 255, 255));
                    button[idx].setForeground(new Color(255, 99, 71));
                }

                // 鼠标离开组件事件
                @Override
                public void mouseExited(MouseEvent e) {
                    button[idx].setFont(new Font("黑体", Font.CENTER_BASELINE, 10));
                    button[idx].setBackground(new Color(242, 240, 235));
                    button[idx].setForeground(new Color(0, 0, 0));
                }
            });

            // 按钮添加到面板
            panel.add(button[i]);
        }

        frame.add(panel);
    }
    public void click(String content) {
        String operator = "";

        try {
            if("1".equals(content)) {
                data += "1";
                textField.setText(data);
            }else if("2".equals(content)){
                data += "2";
                textField.setText(data);
            }else if("3".equals(content)){
                data += "3";
                textField.setText(data);
            }else if("4".equals(content)){
                data += "4";
                textField.setText(data);
            }else if("5".equals(content)){
                data += "5";
                textField.setText(data);
            }else if("6".equals(content)){
                data += "6";
                textField.setText(data);
            }else if("7".equals(content)){
                data += "7";
                textField.setText(data);
            }else if("8".equals(content)){
                data += "8";
                textField.setText(data);
            }else if("9".equals(content)){
                data += "9";
                textField.setText(data);
            }else if("0".equals(content)){
                data += "0";
                textField.setText(data);
            }else if(".".equals(content)){
                data += ".";
                textField.setText(data);
            }else if("e".equals(content)){
                data += Math.E;
                textField.setText(data);
            }else if("PI".equals(content)){
                data += Math.PI;
                textField.setText(data);
            }else if ("M+".equals(content)) {
                huanchong+=Double.parseDouble(data);
                textField.setText(data);
            }else if ("M-".equals(content)) {
                huanchong-=Double.parseDouble(data);
                textField.setText(data);
            }else if ("MR".equals(content)) {
                data+=huanchong;
                textField.setText(data);
            }
            else if ("MC".equals(content)) {
                huanchong = 0;
                textField.setText(data);
            }
            else if("+/-".equals(content)){
                // 找不到负号，代表这是正数
                if(data.indexOf('-') < 0)
                {
                    data = "-" + data;
                }
                // 负数
                else
                {
                    data = data.substring(1);
                }
                textField.setText(data);
            }else if("%".equals(content)){
                data = Double.parseDouble(data) / 100 + "";
                textField.setText(data);
            }else if("+".equals(content)){
                operator = "+";
                cal(operator);
            }else if("-".equals(content)){
                operator = "-";
                cal(operator);
            }else if("*".equals(content)){
                operator = "*";
                cal(operator);
            }else if("/".equals(content)){
                operator = "/";
                cal(operator);
            }else if ("^".equals(content)) {
                operator = "^";
                cal(operator);
            }else if("=".equals(content)){
                operator = "=";
                cal(operator);
            }else if("del".equals(content)){
                if(data.length() != 0)
                {
                    data = data.substring(0, data.length() - 1);
                }
                textField.setText(data);
            }else if("C".equals(content)){
                data = "";
                isLeftAvailable = false;
                textField.setText(data);
            }else if("^2".equals(content)){
                data=Double.parseDouble(data)*Double.parseDouble(data)+"";
                textField.setText(data);
            }else if("^3".equals(content)) {
                data=Double.parseDouble(data)*Double.parseDouble(data)*Double.parseDouble(data)+"";
                textField.setText(data);
            }else if ("3√".equals(content)) {
                data = Math.pow(Double.parseDouble(data), 1/3.0)+"";
                textField.setText(data);
            }
            else if ("2√".equals(content)) {
                data = Math.pow(Double.parseDouble(data), 1/2.0)+"";
                textField.setText(data);
            }else if ("X!".equals(content)) {
                lingshi = Double.parseDouble(data);
                if(lingshi == 0||lingshi == 1)
                    lingshi = 1;
                else {
                    for(int i = (int)lingshi-1;i>1;i--) {
                        lingshi *=i;
                    }
                }
                data=Double.parseDouble(data)+lingshi+"";
                textField.setText(data);
            }
            else if ("acos".equals(content)) {
                data=Math.acos(Double.parseDouble(data))+"";
                textField.setText(data);
            }
            else if ("asin".equals(content)) {
                data=Math.asin(Double.parseDouble(data))+"";
                textField.setText(data);
            }
            else if ("atan".equals(content)) {
                data=Math.atan(Double.parseDouble(data))+"";
                textField.setText(data);
            }
            else if ("cos".equals(content)) {
                data=Math.cos(Double.parseDouble(data))+"";
                textField.setText(data);
            }
            else if ("sin".equals(content)) {
                data=Math.sin(Double.parseDouble(data))+"";
                textField.setText(data);
            }
            else if ("tan".equals(content)) {
                data=Math.tan(Double.parseDouble(data))+"";
                textField.setText(data);
            }
            else if ("|x|".equals(content)) {
                data=Math.abs(Double.parseDouble(data))+"";
                textField.setText(data);
            }
            else if ("1/x".equals(content)) {
                data=1/Double.parseDouble(data)+"";
                textField.setText(data);
            }
            else if ("ln".equals(content)) {
                data=Math.log(Double.parseDouble(data))+"";
                textField.setText(data);
            }
            else if ("log".equals(content)) {
                data=Math.log10(Double.parseDouble(data))+"";
                textField.setText(data);
            }
        } catch (ArithmeticException e) {
            textField.setText("除数不能为0");
        }
    }
    private void cal(String operator)
    {
        // 如果 data 为空，不执行任何操作
        if("".equals(data))
        {
            // 用户只要输入 = ，无论前面的输入是否合法，结束此轮计算
            if("=".equals(operator))
            {
                isLeftAvailable = false;
            }
            return;
        }

        /**
         * 第一次把 data 中的数据赋给 left
         * 此后，每次运算都将 right 与 left 运算的结果放入 left 中，并显示 left
         * 运算符 = 使用后可以重新向 left 中输入值
         * 每次获取到 data 中的值后清空 data
         *
         * 每次运算使用上一次传入的运算符，等号出现重新开始新的计算
         */

        if(isLeftAvailable)
        {
            right = Double.parseDouble(data);
            data = "";

            // 使用前一个运算符
            if("+".equals(prevOperaotor))
            {
                left += right;
            }
            else if("-".equals(prevOperaotor))
            {
                left -= right;
            }
            else if("*".equals(prevOperaotor))
            {
                left *= right;
            }
            else if("/".equals(prevOperaotor))
            {
                left /= right;
            }
            else if("^".equals(prevOperaotor))
            {
                left = Math.pow(left, right);
            }

            // 如果运算结果为整数，就用整数输出
            if(left == (int)left)
            {
                left = (int)left;
            }

        }
        else
        {
            left = Double.parseDouble(data);
            // 清空 data
            data = "";
            isLeftAvailable = true;
        }

        // 将运算结果转换为字符串
        String result = left + "";

        // "=" 操作符清理右操作数，重新开始计算
        if("=".equals(operator))
        {
            isLeftAvailable = false;
        }
        // 更新运算符
        if(operator.equals("=")==false) {
            prevOperaotor = operator;
            textField.setText(result + " " +operator);
        }
        else {
            prevOperaotor = operator;
            textField.setText(operator+ " "+result);
        }
    }

    public void display()
    {
        // 设置关闭 frame 窗口时退出程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置 frame 可见，默认值为 false
        frame.setVisible(true);
    }

}
