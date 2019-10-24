package model;

import java.util.Date;

public class Bookings {
    private Integer BookingId;
    private Date BookingDate;
    private String BookingNo;
    private Integer CustomerId;
    private String TripTypeId;
    private Integer PackageId;
    private Integer TravelerCount;



    public Bookings(Integer BookingId,
                    Date BookingDate,
                    String BookingNo,
                    Integer CustomerId,
                    String TripTypeId,
                    Integer PackageId,
                    Integer TravelerCount

    ) {
        this.BookingId = BookingId;
        this.BookingDate = BookingDate;
        this.BookingNo = BookingNo;
        this.CustomerId = CustomerId;
        this.TripTypeId =  TripTypeId;
        this.PackageId =  PackageId;
        this.TravelerCount = TravelerCount;


    }



    //public Bookings(int anInt, java.sql.Date date, int anInt1, int anInt2, int anInt3, int anInt4, int anInt5) {
    //}


    public Integer getBookingId() {
        return BookingId;
    }

    public void setBookingId(Integer BookingId) {
        BookingId = BookingId;
    }

    public Date getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(Date BookingDate) {
        BookingDate = BookingDate;
    }

    public String getBookingNo() {
        return BookingNo;
    }

    public void setBookingNo(Integer BookingNo) {
        BookingNo = BookingNo;
    }

    public Integer getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Integer CustomerId) {
        CustomerId = CustomerId;
    }

    public String getTripTypeId() {
        return TripTypeId;
    }

    public void setTripTypeId(Integer TripTypeId) {
        TripTypeId = TripTypeId;
    }

    public Integer getPackageId() {
        return PackageId;
    }

    public void setPackage(Integer PackageId) {
        PackageId = PackageId;
    }



    public Integer getTravelerCount() {
        return TravelerCount;
    }

    public void setTravelerCount(Integer TravelerCount) {
        TravelerCount = TravelerCount;
    }



    @Override
    public String toString() {
        return BookingId + " " + BookingNo; // + " " + TravelerCount + " " + TripTypeId + " " + CustomerId + " "
        // + BookingDate;
    }


}
