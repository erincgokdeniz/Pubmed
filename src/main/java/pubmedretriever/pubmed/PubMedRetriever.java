package pubmedretriever.pubmed;


public class PubMedRetriever {

	public static void main(String[] args) {
		
		PubMedConnector connector = new PubMedConnector();
		connector.search("PVT");
		connector.getSummary("24497651");
		
	}


}
