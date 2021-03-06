package net.mingsoft.mall.parser.impl;


import com.mingsoft.parser.IParser;
import com.mingsoft.util.StringUtil;

/**
 * 内容标题(单标签)
 * 商品标题标签
 * {ms:field.title/}
 * @author 史爱华
 * 技术支持：景德镇铭飞科技
 * 官网：www.ming-soft.com
 */
public class ProductTypeTitleParser extends IParser {

	/**
	 * 文章所属栏目标题标签
	 */
	private final static String PRODUCT_TYPETITLE ="\\{ms:field.typetitle(.*)?/\\}";
	
	/**
	 * 商品栏目标签的属性 
	 */
	private  final static String TYPE = "type";
	
	/**
	 * 商品栏目标签的属性值。top表示取顶级栏目
	 */
	private final static String TYPE_TOP = "top";
	
	/**
	 * 构造标签的属性
	 * @param htmlContent原HTML代码
	 * @param newContent替换的内容
	 */
	public ProductTypeTitleParser(String htmlContent,String newContent){
		super.htmlCotent = htmlContent;
		super.newCotent = newContent;
	}
	@Override
	public String parse() {
		// TODO Auto-generated method stub
		return super.replaceAll(PRODUCT_TYPETITLE);
	}
	
	/**
	 *  是否存在type=top的属性
	 * @return　true:存在 false:不存在
	 */
	public boolean  isTop() {
		String temp  = super.getProperty(PRODUCT_TYPETITLE).get(TYPE);
		if (StringUtil.isBlank(temp)) {
			return false;
		} else {
			return temp.equalsIgnoreCase(TYPE_TOP) ;
		}
	}

}
