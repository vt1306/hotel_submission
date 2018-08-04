
package util;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import Model.Branch;
import Model.Orderdetail;
import Model.RootObject;

public class JSONFileParser {

	private JSONFileParser() {};
	public static void readJSONFile(File file, List<Branch> success, List<Branch> failure) throws Exception {
		byte[] jsonDataCM = Files.readAllBytes(file.toPath());
		
		//create ObjectMapper instance
		ObjectMapper objectMapperCM = new ObjectMapper();
		
		RootObject cm = objectMapperCM.readValue(jsonDataCM, RootObject.class);
		Double totalCollection = null;
		Double orderCollection = null;
		String locationId, location;
		
		totalCollection = Double
				.parseDouble(cm.getCmfoodchain().getBranch().getTotalcollection().toString());
		
		location = cm.getCmfoodchain().getBranch().getLocation();
		
		locationId = cm.getCmfoodchain().getBranch().getLocationid();
		for(Orderdetail od :cm.getCmfoodchain().getOrders().getOrderdetail())
		{
			orderCollection += Double.parseDouble(od.getBillamount().toString());
		}
		
		if (Double.compare(totalCollection, orderCollection)==0) {
			success.add(new Branch(location, totalCollection, orderCollection, locationId));
		} else {
			failure.add(new Branch(location, totalCollection, orderCollection, locationId));
		}
		
	}
}