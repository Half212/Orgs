package com.example.orgs.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Placeholder
import coil.load
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.model.Produto
import java.math.BigDecimal
import com.example.orgs.databinding.ActivityFormularioProdutosBinding
import com.example.orgs.databinding.FormularioImagemBinding
import com.example.orgs.extensions.tryLoadImage

class FormularioProdutosActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutosBinding.inflate(layoutInflater)
    }
    private var url : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        confgBtnSalvar()
        binding.activityFormularioProdutoImagem.setOnClickListener {
            val bindingFormularioImagem = FormularioImagemBinding.inflate(layoutInflater)
            bindingFormularioImagem.formularioImagemBotaoCarregar.setOnClickListener {
                val url = bindingFormularioImagem.activityFormularioImagemUrl.text.toString()
                bindingFormularioImagem.formularioImagemImageview.tryLoadImage(url)

            }

            AlertDialog.Builder(this)
                .setView(bindingFormularioImagem.root)
                .setPositiveButton("Confirmar") { _, _ ->
                    url = bindingFormularioImagem.activityFormularioImagemUrl.text.toString()
                    binding.activityFormularioProdutoImagem.tryLoadImage(url)
                }
                .setNegativeButton("Cancelar") { _, _ ->
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
            valor = valor,
            imagem = url
        )
    }
}

