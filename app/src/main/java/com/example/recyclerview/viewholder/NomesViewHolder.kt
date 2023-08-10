package com.example.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RowNomesBinding
import com.example.recyclerview.listener.OnNomesListener

class NomesViewHolder(private val bind: RowNomesBinding, private val listener: OnNomesListener): RecyclerView.ViewHolder(bind.root) {

    fun bind(nome: String){
        //Representa a ligação do elemento de Interface com seus dados.
        //A variável nome contém o nome de um dos elementos da nossa lista (que pode ser: "Micilini Roll", "Gabriel Solano" ou "Frederico Barlett").
        //Ou seja, a função bind() é como se ela fosse executada dentro de um loop, onde a cada laço, viesse um nome diferente. E quem executa esse loop? O método onBindViewHolder() da classe do Adapter quando ele monta a lista

        /* Método de Chamada 2 */
        //Aqui estamos usando o padrão viewBinding
        bind.textNome.text = nome

        //Agora temos acesso ao RowNomesBinding para ter um acesso padronizado aas views do row_nomes.xml

        //Configurações do CLique no TextView

        bind.textNome.setOnClickListener{
            listener.onClick()//Chamamos o método OnClick da Interface
            //Não precisamos ter o código do onClick implementado, pois quem está fornecendo a ViewHolder nos construtores dessa classe, é que vai implementar o listener.
        }

    }

}