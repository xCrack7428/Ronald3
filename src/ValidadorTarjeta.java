import java.util.Scanner; 

public class ValidadorTarjeta { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Ingrese el número de la tarjeta: "); 
        String numeroTarjeta = scanner.nextLine(); 

        if (validarTarjeta(numeroTarjeta)) { 
            char primerDigito = numeroTarjeta.charAt(0); 

            switch (primerDigito) { 
                case '3': 
                    System.out.println("La tarjeta es American Express."); 
                    break; 
                case '4': 
                    System.out.println("La tarjeta es Visa."); 
                    break; 
                case '5': 
                    System.out.println("La tarjeta es MasterCard."); 
                    break; 
                default: 
                    System.out.println("El tipo de tarjeta no está soportado."); 
                    break; 
            } 
        } else { 
            System.out.println("El número de tarjeta no es válido."); 
        } 

        scanner.close(); 
    } 

    private static boolean validarTarjeta(String numeroTarjeta) { 
        // Lógica de validación: verificar que el número tenga 16 dígitos 
        return numeroTarjeta.matches("\\d{16}"); 
    } 
} 
