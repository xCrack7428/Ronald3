import java.util.Scanner;

public class Caja {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(
				"Bienvenido a la caja del restaurante, esperemos que su estancia haya sido la mejor posible. ¿Cómo desea pagar? (Efectivo o Tarjeta): ");
		String tipoPago = scanner.nextLine();

		if (tipoPago.equalsIgnoreCase("efectivo")) {
			System.out.println("Ingrese el importe a pagar: ");
			double montoAPagar = scanner.nextDouble();

			double montoEntregado = 0.0;

			do {
				System.out.println("Ingrese la cantidad entregada: ");
				montoEntregado = scanner.nextDouble();
			} while (montoEntregado < montoAPagar);

			double cambio = montoEntregado - montoAPagar;

			int[] billetes = { 50, 20, 10, 5 };
			int[] monedas = { 1, 2, 5, 10, 20, 50 };

			System.out.println("Cambio a devolver:");
			for (int billete : billetes) {
				int cantidad = (int) (cambio / billete);
				if (cantidad > 0) {
					System.out.println(cantidad + " billete(s) de " + billete + "€");
					cambio -= cantidad * billete;
				}
			}

			for (int moneda : monedas) {
				int cantidad = (int) (cambio / moneda);
				if (cantidad > 0) {
					System.out.println(cantidad + " moneda(s) de " + moneda + "€");
					cambio -= cantidad * moneda;
				}
			}
		} else if (tipoPago.equalsIgnoreCase("tarjeta")) {
			System.out.println("Ingrese el número de tarjeta:");
			String numeroTarjeta = scanner.next().replaceAll("\\s", "");

			if (validarNumeroTarjeta(numeroTarjeta)) {
				System.out.println("Tarjeta válida.");
			} else {
				System.out.println("Número de tarjeta no válido.");
			}
		} else {
			System.out.println("Método de pago no válido. Por favor, seleccione 'Efectivo' o 'Tarjeta'.");
		}

		scanner.close();
	}

	public static boolean validarNumeroTarjeta(String numeroTarjeta) {
		if (numeroTarjeta.matches("^(\\d{16}|\\d{15})$")) {
			char primerDigito = numeroTarjeta.charAt(0);
			if (primerDigito == '3' || primerDigito == '4' || primerDigito == '5') {
				return true;
			}
		}
		return false;
	}
}
