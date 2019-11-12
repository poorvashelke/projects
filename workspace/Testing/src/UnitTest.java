import java.io.*;
import java.net.*;
import java.util.*;

public class UnitTest{

     public static void main(String[] args){
    	 // case 1: given data
        try{
            URL url = new URL("https://research.theguarantors.com/qa-test/");
            Map<String,Object> params = new LinkedHashMap<>();
            params.put("numbers", "[2, 3, 1]");
            
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(param.getValue());
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
    
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
    
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    
            for (int c; (c = in.read()) >= 0;)
                System.out.print((char)c);
            System.out.println("Hiii");
        
        }
        catch(Exception e){
            System.out.println(e);
        }
        
     // case 2: same values
        try{
            URL url = new URL("https://research.theguarantors.com/qa-test/");
            Map<String,Object> params = new LinkedHashMap<>();
            params.put("numbers", "[2, 1, 2]");
            
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(param.getValue());
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
    
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
    
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    
            for (int c; (c = in.read()) >= 0;)
                System.out.print((char)c);
            System.out.println("Hiii");
        
        }
        catch(Exception e){
            System.out.println(e);
        }
     // case 3: negative values
        try{
            URL url = new URL("https://research.theguarantors.com/qa-test/");
            Map<String,Object> params = new LinkedHashMap<>();
            params.put("numbers", "[2, -5, 9, 1]");
            
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(param.getValue());
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
    
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
    
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    
            for (int c; (c = in.read()) >= 0;)
                System.out.print((char)c);
            System.out.println("Hiii");
        
        }
        catch(Exception e){
            System.out.println(e);
        }
     // case 4: null
        try{
            URL url = new URL("https://research.theguarantors.com/qa-test/");
            Map<String,Object> params = new LinkedHashMap<>();
            params.put("numbers", "[ ]");
            
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(param.getValue());
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
    
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
    
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    
            for (int c; (c = in.read()) >= 0;)
                System.out.print((char)c);
            System.out.println("Hiii");
        
        }
        catch(Exception e){
            System.out.println(e);
        }
        //we can also check for decimal and for double value
    
     }  
}