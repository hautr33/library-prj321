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
public class BookDTO implements Serializable {

    private String bookID, title, author, publisher;
    private int pageNumber, price, quantity;
    private String imageURL, description;

    public BookDTO() {
    }

    public BookDTO(String bookID, String title, String author, String publisher, int pageNumber, int price, int quantity, String imageURL, String description) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageNumber = pageNumber;
        this.price = price;
        this.quantity = quantity;
        this.imageURL = imageURL;
        this.description = description;
    }

    public BookDTO(String bookID, String title, String author, String publisher, int pageNumber, int price, int quantity, String description) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageNumber = pageNumber;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
