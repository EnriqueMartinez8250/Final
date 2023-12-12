import java.util.Random;
import java.util.Scanner;

public class TwoFactorAuth {
    public static void main(String[] args){
        //Generate a random 6 digit OTP

        String otp = generateOTP(6);
        System.out.println("Your OTP is: " + otp);


        // prompt the user to enter the OTP

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the OTP: ");
        String userInput = scanner.nextLine();

        if(userInput.equals(otp)){
            System.out.println("Authenticated successfully.");
            } else{
            System.out.println("Authentication failed.");
        }
    }

    private static String generateOTP(int length){
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for(int i = 0; i < length; i++){
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
}
