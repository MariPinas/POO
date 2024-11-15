using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace $safeprojectname$ {
    internal class Bolacha : Produto{
        private String marca;

        public Bolacha(String m, double p) : base("Bolacha",p) {
            this.marca = m;
        }

        public override void reajustarPreco(Produto a) {
            preco = preco * 1.01;
        }

        public override void exibirProduto() {
            base.exibirProduto();
            Console.WriteLine($"Marca da bolacha: {marca}\nValor de reajuste de Bolacha: {1.01}");
        }
    }
}
