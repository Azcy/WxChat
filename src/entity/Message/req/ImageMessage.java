package entity.Message.req;
/**
 * 接收图片信息
 * @author zcy
 *
 */

public class ImageMessage extends BaseMessage{  
	  
    private String picUrl;  
  
    public String getPicUrl() {  
        return picUrl;  
    }  
  
    public void setPicUrl(String picUrl) {  
        this.picUrl = picUrl;  
    }  
      
}  