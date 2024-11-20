package exercicioFixacaoAbstract.entities;

// Classe Company que representa um contribuinte pessoa jurídica, herda de TaxPayer
public class Company extends TaxPayer {
    //Atributo específico da classe
    private Integer numberOfEmployees;

    // Construtor padrão (sem parâmetros), chama o construtor da classe pai
    public Company() {
        super();
    }

    // Construtor com parâmetros para inicializar os atributos da classe pai e o atributo específico
    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    //Getter e setter:
    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    // Implementação do metodo abstrato 'tax' da classe pai, que calcula o imposto
    @Override
    public double tax() {
        // Se a empresa tiver mais de 10 funcionários, aplica uma alíquota de 14%
        if (numberOfEmployees > 10) {
            return getAnualIncome() * 0.14;
        }
        // Se a empresa tiver 10 ou menos funcionários, aplica uma alíquota de 16%
        else {
            return getAnualIncome() * 0.16;
        }
    }
}
