package bank;

import java.util.Scanner;

public class BankManagement {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter your 'Name' and 'Customer Id' to access your account:  ");
        String name=input.nextLine();
        String customerId=input.nextLine();
        BankAccount obj1= new BankAccount(name,customerId);
    }
}   class BankAccount{
        double balance;
        double PreTrans;
        String CustomerName;
        String CustomerId;
        BankAccount(String CustomerName,String CustomerId){
            this.CustomerName=CustomerName;
            this.CustomerId=CustomerId;
        }
        void deposit(double amount){
            if(amount!=0){
                balance+=amount;
                PreTrans=amount;
            }
        }
        void withdraw(double amount){
            if(amount!=0 && balance>=amount){
                balance-=amount;
                PreTrans=-amount;
            }else if(balance<amount){
                System.out.println("Your Bank balance insufficient ");
            }
        }
        void getPreviousTransaction(){
            if(PreTrans>0){
                System.out.println("Deposited: "+PreTrans);
            }else if(PreTrans<0){
                System.out.println("Withdrawn: "+Math.abs(PreTrans));
            }else{
                System.out.println("No transaction occured");
            }
        }
        void menu(){
            char option;
            Scanner input= new Scanner(System.in);
            System.out.println("Welcome "+CustomerName);
            System.out.println(" Your Id "+CustomerId);
            System.out.println("a)check balance");
            System.out.println("b)Deposit amount");
            System.out.println("c)Withdraw amount");
            System.out.println("d)Previous Transaction");
            System.out.println("e)exit");
            
            do{
                System.out.println("****************");
                System.out.println("Choose an option");
                option=input.next().charAt(0);
                System.out.println("\n");
                
                switch(option){
                    case 'a':
                        System.out.println("...........");
                        System.out.println("Balance="+balance);
                        System.out.println("...........");
                        System.out.println("\n");
                        break;
                    case 'b':
                        System.out.println("...........");
                        System.out.println("Enter a amount to deposit: ");
                        System.out.println("...........");
                        double amount=input.nextDouble();
                        deposit(amount);
                        System.out.println("\n");
                        break;
                    case 'c':
                        System.out.println("...........");
                        System.out.println("Enter a amount to Withdraw: ");
                        System.out.println("...........");
                        double amountWithdraw=input.nextDouble();
                        deposit(amountWithdraw);
                        break;
                    case 'd':
                        System.out.println("...........");
                        System.out.println("Previous Transaction:");
                        getPreviousTransaction();
                        System.out.println("...........");
                        break;
                    case 'e':
                        System.out.println(".............");
                        break;
                }
            }while(option!='e');
            
            System.out.println("Thanks to our Banking system");
        }
        
    }
