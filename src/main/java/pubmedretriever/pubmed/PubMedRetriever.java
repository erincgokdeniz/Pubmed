package pubmedretriever.pubmed;

import java.util.List;
import pubmedretriever.utils.FileUtils;


public class PubMedRetriever {

	public static void main(String[] args) {
		
		PubMedProcessor processor = new PubMedProcessor();
		
		// Return the list of PubMed Publications
		List<PubMedObject> pubMedObjectList = processor.getPubMedObjectList(args[0]);
		
		// Write the pattern evaluation of the publications to the output
		FileUtils.writePatternResultsToFile(pubMedObjectList);
		
		System.out.println("Please check PublicationList.csv under output folder..");
	}

}
