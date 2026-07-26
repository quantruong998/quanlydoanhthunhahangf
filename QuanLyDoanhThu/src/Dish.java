/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Dish {
    private int id;
    private String type;
    private String name;
    private String description;
    private float price; // Giá hiện hành
    
    private int totalSold;
    private float totalRevenue;

    public Dish() {}

    public Dish(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public int getTotalSold() { return totalSold; }
    public void setTotalSold(int totalSold) { this.totalSold = totalSold; }
    
    public float getTotalRevenue() { 
    return totalRevenue; 
}

public void setTotalRevenue(float totalRevenue) { 
    this.totalRevenue = totalRevenue; 
}
}
