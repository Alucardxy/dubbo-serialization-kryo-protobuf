
package org.apache.dubbo.common.serialize.kryo.protobuf;

import java.io.IOException;

/**
 * 
 * @Description: TODO
 * @author Alucardxy
 * @date 2015年12月25日 下午10:01:01
 *
 */
public interface SpecialSerializeFactory {
	
	/**
	 * 是否支持指定类型的反序列化
	 * @param 
	 * @return
	 */
	boolean supportDeserialize(int type);

	/**
	 * 解析数据
	 * @param 
	 * @return
	 */
	Object parse(KryoWithSpecialObjectInput input) throws IOException;
	
	/**
	 * 尝试序列化指定对象，如果无法处理则返回false
	 * @param 
	 * @return
	 */
	boolean trySerializeObject(KryoWithSpecialObjectOutput output, Object obj) throws IOException;
}

