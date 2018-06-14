package test.adviteya.simulator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import test.adviteya.mobile.util.MobileConstants;

public class AndroidMobileSimulator implements MobileConstants
{
	
	private static int numOfRecs = 0;
	
	public AndroidMobileSimulator()
	{
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			StringBuffer _mobileData = loadTestTimesheets();
			System.out.println(_mobileData.toString());
			
			String response = synchMobileUsingIMEI("123456789123456", _mobileData.toString(), "51-1003",
			        "23.43545@35.34535@12", numOfRecs);
			
			System.out.println(response);
			
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 * @param imeiCode
	 * @param mobileData
	 * @param supervisorUserName
	 * @param latLang
	 * @param recsSent
	 * @return
	 * @throws Exception
	 */
	public static String synchMobileUsingIMEI(String imeiCode,
	        String mobileData, String supervisorUserName, String latLang,
	        int recsSent) throws Exception
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
		
		String _synchServerData = IMEI_SYNCH_SERVER_DATA;
		String _webAppURL = BASE_URL + IMEI_SYNCH_SERVER_DATA;
		HttpPost httppost = new HttpPost(_webAppURL);
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
		nameValuePairs.add(new BasicNameValuePair("imeiCode", imeiCode.trim()));
		nameValuePairs.add(new BasicNameValuePair("supervisorUserName",
		        supervisorUserName));
		nameValuePairs.add(new BasicNameValuePair("mobileData", mobileData
		        .toString().trim()));
		nameValuePairs.add(new BasicNameValuePair("latLang", latLang));
		nameValuePairs.add(new BasicNameValuePair("mobileRecsSent", Integer
		        .toString(recsSent)));
		httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		
		response = client.execute(httppost);
		Header[] headers = response.getHeaders("AUTH_MSG");
		
		if (headers[0].getValue().equalsIgnoreCase("MOBILE_SERVER_SYSTEM_ERR"))
		{
			throw new Exception("SYNCH_ERR");
		}
		
		synchServerDataString = readHTTPResponse(client, httppost, response);
		
		return synchServerDataString;
	}
	
	/**
	 * 
	 * @param client
	 * @param httppost
	 * @param response
	 * @throws IOException
	 */
	private static String readHTTPResponse(HttpClient client,
	        HttpPost httppost, HttpResponse response) throws IOException
	{
		// Get hold of the response entity
		HttpEntity entity = response.getEntity();
		String responseString = null;
		
		// If the response does not enclose an entity, there is no need
		// to worry about connection release
		if (entity != null)
		{
			
			InputStream instream = null;
			
			try
			{
				instream = entity.getContent();
				
				GZIPInputStream zis = new GZIPInputStream(
				        new BufferedInputStream(instream));
				
				BufferedReader reader = new BufferedReader(
				        new InputStreamReader(zis));
				// do something useful with the response
				responseString = reader.readLine();
			} catch (IOException ex)
			{
				
				// In case of an IOException the connection will be released
				// back to the connection manager automatically
				throw ex;
				
			} catch (RuntimeException ex)
			{
				
				// In case of an unexpected exception you may want to abort
				// the HTTP request in order to shut down the underlying
				// connection and release it back to the connection manager.
				httppost.abort();
				throw ex;
				
			} finally
			{
				
				// Closing the input stream will trigger connection release
				instream.close();
				// When HttpClient instance is no longer needed,
				// shut down the connection manager to ensure
				// immediate deallocation of all system resources
				client.getConnectionManager().shutdown();
			}
		}
		
		return responseString;
	}
	
	/**
	 * Load test timesheet path from filesystem
	 * 
	 * @throws IOException
	 */
	private static StringBuffer loadTestTimesheets() throws IOException
	{
		
		StringBuffer timeSheetStream = new StringBuffer();
		
		FileReader fr = null;
		File f = new File(
		        "E:/Userlib/trunk11032012/MobileSlimAttendance/testdata/MobileTestDataInOut.csv");
		if (f.exists())
		{
			try
			{
				fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String eachLine = "";
				int i = 0;
				while (eachLine != null)
				{
					eachLine = br.readLine();
					if (eachLine != null)
					{
						// Omit header
//						if (i > 0)
//						{
							timeSheetStream.append(eachLine);
							timeSheetStream.append("\n");
							numOfRecs++;
//						}
					}
					
					i++;
				}
			} finally
			{
				fr.close();
			}
		}
		
		return timeSheetStream;
	}
	
}
