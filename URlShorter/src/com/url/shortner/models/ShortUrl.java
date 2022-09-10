package com.url.shortner.models;

import java.util.Date;
import java.util.Objects;

public class ShortUrl {

    //PK
    private String shortUrlHash;
    private String url;
    private Date creationDate;
    private Date expirationDate;
    private Long userId;

    public String getShortUrlHash() {
        return shortUrlHash;
    }

    public void setShortUrlHash(String shortUrlHash) {
        this.shortUrlHash = shortUrlHash;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortUrl shortUrl = (ShortUrl) o;
        return Objects.equals(shortUrlHash, shortUrl.shortUrlHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortUrlHash);
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                "shortUrlHash='" + shortUrlHash + '\'' +
                ", url='" + url + '\'' +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
