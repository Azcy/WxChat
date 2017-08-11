package entity.Message.req;

/**
 * 接收文本信息
 * @author zcy
 *
 */
public class TextMessage extends BaseMessage {
	 /** 
     * 回复的消息内容 
     */  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  

}
