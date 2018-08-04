package util;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Model.Branch;

public class XMLFileParser {

	private XMLFileParser() {};
	public static void readXMLFile(File file, List<Branch> success, List<Branch> failure) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(file);
		Double totalCollection =0.0;
		Double orderCollection = 0.0;
		String locationId, location;

		document.getDocumentElement().normalize();

		NodeList nList = document.getElementsByTagName("branch");
		NodeList nListOrderDetail = null;

			Node nNode = nList.item(0);
			Element element = (Element) nNode;
			totalCollection = Double
					.parseDouble(element.getElementsByTagName("totalcollection").item(0).getTextContent());
			locationId = element.getElementsByTagName("locationid").item(0).getTextContent();
			location = element.getElementsByTagName("location").item(0).getTextContent();

			nListOrderDetail = document.getElementsByTagName("orderdetail");

			for (int temp = 0; temp < nListOrderDetail.getLength(); temp++) {
				nNode = nListOrderDetail.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					element = (Element) nNode;
					orderCollection += Double
							.parseDouble(element.getElementsByTagName("billamount").item(0).getTextContent());
				}
			}

			if (Double.compare(totalCollection, orderCollection)==0) {
				success.add(new Branch(location, totalCollection, orderCollection, locationId));
			} else {
				failure.add(new Branch(location, totalCollection, orderCollection, locationId));
			}
	}

}
