package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutosActivity : AppCompatActivity(R.layout.activity_formulario_produtos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        btnSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()


            val campoDesc = findViewById<EditText>(R.id.descricao)
            val desc = campoDesc.text.toString()


            val campoValor = findViewById<EditText>(R.id.valor)
            val valorEmTexto = campoValor.text.toString()
            val valor = if (valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            val criaProduto = Produto(
                nome=nome,
                descricao = desc,
                valor = valor
            )
            Log.i("formproduto", "oncreate:$criaProduto")

            val dao = ProdutosDao()
            dao.adiciona(criaProduto)
            Log.i("formproduto", "oncreate:${dao.buscaTodos()}")

            val save = "Produto Salvo"
            val duration = Toast.LENGTH_SHORT
            Toast.makeText(this,save,duration).show()
            finish()
        }

    }
}