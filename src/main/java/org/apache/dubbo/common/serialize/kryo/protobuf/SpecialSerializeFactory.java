
package org.apache.dubbo.common.serialize.kryo.protobuf;

import java.io.IOException;

/**
 * 
 * @author Alucardxy
 * 2015年12月25日 下午10:01:01
 *
 */
public interface SpecialSerializeFactory {
	
	/**
	 * 是否支持指定类型的反序列化
	 * @param type 类型号
	 * @return 是否支持
	 */
	boolean supportDeserialize(int type);

	/**
	 * 解析数据
	 * @param input 待解码输入流
	 * @return 已解码数据对象
	 * @throws IOException IO异常
	 */
	Object parse(KryoWithSpecialObjectInput input) throws IOException;
	
	/**
	 * 尝试序列化指定对象，如果无法处理则返回false
	 * @param output 编码后输出流
	 * @param obj 待编码对象
	 * @return 是否成功编码
	 * @throws IOException IO异常
	 */
	boolean trySerializeObject(KryoWithSpecialObjectOutput output, Object obj) throws IOException;
}

