
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Desafio
 */
public class Desafio {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> ListaFinal = new ArrayList<String>();
        System.out.println("Digite o caminho do arquivo para leitura: \n");
        System.out.println("Exemplo: C:\\Users\\meu usuario\\git\\Desafio Aspas\\palavras.txt \n");
        System.out.println(
                "No final da execução será gerado um arquivo no mesmo local do inicial com o mesmo nome acrescido de '-check'.\n");
        System.out.print("Digite agora o caminho: ");
        Scanner scan = new Scanner(System.in);
        String caminho = scan.nextLine();
        if (!caminho.contains("\\\\"))
            caminho = caminho.replace("\\", "\\\\");
        String path = caminho;
        try {
            scan = new Scanner(new File(path));
            while (scan.hasNextLine()) {
                list.add(scan.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        String palavra = "";
        for (int lista = 0; lista < list.size(); lista++) {
            palavra = list.get(lista);
            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.contains("()")) {
                    palavra = palavra.replaceAll("\\(\\)", "");
                }
                if (palavra.contains("[]")) {
                    palavra = palavra.replaceAll("\\[\\]", "");
                }
                if (palavra.contains("{}")) {
                    palavra = palavra.replaceAll("\\{\\}", "");
                }
            }
            if (palavra.trim().isEmpty()) {
                System.out.println(list.get(lista) + " - Ok");
                ListaFinal.add(list.get(lista) + " - Ok");
            } else {
                System.out.println(list.get(lista) + " - Inválido");
                ListaFinal.add(list.get(lista) + " - Inválido");
            }
        }

        try {
            FileWriter fw = new FileWriter(caminho.substring(0, caminho.length() - 5) + "-check.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < ListaFinal.size(); i++) {
                pw.println(ListaFinal.get(i));
            }
            fw.flush();
            pw.close();
            fw.close();
            System.out.println("Caminho do Arquivo novo: " + caminho.substring(0, caminho.length() - 5) + "-check.txt");
            Thread.sleep(3000);
            System.out.println("Finalizando ...");
            Thread.sleep(1500);
        } catch (Exception e) {

        }
        scan.close();
    }

}