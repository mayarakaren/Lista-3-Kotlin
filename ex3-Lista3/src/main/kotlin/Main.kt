// Classe abstrata Conta
abstract class Conta(val cliente: String, var saldo: Double) {
    // Método abstrato para sacar
    abstract fun sacar(valor: Double)

    // Método abstrato para depositar
    abstract fun depositar(valor: Double)
}

// Classe ContaCorrente que herda de Conta
class ContaCorrente(cliente: String, saldo: Double, var limiteChequeEspecial: Double) : Conta(cliente, saldo) {
    // Método para sacar na conta corrente
    override fun sacar(valor: Double) {
        if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor
            println("Saque de R$$valor realizado na conta corrente de $cliente. Saldo: R$$saldo")
        } else {
            println("Saldo insuficiente na conta corrente de $cliente.")
        }
    }

    // Método para depositar na conta corrente
    override fun depositar(valor: Double) {
        saldo += valor
        println("Depósito de R$$valor realizado na conta corrente de $cliente. Saldo: R$$saldo")
    }
}

// Classe ContaPoupanca que herda de Conta
class ContaPoupanca(cliente: String, saldo: Double, var taxaRendimento: Double) : Conta(cliente, saldo) {
    // Método para sacar na conta poupança
    override fun sacar(valor: Double) {
        if (valor <= saldo) {
            saldo -= valor
            println("Saque de R$$valor realizado na conta poupança de $cliente. Saldo: R$$saldo")
        } else {
            println("Saldo insuficiente na conta poupança de $cliente.")
        }
    }

    // Método para depositar na conta poupança
    override fun depositar(valor: Double) {
        saldo += valor
        println("Depósito de R$$valor realizado na conta poupança de $cliente. Saldo: R$$saldo")
    }

    // Método para aplicar o rendimento mensal
    fun aplicarRendimentoMensal() {
        saldo += saldo * (taxaRendimento / 100.0)
        println("Rendimento mensal aplicado na conta poupança de $cliente. Saldo: R$$saldo")
    }
}

fun main() {
    val contaCorrente = ContaCorrente("João", 1000.0, 500.0)
    val contaPoupanca = ContaPoupanca("Maria", 2000.0, 2.0)

    contaCorrente.depositar(500.0)
    contaCorrente.sacar(1200.0)

    contaPoupanca.depositar(1000.0)
    contaPoupanca.sacar(250.0)
    contaPoupanca.aplicarRendimentoMensal()
}
