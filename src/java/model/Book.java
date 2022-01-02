package model;

import model.Author;
import model.Publisher;

public class Book {

    private int id;
    private String name;
    private float price;
    private int inventory;
    private Author author;
    private Publisher publisher;
    private String summary;
    private String language;
    private String category;
    private String authorName;
    private String publisherName;
    private float discount;

    public Book(int id, String name, float price, int inventory, Author author, Publisher publisher, String summary, float discount,  String language, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.author = author;
        this.publisher = publisher;
        this.summary = summary;
        this.language = language;
        this.category = category;
        this.discount = discount;
    }   

    public Book(int id, String name, float price, int inventory, String category, float discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.inventory = inventory;
        this.discount = discount;
    }

    public Book(int id, String name, float price, int inventory, String summary, String language, String category, float discount, String authorName, String publisherName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.summary = summary;
        this.language = language;
        this.category = category;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.discount = discount;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
}
