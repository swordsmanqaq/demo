package cn.henghuasoft.util;/**
 * @author shkstart
 * @create 2023-03-05 20:03
 */

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 *@Auther:Jarvis
 *@Date:2023年03月2023/3/5日20:03
 *@Description:
 */
public class SendEmailUtils {

    public static JavaMailSender javaMailSender;

    public static void sendEasyEmail(String subject,String text,String addressee) throws Exception {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //设置发送人
        mailMessage.setFrom("swords_man12@163.com");
        //邮件主题
        mailMessage.setSubject(subject);
        //邮件内容
        mailMessage.setText(text);
        //收件人
        mailMessage.setTo(addressee);

        javaMailSender.send(mailMessage);

    }

    public static void sendComplexEmail(String subject,String text,String addressee) throws Exception {
        //创建复杂邮件对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //发送复杂邮件的工具类
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"utf-8");
        helper.setFrom("swords_man12@163.com");
        //主题
        helper.setSubject(subject);
        //邮件内容
        helper.setText(text,true);
//        helper.setText("<h1>恭喜你店铺审核通过，请前往链接激活店铺</h1>" + "<a href='http://localhost:8082/shop/active?shopId=1'>激活链接</a>",true);
        //添加附件
        //helper.addAttachment("罗宾.jpg",new File("C:\\Users\\hm\\Desktop\\work\\aa.jpg"));
        //helper.addAttachment("压缩文件", new File("C:\\Users\\hm\\Desktop\\20191010\\2020-02-05-智能商贸-DAY4\\resources\\resources.zip"));
        //收件人
        helper.setTo(addressee);

        javaMailSender.send(mimeMessage);
    }
}
