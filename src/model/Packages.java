package model;

import java.util.Date;

public class Packages {

    public Integer getPackageId() {
        return PackageId;
    }

    public void setPackageId(Integer packageId) {
        PackageId = packageId;
    }

    public String getPkgName() {
        return PkgName;
    }

    public void setPkgName(String pkgName) {
        PkgName = pkgName;
    }

    public Date getPkgStartDate() {
        return PkgStartDate;
    }

    public void setPkgStartDate(Date pkgStartDate) {
        PkgStartDate = pkgStartDate;
    }

    public Date getPkgEndDate() {
        return PkgEndDate;
    }

    public void setPkgEndDate(Date pkgEndDate) {
        PkgEndDate = pkgEndDate;
    }

    public String getPkgDesc() {
        return PkgDesc;
    }

    public void setPkgDesc(String pkgDesc) {
        PkgDesc = pkgDesc;
    }

    public Double getPkgBasePrice() {
        return PkgBasePrice;
    }

    public void setPkgBasePrice(Double pkgBasePrice) {
        PkgBasePrice = pkgBasePrice;
    }

    public Double getPkgAgencyCommission() {
        return PkgAgencyCommission;
    }

    public void setPkgAgencyCommission(Double pkgAgencyCommission) {
        PkgAgencyCommission = pkgAgencyCommission;
    }

    private Integer PackageId;
    private String PkgName;
    private Date PkgStartDate;
    private Date PkgEndDate;
    private String PkgDesc;
    private Double PkgBasePrice;
    private Double PkgAgencyCommission;



    public Packages(Integer PackageId,
                    String PkgName,
                    Date PkgStartDate,
                    Date PkgEndDate,
                    String PkgDesc,
                    double PkgBasePrice,
                    double PkgAgencyCommission
    ) {
        this.PackageId = PackageId;
        this.PkgName = PkgName;
        this.PkgStartDate = PkgStartDate;
        this.PkgEndDate = PkgEndDate;
        this.PkgDesc =  PkgDesc;
        this.PkgBasePrice = PkgBasePrice;
        this.PkgAgencyCommission = PkgAgencyCommission;
    }

    @Override
    public String toString() {
        return PackageId + " " + PkgName;
    }


}
