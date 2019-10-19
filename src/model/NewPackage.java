package model;

import java.util.Date;

public class NewPackage {

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

    public Integer getPkgBasePrice() {
        return PkgBasePrice;
    }

    public void setPkgBasePrice(Integer pkgBasePrice) {
        PkgBasePrice = pkgBasePrice;
    }

    public Integer getPkgAgencyCommission() {
        return PkgAgencyCommission;
    }

    public void setPkgAgencyCommission(Integer pkgAgencyCommission) {
        PkgAgencyCommission = pkgAgencyCommission;
    }

    private Integer PackageId;
    private String PkgName;
    private Date PkgStartDate;
    private Date PkgEndDate;
    private String PkgDesc;
    private Integer PkgBasePrice;
    private Integer PkgAgencyCommission;



    public NewPackage(Integer PackageId,
                    String PkgName,
                    Date PkgStartDate,
                    Date PkgEndDate,
                    String PkgDesc,
                    int PkgBasePrice,
                    int PkgAgencyCommission
    ) {
        this.PackageId = PackageId;
        this.PkgName = PkgName;
        this.PkgStartDate = PkgStartDate;
        this.PkgEndDate = PkgEndDate;
        this.PkgDesc =  PkgDesc;
        this.PkgBasePrice = PkgBasePrice;
        this.PkgAgencyCommission = PkgAgencyCommission;
    }
}


