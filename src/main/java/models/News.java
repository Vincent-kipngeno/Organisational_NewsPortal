package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class News {
    private int id;
    private String content;
    private String author;
    private long createdAt;
    private String formattedCreatedAt;

    public News(int id, String content, String author, long createdAt) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = System.currentTimeMillis();
        setFormattedCreatedAt();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public String getFormattedCreatedAt() {
        Date date = new Date(createdAt);
        String datePattern = "MMM/dd/yyyy @ K:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        return sdf.format(date);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = System.currentTimeMillis();
    }

    public void setFormattedCreatedAt() {
        Date date = new Date(createdAt);
        String datePattern = "MMM/dd/yyyy @ K:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        this.formattedCreatedAt = sdf.format(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(content, news.content) &&
                Objects.equals(author, news.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, author);
    }
}
