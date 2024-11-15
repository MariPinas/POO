using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace $safeprojectname$ {
    internal class Queijo : Produto{
        String tipo;

        public Queijo(String tipo, double p) : base("Coalho",p) {
            this.tipo = tipo;
        }

        public override void reajustarPreco(Produto a) {
            preco = preco * 1.02;
        }
    }
}
