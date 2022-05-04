package Util;

import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import com.opencsv.CSVReader;

public class CityDatasetReader {
	
	private Map<Integer,List<String>> rows = new HashMap<Integer,List<String>>();
	
	public void readDataLineByLine(String file) {

		try {
			FileReader filereader = new FileReader(file);

			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;

			Integer id = 0;

			while ((nextRecord = csvReader.readNext()) != null) {
				List<String> rowElements = new ArrayList<>();
				for (String cell : nextRecord) {
					rowElements.add(cell);
				}
				rows.put(id,rowElements);
				id++;
			}
			csvReader.close();
			rows.remove(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayAll()
	{
		for(Integer key : rows.keySet())
		{
			System.out.print(key + " ");
			for(String cell : rows.get(key))
			{
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}
	
	public Map<Integer,List<String>> getData()
	{
		return rows;
	}

}
