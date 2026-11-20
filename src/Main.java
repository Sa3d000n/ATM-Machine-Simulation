import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int pin = 1234;
    double balance = 2500.75;
    int retries = 1;
    boolean showMenu = true;
    int transactionCount = 0;
    do {
      System.out.println("Please enter pin code");
      int passEntered = scan.nextInt();
      if (passEntered == pin) {
        System.out.println("Pin code is right");
        break;
      } else {
        System.out.println("Pin code is wrong");
        retries++;
      }
    } while (retries < 4);
    if (retries == 4) {
      System.out.println("Your account has been locked.");
    }
    while (retries < 4 && showMenu) {
      System.out.println("========= ATM ========= ");
      System.out.println(
          "1. Check Balance \n2. Deposit \n3. Withdraw \n4. Show Account Status \n5. Exit ");
      System.out.println("======================= ");
      int processNum = scan.nextInt();

      switch (processNum) {
        case 1:
          System.out.println("Your balance is " + balance);
          break;
        case 2:
          System.out.println("Enter the deposit amount");
          double depositAmount = scan.nextDouble();
          if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("Your new balance is " + balance);
            transactionCount++;
          } else {
            System.out.println("Invalid amount.");
          }
          break;
        case 3:
          System.out.println("Enter the withdraw amount");
          double withdrawAmount = scan.nextDouble();
          if (withdrawAmount == 0) {
            System.out.println("Transaction cancelled");
          } else if (withdrawAmount < 0) {
            System.out.println("Invalid amount");
          } else if (withdrawAmount > balance) {
            System.out.println("Insufficient balance");
          } else {
            balance -= withdrawAmount;
            System.out.println("Your new balance is " + balance);
            transactionCount++;
            if (balance == 0) {
              System.out.println("Warning: Your account is empty.");
            }
          }
          break;
        case 4:
          if (balance < 1000) {
            System.out.println("Low Balance");
          } else if (balance < 5000) {
            System.out.println("Regular Customer");
          } else {
            System.out.println("VIP Customer");
          }
          break;
        case 5:
          System.out.println("Thank you for using our ATM.");
          System.out.println("Total transactions: " + transactionCount);
          showMenu = false;
          break;
        default:
          System.out.println("Invalid option.");
      }
    }
    scan.close();
  }
}
