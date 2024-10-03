import java.util.*;

class finalcoursework {
    static String[] idarray = new String[0];
    static String[] contactnumber = new String[0];
    static int[] qtyarray = new int[0];
    static double[] amountarray = new double[0];
    static String[] tshirtsizearray = new String[0];

    static String odr = "ODR#";
    static int orderNumber = 0;
    static String newOrderID;
    static String contact;
    static int QTY;
    static double amount;
    static String tshirtsize;

    static String numberid;
    static boolean isvalidate;

    static int tempMcount = 0;
    static int tempScount = 0;
    static int tempXScount = 0;
    static int tempLcount = 0;
    static int tempXLcount = 0;
    static int tempXXLcount = 0;

    static double Mamount = 0;
    static double Samount = 0;
    static double XSamount = 0;
    static double Lamount = 0;
    static double XLamount = 0;
    static double XXLamount = 0;
    static double Totalamount = 0;
    static final String Status = "PROCESSING";

    static String searchoid;
    static boolean istrue;

    static boolean istruedelete;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println(
                " /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$                          ");
        System.out.println(
                "| $$_____/                | $$      |__/                           /$$__  $$| $$                          ");
        System.out.println(
                "| $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ ");
        System.out.println(
                "| $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
        System.out.println(
                "| $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
        System.out.println(
                "| $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
        System.out.println(
                "| $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
        System.out.println(
                "|__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/ ");
        System.out.println(
                "                                                                                                | $$      ");
        System.out.println(
                "                                                                                                | $$      ");
        System.out.println(
                "                                                                                                |__/      ");

        System.out.println(
                "\n\n_____________________________________________________________________________________________________________\n\n");

        System.out.println(
                "\t\t[1]place Order                                                      [2]Search Customrer\n");
        System.out.println("\t\t[3]Search Order                                                     [4]View Reports\n");
        System.out.println("\t\t[5]Set Order Status                                                 [6]Delete Order");

        System.out.print("\n\nInput Option : ");
        int Option = input.nextInt();

        switch (Option) {
            case 1:
                placeorder();
                break;
            case 2:
                SearchCustomer();
                break;
            case 3:
                SearchOrder();
                break;
            case 4:
                viewreports();
                break;
            case 5:
                setorder();
                break;
            case 6:
                deleteorder();
                break;
            default:
                break;
        }

    }

    public static void placeorder() {

        System.out.println("\t\t\t  _____  _                   ____          _           ");
        System.out.println("\t\t\t |  __ \\| |                 / __ \\        | |          ");
        System.out.println("\t\t\t | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ ");
        System.out.println("\t\t\t |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
        System.out.println("\t\t\t | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   ");
        System.out.println("\t\t\t |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   ");

        Scanner input = new Scanner(System.in);
        orderNumber++;
        System.out.print("\n\n\nEnter Order ID :");
        String odernumber = generateOrderID();
        System.out.println(odernumber);

        customernumber();

        Tshirtsize();

        EnterQty();

        amount();

        completeorder();

        navigate();

    }

    public static String generateOrderID() {
        int tempOrderNumber = orderNumber;
        int[] tempNumOrder = new int[5];
        String idNum = "";
        String tag = "ODR#";
        newOrderID = "";
        for (int i = 4; tempOrderNumber > 0; i--) {
            tempNumOrder[i] = tempOrderNumber % 10;
            tempOrderNumber /= 10;
        }
        for (int i = 0; i < tempNumOrder.length; i++) {
            idNum += tempNumOrder[i];
        }
        newOrderID = tag + idNum;
        return newOrderID;
    }

    public static void customernumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Customer Number : ");
        contact = input.nextLine();

        if (contact.length() != 10 || contact.charAt(0) != '0') {
            System.out.println("\t\tinvalid phone number....Try again");
            System.out.print("Do you want to enter phone number again? (y/n) :");
            char yesno = input.next().charAt(0);

            if (yesno == 'y' || yesno == 'Y') {
                customernumber();
            } else if (yesno == 'N' || yesno == 'n') {
                main(null);
            } else {
                System.out.print("\033[1A");
            }
        }

    }

    public static void Tshirtsize() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter T-shirt Size(XS/S/M/L/XL/XXL) :");
        tshirtsize = input.next().toUpperCase();

        if (tshirtsize.equals("XS") || tshirtsize.equals("S") || tshirtsize.equals("L") || tshirtsize.equals("XL")
                || tshirtsize.equals("M") || tshirtsize.equals("XXL")) {

        } else {
            System.out.print("\033[1A");
            System.out.print("\033[0J");
            Tshirtsize();
        }

    }

    public static void EnterQty() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter QTY : ");
        QTY = input.nextInt();
        if (QTY <= 0) {
            System.out.print("\033[1A");
        }
    }

    public static void amount() {
        Scanner input = new Scanner(System.in);

        switch (tshirtsize) {
            case "XS":
                amount = 600 * QTY;
                break;
            case "S":
                amount = 800 * QTY;
                break;
            case "M":
                amount = 900 * QTY;
                break;
            case "L":
                amount = 1000 * QTY;
                break;
            case "XL":
                amount = 11000 * QTY;
            case "XXL":
                amount = 12000 * QTY;
            default:
                break;
        }
        System.out.println("Amount : " + amount);

    }

    public static void completeorder() {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you wat to place this order(y/N)");
        char yesno = input.next().charAt(0);
        if (yesno == 'y' || yesno == 'Y') {
            storedata();

        } else if (yesno == 'n' || yesno == 'N') {
            navigate();
        }

    }

    public static void storedata() {
        String[] tempidarray = new String[idarray.length + 1];
        String[] tempcontact = new String[contactnumber.length + 1];
        int[] tempqty = new int[qtyarray.length + 1];
        double[] tempamountarray = new double[amountarray.length + 1];
        String[] temptshirtsizearray = new String[tshirtsizearray.length + 1];

        for (int i = 0; i < idarray.length; i++) {
            tempidarray[i] = idarray[i];
        }
        for (int i = 0; i < contactnumber.length; i++) {
            tempcontact[i] = contactnumber[i];
        }
        for (int i = 0; i < amountarray.length; i++) {
            tempamountarray[i] = amountarray[i];
        }
        for (int i = 0; i < tshirtsizearray.length; i++) {
            temptshirtsizearray[i] = tshirtsizearray[i];
        }
        for (int i = 0; i < qtyarray.length; i++) {
            tempqty[i] = qtyarray[i];
        }

        tempidarray[tempidarray.length - 1] = newOrderID;
        idarray = tempidarray;

        tempcontact[tempcontact.length - 1] = contact;
        contactnumber = tempcontact;

        tempqty[tempqty.length - 1] = QTY;
        qtyarray = tempqty;

        tempamountarray[tempamountarray.length - 1] = amount;
        amountarray = tempamountarray;

        temptshirtsizearray[temptshirtsizearray.length - 1] = tshirtsize;
        tshirtsizearray = temptshirtsizearray;

        // System.out.println(Arrays.toString(contactnumber));
        // System.out.println(Arrays.toString(idarray));
        // System.out.println(Arrays.toString(tshirtsizearray));
        // System.out.println(Arrays.toString(amountarray));
        // System.out.println(Arrays.toString(qtyarray));
        // System.out.println("order placed");
    }

    public static void navigate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you wat to enter another order(y/N)");
        char yesno = input.next().charAt(0);
        if (yesno == 'y') {
            placeorder();
        } else if (yesno == 'n') {
            main(null);
        }

    }

    public static void SearchCustomer() {
        System.out.println("   _____                     _        _____          _                            ");
        System.out.println("  / ____|                   | |      / ____|        | |                           ");
        System.out.println(" | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ");
        System.out.println("  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|");
        System.out.println("  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   ");
        System.out
                .println(" |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   ");

        System.out.println(
                "\n\n_________________________________________________________________________________________\n\n");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Customer Phone Number :");
        numberid = input.nextLine();
        searchcontact();

    }

    public static void searchcontact() {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < contactnumber.length; i++) {

            if (numberid.equals(contactnumber[i])) {

                if (tshirtsizearray[i].equals("M")) {
                    tempMcount = tempMcount + qtyarray[i];

                } else if (tshirtsizearray[i].equals("XS")) {
                    tempXScount = tempXScount + qtyarray[i];
                } else if (tshirtsizearray[i].equals("S")) {
                    tempScount = tempScount + qtyarray[i];
                } else if (tshirtsizearray[i].equals("L")) {
                    tempLcount = tempLcount + qtyarray[i];
                } else if (tshirtsizearray[i].equals("XL")) {
                    tempXLcount = tempXLcount + qtyarray[i];
                } else if (tshirtsizearray[i].equals("XXL")) {
                    tempXXLcount = tempXXLcount + qtyarray[i];
                }

            } else {

                System.out.println("Invalid Input...");
                System.out.println("Do you want to enter phone number again? (y/n) :");
                char yesno = input.next().charAt(QTY);

                if (yesno == 'y' || yesno == 'Y') {
                    customernumber();
                } else if (yesno == 'N' || yesno == 'n') {
                    main(null);
                } else {
                    System.out.print("\033[1A");
                }
            }

        }

        printresult();

    }

    public static void printresult() {
        Mamount = tempMcount * 900;
        XLamount = tempXLcount * 1100;
        XXLamount = tempXXLcount * 1200;
        XSamount = tempXScount * 600;
        Samount = tempScount * 800;
        Lamount = tempLcount * 1000;
        Totalamount = Mamount + XLamount + XXLamount + XSamount + Samount + Lamount;

        System.out.printf("%-9s+%13s", "+------+-------", "------------+");
        System.out.printf("%-9s|%13s", "\n| Size | QTY   ", " Amount |");
        System.out.printf("%-9s+%13s", "\n+------+-------", "------------+");
        System.out.println();
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "M", tempMcount, Mamount);
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "XL", tempXLcount, XLamount);
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "XXL", tempXXLcount, XXLamount);
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "XS", tempXScount, XSamount);
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "S", tempScount, Samount);
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "L", tempLcount, Lamount);
        System.out.printf("+------+-------+------------+\n");
        System.out.printf("%-1s|%11.2f |", "| Total Amount ", Totalamount);
        System.out.printf("\n+--------------+------------+\n");

        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to search phone number again? (y/n) :");
        char yesno = input.next().charAt(0);

        if (yesno == 'y' || yesno == 'Y') {
            SearchCustomer();
        } else if (yesno == 'N' || yesno == 'n') {
            main(null);
        } else {
            System.out.print("\033[1A");
        }

    }

    public static void SearchOrder() {
        Scanner input = new Scanner(System.in);

        System.out.println("   _____                     _        ____          _           ");
        System.out.println("  / ____|                   | |      / __ \\        | |          ");
        System.out.println(" | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ ");
        System.out.println("  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|");
        System.out.println("  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   ");
        System.out.println(" |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|   ");

        System.out.println("\n\n_____________________________________________________________\n\n");

        System.out.print("\nEnter Order ID :");
        searchoid = input.nextLine();

        searchoid();
    }

    public static void searchoid() {
        Scanner input = new Scanner(System.in);
        istrue = false;
        for (int i = 0; i < idarray.length; i++) {

            if (searchoid.equals(idarray[i])) {
                System.out.println("\nPhone number :" + contactnumber[i]);
                System.out.println("Size         :" + tshirtsizearray[i]);
                System.out.println("QTY          :" + qtyarray[i]);
                System.out.println("Amount       :" + amountarray[i]);
                System.out.println("Status       :" + Status);

                istrue = true;

                System.out.print("Do you want to search Oder ID again? (y/n) :");
                char yesno = input.next().charAt(0);

                if (yesno == 'y' || yesno == 'Y') {
                    SearchOrder();
                } else if (yesno == 'N' || yesno == 'n') {
                    main(null);
                } else {
                    System.out.print("\033[1A");
                }

            } else {
                continue;
            }

        }

        if (istrue == false) {
            System.out.println("Invalid Input...");
            System.out.println("Do you want to Search Oder ID again? (y/n) :");
            char yesno = input.next().charAt(QTY);

            if (yesno == 'y' || yesno == 'Y') {
                SearchOrder();
            } else if (yesno == 'N' || yesno == 'n') {
                main(null);
            } else {
                System.out.print("\033[1A");
            }
        }
    }

    public static void deleteorder() {
        Scanner input = new Scanner(System.in);

        System.out.println("  _____       _      _          ____          _           ");
        System.out.println(" |  __ \\     | |    | |        / __ \\        | |          ");
        System.out.println(" | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ ");
        System.out.println(" | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
        System.out.println(" | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   ");
        System.out.println(" |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   ");

        System.out.println("\n\n_____________________________________________________________\n\n");

        System.out.print("\nEnter Order ID :");
        searchoid = input.nextLine();

        istruedelete = false;

        for (int i = 0; i < idarray.length; i++) {

            if (searchoid.equals(idarray[i])) {

                System.out.println("\nPhone number :" + contactnumber[i]);
                System.out.println("Size         :" + tshirtsizearray[i]);
                System.out.println("QTY          :" + qtyarray[i]);
                System.out.println("Amount       :" + amountarray[i]);
                System.out.println("Status       :" + Status);

                idarray[i] = null;
                contactnumber[i] = null;
                tshirtsizearray[i] = null;
                qtyarray[i] = 0;
                amountarray[i] = 0;

                istruedelete = true;

                
                System.out.print("Do you want to Delete another order? (y/n) :");
                char yesno = input.next().charAt(0);

                if (yesno == 'y' || yesno == 'Y') {
                    deleteorder();
                } else if (yesno == 'N' || yesno == 'n') {
                main(null);
                } else {
                System.out.print("\033[1A");
                }

            } else {
                continue;
            }

        }

        // System.out.println(Arrays.toString(contactnumber));
        // System.out.println(Arrays.toString(idarray));
        // System.out.println(Arrays.toString(tshirtsizearray));
        // System.out.println(Arrays.toString(qtyarray));
        // System.out.println(Arrays.toString(amountarray));

        if (istrue == false) {
            System.out.println("Invalid Input...");
            System.out.println("Do you want to emter another Oder ID? (y/n) :");
            char yesno = input.next().charAt(QTY);

            if (yesno == 'y' || yesno == 'Y') {
                deleteorder();
            } else if (yesno == 'N' || yesno == 'n') {
                main(null);
            } else {
                System.out.print("\033[1A");
            }
        }

    }

    

    public static void setorder() {

    }

    public static void viewreports() {

    }

    public static void sizeoftshirt() {

        // System.out.printf("%-17s+%-18s+%20s","+----------------","------------------","-------------------+");
        // System.out.printf("%-18s|%-18s|%20s", "\n| Size ", " QTY ", " Amount |");
        // System.out.printf("%19s+%-18s+%20s","\n+----------------","------------------","-------------------+");
        // System.out.printf("%-18s|%-18s|%20s","\n|","","|");
        // System.out.printf("%-18s|%-18s|%20s","\n| M"," ",tempMcount," ","|");

        // Mamount = tempMcount * 900;
        // XLamount = tempXLcount * 1100;
        // XXLamount = tempXXLcount * 1200;
        // XSamount = tempXScount * 600;
        // Samount = tempScount * 800;
        // Lamount = tempLcount * 1000;
        // Totalamount = Mamount + XLamount + XXLamount + XSamount + Samount + Lamount;

        // System.out.printf("%-9s+%13s", "+------+-------", "------------+");
        // System.out.printf("%-9s|%13s", "\n| Size | QTY ", " Amount |");
        // System.out.printf("%-9s+%13s", "\n+------+-------", "------------+");
        // System.out.println();
        // System.out.printf("| %-4s | %-5d | %10.2f |\n", "M", tempMcount, Mamount);
        // System.out.printf("| %-4s | %-5d | %10.2f |\n", "XL", tempXLcount, XLamount);
        // System.out.printf("| %-4s | %-5d | %10.2f |\n", "XXL", tempXXLcount,
        // XXLamount);
        // System.out.printf("| %-4s | %-5d | %10.2f |\n", "XS", tempXScount, XSamount);
        // System.out.printf("| %-4s | %-5d | %10.2f |\n", "S", tempScount, Samount);
        // System.out.printf("| %-4s | %-5d | %10.2f |\n", "L", tempLcount, Lamount);
        // System.out.printf("+------+-------+------------+\n");
        // System.out.printf("%-1s|%11.2f |", "| Total Amount ", Totalamount);
        // System.out.printf("\n+--------------+------------+\n");

        // Scanner input = new Scanner(System.in);
        // System.out.print("\nEnter Customer Phone Number :");
        // numberid = input.nextLine();

    }
}
