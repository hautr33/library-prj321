/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautt.dtos;

import java.io.Serializable;

/**
 *
 * @author SE130205
 */
public class BookErrorDTO implements Serializable {

    private String bookIDErr, titleErr, authorErr, publisherErr, pageNumberErr, priceErr, quantityErr, imageURLErr, descriptionErr, notFoundErr, searchErr;

    public BookErrorDTO() {
    }

    public String getBookIDErr() {
        return bookIDErr;
    }

    public void setBookIDErr(String bookIDErr) {
        this.bookIDErr = bookIDErr;
    }

    public String getTitleErr() {
        return titleErr;
    }

    public void setTitleErr(String titleErr) {
        this.titleErr = titleErr;
    }

    public String getAuthorErr() {
        return authorErr;
    }

    public void setAuthorErr(String authorErr) {
        this.authorErr = authorErr;
    }

    public String getPublisherErr() {
        return publisherErr;
    }

    public void setPublisherErr(String publisherErr) {
        this.publisherErr = publisherErr;
    }

    public String getPageNumberErr() {
        return pageNumberErr;
    }

    public void setPageNumberErr(String pageNumberErr) {
        this.pageNumberErr = pageNumberErr;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }

    public String getQuantityErr() {
        return quantityErr;
    }

    public void setQuantityErr(String quantityErr) {
        this.quantityErr = quantityErr;
    }

    public String getImageURLErr() {
        return imageURLErr;
    }

    public void setImageURLErr(String imageURLErr) {
        this.imageURLErr = imageURLErr;
    }

    public String getDescriptionErr() {
        return descriptionErr;
    }

    public void setDescriptionErr(String descriptionErr) {
        this.descriptionErr = descriptionErr;
    }

    public void setNotFoundErr(String notFoundErr) {
        this.notFoundErr = notFoundErr;
    }

    public String getNotFoundErr() {
        return notFoundErr;
    }

    public void setSearchErr(String searchErr) {
        this.searchErr = searchErr;
    }

    public String getSearchErr() {
        return searchErr;
    }

}
