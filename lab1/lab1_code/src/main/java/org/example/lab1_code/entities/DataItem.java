package org.example.lab1_code.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "data_items")
public class DataItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    public DataItem() {
    }

    public DataItem(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}