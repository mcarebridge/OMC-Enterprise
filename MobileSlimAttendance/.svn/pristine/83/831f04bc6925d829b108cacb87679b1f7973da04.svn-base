package test.adviteya.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.junit.Test;

import test.adviteya.mobile.util.MobileConstants;

public class TestPayrollProcessController implements MobileConstants
{
	@Test
	public void testPayrollProcessController() throws ClientProtocolException, IOException
	{
		HttpResponse response = null;
		
		// Get Timesheet snapshot from SqlLite
		String synchServerDataString = null;
		final HttpParams httpParams = new BasicHttpParams();
		// added timeout of 60 sec
		HttpConnectionParams.setConnectionTimeout(httpParams, 60000);
		HttpClient client = new DefaultHttpClient();
		
		// Throw exception
		
		// client = null;
		String _webAppURL = "http://localhost/humancapital/"
		        + "payrollAsyncProcessor";
		
		HttpPost httppost = new HttpPost(_webAppURL);
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
		nameValuePairs.add(new BasicNameValuePair("COMPANYID", "102051"));
		nameValuePairs.add(new BasicNameValuePair("STARTDATE", "11/1/2012"));
		nameValuePairs.add(new BasicNameValuePair("ENDDATE", "11/30/2012"));
		nameValuePairs.add(new BasicNameValuePair("actionParam", "payrollAsyncProcessor"));
		
		
		httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		response = client.execute(httppost);
		
	}
}
