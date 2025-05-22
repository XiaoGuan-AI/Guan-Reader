import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;
import com.imooc.ireader.utils.TTS;
import org.apache.commons.io.FileUtils;
/*
 * Created by JFormDesigner on Wed Mar 24 19:43:12 CST 2021
 */



/**
 * @author 赵迦南
 */
public class MainForm extends JPanel {
    private int speed = 40;
    private int volume = 60;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //ImageIcon是创建一个Swing的图片对象，指向运行环境images目录的bg.png文件
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/bg.png"));
        //在界面上绘制图片，将图片大小设置与界面大小相同
        g.drawImage(icon.getImage(),0,0,this.getWidth(),this.getHeight(),this);
    }

    private void doTTS(String voiceName){
        String text = this.areaText.getText();
        //trim()方法用于删除字符串前后的空格
        if(text.trim().length() == 0){
            JOptionPane.showMessageDialog(null,"请输入文本内容","警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(text.trim().length() > 10000){
            JOptionPane.showMessageDialog(null,"文本最大长度不得超过10000字","警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        TTS tts = new TTS();
        tts.appid = "60588869";
        tts.apiKey = "87501c11146e2971f6e68897d0902f72";
        tts.apiSecret = "24b43bd04aecb0873f868de2f30a6aa3";
        tts.voiceLocation = "E:\\新加卷（E）\\Java学习\\Java_code\\guan_reader\\voice";
        //1.生成认证信息
        String authUrl = tts.getAuthUrl();
        //2.生成语音文件，下载到本地磁盘
        String filePath=tts.startDoTTS(authUrl ,  text, voiceName, this.speed, this.volume );
        System.out.println(filePath);
        //3.播放语音文件
        tts.play(filePath);
        System.out.println("音量："+this.volume);
        System.out.println("语速："+this.speed);
    }
    public MainForm() {

        initComponents();
        this.sldSpeed.setValue(this.speed);
        this.sldVolume.setValue(this.volume);
    }

    public static void main(String[] args) {
        //创建窗口对象
        JFrame jFrame = new JFrame();
        //设置窗口大小
        jFrame.setSize(900,790);
        //设置窗口大小不可以改变
        jFrame.setResizable(false);
        //点击关闭时退出
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //实例化窗体主界面
        jFrame.setContentPane(new MainForm());
        //设置窗体名称
        jFrame.setTitle("小关听书");
        //设置显示界面
        jFrame.setVisible(true);
    }

    private void btnMaleMouseClicked(MouseEvent e) {
        // TODO add your code here
        this.doTTS("aisjiuxu");
    }

    private void sldSpeedStateChanged(ChangeEvent e) {
        // TODO add your code here
        this.speed = this.sldSpeed.getValue();
    }

    private void sldVolumeStateChanged(ChangeEvent e) {
        // TODO add your code here
        this.volume = this.sldVolume.getValue();
    }

    private void btnFemaleMouseClicked(MouseEvent e) {
        // TODO add your code here
        this.doTTS("xiaoyan");
    }

    private void btnChooseMouseClicked(MouseEvent e) {
        // TODO add your code here
        JFileChooser chooser = new JFileChooser();
        //打开对话框
        chooser.showOpenDialog(chooser);
        //获取可选择的文件
        File file = chooser.getSelectedFile();
        if(file == null){//null就是空，代表点击取消按钮
            return;
        }
        if(file.exists() == false){
            JOptionPane.showMessageDialog(null,"文件不存在，请重新选择！","警告",JOptionPane.WARNING_MESSAGE);
            return;
        }

        //设置文本
        txtFile.setText(file.getPath());
        //读取txt文本内容
        try {
           String content = FileUtils.readFileToString(file,"UTF-8");
           this.areaText.setText(content);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        this.doTTS("aisbabyxu");
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 赵迦南
        label1 = new JLabel();
        txtFile = new JTextField();
        btnChoose = new JButton();
        scrollPane1 = new JScrollPane();
        areaText = new JTextArea();
        label2 = new JLabel();
        label3 = new JLabel();
        sldSpeed = new JSlider();
        sldVolume = new JSlider();
        btnMale = new JButton();
        btnFemale = new JButton();
        button4 = new JButton();

        //======== this ========
        setBackground(new Color(153, 153, 153));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax .
        swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing .border
        . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dialo\u0067"
        , java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder
        () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java
        . beans. PropertyChangeEvent e) { if( "borde\u0072" .equals ( e. getPropertyName () ) )throw new RuntimeException
        ( ) ;} } );
        setLayout(null);

        //---- label1 ----
        label1.setText("\u6587\u4ef6");
        label1.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 20));
        label1.setForeground(Color.white);
        add(label1);
        label1.setBounds(55, 40, 40, 24);

        //---- txtFile ----
        txtFile.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 20));
        txtFile.setEditable(false);
        add(txtFile);
        txtFile.setBounds(110, 35, 605, 35);

        //---- btnChoose ----
        btnChoose.setText("\u9009\u62e9");
        btnChoose.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 20));
        btnChoose.setForeground(Color.white);
        btnChoose.setBackground(new Color(8, 145, 224));
        btnChoose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnChooseMouseClicked(e);
            }
        });
        add(btnChoose);
        btnChoose.setBounds(730, 35, 105, 35);

        //======== scrollPane1 ========
        {

            //---- areaText ----
            areaText.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 20));
            areaText.setLineWrap(true);
            scrollPane1.setViewportView(areaText);
        }
        add(scrollPane1);
        scrollPane1.setBounds(25, 85, 845, 370);

        //---- label2 ----
        label2.setText("\u8bed\u901f");
        label2.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 20));
        label2.setForeground(Color.white);
        add(label2);
        label2.setBounds(140, 470, 40, 24);

        //---- label3 ----
        label3.setText("\u97f3\u91cf");
        label3.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 20));
        label3.setForeground(Color.white);
        add(label3);
        label3.setBounds(140, 505, 40, 24);

        //---- sldSpeed ----
        sldSpeed.setOpaque(false);
        sldSpeed.addChangeListener(e -> sldSpeedStateChanged(e));
        add(sldSpeed);
        sldSpeed.setBounds(220, 470, 530, sldSpeed.getPreferredSize().height);

        //---- sldVolume ----
        sldVolume.setOpaque(false);
        sldVolume.addChangeListener(e -> sldVolumeStateChanged(e));
        add(sldVolume);
        sldVolume.setBounds(220, 505, 530, sldVolume.getPreferredSize().height);

        //---- btnMale ----
        btnMale.setIcon(new ImageIcon(getClass().getResource("/images/btn_male.png")));
        btnMale.setBackground(new Color(153, 153, 153));
        btnMale.setOpaque(false);
        btnMale.setBorderPainted(false);
        btnMale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnMaleMouseClicked(e);
            }
        });
        add(btnMale);
        btnMale.setBounds(254, 570, 100, 100);

        //---- btnFemale ----
        btnFemale.setIcon(new ImageIcon(getClass().getResource("/images/btn_female.png")));
        btnFemale.setBackground(new Color(153, 153, 153));
        btnFemale.setOpaque(false);
        btnFemale.setBorderPainted(false);
        btnFemale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnFemaleMouseClicked(e);
            }
        });
        add(btnFemale);
        btnFemale.setBounds(400, 570, 100, 100);

        //---- button4 ----
        button4.setIcon(new ImageIcon(getClass().getResource("/images/btn_henan.png")));
        button4.setBackground(new Color(153, 153, 153));
        button4.setOpaque(false);
        button4.setBorderPainted(false);
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked(e);
            }
        });
        add(button4);
        button4.setBounds(550, 570, 100, 100);

        setPreferredSize(new Dimension(900, 765));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 赵迦南
    private JLabel label1;
    private JTextField txtFile;
    private JButton btnChoose;
    private JScrollPane scrollPane1;
    private JTextArea areaText;
    private JLabel label2;
    private JLabel label3;
    private JSlider sldSpeed;
    private JSlider sldVolume;
    private JButton btnMale;
    private JButton btnFemale;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
