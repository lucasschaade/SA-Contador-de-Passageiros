
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Sistema {

    //Criação de ArrayList para cada classe
    private static ArrayList<Onibus> listaonibus = new ArrayList<Onibus>();
    private static ArrayList<Linha> listalinha = new ArrayList<Linha>();
    private static ArrayList<Viagem> listaviagem = new ArrayList<Viagem>();

    public static void main(String[] args) throws IOException {
        //muda a escrita padrão do OPtionPane
        UIManager.put("OptionPane.cancelButtonText", "Voltar");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.yesButtonText", "Sim");
        //metodo para recuperar onibus, linhas e viagens.(atualiza o array list, atraves dos arquivos .txt)
        recuperarOnibustxt();
        recuperarLinhatxt();
        recuperarViagemtxt();
        System.out.println("Progama em execução");
        Menu();
    }

    public static void Menu() throws IOException {
        String opcao;
        String tela;
        tela = """
               1  -  Menu Cadastrar  
               2  -  Menu Listar 
               3  -  Menu Alterar 
               4  -  Menu Apagar 
               5  -  Menu Deletar 
               6  -  Sair 
               """;
        opcao = JOptionPane.showInputDialog(null, tela, "----------- MENU PRINCIPAL -----------\n", 1);
        while (!"7".equals(opcao)) {
            if (opcao == null) {
                Menu();
            }
            switch (opcao) {
                case "1":
                    MenuCadastro();
                    break;
                case "2":
                    MenuListar();
                    break;
                case "3":
                    MenuAlterar();
                    break;
                case "4":
                    MenuApagar();
                    break;
                case "5":
                    MenuDeletar();
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "Saindo do programa!", "----------- MENU PRINCIPAL -----------\n", 1);
                    System.out.println("Programa Finalizado!");
                    System.exit(0);
                default:
                    break;
            }
            JOptionPane.showMessageDialog(null, "Opção inválida!", "----------- MENU PRINCIPAL -----------\n", 1);
            Menu();
        }
    }

    public static void MenuCadastro() throws IOException {
        String opcao;
        String tela;
        tela = """
               1  -  Cadastrar Onibus
               2  -  Cadastrar Linha
               3  -  Cadastrar Viagem
               4  -  Voltar
               """;
        opcao = JOptionPane.showInputDialog(null, tela, "----------- MENU CADASTRO -----------\n", 1);
        while (!"5".equals(opcao)) {
            if (opcao == null) {
                Menu();
            }
            switch (opcao) {
                case "1" ->
                    cadastrarOnibus();
                case "2" ->
                    cadastrarLinha();
                case "3" ->
                    cadastrarViagem();
                case "4" ->
                    Menu();
                default -> {
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "----------- MENU CADASTRO -----------\n", 1);
                    MenuCadastro();
                }
            }
        }
    }

    public static void MenuListar() throws IOException {
        String opcao;
        String tela;
        tela = """
                  1  -  Listar Onibus 
                  2  -  Listar Linha 
                  3  -  Listar Viagem 
                  4  -  Voltar 
                  """;
        opcao = JOptionPane.showInputDialog(null, tela, "----------- MENU LISTAR -----------\n", 1);
        while (!"5".equals(opcao)) {
            if (opcao == null) {
                Menu();
            }
            switch (opcao) {
                case "1" ->
                    listarOnibus();
                case "2" ->
                    listarLinha();
                case "3" ->
                    listarViagem();
                case "4" ->
                    Menu();
                default -> {
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "----------- MENU LISTAR -----------\n", 1);
                    MenuListar();
                }
            }
        }
    }

    public static void MenuAlterar() throws IOException {
        String opcao;
        String tela;
        tela = """
               1  -  Alterar Onibus
               2  -  Alterar Linha
               3  -  Voltar
               """;
        opcao = JOptionPane.showInputDialog(null, tela, "----------- MENU ALTERAR -----------\n", 1);
        while (!"4".equals(opcao)) {
            if (opcao == null) {
                Menu();
            }
            switch (opcao) {
                case "1" ->
                    alterarOnibus();
                case "2" ->
                    alterarLinha();
                case "3" ->
                    Menu();
                default -> {
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "----------- MENU ALTERAR -----------\n", 1);
                    MenuAlterar();
                }
            }
        }
    }

    public static void MenuApagar() throws IOException {
        String opcao;
        String tela;
        tela = """
               1  -  Apagar Onibus
               2  -  Apagar Linha
               3  -  Apagar Viagem
               4  -  Voltar
               """;
        opcao = JOptionPane.showInputDialog(null, tela, "----------- MENU APAGAR-----------\n", 1);
        while (!"5".equals(opcao)) {
            if (opcao == null) {
                Menu();
            }
            switch (opcao) {
                case "1" ->
                    apagarOnibus();
                case "2" ->
                    apagarLinha();
                case "3" ->
                    apagarViagem();
                case "4" ->
                    Menu();
                default -> {
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "----------- MENU APAGAR-----------\n", 1);
                    MenuApagar();
                }
            }
        }
    }

    public static void MenuDeletar() throws IOException {
        String opcao;
        String tela;
        tela = """
               1  -  Deletar todos os Onibus
               2  -  Deletar todas as Linhas
               3  -  Deletar todas as Viagens
               4  -  Voltar
               """;
        opcao = JOptionPane.showInputDialog(null, tela, "----------- MENU DELETAR-----------\n", 1);
        while (!"5".equals(opcao)) {
            if (opcao == null) {
                Menu();
            }
            switch (opcao) {
                case "1" ->
                    deletarTodosOnibus();
                case "2" ->
                    deletarTodasLinhas();
                case "3" ->
                    deletarTodasViagens();
                case "4" ->
                    Menu();
                default -> {
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "----------- MENU DELETAR-----------\n", 1);
                    MenuDeletar();
                }
            }
        }
    }

    public static void cadastrarOnibus() throws IOException {
        String placa = null;
        boolean cadastrar = true;
        while (cadastrar == true) {
            boolean formatoinvalido = false;
            while (formatoinvalido == false) {
                placa = JOptionPane.showInputDialog(null, "Digite a placa do ônibus:\nFormato de placa: ABC1234", "CADASTRO ÔNIBUS", 3);
                //tratamento do JOptionPane(opção cancel)
                if (placa == null) {
                    JOptionPane.showMessageDialog(null, "Redirecionando para o menu!", "CADASTRO ÔNIBUS", 1);
                    MenuCadastro();
                }
                //tratamento para formato da placa
                if (validarPlaca(placa)) {
                    JOptionPane.showMessageDialog(null, "Placa validada com sucesso!", "CADASTRO ÔNIBUS", 1);
                    formatoinvalido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Formato da placa inválido!\nFormato esperado: ABC1234", "CADASTRO ÔNIBUS", 1);
                    formatoinvalido = false;
                }
            }
            String capacidadeMaxima = JOptionPane.showInputDialog(null, "Digite a capacidade máxima de passageiros:", "CADASTRO ÔNIBUS", 3);
            if (capacidadeMaxima == null || capacidadeMaxima.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Redirecionando para o menu!", "CADASTRO ÔNIBUS", 1);
                MenuCadastro();
            }
            int capacidadeMaxima2 = Integer.parseInt(capacidadeMaxima);
            Onibus onibus = new Onibus(placa, capacidadeMaxima2);
            listaonibus.add(onibus);
            salvarOnibus();

            int resposta = JOptionPane.showConfirmDialog(null, "Cadastrar novamente?", "CADASTRO ÔNIBUS", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION){
                cadastrar = true;
            }else{
                cadastrar = false;
            }    
        }
        MenuCadastro();
    }

    public static void cadastrarLinha() throws IOException {
        boolean cadastrar = true;
        while (cadastrar == true) {
            String nomeLinha = JOptionPane.showInputDialog(null, "Digite o nome da linha:", "CADASTRO LINHA", 3);
            if (nomeLinha == null || nomeLinha.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Redirecionando para o menu!", "CADASTRO LINHA", 1);
                MenuCadastro();
            }
            String qtdParadas = JOptionPane.showInputDialog(null, "Digite a quantidade de paradas:", "CADASTRO LINHA", 3);
            if (qtdParadas == null || qtdParadas.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Redirecionando para o menu!", "CADASTRO LINHA", 1);
                MenuCadastro();
            }
            int qtdParadas2 = Integer.parseInt(qtdParadas);
            Linha linha = new Linha(nomeLinha, qtdParadas2);
            listalinha.add(linha);
            salvarLinha();

            int resposta = JOptionPane.showConfirmDialog(null, "Cadastrar novamente?", "CADASTRO LINHA", JOptionPane.YES_NO_OPTION);
            cadastrar = resposta == JOptionPane.YES_OPTION;
        }
        MenuCadastro();
    }

    public static void cadastrarViagem() throws IOException {
        if (listaonibus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum ônibus cadastrado!\nCadastre um onibus primeiro!", "CADASTRO VIAGEM", 1);
            MenuCadastro();
        }
        if (listalinha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha cadastrada!\nCadastre uma linha primeiro!", "CADASTRO VIAGEM", 1);
            MenuCadastro();
        }
        Random random = new Random();//gera um número aleatório
        //variáveis que serão usadas para pasar atributos do objeto
        String nomeViagem;
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int qtdPassageirosViagem = 0;
        //variáveis usandas dentro desse método
        int qtdEmbarque;
        int qtdDesembarque;
        String escolherOnibus = "";
        String escolherLinha = "";

        nomeViagem = JOptionPane.showInputDialog(null, "Digite o nome da viagem:", "CADASTRO VIAGEM", 3);
        if (nomeViagem == null || nomeViagem.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Redirecionando para o menu!", "CADASTRO VIAGEM", 1);
            MenuCadastro();
        }
        boolean onibusencontrado = false;
        while (onibusencontrado == false) {
            String relatorio = "";
            String relatoriocompleto = "";
            for (int i = 0; i < listaonibus.size(); i++) {
                Onibus onibus = listaonibus.get(i);//cria um objeto e adiciona todas as informaçoes do array list dentro desse objeto
                relatorio = "\nPlaca: " + onibus.getPlaca()
                        + "\nQuantidade maxima de Passageiros: " + onibus.getCapacitadeMaxima();
                relatoriocompleto += relatorio;
            }
            JOptionPane.showMessageDialog(null, "Selecione um ônibus para viagem!", "CADASTRO VIAGEM", 1);
            escolherOnibus = JOptionPane.showInputDialog(null, relatoriocompleto + " \n\n Digite a placa:", "CADASTRO VIAGEM", 3);
            if (escolherOnibus == null) {
                MenuCadastro();
            }
            for (int i = 0; i < listaonibus.size(); i++) {
                Onibus comfirmarOnibus = listaonibus.get(i);
                if (escolherOnibus.equalsIgnoreCase(comfirmarOnibus.getPlaca())) {//verefica se o ônibus esta cadastrado(comparando as placas)
                    onibusencontrado = true;
                }
            }
            if (onibusencontrado == false) {
                JOptionPane.showMessageDialog(null, "Ônibus não cadastrado!\nNão há registros dessa placa!", "CADASTRO VIAGEM", 1);
            }
        }
        JOptionPane.showMessageDialog(null, "Ônibus encontrado!", "CADASTRO VIAGEM", 1);

        boolean linhaencontrada = false;
        while (linhaencontrada == false) {
            String relatoriolinha = "";
            String relatoriolinhac = "";
            for (int i = 0; i < listalinha.size(); i++) {
                Linha linha = listalinha.get(i);
                relatoriolinha = "\nNome da linha: " + linha.getNomeLinha()
                        + "\nQuantidade de paradas: " + linha.getQtdParadas();
                relatoriolinhac += relatoriolinha;
            }
            JOptionPane.showMessageDialog(null, "Selecione uma linha para viagem!", "CADASTRO VIAGEM", 1);
            escolherLinha = JOptionPane.showInputDialog(null, relatoriolinhac + " \n\n Digite o nome da linha:", "CADASTRO VIAGEM", 3);
            if (escolherLinha == null) {
                JOptionPane.showMessageDialog(null, "Redirecionando para o menu!", "CADASTRO VIAGEM", 1);
                MenuCadastro();
            }
            for (int i = 0; i < listalinha.size(); i++) {
                Linha comfirmarLinha = listalinha.get(i);
                if (escolherLinha.equalsIgnoreCase(comfirmarLinha.getNomeLinha())) {//verefica se a linha esta cadastrado(comparando os nomes das linhas)
                    linhaencontrada = true;
                }
            }
            if (linhaencontrada == false) {
                JOptionPane.showMessageDialog(null, "Linha não cadastrada!\nNão há registros dessa linha!", "CADASTRO VIAGEM", 1);
            }
        }
        JOptionPane.showMessageDialog(null, "Linha encontrada", "CADASTRO VIAGEM", 1);

        for (int b = 0; b < listaonibus.size(); b++) {
            Onibus onibus = listaonibus.get(b);
            for (int i = 0; i < listalinha.size(); i++) {
                Linha linha = listalinha.get(i);
                for (int j = 1; j <= linha.getQtdParadas(); j++) {// repetição de acordo com a quantidade de paradas da linha
                    if (escolherOnibus.equalsIgnoreCase(onibus.getPlaca()) && escolherLinha.equalsIgnoreCase(linha.getNomeLinha())) {//comfirma se a linha e o onibus escolhido pelo usario estao cadastrados                       
                        qtdEmbarque = random.nextInt(onibus.getCapacitadeMaxima() - onibus.getQtdAtual());//quantidade de passageiros que embarcam a cada parada
                        onibus.setQtdAtual(onibus.getQtdAtual() + qtdEmbarque);//atualiza a quantidade atual de passageiros do ônibus
                        if (j != 1) {
                            qtdDesembarque = random.nextInt(onibus.getQtdAtual());//quantidade de passageiros que embarcam a cada parada
                            onibus.setQtdAtual(onibus.getQtdAtual() - qtdDesembarque);//atualiza a quantidade atual de passageiros do ônibus
                        }
                        qtdPassageirosViagem += qtdEmbarque;//atualiza o total de passageiros que entraram no ônibus  a cada parada
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Nome da viagem:" + nomeViagem + " \n Data:" + data + " \n Quantidade total de passageiros da viagem:" + qtdPassageirosViagem, "CADASTRO VIAGEM", 1);
        Viagem viagem = new Viagem(nomeViagem, data, qtdPassageirosViagem);
        listaviagem.add(viagem);
        salvarViagem();
        MenuCadastro();
    }

    private static void salvarOnibus() throws IOException {
        try {
            FileWriter arquivo = new FileWriter("registroOnibus.txt");
            try (PrintWriter gravador = new PrintWriter(arquivo)) {
                for (int i = 0; i < listaonibus.size(); i++) {
                    Onibus onibus = listaonibus.get(i);
                    gravador.println(onibus.getPlaca() + "," + onibus.getCapacitadeMaxima());
                }
            }
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!", "SALVAR ÔNIBUS", 1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar registro!" + e.getMessage(), "SALVAR ÔNIBUS", 1);
        }
    }

    private static void salvarLinha() throws IOException {
        try {
            FileWriter arquivo = new FileWriter("registroLinha.txt");
            try (PrintWriter gravador = new PrintWriter(arquivo)) {
                for (int i = 0; i < listalinha.size(); i++) {
                    Linha linha = listalinha.get(i);
                    gravador.println(linha.getNomeLinha() + "," + linha.getQtdParadas());
                }
            }
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!", "SALVAR LINHA", 1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar registro!" + e.getMessage(), "SALVAR LINHA", 1);
        }
    }

    private static void salvarViagem() throws IOException {
        try {
            FileWriter arquivo = new FileWriter("registroViagem.txt");
            try (PrintWriter gravador = new PrintWriter(arquivo)) {
                for (int i = 0; i < listaviagem.size(); i++) {
                    Viagem viagem = listaviagem.get(i);
                    gravador.println(viagem.getNomeViagem() + "," + viagem.getData() + "," + viagem.getQtdPassageirosViagem());
                }
            }
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!", "SALVAR VIAGEM", 1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar registro!" + e.getMessage(), "SALVAR VIAGEM", 1);
        }
    }

    public static void recuperarOnibustxt() {
        String aarq = "registroOnibus.txt";
        String linha = "";
        File arq = new File(aarq);
        if (arq.exists()) {
            try {
                FileReader abrindo = new FileReader(aarq);
                BufferedReader leitor = new BufferedReader(abrindo);
                while (true) {
                    linha = leitor.readLine();
                    if (linha == null) {
                        break;
                    }
                    //pega cada linha do arquivo de texto e divide numa lista separando por ,
                    String[] onibusLinhaAtual = linha.split(",");
                    //cria objeto com as posicoes do vetor iniciando com 0 pela placa e 1 capacidadeMaxima
                    Onibus onibus = new Onibus(onibusLinhaAtual[0], Integer.parseInt(onibusLinhaAtual[1]));
                    listaonibus.add(onibus);
                }
                leitor.close();
            } catch (Exception erro) {
            }
        }
    }

    public static void recuperarLinhatxt() {
        String aarq = "registroLinha.txt";
        String linha = "";
        File arq = new File(aarq);
        if (arq.exists()) {
            try {
                FileReader abrindo = new FileReader(aarq);
                BufferedReader leitor = new BufferedReader(abrindo);
                while (true) {
                    linha = leitor.readLine();
                    if (linha == null) {
                        break;
                    }
                    //pega cada linha do arquivo de texto e divide numa lista separando por ,
                    String[] TesteLinhaAtual = linha.split(",");
                    //cria objeto com as posicoes do vetor iniciando com 0 nome da linha e 1 quantidade de paradas
                    Linha Teste = new Linha(TesteLinhaAtual[0], Integer.parseInt(TesteLinhaAtual[1]));
                    listalinha.add(Teste);
                }
                leitor.close();
            } catch (Exception erro) {
            }
        }
    }

    public static void recuperarViagemtxt() {
        String aarq = "registroViagem.txt";
        String linha = "";
        File arq = new File(aarq);
        if (arq.exists()) {
            try {
                FileReader abrindo = new FileReader(aarq);
                BufferedReader leitor = new BufferedReader(abrindo);
                while (true) {
                    linha = leitor.readLine();
                    if (linha == null) {
                        break;
                    }
                    //pega cada linha do arquivo de texto e divide numa lista separando por ,
                    String[] viagemLinhaAtual = linha.split(",");
                    //cria objeto com as posicoes do vetor iniciando com 0 nome da viagem, 1 data e 2 quantidade de passageiros da viagem
                    Viagem viagem = new Viagem(viagemLinhaAtual[0], (viagemLinhaAtual[1]), Integer.parseInt(viagemLinhaAtual[2]));
                    listaviagem.add(viagem);
                }
                leitor.close();
            } catch (Exception erro) {
            }
        }
    }

    public static void listarOnibus() throws IOException {
        if (listaonibus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum ônibus cadastrado!", "LISTAR ÔNIBUS", 1);
            MenuListar();
        }
        String relatorio = "";
        String relatorioc = "";
        for (int i = 0; i < listaonibus.size(); i++) {
            Onibus onibus = listaonibus.get(i);
            relatorio = "\nPlaca: " + onibus.getPlaca()
                    + "\nQuantidade maxima de Passageiros: " + onibus.getCapacitadeMaxima();
            relatorioc += relatorio;
        }
        JOptionPane.showMessageDialog(null, relatorioc, "LISTAR ÔNIBUS", 1);
        MenuListar();

    }

    public static void listarLinha() throws IOException {
        if (listalinha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha cadastrada!", "LISTAR LINHA", 1);
            MenuListar();
        }
        String relatorio = "";
        String relatorioc = "";
        for (int i = 0; i < listalinha.size(); i++) {
            Linha linha = listalinha.get(i);
            relatorio = "\nNome da linha: " + linha.getNomeLinha()
                    + "\nQuantidade de paradas: " + linha.getQtdParadas();
            relatorioc += relatorio;
        }
        JOptionPane.showMessageDialog(null, relatorioc, "LISTAR LINHA", 1);
        MenuListar();
    }

    public static void listarViagem() throws IOException {
        if (listaviagem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma viagem cadastrada!", "LISTAR VIAGEM", 1);
            MenuListar();
        }
        String relatorio = "";
        String relatorioc = "";
        for (int i = 0; i < listaviagem.size(); i++) {
            Viagem viagem = listaviagem.get(i);
            relatorio = "\nNome da viagem: " + viagem.getNomeViagem()
                    + "\nData: " + viagem.getData()
                    + "\nTotal de passageiros da viagem:" + viagem.getQtdPassageirosViagem();
            relatorioc += relatorio;
        }
        JOptionPane.showMessageDialog(null, relatorioc, "LISTAR VIAGEM", 1);
        MenuListar();
    }

    public static void apagarOnibus() throws IOException {
        if (listaonibus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum ônibus cadastrado!", "APAGAR ÔNIBUS", 1);
            MenuApagar();
        }
        String relatorio = "";
        String relatorioc = "";
        for (int i = 0; i < listaonibus.size(); i++) {
            Onibus onibus = listaonibus.get(i);
            relatorio = "\nPlaca: " + onibus.getPlaca()
                    + "\nQuantidade maxima de Passageiros: " + onibus.getCapacitadeMaxima();
            relatorioc += relatorio;
        }
        boolean onibusencontrado = false;
        while (onibusencontrado == false) {
            String pesquisar = JOptionPane.showInputDialog(null, relatorioc + "\n\nInforme a placa do onibus que deseja apagar:", "APAGAR ÔNIBUS", 3);
            if (pesquisar == null) {
                JOptionPane.showMessageDialog(null, "Redirecionando para o menu!", "APAGAR ÔNIBUS", 1);
                MenuApagar();
            }
            for (int i = 0; i < listaonibus.size(); i++) {
                Onibus alterarCodigo = listaonibus.get(i);
                if (pesquisar.equalsIgnoreCase(alterarCodigo.getPlaca())) {
                    onibusencontrado = true;
                    listaonibus.remove(i);
                    JOptionPane.showMessageDialog(null, "Ônibus apagado com sucesso!", "APAGAR ÔNIBUS", 1);
                }
            }
            if (onibusencontrado == false) {
                JOptionPane.showMessageDialog(null, "Ônibus não cadastrado!\nNão há registros dessa placa!", "APAGAR ÔNIBUS", 3);
            }
        }
        salvarOnibus();
        MenuApagar();
    }

    public static void apagarLinha() throws IOException {
        if (listalinha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha cadastrada!", "APAGAR LINHA", 1);
            MenuApagar();
        }
        String relatorio = "";
        String relatorioc = "";
        for (int i = 0; i < listalinha.size(); i++) {
            Linha linha = listalinha.get(i);
            relatorio = "\nNome da linha: " + linha.getNomeLinha()
                    + "\nQuantidade de paradas: " + linha.getQtdParadas();
            relatorioc += relatorio;
        }
        boolean linhaencontrada = false;
        while (linhaencontrada == false) {
            String pesquisar = JOptionPane.showInputDialog(null, relatorioc + " \n\nInforme o nome da linha que deseja apagar:", "APAGAR LINHA", 3);
            if (pesquisar == null) {
                JOptionPane.showMessageDialog(null, "Redirecionando para o menu!", "APAGAR LINHA", 1);
                MenuApagar();
            }
            for (int i = 0; i < listalinha.size(); i++) {
                Linha alterarCodigo = listalinha.get(i);
                if (pesquisar.equalsIgnoreCase(alterarCodigo.getNomeLinha())) {
                    linhaencontrada = true;
                    listalinha.remove(i);
                    JOptionPane.showMessageDialog(null, "Linha apagada com sucesso!", "APAGAR LINHA", 1);
                }
            }
            if (linhaencontrada == false) {
                JOptionPane.showMessageDialog(null, "Linha não cadastrada!\nNão há registros desse nome de linha!", "APAGAR LINHA", 1);
            }
        }
        salvarLinha();
        MenuApagar();
    }

    public static void apagarViagem() throws IOException {
        if (listaviagem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma viagem cadastrada!", "APAGAR VIAGEM", 1);
            MenuApagar();
        }
        String relatorio = "";
        String relatorioc = "";
        for (int i = 0; i < listaviagem.size(); i++) {
            Viagem viagem = listaviagem.get(i);
            relatorio = "\nNome da viagem: " + viagem.getNomeViagem()
                    + "\nData: " + viagem.getData()
                    + "\nQuantidade de passageiros: " + viagem.getQtdPassageirosViagem();
            relatorioc += relatorio;
        }
        boolean viagemencontrada = false;
        while (viagemencontrada == false) {
            String pesquisar = JOptionPane.showInputDialog(null, relatorioc + "\n\nInforme o nome da viagem que deseja apagar:", "APAGAR VIAGEM", 3);
            if (pesquisar == null) {
                JOptionPane.showMessageDialog(null, "Redirecionando para o menu!", "APAGAR VIAGEM", 1);
                MenuApagar();
            }
            for (int i = 0; i < listaviagem.size(); i++) {
                Viagem alterarCodigo = listaviagem.get(i);
                if (pesquisar.equalsIgnoreCase(alterarCodigo.getNomeViagem())) {
                    viagemencontrada = true;
                    listaviagem.remove(i);
                    JOptionPane.showMessageDialog(null, "Viagem apagada com sucesso!", "APAGAR VIAGEM", 1);
                }
            }
            if (viagemencontrada == false) {
                JOptionPane.showMessageDialog(null, "Viagem não cadastrada!\nNão há regitro desse nome de viagem!", "APAGAR VIAGEM", 1);
            }
        }
        salvarOnibus();
        MenuApagar();
    }

    public static void deletarTodosOnibus() throws IOException {
        if (listaonibus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum ônibus cadastrado!", "DELETAR TODOS OS ÔNIBUS", 1);
            MenuDeletar();
        }
        listaonibus.clear();
        JOptionPane.showMessageDialog(null, "Todos os ônibus deletados com sucesso!", "DELETAR TODOS OS ÔNIBUS", 1);
        salvarOnibus();
        MenuDeletar();
    }

    public static void deletarTodasLinhas() throws IOException {
        if (listalinha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha cadastrada!", "DELETAR TODAS AS LINHAS", 1);
            MenuDeletar();
        }
        listalinha.clear();
        JOptionPane.showMessageDialog(null, "Todas as linhas deletas com sucesso!", "DELETAR TODAS AS LINHAS", 1);
        salvarLinha();
        MenuDeletar();
    }

    public static void deletarTodasViagens() throws IOException {
        if (listaviagem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma viagem cadastrada!", "DELETAR TODAS AS VIAGENS", 1);
            MenuDeletar();
        }
        listaviagem.clear();
        JOptionPane.showMessageDialog(null, "Todas as viagens deletas com sucesso!", "DELETAR TODAS AS VIAGENS", 1);
        salvarViagem();
        MenuDeletar();
    }

    public static void alterarOnibus() throws IOException {
        if (listaonibus.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum ônibus cadastrado!", "ALTERAR ONIBUS", 1);
            MenuAlterar();
        }
        String pesquisar = "";
        String relatorio = "";
        String relatorioc = "";
        for (int i = 0; i < listaonibus.size(); i++) {
            Onibus onibus = listaonibus.get(i);
            relatorio = "\nPlaca: " + onibus.getPlaca()
                    + "\nQuantidade maxima de Passageiros: " + onibus.getCapacitadeMaxima();
            relatorioc += relatorio;
        }
        boolean placaencontrada = false;
        while (placaencontrada == false) {// verefica se a placa tem no array list
            pesquisar = JOptionPane.showInputDialog(null, relatorioc + "\n\nDigite a placa que deseja alterar:", "ALTERAR ÔNIBUS", 3);
            if (pesquisar == null) {
                JOptionPane.showMessageDialog(null, "Redireciondo para o menu!", "ALTERAR ÔNIBUS", 1);
                MenuAlterar();
            }
            for (int i = 0; i < listaonibus.size(); i++) {
                Onibus alterarOnibus = listaonibus.get(i);
                if (pesquisar.equalsIgnoreCase(alterarOnibus.getPlaca())) {//compara as placas
                    placaencontrada = true;
                    String novaPlaca = "";
                    novaPlaca = JOptionPane.showInputDialog(null, "Digite a nova placa:", "ALTERAR ÔNIBUS", 3);
                    if (novaPlaca == null) {
                        JOptionPane.showMessageDialog(null, "Redireciondo para o menu!", "ALTERAR ÔNIBUS", 1);
                        MenuAlterar();
                    }
                    if (validarPlaca(novaPlaca)) {
                        JOptionPane.showMessageDialog(null, "Placa validada com sucesso!", "ALTERAR ÔNIBUS", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Formato da placa inválido!\nFormato esperado: ABC1234", "ALTERAR ÔNIBUS", 1);
                        MenuCadastro();
                    }
                    alterarOnibus.setPlaca(novaPlaca);//troca as placas
                    JOptionPane.showMessageDialog(null, "Placa alterada com sucesso!", "ALTERAR ÔNIBUS", 1);
                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja alterar a capacidade máxima de passageiros desse onibus?\nCapacidade atual:" + alterarOnibus.getCapacitadeMaxima(), "ALTERAR ÔNIBUS", JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        String novaCapacidadeMaxima = "";
                        novaCapacidadeMaxima = JOptionPane.showInputDialog(null, "Digite a nova capacidade:", "ALTERAR ÔNIBUS", 3);
                        int convertenovaCapacidadeMaxima = Integer.parseInt(novaCapacidadeMaxima);
                        alterarOnibus.setCapacitadeMaxima(convertenovaCapacidadeMaxima);//troca a capacidade maxima
                        JOptionPane.showMessageDialog(null, "Capacidade máxima alterara com sucesso!", "ALTERAR ÔNIBUS", 1);
                    }
                }
            }
            if (placaencontrada == false) {
                JOptionPane.showMessageDialog(null, "Ônibus não cadastrado!\nNão há registros dessa placa!", "ALTERAR ONIBUS", 3);
            }
        }
        salvarOnibus();
        MenuAlterar();
    }

    public static void alterarLinha() throws IOException {
        if (listalinha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha cadastrada!", "ALTERAR LINHA", 1);
            MenuAlterar();
        }
        String pesquisar = "";
        String relatorio = "";
        String relatorioc = "";
        for (int i = 0; i < listalinha.size(); i++) {
            Linha linha = listalinha.get(i);
            relatorio = "\nNome da linha: " + linha.getNomeLinha()
                    + "\nQuantidade de paradas: " + linha.getQtdParadas();
            relatorioc += relatorio;
        }
        boolean linhaencontrada = false;
        while (linhaencontrada == false) {
            pesquisar = JOptionPane.showInputDialog(null, relatorioc + "\n\nDigite o nome da linha que deseja alterar:", "ALTERAR LINHA", 3);
            if (pesquisar == null) {
                JOptionPane.showMessageDialog(null, "Redirecionando para o menu!", "ALTERAR LINHA", 1);
                MenuAlterar();
            }
            for (int i = 0; i < listalinha.size(); i++) {
                Linha alterarLinha = listalinha.get(i);
                if (pesquisar.equalsIgnoreCase(alterarLinha.getNomeLinha())) {
                    linhaencontrada = true;
                    String novoNomeLinha = "";
                    novoNomeLinha = JOptionPane.showInputDialog(null, "\nDigite o novo nome da linha:", "ALTERAR LINHA", 3);
                    if (novoNomeLinha == null) {
                        JOptionPane.showMessageDialog(null, "Redirecionando para o menu!", "ALTERAR LINHA", 1);
                        MenuAlterar();
                    }
                    alterarLinha.setNomeLinha(novoNomeLinha);
                    JOptionPane.showMessageDialog(null, "Linha alterada com sucesso!", "ALTERAR LINHA", 1);
                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja alterar a quantidade de paradas dessa linha?\nQuantidade de paradas atual:" + alterarLinha.getQtdParadas(), "ALTERAR LINHA", JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        String novaQtdParada = "";
                        novaQtdParada = JOptionPane.showInputDialog(null, "Digite a nova quantidade de paradas:", "ALTERAR LINHA", 3);
                        int convertenovaQtdParada = Integer.parseInt(novaQtdParada);
                        alterarLinha.setQtdParadas(convertenovaQtdParada);
                        JOptionPane.showMessageDialog(null, "Quantidade de paradas alterar com sucesso!", "ALTERAR LINHA", 1);
                    }
                }
            }
            if (linhaencontrada == false) {
                JOptionPane.showMessageDialog(null, "Linha não cadastrada!\nNão há registros desse nome de linha!", "ALTERAR LINHA", 1);
            }
        }
        salvarLinha();
        MenuAlterar();
    }

    public static boolean validarPlaca(String placa) {
        // Formato padrão da placa AAA-1234
        String formatoplaca = "[A-Za-z]{3}\\d{4}";
        // Verifica se a placa corresponde ao formato esperado
        if (placa.matches(formatoplaca)) {
            return true;
        }
        return false;
    }
}
