package org.openmrs.customdatatype;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.test.BaseContextSensitiveTest;

public class CustomDatatypeUtilTest extends BaseContextSensitiveTest {
	
	/**
	 * @see CustomDatatypeUtil#deserializeSimpleConfiguration(String)
	 * @verifies deserialize a configuration serialized by the corresponding serialize method
	 */
	@Test
	public void deserializeSimpleConfiguration_shouldDeserializeAConfigurationSerializedByTheCorrespondingSerializeMethod()
	        throws Exception {
		Map<String, String> config = new HashMap<String, String>();
		config.put("one property", "one value");
		config.put("another property", "another value < with > strange&nbsp;characters");
		
		String serialized = CustomDatatypeUtil.serializeSimpleConfiguration(config);
		Map<String, String> deserialized = CustomDatatypeUtil.deserializeSimpleConfiguration(serialized);
		Assert.assertEquals(2, deserialized.size());
		Assert.assertEquals("one value", deserialized.get("one property"));
		Assert.assertEquals("another value < with > strange&nbsp;characters", deserialized.get("another property"));
	}
}
