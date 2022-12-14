package com.shrimpco.bookclub.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Title is required!")
	@Size(min=2, max=50)
	private String title;
	
	@NotEmpty(message="Author is required!")
	@Size(min=2, max=50)
	private String author;
	
	@NotEmpty(message="Description must not be blank!")
	@Size(min=2, max=250)
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "likes", 
        joinColumns = @JoinColumn(name = "book_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	

	public Book() {}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
    
//end	
}
