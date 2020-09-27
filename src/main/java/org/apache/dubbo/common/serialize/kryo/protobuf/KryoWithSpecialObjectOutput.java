/**
 * Copyright: Copyright (c) 2015 
 * 
 * @author youaremoon
 * @date 2015年12月25日
 * @version V1.0
 */
package org.apache.dubbo.common.serialize.kryo.protobuf;


import org.apache.dubbo.common.serialize.kryo.KryoObjectOutput;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alucardxy
 * 2015年12月25日 下午10:00:27
 *
 */
public class KryoWithSpecialObjectOutput extends KryoObjectOutput {

	private List<SpecialSerializeFactory> factoryList;
	
	public KryoWithSpecialObjectOutput(OutputStream os) {
		super(os);
	}
	
	public KryoWithSpecialObjectOutput(OutputStream os, SpecialSerializeFactory... factories) {
		this(os);
		
		if (null != factories) {
			factoryList = new ArrayList<SpecialSerializeFactory>();
			for (SpecialSerializeFactory factory : factories) {
				factoryList.add(factory);
			}
		}
	}
	
	public void addSerializeFactory(SpecialSerializeFactory factory) {
		if (null == factoryList) {
			factoryList = new ArrayList<SpecialSerializeFactory>();
		}
		
		factoryList.add(factory);
	}

	public void writeObject(Object obj) throws IOException {
		if (null != factoryList) {
			for (SpecialSerializeFactory factory : factoryList) {
				if (factory.trySerializeObject(this, obj)) {
					return;
				}
			}
		}
	
		// 无法处理则按照正常的hessian写入
		super.writeInt(ProtobufUtil.TYPE_NORMAL);
		super.writeObject(obj);
	}
}
