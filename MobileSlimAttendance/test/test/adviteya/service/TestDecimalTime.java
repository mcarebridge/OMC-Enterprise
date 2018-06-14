package test.adviteya.service;

import java.text.DecimalFormat;

import org.junit.Test;

import com.adviteya.service.PayRollBusinessService;

public class TestDecimalTime
{
	@Test
	public void testDecimalTime()
	{
		PayRollBusinessService service=new PayRollBusinessService();
		double time= 12840;
		
		float timeInDecimal=service.getSecondsToDecimal(time);
		DecimalFormat df= new DecimalFormat("###.#");
		
		System.out.println("Time"+time+" In Decimal "+df.format(timeInDecimal));
	}
}
