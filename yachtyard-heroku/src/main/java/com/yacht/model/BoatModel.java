package com.yacht.model;

import java.math.BigDecimal;

public class BoatModel 
	{
	    private int id; 
	    private String brand; 
	    private String model; 
	    private int length;
	    private String description; 
	    private BigDecimal price;
	    private String img;


	    //Default
	    public BoatModel()
	    {
	        id = 0;
	        brand = "";
	        model = "";
	        length = 0; 
	        description = "";
	        price = new BigDecimal(0);
	        img = "";



	    }

	    //Parameterized
	    public BoatModel(int id, String  brand, String model, int length, String description, BigDecimal price, String img)
	    {
	        this.id = id; 
	        this.brand = brand; 
	        this.model = model;
	        this.length = length; 
	        this.price = price;
	        this.description = description; 
	        this.img = img;
	    }

	    //id
	    public int getId() 
	    {
	        return id;
	    }
	    public void setId(int id)
	    {
	        this.id=id;
	    }

	     //brand
	    public String getBrand()
	    {
	        return brand;
	    }
	    public void setBrand(String brand)
	    {
	        this.brand=brand;
	    }
	     //type
	     public String getModel()
	    {
	        return model;
	    }
	    public void setModel(String model)
	    {
	        this.model=model;
	    }
	     //length
	    public int getLength()
	    {
	        return length;
	    }
	    public void setLength(int length)
	    {
	        this.length = length;
	    }
	     //description
	    public String getDescription()
	    {
	        return description;
	    }
	    public void setDescription(String description)
	    {
	        this.description=description;
	    }
	     //price
	    public BigDecimal getPrice()
	    {
	        return price; 
	    }
	    public void setPrice(BigDecimal price)
	    {
	        this.price = price; 
	    }
	    //img
	    public String getImg()
	    {
	    	return img;
	    }
	    public void setImg(String img)
	    {
	    	this.img = img;
	    }
	   
	}

