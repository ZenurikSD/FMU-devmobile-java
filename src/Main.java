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
                        //Adiciona uma nova receita à lista e incrementa o saldo do user
                        System.out.print("Digite um valor: R$ ");
                        double valor = input.nextDouble();
                        input.nextLine();

                        receita = new Receita(valor);
                        user.getReceitaList().add(receita);
                        user.updateSaldo(valor);
                        break;
        
                    case 3:
                        System.out.print("Digite o ID da receita: ");
                        int id = input.nextInt();
                        input.nextLine();

                        //Se a receita existir, subtrai seu valor do saldo antes de remover
                        Receita temp;
                        try {
                            temp = user.getReceitaList().get(id);
                        } catch (IndexOutOfBoundsException ioobe) {
                            System.out.println("Índice não existe na lista");
                            break;
                        }        

                        user.updateSaldo( - temp.getValor());
                        user.getReceitaList().remove(temp);
                        
                        break;
                        
                    default:
                        break;
                }
            }
        }
    }

    private static void manageDespesas(){
        Despesa despesa;

        int d_option = 1;
        while (d_option > 0 && d_option < 4){
            System.out.print(
                "Despesas" +
                "\n\t1. Ver todas" +
                "\n\t2. Adicionar" +
                "\n\t3. Remover" +
                "\n\t4. Voltar" +
                "\n> "
            );
            d_option = input.nextInt();
            input.nextLine();
    
            // Faz as operações apenas se a opção for válida
            if (d_option < 0 && d_option > 4){
                break;
            } else {
                switch (d_option) {
                    case 1:
                        if(user.getDespesaList().size() == 0){
                            System.out.println("A lista está vazia");
                            break;
                        } else {
                            for (Despesa d : user.getDespesaList()){
                                System.out.println(d.toString());
                                System.out.println();
                            }
                        }
                        break;
        
                    case 2:
                        System.out.print("Digite o número da categoria: ");
                        int categoriaIndex = input.nextInt();
                        input.nextLine();

                        System.out.print("Digite um valor: R$ ");
                        double valor = input.nextDouble();
                        input.nextLine();

                        despesa = new Despesa(categoriaIndex, valor);
        
                        user.getDespesaList().add(despesa);
                        user.updateSaldo( - despesa.getValor()); //decrementa o saldo
                        break;
        
                    case 3:
                        System.out.print("Digite o ID da despesa: ");
                        int id = input.nextInt();
                        input.nextLine();

                        Despesa temp;
                        try {
                            temp = user.getDespesaList().get(id);
                        } catch (IndexOutOfBoundsException ioobe) {
                            System.out.println("Índice não existe na lista");
                            break;
                        }        
                        user.updateSaldo(temp.getValor()); //incrementa o saldo
                        user.getDespesaList().remove(id);

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
                    manageDespesas();
                default:
                    break;
            }
        }

        input.close();
    }
}
