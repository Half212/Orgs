package com.example.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Produto

class ListaProdutosAdapter(
    private val produtos : List<Produto>,
    private val context: Context
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {
        class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
            fun vincula (produto:Produto){
                val nome = itemView.findViewById<TextView>(R.id.nome)
                nome.text = produto.nome
                val descricao = itemView.findViewById<TextView>(R.id.descricao)
                descricao.text = produto.descricao
                val valor = itemView.findViewById<TextView>(R.id.valor)
                valor.text = produto.valor.toPlainString()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  infalter = LayoutInflater.from(context)
        val view = infalter.inflate(R.layout.produto_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return produtos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

}
