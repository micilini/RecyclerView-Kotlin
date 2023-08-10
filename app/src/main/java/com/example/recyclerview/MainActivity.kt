package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.adapter.NomesAdapter
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Abaixo definimos a lista de nomes que serão carregados pela RecyclerView
    val listaDeNomes: List<String> = listOf("Micilini Roll", "Gabriel Solano", "Frederico Barlett")
    private lateinit var binding: ActivityMainBinding
    //Instancia Global da classe do Adapter
    private val adapter = NomesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)//Instancia o ViewBinding
        setContentView(binding.root)//Seta a view para a bindingRoot

        //Para estruturarmos uma RecycleView precisamos definir seu Layout e também um Adapter:

        //Layout da RecyclerView
        binding.recyclerNames.layoutManager = LinearLayoutManager(this)//Estamos usando o formato de Layout mais simples para criar essa View

        //Adapter da RecyclerView
        binding.recyclerNames.adapter = adapter//Aqui estamos dizendo que a nossa RecyclerView será gerenciada pela nossa classe de Adapter, que possui todos os métodos capazes de dar a vida a nossa lista.

        //Passa a lista de nomes para o Adapter
        adapter.atualizaNomes(listaDeNomes)
    }
}