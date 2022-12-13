// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO}

data class Usuario (val nome: String, var cursando: String = "nao matriculado") { //Atualizado para data class e inclusas as propriedades nome, curso que está cursando e conteúdo atual
    var conteudoAtual: List<ConteudoEducacional> = listOf()
    }


data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)  // Cada conteúdo pode ter um nível e duração personalizada

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        usuario.forEach {
            inscritos.add(it)
            it.cursando = nome
            it.conteudoAtual = conteudos.filter { it.nivel == Nivel.BASICO}  // matricula a turma ou um usuário no curso e atribui todos os conteúdos básicos
        }
    }
}

fun main() {

    val kotlin101 = ConteudoEducacional("Kotlin101", 60, Nivel.BASICO)
    val intro = ConteudoEducacional("Introdução à programação", 60, Nivel.BASICO)
    val kotlin102 = ConteudoEducacional("Kotlin102", 60, Nivel.INTERMEDIARIO)
    val kotlin201 = ConteudoEducacional("Kotlin201", 60, Nivel.AVANCADO)   // conteúdos para teste

    val formacaoKotlin = Formacao("Formacao Kotlin", listOf(kotlin101, kotlin102, kotlin201, intro)) //formação para teste
    val turma: MutableList<Usuario> = mutableListOf(Usuario("Jonas"),                         // turma para teste
        Usuario("Lucas"),
        Usuario("Tia"),
        Usuario("Getulio"),
        Usuario("Iris"),
        Usuario("Marcos"))


    turma.forEach {
        formacaoKotlin.matricular(it)
        println("O usuário ${it.nome} acaba de se matricular no curso ${formacaoKotlin.nome}") // matriculuando a turma toda em batch
    }
    turma.forEach {
        println("O usuário ${it.nome} está matriculado em ${it.cursando}. Atualmente, assiste à: ${it.conteudoAtual.map{ it.nome }.joinToString()}") // conferindo se cada usuário foi matriculado no curso e conteúdos corretamente
    }
}
