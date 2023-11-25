import java.util.ArrayList;

/** Classe Singleton que define um único usuário para todo o app 
 * <code>receitaList</code> e <code>despesaList</code> são temporários, substitua pela implementação do banco mais tarde
*/
public class UserStorage{
    private String nome;
    private double saldo;
    private ArrayList<Receita> receitaList;
    private ArrayList<Despesa> despesaList;
    private static UserStorage instancia;

    /** Retorna a instância do usuário, definido <code>0</code> como saldo
     * @param nome Nome do usuário
     * @return Instância única e global do usuário
     */
    public static synchronized UserStorage getInstancia(String nome){
        if (instancia == null){
            instancia = new UserStorage(nome);
        }

        return instancia;
    }
    
    private UserStorage(String nome){
        this.nome = nome;
        this.saldo = 0;
        this.receitaList = new ArrayList<>();
        this.despesaList = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }
    /** Atualiza o saldo do usuário com um certo valor
     * @param incremento
     */
    public void setSaldo(double incremento){
        this.saldo += incremento;
    }

    public ArrayList<Receita> getReceitaList() {
        return receitaList;
    }
    public ArrayList<Despesa> getDespesaList() {
        return despesaList;
    }
}
