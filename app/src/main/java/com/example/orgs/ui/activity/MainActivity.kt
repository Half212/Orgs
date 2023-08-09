package com.example.orgs.ui.activity


import android.content.Intent
import android.os.Bundle
import android.service.controls.actions.FloatAction
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Produto
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(
            context = this, produtos = listOf(
                Produto(
                    nome = "teste",
                    descricao = "teste desc",
                    valor = BigDecimal("19.99")
                ),
                Produto(
                    nome = "teste1",
                    descricao = "teste desc1",
                    valor = BigDecimal("29.99")
                ),
                Produto(
                    nome = "teste2",
                    descricao = "teste desc2",
                    valor = BigDecimal("39.99")
                ),
        ))
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener{
           val intent =  Intent(this,FormularioProdutosActivity::class.java)
            startActivity(intent)
        }

    }

}