package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.orgs.R

class FormularioProdutosActivity : AppCompatActivity(R.layout.activity_formulario_produtos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        btnSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
            Log.i("formproduto", "oncreate:$nome")

            val campoDesc = findViewById<EditText>(R.id.descricao)
            val desc = campoDesc.text.toString()
            Log.i("formproduto", "oncreate:$desc")

            val campoValor = findViewById<EditText>(R.id.valor)
            val valor = campoValor.text.toString()
            Log.i("formproduto", "oncreate:$valor")
        }

    }
}