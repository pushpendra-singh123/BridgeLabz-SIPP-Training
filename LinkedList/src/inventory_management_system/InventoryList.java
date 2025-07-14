package inventory_management_system;

class InventoryList {
    private InventoryNode head;

    public void addAtBeginning(String name, int id, int qty, double price) {
        InventoryNode newNode = new InventoryNode(name, id, qty, price);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(String name, int id, int qty, double price) {
        InventoryNode newNode = new InventoryNode(name, id, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        InventoryNode current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }

    public void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos <= 1 || head == null) {
            addAtBeginning(name, id, qty, price);
            return;
        }

        InventoryNode newNode = new InventoryNode(name, id, qty, price);
        InventoryNode current = head;
        for (int i = 1; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void removeById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        InventoryNode current = head;
        while (current.next != null && current.next.itemId != id) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Item removed.");
        } else {
            System.out.println("Item ID not found.");
        }
    }

    public void updateQuantity(int id, int newQty) {
        InventoryNode current = head;
        while (current != null) {
            if (current.itemId == id) {
                current.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item ID not found.");
    }

    public void searchItem(String key) {
        InventoryNode current = head;
        boolean found = false;

        while (current != null) {
            if (String.valueOf(current.itemId).equals(key) || current.itemName.equalsIgnoreCase(key)) {
                System.out.println("Item → ID: " + current.itemId + ", Name: " + current.itemName +
                        ", Qty: " + current.quantity + ", Price: " + current.price);
                found = true;
            }
            current = current.next;
        }

        if (!found) System.out.println("Item not found.");
    }

    public void calculateTotalValue() {
        double total = 0;
        InventoryNode current = head;

        while (current != null) {
            total += current.quantity * current.price;
            current = current.next;
        }

        System.out.println("Total Inventory Value: ₹" + total);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        InventoryNode current = head;
        System.out.println("--- Inventory ---");
        while (current != null) {
            System.out.println("ID: " + current.itemId + ", Name: " + current.itemName +
                    ", Qty: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }

    // Sorting
    public void sort(String sortBy, boolean ascending) {
        head = mergeSort(head, sortBy, ascending);
        System.out.println("Inventory sorted by " + sortBy + " (" + (ascending ? "asc" : "desc") + ").");
    }

    private InventoryNode mergeSort(InventoryNode node, String sortBy, boolean asc) {
        if (node == null || node.next == null)
            return node;

        InventoryNode mid = getMiddle(node);
        InventoryNode right = mid.next;
        mid.next = null;

        InventoryNode leftSorted = mergeSort(node, sortBy, asc);
        InventoryNode rightSorted = mergeSort(right, sortBy, asc);

        return merge(leftSorted, rightSorted, sortBy, asc);
    }

    private InventoryNode merge(InventoryNode a, InventoryNode b, String sortBy, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean comp;
        if (sortBy.equalsIgnoreCase("name")) {
            comp = asc ? a.itemName.compareToIgnoreCase(b.itemName) <= 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            comp = asc ? a.price <= b.price : a.price > b.price;
        }

        if (comp) {
            a.next = merge(a.next, b, sortBy, asc);
            return a;
        } else {
            b.next = merge(a, b.next, sortBy, asc);
            return b;
        }
    }

    private InventoryNode getMiddle(InventoryNode node) {
        if (node == null) return node;

        InventoryNode slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
