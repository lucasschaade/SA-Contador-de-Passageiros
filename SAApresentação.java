
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
 public static boolean validarPlaca(String placa) {
        // Formato padrão da placa AAA-1234
        String formatoplaca = "[A-Za-z]{3}\\d{4}";
        // Verifica se a placa corresponde ao formato esperado
        if (placa.matches(formatoplaca)) {
            return true;
        }
        return false;
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
