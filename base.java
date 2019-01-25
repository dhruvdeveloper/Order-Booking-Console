//Writer : Dhruv Thakkar
//online-order-booking-by-JAVA

import java.util.Date;

class signup {
    String ss1, ss2;
    int xs = 5;
    int yo = 1;
    Scanner sin = new Scanner(System.in);

    void show() throws Exception {
        FileReader fr = new FileReader("signup.txt");
        FileWriter fw = new FileWriter("signup.txt", true);
        BufferedReader br = new BufferedReader(fr);
        System.out.print("\n\n\tEnter user name : ");
        ss1 = sin.nextLine();
        System.out.print("\tEnter Your Password : ");
        ss2 = sin.nextLine();
        String s = null;
        int temps = 0;
        while ((s = br.readLine()) != null) {
            String words[] = s.split(" ");
            if ((words[0].equals(ss1)) == true) {
                temps = 5;
            }
        }
        if ((temps != 5)) {
            fw.write("\r\n");
            fw.write(ss1 + " " + ss2);
            System.out.print("\n\n\nyou are succsefully signup!\n\n\n\n");
            xs = 0;
            yo = 0;
        } else {
            System.out.print("\n\nSorry! this user name is already alocate to some one please type different again!\n\n");
        }
        fw.close();
    }
}

class Login {
    String sl1, sl2;
    int xl = 4, yoyo = 1;
    Scanner sin = new Scanner(System.in);

    void LoginF() throws Exception {
        FileReader fr = new FileReader("signup.txt");
        FileWriter fw = new FileWriter("signup.txt", true);
        BufferedReader br = new BufferedReader(fr);
        System.out.print("Hello! Welcome to Gala Online!\n\n" + "\nLOGIN\n" + "Enter user name : ");
        sl1 = sin.nextLine();
        System.out.print("Enter Your Password : ");
        sl2 = sin.nextLine();
        String s = null;
        int templ = 0;
        while ((s = br.readLine()) != null) {
            String words[] = s.split(" ");
            if ((words[0].equals(sl1)) == true) {
                if ((words[1].equals(sl2)) == true) {
                    templ = 5;
                }
            }
        }
        if ((templ == 5)) {
            System.out.print("\n\n\nyou are succsefully Login!\n\n\n\n");
            xl = 0;
            yoyo = 0;
        } else {
            System.out.print("\n\ntry again\n\n");
        }
        fw.close();
    }
}

class base extends Login {
    Scanner sin = new Scanner(System.in);

    void catlog() throws Exception {
        String s = " ";
        FileReader fr = new FileReader("catlog1.txt");
        BufferedReader br = new BufferedReader(fr);
        while ((s = br.readLine()) != null) {
            System.out.println(s + "\n");
        }
    }

    void contact() {
        System.out.println("\n\n\t\tSHREE SWAMINARAYAN AGENCY\n\n");
        System.out.println("\tAdress:6/Jyoti Jalaram Socity, Jivrajpark, Ahmedabad - 380015");
        System.out.println("\n\tContact Number : 9879007662");
        System.out.println("\n\tEmail-id : dktthakkar@gmail.com");
        System.out.println("\n\tDHANANJAY THAKKAR");
    }

    void order() throws Exception {
        FileReader fr2 = new FileReader("catlog.txt");
        BufferedReader br2 = new BufferedReader(fr2);
        int n = 1;
        int i = 0;
        int qty[] = new int[50];
        String temp = "";
        String s1[] = new String[50];
        while (n != 0) {
            System.out.print("Enter the Code of Items : ");
            s1[i] = sin.nextLine();
            System.out.print("How many Qty you want : ");
            qty[i] = sin.nextInt();
            System.out.print("You Want to continue? Press 1 Else Press 0 : ");
            n = sin.nextInt();
            temp = sin.nextLine();
            i = i + 1;
        }
        System.out.println("\n\nThanks for your order! Here is your bill please confirm! : \n\n");
        int VI = i;
        int j;
        //int count=0;
        String s = "";
        /*while((s=br2.readLine())!=null)
		{
			count=count+1;
		}*/
        String s2[] = new String[11];
        String s3[] = new String[11];
        String s4[] = new String[11];
        i = 0;
        int y;
        String s5[] = new String[11];
        while ((s = br2.readLine()) != null) {
            y = 0;
            String words[] = s.split(" ");
            s2[i] = words[0];
            s3[i] = s;
            s4[i] = words[words.length - 1];
            for (y = 2; y < words.length - 1; y++) {
                if (y == 2) {
                    s5[i] = words[y];
                } else {
                    s5[i] = s5[i] + " " + words[y];
                }
            }
            i = i + 1;
        }
        double total = 0;
        int totalqty = 0;
        int u = 1;
        for (i = 0; i < VI; i++) {
            for (j = 0; j < 11; j++) {
                if (s1[i].equals(s2[j])) {
                    double a = Double.parseDouble(s4[j]);
                    a = a * qty[i];
                    totalqty = totalqty + qty[i];
                    System.out.println("\t " + u + ". quantity : " + qty[i] + "  ||   total:" + (a) + "  ||   Name : " + s5[j]);
                    total = a + total;
                    u = u + 1;
                    break;
                }
            }
        }
        System.out.println("\n\n\t Total Quantity : " + totalqty + "\tGrand total : " + total);
        Date date = new Date();
        // display time and date using toString()
        System.out.println("\n\nDo you want to store data for future access? YES:1 || NO:0");
        int N1 = sin.nextInt();
        String sN = sin.nextLine();
        if (N1 != 0) {
            String Name = " ";
            System.out.print("\n\nplease provid your user name again : ");
            Name = sin.nextLine();
            Name = (Name + ".txt");
            FileWriter fwf = new FileWriter(Name, true);
            fwf.append(date.toString() + " : " + " Total Quantity : " + totalqty + "  Grand total : " + total + "\r\n");
            fwf.close();
            System.out.println("\n\nIf you want to show your statements press 1 else press 0");
            int N2 = sin.nextInt();
            String XS = sin.nextLine();
            int O = 1;
            if (N2 == 1) {
                FileReader fr3 = new FileReader(Name);
                BufferedReader br3 = new BufferedReader(fr3);
                while ((s = br3.readLine()) != null) {
                    System.out.println(O + " :-" + s);
                    O++;
                }
            }
        }
    }
}

class demo {
    public static void main(String args[]) throws Exception {
        signup a = new signup();
        Login L = new Login();
        base B = new base();
        Scanner cin = new Scanner(System.in);
        int M;
        System.out.println("\n\n\n\t\t\tGALA ONLINE\n\n");
        System.out.print("Are you new user? If Yes:1 || No:2  :  ");
        M = cin.nextInt();
        int TM = 0;
        switch (M) {
            case 1:
                System.out.print("Hello! Welcome to Gala Online!\n\n" + "please provide uniq USER-NAME. -you are Free to select your User name!\n\n");
                System.out.print("\t\t\tSIGNUP");
                int x2 = 4;
                while ((a.xs) > 0) {
                    if (x2 > 0) {
                        a.show();
                        x2 = x2 - 1;
                    } else {
                        System.out.print("\nyou try many times come back later!\n\n");
                        TM = 1;
                    }
                    a.xs = (a.xs) - 1;
                }
            case 2:
                if (TM != 1) {
                    int x1 = 3;
                    while ((L.xl) > 0) {
                        if (x1 > 0) {
                            L.LoginF();
                            x1 = x1 - 1;
                        } else {
                            System.out.print("\nyou try many times come back later!\n\n");
                        }
                        L.xl = (L.xl) - 1;
                    }
                }
        }
        if (L.yoyo == 0) {
            System.out.println("\nHello Welcome to Gala Online\n");
            int j = 1;
            while (j != 0) {
                System.out.println("\n1. Catalog\t 2. Place Order\t 3. Contact\n");
                System.out.print("\nPress any one from above statements : \n");
                int n = cin.nextInt();
                switch (n) {
                    case 1:
                        System.out.print("\n\t\t\t   GALA BRUSH\n\n\n");
                        B.catlog();
                        break;
                    case 2:
                        System.out.print("\n\n\t\tHello! place your order by given Instructions\n\n\n");
                        B.catlog();
                        System.out.println("\n\n  \tShow Item code number in catlog and place order! \n\n");
                        B.order();
                        break;
                    case 3:
                        System.out.print("\n\n\t\t\tGALA AHMADABAD\n\n");
                        B.contact();
                        break;
                    default:
                        System.out.println("\nIts invalid Number!\n");
                }
                System.out.println("\nif you want End press 0 else 1 : ");
                j = cin.nextInt();
            }
        }
    }
}
