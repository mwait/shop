package com.wait.model;





import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by mc on 2016-02-27.
 */

@Entity
public class Cart implements Serializable {
    
	
	private static final long serialVersionUID = 7339538708297341393L;
	
	@Id
	@GeneratedValue
	private int cartId;
	
	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItem;
	
	@OneToOne
	@JoinColumn(name="customerId")
	@JsonIgnore
	private Customer customer;
	
	private double grandTota;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getGrandTota() {
		return grandTota;
	}

	public void setGrandTota(double grandTota) {
		this.grandTota = grandTota;
	}
	
	
	
	
	/*private String cartId;
    private Map<String, CartItem> cartItems;
    private double grandTotal;


    private Cart() {
        cartItems = new HashMap<String, CartItem>();
        grandTotal=0;
    }

    public Cart(String cartId) {
        this();
        this.cartId=cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void addCartItem(CartItem item){
        int productIdInt = item.getProduct().getProductId();
        String productId=Integer.toString(productIdInt);
        if(cartItems.containsKey(productId)){
        CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity()+item.getQuantity());
            //mua
            existingCartItem.setTotalPrice(existingCartItem.getQuantity()*existingCartItem.getProduct().getProductPrice());
            cartItems.put(productId, existingCartItem);
        } else {
            cartItems.put(productId, item);
        }

        updateGrandTotal();
    }

    public void removeCartItem (CartItem item) {
        int productIdInt=item.getProduct().getProductId();
        String productId = Integer.toString(productIdInt);
        cartItems.remove(productId);
        updateGrandTotal();
    }

    public void updateGrandTotal() {
        grandTotal=0;
        for(CartItem item : cartItems.values()){
            grandTotal = grandTotal + item.getTotalPrice();
        }
    }*/
}
