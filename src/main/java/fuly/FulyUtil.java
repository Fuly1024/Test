package fuly;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FulyUtil {
	
	static  public String  StringToHexstr(String str)
	{
		byte[] bytes = str.getBytes();
		StringBuilder stringBuilder = new StringBuilder("");
	        if (bytes == null || bytes.length <= 0) {
	            return null;
	        }
	        for (int i = 0; i < bytes.length; i++) {
	            int v = bytes[i] & 0xFF;
	            String hv = Integer.toHexString(v);
	            if (hv.length() < 2) {
	                stringBuilder.append(0);
	            }
	            stringBuilder.append(hv);
	        }
	        return stringBuilder.toString();
	}
	
	static  public String  byteToHexstr(byte[] bytes)
	{
		StringBuilder stringBuilder = new StringBuilder("");
	        if (bytes == null || bytes.length <= 0) {
	            return null;
	        }
	        for (int i = 0; i < bytes.length; i++) {
	            int v = bytes[i] & 0xFF;
	            String hv = Integer.toHexString(v);
	            if (hv.length() < 2) {
	                stringBuilder.append(0);
	            }
	            stringBuilder.append(hv);
	        }
	        return stringBuilder.toString();
	}
	
	
	static  public String HexstrToString(String hexString)
	{
		  if (hexString == null || hexString.equals("")) {
	            return null;
	        }
	        hexString = hexString.toUpperCase();
	        int length = hexString.length() / 2;
	        char[] hexChars = hexString.toCharArray();
	        byte[] d = new byte[length];
	        for (int i = 0; i < length; i++) {
	            int pos = i * 2;
	            d[i] = (byte) ("0123456789ABCDEF".indexOf(hexChars[pos]) << 4 | "0123456789ABCDEF".indexOf(hexChars[pos + 1]));
	        }
		return new String(d);	
	}

	static  public  byte[] HexstrToBytes(String hexString)
	{
		  if (hexString == null || hexString.equals("")) {
	            return null;
	        }
	        hexString = hexString.toUpperCase();
	        int length = hexString.length() / 2;
	        char[] hexChars = hexString.toCharArray();
	        byte[] d = new byte[length];
	        for (int i = 0; i < length; i++) {
	            int pos = i * 2;
	            d[i] = (byte) ("0123456789ABCDEF".indexOf(hexChars[pos]) << 4 | "0123456789ABCDEF".indexOf(hexChars[pos + 1]));
	        }
		return d;	
	}
	
	static  public int  getObjectAddress(Object object)
	{
		return System.identityHashCode(object);		
	}
	
	static  public String  getFileInfo()
	{
		return "___FILE:"+System.getProperty("user.dir")+"|"+Thread.currentThread().getStackTrace()[2].getFileName()+"___LINE:"+Thread.currentThread().getStackTrace()[2].getLineNumber();
	}

	static  public String  getClassName()
	{
		return Thread.currentThread().getStackTrace()[2].getClassName();
	}
	static  public String  getFileName()
	{
		return Thread.currentThread().getStackTrace()[2].getFileName();
	}

	static  public int  getLineNumber()
	{
		return Thread.currentThread().getStackTrace()[2].getLineNumber();
	}
	
	static  public String getCurrentPath(){
		return System.getProperty("user.dir");
	}
	
	static  public String getCurrentThreanName(){
		return Thread.currentThread().getName();
	}
	
	static  public void printLog(String log){
		
		try {
			FileWriter fileWriter = new FileWriter("log.txt", true);
			fileWriter.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()).toString()+" <===> "+log+"\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
