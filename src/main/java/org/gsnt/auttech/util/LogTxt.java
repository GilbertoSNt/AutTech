package org.gsnt.auttech.util;


import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/*
 * Gerenciador de arquivos TXT usando java.io.
 *
 * Operações disponíveis:
 *  - criarArquivo()            → cria um novo arquivo vazio no disco
 *  - abrirArquivo()            → carrega as linhas do arquivo em memória
 *  - inserirLinha()            → adiciona linha ao final da lista em memória
 *  - inserirLinhaNoIndice()    → insere linha em posição específica
 *  - excluirLinha()            → remove linha pelo índice (base 0)
 *  - excluirLinhaPorTexto()    → remove primeira linha com o texto exato
 *  - salvarArquivo()           → grava o conteúdo em memória no disco
 *  - acrescentarLinhaNoDisco() → append direto no disco (sem usar memória)
 *  - lerArquivo()              → lê todas as linhas do disco e retorna lista
 *  - exibirConteudoNoConsole() → imprime linhas numeradas no console
 *
 * Fluxo típico:
 *   GerenciadorArquivoTxt g = new GerenciadorArquivoTxt("dados/clientes.txt");
 *   g.criarArquivo();
 *   g.inserirLinha("João Silva");
 *   g.salvarArquivo();
 *   List<String> linhas = g.lerArquivo();
 */

public class LogTxt {



    private final String comando = "C:\\pen\\OfProg\\AutTech\\logcomando.txt";
    private final String erro = "C:\\pen\\OfProg\\AutTech\\logerro.txt";
    private final String identIni = "C:\\pen\\OfProg\\AutTech\\ini\\login.txt";

    private List<String> linhasEmMemoria;


    /**
     * le linha id do registr do sistema
     *
     * @return
     */
    public String le(){

        return leLinhaID();

    }


    /**
     * leLista retorna de leitura do arquivo
     * 1 - retorna comandos dados
     * 2 - retorna erros
     *
     * @param a
     * @return
     */
    public List leLista(int a){

        List<String> leitura = new ArrayList<>();
        leitura.clear();

        if (a == 1) {
            leitura = leArq(comando);
        } else if (a == 2) {
            leitura = leArq(erro);
        }
         return leitura;
    }

    /**
     * Escreve mensagen no arquivo do log do sistema
     *
     * @param user
     * @param mensagem
     */
    public void escreve(String user, String mensagem){
        escreveLog(user, mensagem);
    }


    /**
     * Com o parametro
     * 1 - escreve no arquivo de erros do sistema
     * 2 - escreve o id da empresa no sistema
     *
     * @param a
     * @param mensagem
     */
    public void escreve(int a, String mensagem){

        if(a == 1){
            escreveErro(mensagem);
        }else if(a == 2){
            escreveId(mensagem);
        }
    }

    /**
     * escreve no arquivo de log
     *
     * @param user
     * @param txtLog
     */
    private void escreveLog(String user, String txtLog){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(comando, true))){
            bw.newLine();
            bw.write(LocalDate.now() +" - "+ LocalTime.now() +" - "+user+" - "+txtLog);
        } catch (IOException e) {
            throw new ExceptionGenerics("Erro no LogTXT - escreveLog "+e.getMessage());
        }
    }

    /**
     * escreve no arquivo de erro
     *
     * @param txtErro
     */
    private void escreveErro(String txtErro){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(erro, true))){
            bw.newLine();
            bw.write(LocalDate.now() +" - "+ LocalTime.now() +" - "+txtErro);
        } catch (IOException e) {
            throw new ExceptionGenerics("Erro no LogTXT - escreveErro "+e.getMessage());
        }
    }

    /**
     * escreve do arquivo de ID
     * @param txt
     */
    private void escreveId(String txt){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(identIni, false))){
            bw.flush();
            bw.write(txt);
        } catch (IOException e) {
            throw new ExceptionGenerics("Erro no LogTXT - escreveErro "+e.getMessage());
        }
    }



    private String leLinhaID(){

        String linha = null;
        try(BufferedReader br = new BufferedReader(new FileReader(identIni))){
            System.out.println("aqui - "+br.readLine());
            linha = br.readLine();
            if(linha != null){
                return linha;
            }else            {
                return "--";
            }

        } catch (IOException e){
            throw new ExceptionGenerics("Erro no LogTXT - lelinhaId "+e.getMessage());
        }

    }

    private List<String> leArq(String arq){

        String linha = null;
        List<String> linhas = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(arq))){

            linha = br.readLine();
            while (linha != null){
                linhas.add(linha);
                linha = null;
                linha = br.readLine();
            }

        } catch (IOException e){
            throw new ExceptionGenerics("Erro no LogTXT - Le Arquivo "+e.getMessage());
        }
            return linhas;
    }

    // -------------------------------------------------------------------------
    // 1. CRIAR ARQUIVO
    // -------------------------------------------------------------------------
    /**
     * Cria o arquivo no disco.
     * - Cria diretórios intermediários se não existirem.
     * - Lança exceção se o arquivo já existir (evita sobrescrever dados).
     *
     * @throws IOException se ocorrer erro de I/O ou se o arquivo já existir.
     */
    public void criarArquivo(String caminho) throws IOException {
        // Cria os diretórios pai, se necessário
        File arquivo = new File(caminho);
        File diretorioPai = arquivo.getParentFile();
        if (diretorioPai != null && !diretorioPai.exists()) {
            diretorioPai.mkdirs();
        }

        // createNewFile() retorna false se o arquivo já existir
        if (!arquivo.createNewFile()) {
            throw new IOException("Arquivo já existe: " + arquivo.getAbsolutePath());
        }

        System.out.println("[CRIAR] Arquivo criado: " + arquivo.getAbsolutePath());
    }



}