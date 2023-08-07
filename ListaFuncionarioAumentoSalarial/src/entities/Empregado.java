package entities;

public class Empregado {

	// Atributos
	private Integer id;
	private String nome;
	private Double salario;

	// Construtor:
	public Empregado(Integer id, String nome, Double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	// Metodos
	public void aumentoSalario(int porcento) {
		this.salario += this.salario * porcento / 100;
	}

	// ToString
	public String toString() {
		return "ID: " + this.getId() + "\nNome: " + this.getNome()
				+ String.format("\nSalário: %.2f", this.getSalario());
	}

	// Getters && Setters
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setSalario(Double Salario) {
		this.salario = salario;
	}

	public Double getSalario() {
		return salario;
	}
}
