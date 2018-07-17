package autovalue.eclipse.test;

import org.junit.Assert;
import org.junit.Test;

public class AutoValueTest {

	
	@Test
	public void testAutoValues() {
		ColumnRestrictionDto created = ColumnRestrictionDto.builder().setColumn(null).build();
		Assert.assertNotNull(created);
	}
}
