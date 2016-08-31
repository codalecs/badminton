package rs.code9.util;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.util.TokenBuffer;

public class JsonDateSerializerTest {
	private JsonDateSerializer jsonDateSerializer;
	
	@Before
	public void init() {
		jsonDateSerializer = new JsonDateSerializer();
	}

	@Test
	public void testSerializeDateJsonGeneratorSerializerProvider() throws JsonProcessingException, IOException {
/*		Date date = new DateTime(2012, 3, 28, 10, 38).toDate();
		TokenBuffer gen = new TokenBuffer(null);
		
		jsonDateSerializer.serialize(date, gen, new StdSerializerProvider());
		
		JsonParser jp = gen.asParser();
		jp.nextToken();
		
		Assert.assertEquals(1332923880, jp.getLongValue());*/
	}		
}