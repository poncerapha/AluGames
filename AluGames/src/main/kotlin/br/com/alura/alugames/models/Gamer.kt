package br.com.alura.alugames.models

import kotlin.random.Random

data class Gamer(
    var name: String,
    var email: String
) {
    var birthday: String? = null
    var userName: String? = null
        set(value) {
            field = value
            if (id.isNullOrBlank()) {
                generateId()
            }
        }
    var id: String? = null
        private set

    constructor(name: String, email: String, birthday: String, userName: String): this(name, email) {
        this.birthday = birthday
        this.userName = userName
    }

    init {
        if (name.isBlank()) {
            throw java.lang.IllegalArgumentException("Nome está em branco")
        }
        this.email = validateEmail()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birthday=$birthday, userName=$userName, id=$id)"
    }

    private fun generateId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        id = "$userName#$tag"
    }

    fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }
}
