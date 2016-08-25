package rs.code9.util;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * Since the FullCalender component is representing date as number of
 * seconds instead of number of milliseconds, we need to change behavior
 * of the custom date editor. 
 * 
 * @author d.gajic
 */
public class FullCalendarCustomDateEditor extends PropertyEditorSupport {
	

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// since the value comes as seconds we need to multiply with 1000
		try {
			long milli = Long.parseLong(text) * 1000;
			super.setValue(new Date(milli));
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("Could not parse, expected number of seconds since January 1, 1970, 00:00:00 GMT");
		}		
	}

	@Override
	public String getAsText() {
		Date date = (Date) super.getValue();
		return (date.getTime() / 1000) + "";
	}
}
