package org.example.dto;

import java.util.Objects;

public class BookAuthorDto {
    private int authorId;
    private String name;
    private String origin;

    private int era;
    public BookAuthorDto() {
    }

    public BookAuthorDto(int authorId, String name, String origin, int era) {
        this.authorId = authorId;
        this.name = name;
        this.origin = origin;
        this.era = era;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getEra() {
        return era;
    }

    public void setEra(int era) {
        this.era = era;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookAuthorDto that = (BookAuthorDto) o;
        return authorId == that.authorId && era == that.era && Objects.equals(name, that.name) && Objects.equals(origin, that.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, name, origin, era);
    }

    @Override
    public String toString() {
        return "BookAuthorDto{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", era=" + era +
                '}';
    }
}
