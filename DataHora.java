//fazer static

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHora {
    private LocalDateTime dataHora;

    public DataHora(String customerName, double total) {
        this.dataHora = LocalDateTime.now();
    }

    public void printVendaHorario() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Data e Hora da Venda: " + dataHora.format(formatter));
    }
}