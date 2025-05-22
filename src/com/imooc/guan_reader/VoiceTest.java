package com.imooc.guan_reader;
//说明TTS类的使用过程
import com.imooc.ireader.utils.TTS;

public class VoiceTest {
    public static void main(String[] args) {
        TTS tts = new TTS();
        tts.appid = "60588869";
        tts.apiKey = "87501c11146e2971f6e68897d0902f72";
        tts.apiSecret = "24b43bd04aecb0873f868de2f30a6aa3";
        tts.voiceLocation = "E:\\新加卷（E）\\Java学习\\Java_code\\guan_reader\\voice";
        //1.生成认证信息
        String authUrl = tts.getAuthUrl();
        //2.生成语音文件，下载到本地磁盘
        String filePath=tts.startDoTTS(authUrl , "First Java", "xiaoyan", 50, 70 );
        System.out.println(filePath);
        //3.播放语音文件
        tts.play(filePath);
    }
}
