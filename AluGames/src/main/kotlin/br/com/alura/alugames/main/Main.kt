package br.com.alura.alugames.main

import br.com.alura.alugames.models.Game
import br.com.alura.alugames.service.ApiRestClient
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val search = scanner.nextLine()

    val searchApi = ApiRestClient()
    val gameInfo = searchApi.searchGame(search)


    var myGame: Game? = null

    val resultado = runCatching {
        myGame = Game(
            gameInfo.info.title,
            gameInfo.info.thumb
        )
    }

    resultado.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val option = scanner.nextLine()
        if (option.equals("s", true)) {
            println("Insira a descrição personalizado para o jogo:")
            val description = scanner.nextLine()
            myGame?.description = description
        } else {
            myGame?.description = myGame?.title

        }

        println(myGame)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso.")
    }
}