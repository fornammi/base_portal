package xml;

import org.apache.commons.lang.StringUtils;

public class XMLHelper {
	
	/**
	 * 添加xml节点
	 * @param sb
	 * @param nodeName
	 * @param value
	 */
	public static void appendXmlNode(StringBuilder sb, String nodeName, String value){
		if(StringUtils.isNotEmpty(value)){
			sb.append('<').append(nodeName).append('>').append(value).append("</").append(nodeName).append('>');
		}
	}
}
