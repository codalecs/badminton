package rs.code9.util;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.codehaus.jackson.util.TokenBuffer;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JsonDateSerializerTest {
	private JsonDateSerializer jsonDateSerializer;
	
	@Before
	public void init() {
		jsonDateSerializer = new JsonDateSerializer();
	}

	@Test
	public void testSerializeDateJsonGeneratorSerializerProvider() throws JsonProcessingException, IOException {
		Date date = new DateTime(2012, 3, 28, 10, 38).toDate();
		TokenBuffer gen = new TokenBuffer(null);
		
		jsonDateSerializer.serialize(date, gen, new StdSerializerProvider());
		
		JsonParser jp = gen.asParser();
		jp.nextToken();
		
		Assert.assertEquals(1332923880, jp.getLongValue());
	}		
}