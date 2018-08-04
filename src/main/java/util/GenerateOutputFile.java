package util;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import Model.Branch;

public class GenerateOutputFile {
	private GenerateOutputFile() {};
	public static void writeToFile(List<Branch> succssBranchList,List<Branch> failureBranchList) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
		StringBuilder bfSuccess = new StringBuilder();
		StringBuilder bfFailure = new StringBuilder();
		try {

			for (Branch branch : succssBranchList) {
				bfSuccess.append(mapper.defaultPrettyPrintingWriter().writeValueAsString(branch));
			}
			for (Branch branch : failureBranchList) {
				bfFailure.append(mapper.defaultPrettyPrintingWriter().writeValueAsString(branch));
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		  try (FileWriter file = new FileWriter("Mismatch.json")) { 
		  file.write(bfFailure.toString()); file.flush(); } catch (IOException e) {
		  e.printStackTrace(); }
		 
		  try (FileWriter file = new FileWriter("Match.json")) { 
			  file.write(bfSuccess.toString()); file.flush(); } catch (IOException e) {
			  e.printStackTrace(); }
	}

}
