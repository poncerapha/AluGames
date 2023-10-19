package br.com.alura.alugames.models

data class Game(
    val title: String,
    val image: String
) {
    var description: String? = null
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $title \n" +
                "Capa: $image \n" +
                "Descricao: $description"
    }
}