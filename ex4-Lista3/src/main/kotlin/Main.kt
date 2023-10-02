// Classe abstrata Funcionario
abstract class Funcionario(
    val nome: String,
    val codigoFuncionario: Int,
    val cargo: String
) {
    abstract fun calcularSalario(): Double
}

// Classe Gerente que herda de Funcionario
class Gerente(
    nome: String,
    codigoFuncionario: Int,
    cargo: String,
    val salarioBase: Double,
    val bonus: Double
) : Funcionario(nome, codigoFuncionario, cargo) {
    override fun calcularSalario(): Double {
        return salarioBase + bonus
    }
}

// Classe Desenvolvedor que herda de Funcionario
class Desenvolvedor(
    nome: String,
    codigoFuncionario: Int,
    cargo: String,
    val salarioHora: Double,
    val horasTrabalhadas: Int
) : Funcionario(nome, codigoFuncionario, cargo) {
    override fun calcularSalario(): Double {
        return salarioHora * horasTrabalhadas
    }
}

fun main() {
    val gerente = Gerente("João", 101, "Gerente de Projetos", 5000.0, 1500.0)
    val desenvolvedor = Desenvolvedor("Maria", 201, "Desenvolvedor Sênior", 50.0, 160)

    val salarioGerente = gerente.calcularSalario()
    val salarioDesenvolvedor = desenvolvedor.calcularSalario()

    println("Salário do Gerente ${gerente.nome}: R$$salarioGerente")
    println("Salário do Desenvolvedor ${desenvolvedor.nome}: R$$salarioDesenvolvedor")
}
