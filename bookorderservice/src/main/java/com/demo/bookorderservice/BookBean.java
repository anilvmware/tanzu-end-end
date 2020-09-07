package com.demo.bookorderservice;

public class BookBean {

	private Long id;
    private String name;
    private Double price;
    private int quantityLeft;

    
	public BookBean() {
		
    }

    public BookBean(Long id, String name, Double price, int quantityLeft) {
    	this.id = id;
        this.name = name;
        this.price = price;
        this.quantityLeft = quantityLeft;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public int getQuantityLeft() {
		return quantityLeft;
	}

	public void setQuantityLeft(int quantityLeft) {
		this.quantityLeft = quantityLeft;
	}

    @Override
    public String toString() {
        
        return "Book{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", quantity Left = " + quantityLeft +
        '}';
    }
}
