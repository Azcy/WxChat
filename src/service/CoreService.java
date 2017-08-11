package service;

import java.util.Date;  
import java.util.Map;  
  
import javax.servlet.http.HttpServletRequest;

import process.TulingApiProcess;
import entity.Message.resp.TextMessage;  
import util.MessageUtil;

public class CoreService {
	public String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            //textMessage.setMsgType(Constant.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setMsgType("text"); 
            textMessage.setFuncFlag(0);  
            // 文本消息  
            if (msgType.equals("text")) {  
                // 接收用户发送的文本消息内容  
                String content = requestMap.get("Content");  
                
                System.out.println("Content:"+content);
               
               String  result = new TulingApiProcess().getTulingResult(content); 
               
               System.out.println(result);
                
               //把智能机器api输出的话，设置到textMessage中
                textMessage.setContent(result);  
                //把textMEssage转成xml格式
                respMessage=MessageUtil.textMessageToXml(textMessage);  
            }   
              
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return respMessage;  
    }  
}
