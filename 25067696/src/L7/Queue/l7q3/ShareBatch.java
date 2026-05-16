package L7.Queue.l7q3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ShareStock {
    public static void main(String[] args) {
        Queue<ShareBatch> queue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int totalCapitalGain = 0;

        while(true) {
            System.out.print("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
            String input = sc.nextLine().toLowerCase();
            String[] words = input.split(" ");
            String action = words[0];
            int quantity = Integer.parseInt(words[1]);
            String priceString = words[4].replace("$", "");
            int price = Integer.parseInt(priceString);

            if(action.equalsIgnoreCase("buy")) {
                queue.add(new ShareBatch(quantity, price));

                System.out.println("Buying now...");
                System.out.print("Queue for Share: Queue: [");
                int count = 0;
                for (ShareBatch q : queue) {
                    System.out.print(q.getQuantity());
                    if (count < queue.size() - 1) {
                        System.out.print(", ");
                    }
                    count++;
                }
                System.out.print("]");
                System.out.println();

                count = 0;

                System.out.print("Queue for Price: Queue: [");
                for (ShareBatch q : queue) {
                    System.out.print(q.getPrice());
                    if (count < queue.size() - 1) {
                        System.out.print(", ");
                    }
                    count++;
                }
                System.out.print("]");
                System.out.println();

            } else if(action.equalsIgnoreCase("sell")) {
                System.out.println("Selling the shares now...");
                if(queue.isEmpty()) {
                    System.out.println("No shares to sell!");
                } else {
                    int sellQty = quantity;
                    int sellPrice = price;

                    while (sellQty > 0 && !queue.isEmpty()){
                        ShareBatch front = queue.peek();

                        if(front.getQuantity() >= sellQty) {
                            int profit = (sellPrice - front.getPrice()) * sellQty;
                            totalCapitalGain += profit;

                            int currentQuantity = front.getQuantity();
                            currentQuantity -= sellQty;
                            front.setQuantity(currentQuantity);
                            if(front.getQuantity() == 0) {
                                queue.remove(front);
                            }
                            sellQty = 0;

                        } else if(front.getQuantity() <= sellQty) {
                            int profit = (sellPrice - front.getPrice()) * front.getQuantity();
                            totalCapitalGain += profit;

                            sellQty = sellQty - front.getQuantity();
                            queue.remove(front);
                        }
                    }

                System.out.println("Capaital Gain / Loss: $" + totalCapitalGain);
                System.out.print("Queue for Share: Queue: [");
                int count = 0;
                for (ShareBatch q : queue) {
                    System.out.print(q.getQuantity());
                    if (count < queue.size() - 1) {
                        System.out.print(", ");
                    }
                    count++;
                }
                System.out.print("]");
                System.out.println();

                count = 0;
                
                System.out.print("Queue for Price: Queue: [");
                for (ShareBatch q : queue) {
                    System.out.print(q.getPrice());
                    if (count < queue.size() - 1) {
                        System.out.print(", ");
                    }
                    count++;
                }
                System.out.print("]");
                System.out.println();
                
                }
            }        
            
        }
    }
}

class ShareBatch {
    private int quantity;
    private int price;

    public ShareBatch(int q, int p) {
        this.quantity = q;
        this.price = p;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
}


