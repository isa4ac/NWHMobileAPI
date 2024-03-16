package me.networkhub.networkhubapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "define_Timezones")
public class DefineTimezone {
    @Id
    @Column(name = "define_Timezone_Id_PK", nullable = false, length = 96)
    private String defineTimezoneIdPk;

    @Lob
    @Column(name = "define_Timezone_Name_Region")
    private String defineTimezoneNameRegion;

    @Lob
    @Column(name = "define_Timezone_Name_PHP")
    private String defineTimezoneNamePhp;

    @Column(name = "define_Timezone_Sort")
    private Byte defineTimezoneSort;

    public String getDefineTimezoneIdPk() {
        return defineTimezoneIdPk;
    }

    public void setDefineTimezoneIdPk(String defineTimezoneIdPk) {
        this.defineTimezoneIdPk = defineTimezoneIdPk;
    }

    public String getDefineTimezoneNameRegion() {
        return defineTimezoneNameRegion;
    }

    public void setDefineTimezoneNameRegion(String defineTimezoneNameRegion) {
        this.defineTimezoneNameRegion = defineTimezoneNameRegion;
    }

    public String getDefineTimezoneNamePhp() {
        return defineTimezoneNamePhp;
    }

    public void setDefineTimezoneNamePhp(String defineTimezoneNamePhp) {
        this.defineTimezoneNamePhp = defineTimezoneNamePhp;
    }

    public Byte getDefineTimezoneSort() {
        return defineTimezoneSort;
    }

    public void setDefineTimezoneSort(Byte defineTimezoneSort) {
        this.defineTimezoneSort = defineTimezoneSort;
    }

}