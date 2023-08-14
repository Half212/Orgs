package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        confgBtnSalvar()

    }

    private fun confgBtnSalvar() {
        val btnSalvar = findViewById<Button>(R.id.activity_formulario_btn_salvar)
        val dao = ProdutosDao()
        btnSalvar.setOnClickListener {
            val criaProduto = criaProduto()
            dao.adiciona(criaProduto)
            msgToast()
            finish()
        }
    }

    private fun msgToast() {
        val save = "Produto Salvo"
        val duration = Toast.LENGTH_SHORT
        Toast.makeText(this, save, duration).show()
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.activity_formulario_nome)
        val nome = campoNome.text.toString()


        val campoDesc = findViewById<EditText>(R.id.activity_formulario_descricao)
        val desc = campoDesc.text.toString()


        val campoValor = findViewById<EditText>(R.id.activity_formulario_valor)
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome = nome,
            descricao = desc,
            valor = valor
        )
    }
}