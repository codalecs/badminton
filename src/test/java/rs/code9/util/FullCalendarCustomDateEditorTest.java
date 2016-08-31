package rs.code9.util;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class FullCalendarCustomDateEditorTest {

	private FullCalendarCustomDateEditor fullCalendarCustomDateEditor;
	
	@Before
	public void init() {
		fullCalendarCustomDateEditor = new FullCalendarCustomDateEditor();
		fullCalendarCustomDateEditor.setAsText("1332923880");
	}
	
	@Test
	public void testSetAsTextString() {
		//Assert.assertEquals(new DateTime(2012, 3, 28, 10, 38).toDate(), fullCalendarCustomDateEditor.getValue());
	}

	@Test
	public void testGetAsText() {
		Assert.assertEquals("1332923880", fullCalendarCustomDateEditor.getAsText());
	}
}
