package com.example.orgs.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.model.Produto
import java.math.BigDecimal
import com.example.orgs.databinding.ActivityFormularioProdutosBinding

class FormularioProdutosActivity : AppCompatActivity() {

    private val binding by lazy { ActivityFormularioProdutosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        confgBtnSalvar()
        binding.activityFormularioProdutoImagem.setOnClickListener{
            AlertDialog.Builder(this)
                .setView(R.layout.formulario_imagem)
                .setPositiveButton("Confirmar") {_,_ ->
                 }
                .setNegativeButton("Cancelar") {_,_ ->
                }
                .show()
        }


    }

    private fun confgBtnSalvar() {
        val btnSalvar = binding.activityFormularioProdutoBotaoSalvar
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
        val campoNome = binding.activityFormularioProdutoNome
        val nome = campoNome.text.toString()


        val campoDesc = binding.activityFormularioProdutoDescricao
        val desc = campoDesc.text.toString()


        val campoValor = binding.activityFormularioProdutoValor
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

