package org.cwjweixin.weixin.controller;


import java.io.IOException;
import org.cwjweixin.weixin.domain.InMessage;
import org.cwjweixin.weixin.service.MessageConvertHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

// @RestController是满足RESTful风格的一种控制器实现，实际上它还是@Controller。
// 但是@RestController只是返回内容，不返回视图（JSP、HTML）。
@RestController
// 路径和类的映射关系
// <url-pattern> 用于映射URL和Servlet的关系
// 如果多人共享一台服务器，把kemao_2改为姓名的拼音
@RequestMapping("/weixin_2/message/receiver")
public class MessageReceiverController {

	// 日志记录器
		private static final Logger LOG = LoggerFactory.getLogger(MessageReceiverController.class);
	
		// 这种是属性注入，相当于是XML文件中的<property>元素
		@Autowired
		private XmlMapper xmlMapper;
		
		
		// 注意：控制器里面必须要有处理器方法（Handler Method）才能执行操作，才不会404
	// 处理GET请求，HTTP协议支持GET、POST、PUT、DELETE等请求方式，都有对应的注解
		@Autowired
		private RedisTemplate<String, ? extends InMessage> inMessageTemplate;
		
	@GetMapping
	public String echo(//
			@RequestParam("signature") String signature, //
			@RequestParam("timestamp") String timestamp, //
			@RequestParam("nonce") String nonce, //
			@RequestParam("echostr") String echostr//
	//
	) {
		return echostr;
	}
	
	@PostMapping
	// @RequestBody注解表示把请求内容获取出来，并且转换为String传入给xml参数。
	public String onMessage(//
			@RequestParam("signature") String signature, //
			@RequestParam("timestamp") String timestamp, //
			@RequestParam("nonce") String nonce, //
			@RequestBody String xml) throws JsonParseException, JsonMappingException,IOException {
		// 收到消息
		// {}是占位符，第一个{}会把第二个参数的值自动填入
		// LOG.trace必须要求日志记录器的配置为trace级别才能输出
		LOG.trace("收到的消息原文：\n{}\n------------------------------", xml);
		// 转换消息
		
		// 转换消息1.获取消息的类型
//		String type=xml.substring(xml.indexOf("<MsgType><![CDATA[")+18);
//		type=type.substring(0,type.indexOf("]"));
		// 转换消息2.根据消息类型，把XML转换为对应类型的对象
		
		InMessage inMessage=convert(xml);
		if(inMessage==null) {
			LOG.error("信息无法转换！原文:\n{}\n",xml);
			return "success";
		}
		LOG.debug("转换后的消息对象\n{}\n",inMessage);
		String channel= "weixin_2_" + inMessage.getMygType();
		// 把消息丢入队列
//		ByteArrayOutputStream bos=new ByteArrayOutputStream();//另一种方法
//		ObjectOutputStream out=new ObjectOutputStream(bos);
//		out.writeObject(inMessage);
//		byte[] data = bos.toByteArray();
//		
//		inMessageTemplate.execute(new RedisCallback<InMessage>() {
//
//			@Override
//			public InMessage doInRedis(RedisConnection connection) throws DataAccessException {
//				// TODO Auto-generated method stub
//				String channel="weixin_2_"+inMessage.getMygType();
//				connection.publish(channel.getBytes(), data);
//				
//				return null;
//			}
//		});
		inMessageTemplate.convertAndSend(channel, inMessage);
		
		// 消费队列中的消息
		// 产生客服消息

		return "success";
	}
	private InMessage convert(String xml) throws JsonParseException, JsonMappingException, IOException {
		Class<? extends InMessage> c = MessageConvertHelper.getClass(xml);
		InMessage msg = xmlMapper.readValue(xml, c);
		return msg;
	}
}
