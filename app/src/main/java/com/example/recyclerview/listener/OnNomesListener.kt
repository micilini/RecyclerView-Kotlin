package com.example.recyclerview.listener

//Esta Interface é um "Truque" que usamos para que a nossa "MainActivity" responda algum clique advindo do "setOnClickListener" existente no arquivo NomesViewHolder.kt
//Onde o "setOnClickListener" chama o método onClick() toda vez que o usuário clica em algum TextView
//Ao mesmo tempo que todas as classes que implementam essa interface (OnNomesListener) mesmo que de forma anônima, tenham seus métodos onClick executados.

interface OnNomesListener {
    fun onClick()
}