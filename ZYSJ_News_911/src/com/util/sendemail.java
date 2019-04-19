package com.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class sendemail {

	public static int send(String con,String sendto) {
		MailBean mb = new MailBean();
        mb.setHost("smtp.163.com");                        // 设置SMTP主机(163)，若用126，则设为：smtp.126.com
        mb.setUsername("a547074604");                // 设置发件人邮箱的用户名
        mb.setPassword("1234asdf");                        // 设置发件人邮箱的密码，需将*号改成正确的密码
        mb.setFrom("a547074604@163.com");            // 设置发件人的邮箱
        mb.setTo(sendto);                // 设置收件人的邮箱
        mb.setSubject("911指尖资讯平台");                    // 设置邮件的主题
        mb.setContent("您的验证码是:"+con);        // 设置邮件的正文


        
        SendMail sm = new SendMail();
        System.out.println("正在发送邮件...");
        
        if(sm.sendMail(mb))  {                              // 发送邮件
            System.out.println("发送成功!");
            return 1;
            
        }
        	
        else {
            System.out.println("发送失败!");
            return 0;
        }
    }
    
	} 

 class MailBean {

    private String to;                                // 收件人
    private String from;                            // 发件人
    private String host;                            // SMTP主机
    private String username;                        // 发件人的用户名
    private String password;                        // 发件人的密码
    private String subject;                            // 邮件主题
    private String content;                            // 邮件正文
    Vector<String> file;                            // 多个附件
    private String filename;                        // 附件的文件名
    
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
    	
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Vector<String> getFile(){
        return file;
    }
    
    public void attachFile(String fileName) {
        if(file == null)
            file = new Vector<String>();
        file.addElement(fileName);
    }
}
 class SendMail {

	    public String toChinese(String text) {
	        try {
	            text = MimeUtility.encodeText(new String(text.getBytes(), "utf-8"), "utf-8", "B");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return text;
	    }


	    public boolean sendMail(MailBean mb) {
	        String host = mb.getHost();
	        final String username = mb.getUsername();
	        final String password = mb.getPassword();
	        String from = mb.getFrom();
	        String to = mb.getTo();
	        String subject = mb.getSubject();
	        String content = mb.getContent();
	        String fileName = mb.getFilename();
	        Vector<String> file = mb.getFile();
	        
	        
	        Properties props = System.getProperties();
	        props.put("mail.smtp.host", host);                // 设置SMTP的主机
	        props.put("mail.smtp.auth", "true");            // 需要经过验证
	        
	        Session session = Session.getInstance(props, new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        });

	        try {
	            MimeMessage msg = new MimeMessage(session);
	            msg.setFrom(new InternetAddress(from));
	            InternetAddress[] address = {new InternetAddress(to)};
	            msg.setRecipients(Message.RecipientType.TO, address);
	            msg.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
	            msg.setSubject(toChinese(subject));
	           
	            Multipart mp = new MimeMultipart();
	            MimeBodyPart mbpContent = new MimeBodyPart();
	            mbpContent.setText(content);
	            mp.addBodyPart(mbpContent);


	            msg.setContent(mp);
	            msg.setSentDate(new Date());
	            Transport.send(msg);
	            
	        } catch (MessagingException me) {
	            me.printStackTrace();
	            return false;
	        }
	        return true;
	    }

	}
