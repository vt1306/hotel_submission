

package insurance_sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Model.Branch;
import util.GenerateOutputFile;
import util.JSONFileParser;
import util.XMLFileParser;

public class ProcessMain {

	public static List<Branch> success = new ArrayList<Branch>();
	public static List<Branch> failure = new ArrayList<Branch>();

	public static void main(String[] args) throws Exception {
		ProcessMain p = new ProcessMain();
		p.readFile("BOM-1234-456.xml");
		p.readFile("BOM-1234-457.json");
		GenerateOutputFile.writeToFile(success,failure);
	}

	public void readFile(String name) throws Exception {
		if (Objects.isNull(name) || name.isEmpty()) {
			return;
		}
		String extension = null;
		int i = name.lastIndexOf('.');
		if (i > 0) {
			extension = name.substring(i + 1);
		}

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(name).getFile());

		if (!file.exists()) {

		} else {
			if(extension!=null)
			{
				if ("xml".equalsIgnoreCase(extension)) {
					XMLFileParser.readXMLFile(file, success, failure);
				} else if ("json".equalsIgnoreCase(extension)) {
					JSONFileParser.readJSONFile(file, success, failure);
				}
			}
		}
	}
}
