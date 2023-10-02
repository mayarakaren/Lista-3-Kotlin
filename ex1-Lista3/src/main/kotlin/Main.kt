// Classe abstrata Veiculo
abstract class Veiculo {
    // Propriedade velocidade
    var velocidade: Int = 0

    // Método abstrato acelerar
    abstract fun acelerar()
}

// Classe Carro que herda de Veiculo
class Carro : Veiculo() {
    override fun acelerar() {
        velocidade += 10
        println("O carro acelerou e agora está a $velocidade km/h.")
    }
}

// Classe Moto que herda de Veiculo
class Moto : Veiculo() {
    override fun acelerar() {
        velocidade += 20
        println("A moto acelerou e agora está a $velocidade km/h.")
    }
}

fun main() {
    val carro = Carro()
    val moto = Moto()

    carro.acelerar()
    moto.acelerar()

    carro.acelerar()
    moto.acelerar()
}

