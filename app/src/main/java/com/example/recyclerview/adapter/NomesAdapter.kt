package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RowNomesBinding
import com.example.recyclerview.listener.OnNomesListener
import com.example.recyclerview.viewholder.NomesViewHolder

class NomesAdapter: RecyclerView.Adapter<NomesViewHolder>() {

    private var listaNomes: List<String> = listOf()//Instanciamos uma lista vazia para que não quebre a lógica do RecycleView.
    //Fizemos isso porque o getItemCount espera um valor inicial.

    private lateinit var listener: OnNomesListener//Criamos um atributo do tipo listener para que possamos passa-lo para o ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NomesViewHolder {
        val item = RowNomesBinding.inflate(LayoutInflater.from(parent.context), parent, false)//Para inflar o row_nomes.xml, precisamos usar o método inflate
        //Mas para isso a classe precisa ser do tipo Fragment ou Activity, e no nosso caso estamos dentro de um RecyclerView, o que nos impossíbilita de inflar.
        //Por sorte, dentro dos parâmetros deste método, temos o parent, que salva o contexto de onde essa classe foi chamada (MainActivity).
        //Nesse caso é só usarmos o comando do LayoutInflater.from (onde from significa 'onde'), passando o context do parent.
        //Em seguida passando o parent que contém outras informações da ViewGroup e um terceiro parâmetro chamado attachToParent.
        //Quando o attachToParent vem setado como true, ele vai criar o layout e já associar na recyclerView, e como não queremos controlar isso, deixamos como false.

        return NomesViewHolder(item, listener)//Retorna uma instancia de ViewHolder, onde dentro dela passamos o elemento Raiz e o OnNomesListener (pois agora se faz necessário)
    }

    override fun onBindViewHolder(holder: NomesViewHolder, position: Int) {
        //Este é responsável por fazer a cola de forma a atribuir os valores para o seu Layout.
        //É neste método que acontece o loop. A quantidade de vezes que esse método será executada equivale ao retorno do "listaNomes.count()", declarado no método abaixo (getItemCount)

        holder.bind(listaNomes[position])//Aqui estamos chamando o método bind() passando para ele o nome de cada pessoa existente na lista de acordo com a posição retornada (parâmetro "position").
    }

    override fun getItemCount(): Int {
        return listaNomes.count()//Retorna a contagem de elementos existente em listaNomes
    }

    fun atualizaNomes(list: List<String>){
        listaNomes = list//Aqui estamos atribuindo a lista que chegou por parâmetro para nosso atributo declarado acima.
        notifyDataSetChanged()//Indica a RecycleView para que ela atualize seus dados novamente...
    }

    fun attachListener(nomesListener: OnNomesListener){
        //Função responsável por receber o Listener por parâmetro e salvar nos atributos da classe
        listener = nomesListener
    }

}