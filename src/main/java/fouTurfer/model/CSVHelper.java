package fouTurfer.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.devtools.remote.server.HttpHeaderAccessManager;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;


public class CSVHelper {
	
  public static String TYPE = "text/csv";
  
  static String[] HEADERs = { "Id", "Title", "Description", "Published" };

  public static boolean hasCSVFormat(MultipartFile file) {
	  
	  
	  
	  System.out.println(file.getContentType() + 33);

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<TurfInfos> csvToTurfInfos(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<TurfInfos> infos = new ArrayList<TurfInfos>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
    	  TurfInfos info = new TurfInfos(
              Long.parseLong(csvRecord.get("Id")),
              csvRecord.get("Title"),
              csvRecord.get("Description"),
              Boolean.parseBoolean(csvRecord.get("Published"))
            );

    	  infos.add(info);
      }

      return infos;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

}
