    package com.Aries.Thymeleaf_Bootstrap.Entity;

    import jakarta.persistence.*;
    import org.springframework.boot.autoconfigure.domain.EntityScan;
    import org.springframework.context.annotation.Primary;

    @Entity
    public class Book {

@Id
//@GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id;
        @Column
        private String title;
        @Column
        private String author;



        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        public Book() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
    }
