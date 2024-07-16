
public class Linha {

    private int qtdParadas;
    private String nomeLinha;

    public Linha() {

    }

    public Linha(String nomeLinha, int qtdParadas) {
        this.qtdParadas = qtdParadas;
        this.nomeLinha = nomeLinha;
    }

    public int getQtdParadas() {
        return qtdParadas;
    }

    public void setQtdParadas(int qtdParadas) {
        this.qtdParadas = qtdParadas;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }
}
