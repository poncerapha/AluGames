package br.com.alura.alugames.models

data class GameInfo(
    val info: InfoApiShark
) {
    override fun toString(): String {
        return info.toString()
    }
}
