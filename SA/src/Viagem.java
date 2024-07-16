
public class Viagem {

    private String nomeViagem;
    private String data;
    private int qtdPassageirosViagem = 0;

    public Viagem() {

    }

    public Viagem(String nomeViagem, String data, int qtdPassageirosViagem) {
        this.nomeViagem = nomeViagem;
        this.qtdPassageirosViagem = qtdPassageirosViagem;
        this.data = data;
    }

    public String getNomeViagem() {
        return nomeViagem;
    }

    public void setNomeViagem(String nomeViagem) {
        this.nomeViagem = nomeViagem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQtdPassageirosViagem() {
        return qtdPassageirosViagem;
    }

    public void setQtdPassageirosViagem(int qtdPassageirosViagem) {
        this.qtdPassageirosViagem = qtdPassageirosViagem;
    }
}
