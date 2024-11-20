package exercicioFixacaoAbstract.entities;

//Classe abstrata que representa um contribuinte (pessoa física ou jurídica)
public abstract class TaxPayer {
    //Atributos:
    private String name;
    private Double anualIncome;

    //Construtor padrão (sem parâmetros)
    public TaxPayer() {
    }

    //Construtor com parâmetros
    public TaxPayer(String name, Double anualIncome) {
        this.name = name;
        this.anualIncome = anualIncome;
    }

    //Getters e Setters:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnualIncome() {
        return anualIncome;
    }

    public void setAnualIncome(Double anualIncome) {
        this.anualIncome = anualIncome;
    }

    //Metodo abstrato que será implementado pelas subclasses para efetuar o cálculo do imposto
    public abstract double tax();
}
