
public class Onibus {

    private int capacidadeMaxima;
    private int qtdAtual;
    private String placa;
    
    public Onibus(){
        
    }

    public Onibus(String placa, int capacidadeMaxima) {
        this.qtdAtual = 0;
        this.capacidadeMaxima = capacidadeMaxima;
        this.placa = placa;
    }

    public int getCapacitadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacitadeMaxima(int capacitadeMaxima) {
        this.capacidadeMaxima = capacitadeMaxima;
    }

    public int getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String toString() {
        return "Onibus{" + "capacidademaxima=" + capacidadeMaxima + ", quantidadeatual=" + qtdAtual + ", placa=" + placa + '}';
    }
 
}
