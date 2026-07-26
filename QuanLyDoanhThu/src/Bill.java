/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Bill {
    private int id;
    private String paymentDate;
    private float totalAmount;
    private String note;
    private int staffID;
    private int customerID;
    private int tableID;
    private int quantity; // Số lượng của món ăn cụ thể trong hóa đơn này
    
    public Bill() {}

    public Bill(String paymentDate, float totalAmount) {
        this.paymentDate = paymentDate;
        this.totalAmount = totalAmount;
    }
    
    

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public float getTotalAmount() { return totalAmount; }
    public void setTotalAmount(float totalAmount) { this.totalAmount = totalAmount; }
    
    public String getNote() { 
    return note; 
}

public void setNote(String note) { 
    this.note = note; 
}
}
