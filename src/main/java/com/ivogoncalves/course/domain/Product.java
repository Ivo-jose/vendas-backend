package com.ivogoncalves.course.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tb_product_category", 
        joinColumns = { @JoinColumn(name = "product_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany(mappedBy = "id.product", fetch = FetchType.EAGER)
	private Set<OrderItem> items = new HashSet<>();
	
	public Product() {
	} 

	
	public Product(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public Double getPrice() {
		return price;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public Set<Category> getCategories() {
		return categories;
	}
	
	public void addCategories(Category category) {
		this.categories.add(category);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@JsonIgnore
	public Set<Order> getOrders() {
		Set<Order> list = new HashSet<>();
		
		for(OrderItem x : items) {
			list.add(x.getOrder());
		}
		
		return list;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
