package exercicioFixacaoAbstract.entities;

//Classe que representa um contribuinte pessoa física e herda de TaxPayer
public class Individual extends TaxPayer {
    //Atributo específico da classe
    private Double healthExpenditures;

    // Construtor padrão (sem parâmetros), chama o construtor da classe pai
    public Individual() {
        super();
    }

    // Construtor com parâmetros para inicializar os atributos da classe pai e o atributo específico
    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    //Getter e Setter:
    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    // Implementação do metodo abstrato 'tax' da classe pai, que calcula o imposto
    @Override
    public double tax() {
        // Se a renda anual for inferior a 20.000, aplica uma alíquota de 15% e abate 50% dos gastos com saúde
        if (getAnualIncome() < 20000.00) {
            return (getAnualIncome() * 0.15) - (healthExpenditures * 0.50);
        }
        // Se a renda anual for igual ou superior a 20.000, aplica uma alíquota de 25% e abate 50% dos gastos com saúde
        else {
            return (getAnualIncome() * 0.25) - (healthExpenditures * 0.50);
        }
    }
}
