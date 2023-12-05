package org.example.dto;

import java.util.Objects;

public class BookDto {
    private int dtoid;
    private String dtotitle;
    private int dtoquantity;

    private int dtoprice;


    private int dtoauthorId;


    public BookDto() {
    }

    public BookDto(int dtoid, String dtotitle, int dtoquantity, int dtoprice, int dtoauthorId) {
        this.dtoid = dtoid;
        this.dtotitle = dtotitle;
        this.dtoquantity = dtoquantity;
        this.dtoprice = dtoprice;
        this.dtoauthorId = dtoauthorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return dtoid == bookDto.dtoid && dtoquantity == bookDto.dtoquantity && dtoprice == bookDto.dtoprice && dtoauthorId == bookDto.dtoauthorId && Objects.equals(dtotitle, bookDto.dtotitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dtoid, dtotitle, dtoquantity, dtoprice, dtoauthorId);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "dtoid=" + dtoid +
                ", dtotitle='" + dtotitle + '\'' +
                ", dtoquantity=" + dtoquantity +
                ", dtoprice=" + dtoprice +
                ", dtoauthorId=" + dtoauthorId +
                '}';
    }

    public int getDtoid() {
        return dtoid;
    }

    public void setDtoid(int dtoid) {
        this.dtoid = dtoid;
    }

    public String getDtotitle() {
        return dtotitle;
    }

    public void setDtotitle(String dtotitle) {
        this.dtotitle = dtotitle;
    }

    public int getDtoquantity() {
        return dtoquantity;
    }

    public void setDtoquantity(int dtoquantity) {
        this.dtoquantity = dtoquantity;
    }

    public int getDtoprice() {
        return dtoprice;
    }

    public void setDtoprice(int dtoprice) {
        this.dtoprice = dtoprice;
    }

    public int getDtoauthorId() {
        return dtoauthorId;
    }

    public void setDtoauthorId(int dtoauthorId) {
        this.dtoauthorId = dtoauthorId;
    }
}
