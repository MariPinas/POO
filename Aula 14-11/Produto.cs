using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace $safeprojectname$ {
    abstract class Produto {
        protected String nome;
        protected double preco;

        protected Produto(string nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public abstract void reajustarPreco(Produto a);  

        public virtual void exibirProduto() {
            Console.WriteLine($"Nome do Produto: {nome}\nPreço do Produto: {preco}");
        }
    }
}
