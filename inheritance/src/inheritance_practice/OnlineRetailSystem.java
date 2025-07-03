package inheritance_practice;

//Multilevel Inheritance


class Order {
    String orderId;
    String orderDate;

    // Constructor for Order
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to get order status
    public String getOrderStatus() {
        return "Order Placed";
    }
}


class ShippedOrder extends Order {
    String trackingNumber;

    // Constructor for ShippedOrder
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);  // Call Order constructor
        this.trackingNumber = trackingNumber;
    }

    // Overriding getOrderStatus
    @Override
    public String getOrderStatus() {
        return "Order Shipped (Tracking Number: " + trackingNumber + ")";
    }
}


//Second Level Subclass
class DeliveredOrder extends ShippedOrder {
 String deliveryDate;

 // Constructor for DeliveredOrder
 public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
     super(orderId, orderDate, trackingNumber);  // Call ShippedOrder constructor
     this.deliveryDate = deliveryDate;
 }

 // Overriding getOrderStatus
 @Override
 public String getOrderStatus() {
     return "Order Delivered on: " + deliveryDate;
 }
}


public class OnlineRetailSystem {
    public static void main(String[] args) {
        // Create an Order object
        Order order = new Order("ORD001", "2025-07-02");
        System.out.println("Order Status: " + order.getOrderStatus());

        // Create a ShippedOrder object
        ShippedOrder shippedOrder = new ShippedOrder("ORD002", "2025-07-01", "TRK123456");
        System.out.println("Order Status: " + shippedOrder.getOrderStatus());

        // Create a DeliveredOrder object
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD003", "2025-06-30", "TRK789123", "2025-07-02");
        System.out.println("Order Status: " + deliveredOrder.getOrderStatus());
    }
}
