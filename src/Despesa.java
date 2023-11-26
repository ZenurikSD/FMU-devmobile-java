import java.util.Calendar;
import utils.CalendarUtils;

public class Despesa{
    private int id;
    private int categoriaIndex;
    private String descricao;
    private double valor;
    private Calendar data;
    private int recorrencia;

    public Despesa(int categoriaIndex, double valor) {
        this.categoriaIndex = categoriaIndex;
        this.valor = valor;
        this.data = Calendar.getInstance();
        this.recorrencia = 1;
    }

    public Despesa(int categoriaIndex, double valor, String descricao, Calendar data, int recorrencia) {
        this.categoriaIndex = categoriaIndex;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.recorrencia = recorrencia;
    }

    public int getId() {
        return id;
    }

    public int getCategoriaIndex() {
        return categoriaIndex;
    }
    public void setCategoriaIndex(int categoriaIndex) {
        this.categoriaIndex = categoriaIndex;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }
    public void setData(Calendar data) {
        this.data = data;
    }

    public int getRecorrencia() {
        return recorrencia;
    }
    public void setRecorrencia(int recorrencia) {
        this.recorrencia = recorrencia;
    }

    @Override
    public String toString(){
        return
            "ID #" + id + 
            "\nCategoria: " + this.categoriaIndex +
            "\nDescrição: " + this.descricao + 
            "\nR$ " + this.valor +
            "\nData: " + CalendarUtils.getDataString(this.data) +
            "\nRecorrência: " + this.recorrencia;
    }
}
