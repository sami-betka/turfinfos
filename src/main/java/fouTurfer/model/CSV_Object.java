package fouTurfer.model;

public class CSV_Object{
  
	private String hotelName;
    private String distance;
    private String reviewScore;
    private String price;
    private String scrapingTime;
    private String dataRank;
    private String pageNumber;
    private String checkinDate;
    private String ceckoutDate;
    
    public CSV_Object() {
  		super();
  	}
    
  	public CSV_Object(String hotelName, String distance, String reviewScore, String price, String scrapingTime,
  			String dataRank, String pageNumber, String checkinDate, String ceckoutDate) {
  		super();
  		this.hotelName = hotelName;
  		this.distance = distance;
  		this.reviewScore = reviewScore;
  		this.price = price;
  		this.scrapingTime = scrapingTime;
  		this.dataRank = dataRank;
  		this.pageNumber = pageNumber;
  		this.checkinDate = checkinDate;
  		this.ceckoutDate = ceckoutDate;
  	}
  	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getScrapingTime() {
		return scrapingTime;
	}
	public void setScrapingTime(String scrapingTime) {
		this.scrapingTime = scrapingTime;
	}
	public String getDataRank() {
		return dataRank;
	}
	public void setDataRank(String dataRank) {
		this.dataRank = dataRank;
	}
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}
	public String getCeckoutDate() {
		return ceckoutDate;
	}
	public void setCeckoutDate(String ceckoutDate) {
		this.ceckoutDate = ceckoutDate;
	}

    

}