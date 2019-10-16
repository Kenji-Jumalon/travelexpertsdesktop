package model;

import java.util.Date;

public class Bookings {
    private Integer BookingId;
    private Date BookingDate;
    private Integer BookingNo;
    private Integer CustomerId;
    private Integer TripTypeId;
    private Integer TravelerCount;




    public Bookings(Integer BookingId,
                 Date BookingDate,
                 Integer BookingNo,
                 Integer CustomerId,
                 Integer TripTypeId,
                 Integer TravelerCount

    ) {
        this.BookingId = BookingId;
        this.BookingDate = BookingDate;
        this.BookingNo = BookingNo;
        this.CustomerId = CustomerId;
        this.TripTypeId =  TripTypeId;
        this.TravelerCount = TravelerCount;


    }



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

    public Integer getBookingNo() {
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

    public Integer getTripTypeId() {
        return TripTypeId;
    }

    public void setTripTypeId(Integer TripTypeId) {
        TripTypeId = TripTypeId;
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
