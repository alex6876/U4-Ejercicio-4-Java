public class PagoCripto implements ProcesadorPago {

    private double saldoCripto;

    public PagoCripto(double saldoCripto) {
        this.saldoCripto = saldoCripto;
    }

    @Override
    public boolean efectuarCobro(double monto) {

        if (monto > 0 && monto <= saldoCripto) {

            saldoCripto -= monto;

            System.out.println("Pago realizado con criptomonedas.");
            System.out.println("Saldo restante: $" + saldoCripto);

            return true;

        } else {

            System.out.println("Pago rechazado: saldo insuficiente en criptomonedas.");
            return false;
        }
    }
}