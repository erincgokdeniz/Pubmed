package pubmedretriever.pubmed;
  
import java.io.IOException; 
import java.io.UnsupportedEncodingException; 
import java.util.ArrayList; 
import java.util.List; 
  
import org.apache.http.HttpResponse; 
import org.apache.http.NameValuePair; 
import org.apache.http.client.HttpClient; 
import org.apache.http.client.entity.UrlEncodedFormEntity; 
import org.apache.http.client.methods.HttpPost; 
import org.apache.http.impl.client.DefaultHttpClient; 
import org.apache.http.message.BasicNameValuePair; 
import org.apache.http.util.EntityUtils; 
  
public class PubMedConnector { 
  
    public static final String pubMedConnectionUrl = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/";  
    
    public static final String SEARCH_URL = "esearch.fcgi?";
    public static final String SUMMARY_URL = "esummary.fcgi?";
    HttpClient client;
    HttpPost post;
        
    private void connect(String searchType){
    	
    	client  = new DefaultHttpClient(); 
    	post    = new HttpPost(pubMedConnectionUrl + searchType); 
        
    }
    
    public List<String> search(String keyword){ 
          
    	connect(SEARCH_URL);
        List<NameValuePair> parameters    = new ArrayList<NameValuePair>(3); 
        parameters.add(new BasicNameValuePair("db", "pubmed")); 
        parameters.add(new BasicNameValuePair("term", keyword)); 
           
        getHttpResponse(parameters);
  
        return null;
        		
    } 
    
    public List<String> getSummary(String id){ 
        
    	connect(SUMMARY_URL);
        List<NameValuePair> parameters    = new ArrayList<NameValuePair>(3); 
        parameters.add(new BasicNameValuePair("db", "pubmed")); 
        parameters.add(new BasicNameValuePair("id", id)); 
        parameters.add(new BasicNameValuePair("version", "2.0"));
        
        getHttpResponse(parameters);
        
        return null;
        		
    } 
    
    private void getHttpResponse(List<NameValuePair> parameters){
    	
        try { 
            post.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8")); 
            HttpResponse resp = client.execute(post); 
            String entity = EntityUtils.toString(resp.getEntity()); 
            System.out.println(entity); 
              
        } catch (UnsupportedEncodingException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    	
    }
    
    
}