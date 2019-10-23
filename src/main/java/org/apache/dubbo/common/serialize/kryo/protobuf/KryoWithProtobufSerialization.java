
package org.apache.dubbo.common.serialize.kryo.protobuf;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.serialize.ObjectInput;
import org.apache.dubbo.common.serialize.ObjectOutput;
import org.apache.dubbo.common.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * 
 * @author Alucardxy
 * @date 2015年12月25日 下午9:59:54
 *
 */
public class KryoWithProtobufSerialization implements Serialization {

	@Override
	public byte getContentTypeId() {
		return 29;
	}

	@Override
	public String getContentType() {
		return "x-application/kryo-spec";
	}

	@Override
	@Adaptive
	public ObjectOutput serialize(URL url, OutputStream output) throws IOException {
		return new KryoWithSpecialObjectOutput(output, ProtobufSerializeFactory.INSTANCE);
	}

	@Override
	@Adaptive
	public ObjectInput deserialize(URL url, InputStream input) throws IOException {
		return new KryoWithSpecialObjectInput(input, ProtobufSerializeFactory.INSTANCE);
	}
}

