package model;

import java.math.BigDecimal;
import java.sql.Date;

public class BookingDetail {
    private Integer bookingDetailId;
    private Double itineraryNo;
    private Date tripStart;
    private Date tripEnd;
    private String description;
    private String destination;
    private BigDecimal basePrice;
    private BigDecimal agencyCommission;
    private Integer bookingId;
//    private Character regionalId;
    private String regionalId;
//    private Character classId;
    private String classId;
//    private Character feeId;
    private String feeId;
    private Integer productSupplierId;

    //constructor
    public BookingDetail(Integer bookingDetailId, Double itineraryNo, Date tripStart, Date tripEnd, String description,
                         String destination, BigDecimal basePrice, BigDecimal agencyCommission, Integer bookingId,
                         String regionalId, String classId, String feeId, Integer productSupplierId) {
        this.bookingDetailId = bookingDetailId;
        this.itineraryNo = itineraryNo;
        this.tripStart = tripStart;
        this.tripEnd = tripEnd;
        this.description = description;
        this.destination = destination;
        this.basePrice = basePrice;
        this.agencyCommission = agencyCommission;
        this.bookingId = bookingId;
        this.regionalId = regionalId;
        this.classId = classId;
        this.feeId = feeId;
        this.productSupplierId = productSupplierId;
    }

    public BookingDetail() {
    }

    //getters and setters
    public Integer getBookingDetailId() {
        return bookingDetailId;
    }

    public void setBookingDetailId(Integer bookingDetailId) {
        this.bookingDetailId = bookingDetailId;
    }

    public Double getItineraryNo() {
        return itineraryNo;
    }

    public void setItineraryNo(Double itineraryNo) {
        this.itineraryNo = itineraryNo;
    }

    public Date getTripStart() {
        return tripStart;
    }

    public void setTripStart(Date tripStart) {
        this.tripStart = tripStart;
    }

    public Date getTripEnd() {
        return tripEnd;
    }

    public void setTripEnd(Date tripEnd) {
        this.tripEnd = tripEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getAgencyCommission() {
        return agencyCommission;
    }

    public void setAgencyCommission(BigDecimal agencyCommission) {
        this.agencyCommission = agencyCommission;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getRegionalId() {
        return regionalId;
    }

    public void setRegionalId(String regionalId) {
        this.regionalId = regionalId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getFeeId() {
        return feeId;
    }

    public void setFeeld(String feeId) {
        this.feeId = feeId;
    }

    public Integer getProductSupplierId() {
        return productSupplierId;
    }

    public void setProductSupplierId(Integer productSupplierId) {
        this.productSupplierId = productSupplierId;
    }

    @Override
    public String toString() {
        return "BookingDetail"
                + "\n---------------------------------"
                + "\nBookingDetailId: " + bookingDetailId
                + "\nItenerary No.: " + itineraryNo
                + "\nDateStart: " + tripStart + " " + "DateEnd: " + tripEnd
                + "\nDescription: " + description;
    }

  /*  "BookingDetail" +
    "bookingDetailId=" + bookingDetailId +
    ", iteneraryNo=" + iteneraryNo +
    ", tripStart=" + tripStart +
    ", tripEnd=" + tripEnd +
    ", description='" + description + '\'' +
    ", destination='" + destination + '\'' +
    ", basePrice=" + basePrice +
    ", agencyCommission=" + agencyCommission +
    ", bookingId=" + bookingId +
    ", regionalId='" + regionalId + '\'' +
    ", classId='" + classId + '\'' +
    ", feeId='" + feeId + '\'' +
    ", productSupplierId=" + productSupplierId +
    '}';*/
}
