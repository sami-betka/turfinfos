package fouTurfer.model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CSVParser {

    public void parse(){
    	
        try{
            CSVReader reader=
                    new CSVReaderBuilder(new FileReader("C:/cgoka/data.csv")).
                            withSkipLines(1). // Skiping firstline as it is header
                            build();
            List<CSV_Object> csv_objectList = null;
			try {
				csv_objectList = reader.readAll().stream().map(data-> {
				    CSV_Object csvObject= new CSV_Object();
				    csvObject.setHotelName(data[0]);
				    csvObject.setDistance(data[1]);
				    csvObject.setReviewScore(data[2]);
				    csvObject.setPrice(data[3]);
				    csvObject.setScrapingTime(data[4]);
				    csvObject.setDataRank(data[5]);
				    csvObject.setPageNumber(data[6]);
				    csvObject.setCheckinDate(data[7]);
				    csvObject.setCeckoutDate(data[8]);
				    return csvObject;
				}).collect(Collectors.toList());
			} catch (CsvException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            csv_objectList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}