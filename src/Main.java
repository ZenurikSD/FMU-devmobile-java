import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static UserStorage user = UserStorage.getInstancia("Zenurik");
    
    private static void manageReceitas(){
        Receita receita;

        int r_option = 1;
        while (r_option > 0 && r_option < 4){
            System.out.print(
                "Receitas" +
                "\n\t1. Ver todas" +
                "\n\t2. Adicionar" +
                "\n\t3. Remover" +
                "\n\t4. Voltar" +
                "\n> "
            );
            r_option = input.nextInt();
            input.nextLine();
    
            // Faz as operações apenas se a opção for válida
            if (r_option < 0 && r_option > 4){
                break;
            } else {
                switch (r_option) {
                    case 1:
                        if(user.getReceitaList().size() == 0){
                            System.out.println("A lista está vazia");
                            break;
                        } else {
                            for (Receita r : user.getReceitaList()){
                                System.out.println(r.toString());
                                System.out.println();
                            }
                        }
                        break;
        
                    case 2:
                        System.out.print("Digite um valor: R$ ");
                        receita = new Receita(input.nextDouble());
                        input.nextLine();
        
                        user.getReceitaList().add(receita);
                        break;
        
                    case 3:
                        System.out.print("Digite o ID da receita: ");
                        int id = input.nextInt();
                        input.nextLine();
        
                        user.getReceitaList().remove(id);
                        break;
                        
                    default:
                        break;
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        int option = 1;
        while (option > 0 && option < 3){
            System.out.printf("SALDO: R$ %.2f\n", user.getSaldo());
            System.out.print(
                "Escolha uma operação: "+
                "\n\t1. Receitas" +
                "\n\t2. Despesas" +
                "\n\t3. Sair" +
                "\n> "
            );
            option = input.nextInt();
            input.nextLine();
    
            switch (option) {
                case 1:
                    manageReceitas();
                    break;
                case 2:
                    // manageDespesas();
            
                default:
                    break;
            }
        }

        input.close();
    }
}
