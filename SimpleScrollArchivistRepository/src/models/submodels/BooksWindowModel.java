package com.scrollarchivist.simplescrollarchivistrepository.models.submodels;
import jakarta.json.bind.annotation.JsonbProperty;
/**
 * [BooksWindowModel] - class
 * @author Mathaus
 */
public class BooksWindowModel {
    // <editor-fold defaultstate="collapsed" desc="Constructeurs">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Proprietes">
    @JsonbProperty("title")
    private String title;
    @JsonbProperty("author")
    private String author;
    @JsonbProperty("genre")
    private String genre;
    @JsonbProperty("publication")
    private String publicationDate;
    @JsonbProperty("page_count")
    private int pageCount;
    @JsonbProperty("publisher")
    private String publisher;
    @JsonbProperty("isbn")
    private String isbn;
    @JsonbProperty("format")
    private String format;
    @JsonbProperty("dimensions")
    private String dimensions;
    @JsonbProperty("language")
    private String language;
    @JsonbProperty("weight")
    private String weight;
    private final static String[] attributes = { "Titte", "Author", "Genre",
        "Publication", "Pages", "Publisher", "ISBN", "Format", "Dimensions",
        "Language", "Weight"
    };
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methodes">
    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getGenre() {
        return this.genre;
    }
    public String getPublicationDate() {
        return this.publicationDate;
    }
    public int getPageCount() {
        return this.pageCount;
    }
    public String getPublisher() {
        return this.publisher;
    }
    public String getIsbn() {
        return this.isbn;
    }
    public String getFormat() {
        return this.format;
    }
    public String getDimensions() {
        return this.dimensions;
    }
    public String getLanguage() {
        return this.language;
    }
    public String getWeight() {
        return this.weight;
    }
    public static String[] getAttributes() {
        return attributes;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    public final void setTitle(String title) {
        this.title = title;
    }
    public final void setAuthor(String author) {
        this.author = author;
    }
    public final void setGenre(String genre) {
        this.genre = genre;
    }
    public final void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
    public final void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public final void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public final void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public final void setFormat(String format) {
        this.format = format;
    }
    public final void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    public final void setLanguage(String language) {
        this.language = language;
    }
    public final void setWeight(String weight) {
        this.weight = weight;
    }
    // </editor-fold>
}