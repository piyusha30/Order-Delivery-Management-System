package cms;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

class MainSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt1, opt2, opt3;
        char option;
        Operations1 opr = new Operations1();
        System.out.println("\t\t\t*********WELCOME TO ONLINE DELIVERY SYSTEM*********");
        System.out.println("\t\t\t---------------customer is our number 1 priority!--");
        do {
            System.out.println("\n\n\nPLEASE ENTER 1 IF YOU ARE CUSTOMER !!");
            System.out.println("PLEASE ENTER 2 IF YOU ARE EMPLOYEE !!");

            opt1 = sc.nextInt();
            switch (opt1) {
                case 1:

                    System.out.println("WELCOME DEAR CUSTOMER!!");
                    do {
                        System.out.println("\n-------MENU-------");
                        System.out.println("Press 1 to place order");
                        System.out.println("Press 2 to display order");
                        System.out.println("Press 3 to track order");
                        System.out.println("Press 4 to EXIT");
                        opt2 = sc.nextInt();
                        switch (opt2) {
                            case 1:
                                opr.accept_order();
                                System.out.println("ORDER ACCEPTED");
                                break;
                            case 2:
                                opr.display_order();
                                break;
                            case 3:
                                opr.track_order();
                                break;
                            case 4:
                                System.out.println("--THANK YOU!---");
                                System.out.println("--DO VISIT AGAIN SOON!---");
                                break;
                            default:
                                System.out.println("Please enter valid option");

                        }
                        System.out.println("\n---DEAR USER would you like to place or visit another order!!--");
                        System.out.println("---IF YES,input y else input n!!---");

                        option = sc.next().charAt(0);
                    } while (option == 'y');
                    break;
                case 2:
                    System.out.println("WELCOME EMPLOYEE!!");

                    do {
                        System.out.println("\n-------MENU-------");
                        System.out.println("Press 1 to DISPLAY LIST ");
                        System.out.println("Press 2 to UPDATE DETAILS ");// list ,upd status
                        System.out.println("Press 3 to VIEW TODAYS QUEUE by DISTANCE");
                        System.out.println("Press 4 to VIEW TODAY'S QUEUE BY TIME SLOTS ");
                        System.out.println("Press 5 to EXIT");
                        opt2 = sc.nextInt();
                        switch (opt2) {
                            case 1:
                                opr.list_display();
                                break;
                            case 2:
                                opr.update_list();
                                break;
                            case 3:
                                opr.display_path();
                                break;
                            case 4: opr.separate_time();
                            break;
                            case 5:
                                System.out.println("--THANK YOU!---");
                                break;
                            default:
                                System.out.println("Please enter valid option");
                        }
                        System.out.println("\nDEAR USER would you like to edit or visit another order");
                        System.out.println("IF YES,input y else input n");

                        option = sc.next().charAt(0);
                    } while (option == 'y');
                    break;
                default:
                    System.out.println("Please enter valid option");
            }
            System.out.println("\n\n\t\t\tTO RETURN TO MAIN MENU PRESS 1,else PRESS 0");
            opt3 = sc.nextInt();
        } while (opt3 != 0);
        System.out.println("----THANKYOU!----");
    }
}

class details {
    String name, order;
    int price, id, time, weight;
    char size;
    String end_des, status;
    int priority = 0;
    String getName()
    {
        return name;
    }
    String getOrder()
    {
        return order;
    }
    String getend_des()
    {
        return end_des;
    }
    String get_id()
    {
        return Integer.toString(id);
    }
    String get_status(){
        return status;
    }

}

class Operations1 {

    static Scanner sc = new Scanner(System.in);
    int i = 0, n = 0, num = 0, add = 0;
    details[] user = new details[50];

    void accept_order() {
        int op, id = 0;
        num = n;
        System.out.println("Enter the number of orders you want to place");
        add = sc.nextInt();
        n = num + add;

        for (i = num; i < (n); i++) {
            user[i] = new details();
            System.out.println("\nEnter details for order no " + (i + 1) + " :");
            System.out.println("Please enter NAME:");
            user[i].id = i + 1;
            user[i].name = sc.next();
            System.out.println("\nAVAILABLE BOUQUETS:");
            System.out.println("Please enter ORDER:");
            System.out.println("PRESS 1 FOR ROSE FLOWERS");
            System.out.println("PRESS 2 FOR LILY FLOWERS");
            System.out.println("PRESS 3 FOR ORCHID FLOWERS");
            op = sc.nextInt();
            if (op == 1) {
                user[i].order = "rose";
                System.out.println("ROSE FLOWERS BOUQUET BOOKED");
            }
            if (op == 2) {
                user[i].order = "lily";
                System.out.println("LILY FLOWERS BOUQUET BOOKED");
            }
            if (op == 3) {
                user[i].order = "orchid";
                System.out.println("ORCHID FLOWERS BOUQUET BOOKED");
            }
            System.out.println("\nEnter the size of Bouquet as per S-small, M-medium ,L-large:");
            user[i].size = sc.next().charAt(0);
//assign price according to size
            if (user[i].size == 'S' || user[i].size == 's') {
                user[i].price = 150;
                System.out.println("SIZE S BOOKED!(PRICE=150 ruppes)");
            } else if (user[i].size == 'M' || user[i].size == 'm') {
                user[i].price = 300;
                System.out.println("SIZE M BOOKED!(PRICE=300 ruppes)");
            } else if (user[i].size == 'L' || user[i].size == 'l') {
                user[i].price = 450;
                System.out.println("SIZE L BOOKED!(PRICE=450ruppes)");
            }

            System.out.println("\nAVAILABLE AREAS FOR DELIVERY:");
            System.out.println("Enter 1 for KARVENAGAR COLLECTION CENTRE");
            System.out.println("Enter 2 for DECCAN COLLECTION CENTRE");
            System.out.println("Enter 3 for BANER COLLECTION CENTRE");
            System.out.println("Enter 4 for AUNDH COLLECTION CENTRE");
            System.out.println("Enter 5 for WARJE COLLECTION CENTRE");
            int c = sc.nextInt();

            if (c == 1) {
                user[i].end_des = "KARVENAGAR";
                user[i].weight = 1;
            }
            if (c == 2) {
                user[i].end_des = "DECCAN";
                user[i].weight = 2;
            }
            if (c == 3) {
                user[i].end_des = "BANER";
                user[i].weight = 3;
            }
            if (c == 4) {
                user[i].end_des = "AUNDH";
                user[i].weight = 4;
            }
            if (c == 5) {
                user[i].end_des = "WARJE";
                user[i].weight = 5;
            }
            id = id + 1;
            user[i].id = id;

            System.out.println("PLease enter  time for delivery:");
            System.out.println("\nAVAILABLE TIME SLOT:");

            System.out.println("Please enter required time slot:");

            System.out.println("PRESS 1 FOR 8 hrs t0 11 hrs ");

            System.out.println("PRESS 2 FOR 13 hrs to 16 hrs");

            System.out.println("PRESS 3 FOR 17 hrs to 20 hrs");

            int t = sc.nextInt();

            if (t == 1) {

                user[i].time = 8;

                System.out.println("8 am to 10 am time slot BOOKED");

            }

            if (t == 2) {

                user[i].time = 13;
                System.out.println("1 pm to 4 pm time slot BOOKED");

            }

            if (t == 3) {

                user[i].time = 17;
                System.out.println("5  pm to 8 pm time slot BOOKED");

            }

            System.out.println("DEAR USER,WE THANK YOU FOR YOUR COOPERATION!");
            user[i].status = "Pending";

        }

    }

    void display_order() {
        if (n != 0) {
            System.out.println("YOUR ORDERS ARE ACCEPTED!!");

            System.out.println("\n\n---ORDER DETAILS---");
            for (int i = num; i < n; i++) {
                System.out.println("\nDetails for Order number " + (i + 1) + " :");

                System.out.println("CUSTOMER NAME:" + user[i].name);
                System.out.println("CUSTOMER ORDER:" + user[i].order);
                System.out.println("ORDER SIZE:" + user[i].size);
                System.out.println("ORDER PRICE:" + user[i].price);
                System.out.println("ORDER UNIQUE ID:" + user[i].id);
                System.out.println("ORDER DELIVERY time:" + user[i].time + "hrs");
                System.out.println("ORDER END DESTINATION:" + user[i].end_des);
            }
        } else {
            System.out.println("No order has been placed yet");
        }
    }

    void track_order() {
        System.out.println("Please enter your unique id : ");
        int id = sc.nextInt();
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (user[i].id == id) {
                flag = 1;
                System.out.println("Tracking order...");
                System.out.println("Status of your order : " + user[i].status);

            }
        }
        if (flag == 0) {
            System.out.println("Sorry ,No such with this id found!");

        }
    }

    void list_display() {
        if (n != 0) {
            System.out.println("YOUR ORDERS ARE ACCEPTED!!");

            System.out.println("\n\n---ORDER DETAILS---");
            for (int i = 0; i < n; i++) {
                System.out.println("\nDetails for Order number " + (i + 1) + " :");

                System.out.println("CUSTOMER NAME:" + user[i].name);
                System.out.println("CUSTOMER ORDER:" + user[i].order);
                System.out.println("ORDER SIZE:" + user[i].size);
                System.out.println("ORDER PRICE:" + user[i].price);
                System.out.println("ORDER UNIQUE ID:" + user[i].id);
                System.out.println("ORDER DELIVERY time:" + user[i].time + "hrs");
                System.out.println("ORDER END DESTINATION:" + user[i].end_des);
            }
        } else {
            System.out.println("No order has been placed yet");
        }

    }

    void update_list() {
        System.out.println("Enter the user unique id to uptime");
        int id = sc.nextInt();
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (user[i].id == id) {
                flag = 1;
                System.out.println("Enter the status to be updated : ");
                String status = sc.next();
                user[i].status = status;
                System.out.println("Status updated!");
            }
        }
        if (flag == 0) {
            System.out.println("Invalid user Id");
        }
    }


    void separate_time() {
        Queue<details> Q1 = new LinkedList<>();
        Queue<details> Q2 = new LinkedList<>();
        Queue<details> Q3 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (user[i].time == 8) {
                Q1.add(user[i]);
            }
            if (user[i].time == 13) {
                Q2.add(user[i]);
            }
            if (user[i].time == 17) {
                Q3.add(user[i]);
            }
        }
        System.out.println("Displaying list :");
        System.out.println("\n---Queue for 8hr to 11hrs---");
        display(Q1);
        System.out.println();

        System.out.println("\n---Queue for 1 to 4 hrs---");
        display(Q2);
        System.out.println();
        System.out.println("\n---Queue for 5 to 8 hrs---");
        display(Q3);


    }


    void display(Queue<details> q1) {
        details q1_peek = q1.peek();
        Queue<details> sorted_queue = q1;
        while (sorted_queue.isEmpty() != true) {
            details temp = sorted_queue.remove();
            System.out.println("CUSTOMER NAME:" + temp.name);
            System.out.println("CUSTOMER ORDER:" + temp.order);
            System.out.println("ORDER SIZE:" + temp.size);
            System.out.println("ORDER PRICE:" + temp.price);
            System.out.println("ORDER UNIQUE ID:" + temp.id);
            System.out.println("ORDER DELIVERY time:" + temp.time + "hrs");
            System.out.println("ORDER END DESTINATION:" + temp.end_des);
        }
    }
        void display_path(){
           // Operations op = new Operations();

            System.out.println("Displaying Queue");

            System.out.println("\n\nTime:8hrs");


            PriorityQueue<details> priorityQueue = new PriorityQueue<details>(10, new priority());
            for (int i = 0; i < n; i++) {

                priorityQueue.add(user[i]);

            }
            int i = 0;
            // the print section that have to use poll()
            //  while (!priorityQueue.isEmpty()) {
            while (priorityQueue.peek() != null) {

                System.out.println(priorityQueue.peek().get_id() + "  " + priorityQueue.peek().getName() + "  " + priorityQueue.peek().getOrder() + "  " + priorityQueue.peek().getend_des() + "  " + priorityQueue.peek().get_status());
                priorityQueue.poll();
                i++;
            }

        }

    }


